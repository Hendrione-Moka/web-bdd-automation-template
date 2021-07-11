package com.koligrum.hendri.hooks;

import com.koligrum.hendri.webdriverpool.WebdriverInitializer;
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
      TakesScreenshot screenshot = WebdriverInitializer.driver;
      byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
      scenario.attach(imageByte, "image/png", scenario.getId());
    }
    webdriverInitializer.quit();
  }
}
