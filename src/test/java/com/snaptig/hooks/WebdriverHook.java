package com.snaptig.hooks;

import com.snaptig.webdriverpool.WebdriverInitializer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;

public class WebdriverHook {


  @Autowired
  WebdriverInitializer webdriverInitializer;

  @Before
  public void inisialisasiWebdriver() {
    webdriverInitializer.initialize();
  }

  @After
  public void quitBrowser(Scenario scenario) {
    if (scenario.isFailed()) {
      TakesScreenshot screenshot = WebdriverInitializer.getDriver();
      byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
      scenario.attach(imageByte, "image/png", scenario.getId());
    }
    webdriverInitializer.quit();
  }
}
