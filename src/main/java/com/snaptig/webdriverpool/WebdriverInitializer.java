package com.snaptig.webdriverpool;

import com.snaptig.properties.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("com.snaptig.webdriverpool.WebdriverInitializer")
public class WebdriverInitializer {

  @Autowired
  WebDriverProperties webDriverProperties;

  //global variable / instance variable static
  public static AtomicReference<HashMap<String, ChromeDriver>> webDriverPool = new AtomicReference<>(
      new HashMap<>());

  public void initialize() {
    //download webdriver dan setup
    WebDriverManager.chromedriver().setup();

    //nambahin incognito
    ChromeOptions options = new ChromeOptions();
    options.addArguments(webDriverProperties.getChromeArgs());

    //inisialisasi webdriver
    ChromeDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts()
        .implicitlyWait(webDriverProperties.getImplicitTimeout(), TimeUnit.SECONDS);
    webDriverPool.updateAndGet(dv -> {
      dv.put(Thread.currentThread().getName(), driver);
      return dv;
    });
  }

  public void quit() {
    webDriverPool.updateAndGet(dv -> {
      ChromeDriver driver = dv.get(Thread.currentThread().getName());
      dv.remove(Thread.currentThread().getName());
      driver.quit();
      return dv;
    });
  }

  public static ChromeDriver getDriver() {
    return webDriverPool.get().get(Thread.currentThread().getName());
  }
}
