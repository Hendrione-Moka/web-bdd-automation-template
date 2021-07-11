package com.koligrum.hendri.base;

import com.koligrum.hendri.webdriverpool.WebdriverInitializer;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component("base.BasePageObject")
public class BasePageObject {

  public ChromeDriver getDriver() {
    return WebdriverInitializer.getDriver();
  }

}
