package com.koligrum.hendri.webdriverpool;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;


@Component("com.koligrum.hendri.webdriverpool.WebdriverInitializer")
public class WebdriverInitializer {

  //global variable / instance variable static
  public static AtomicReference<HashMap<String, ChromeDriver>> webDriverPool = new AtomicReference<>(
      new HashMap<>());

  public void initialize() {
    //download webdriver dan setup
    WebDriverManager.chromedriver().setup();

    //nambahin incognito
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito", "--start-maximized");

    //inisialisasi webdriver
    ChromeDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
