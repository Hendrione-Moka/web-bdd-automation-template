package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import webdriverpool.WebdriverInitializer;

public class WebdriverHook {

  @Before
  public void inisialisasiWebdriver() {
    WebdriverInitializer.initialize();
  }

  @After
  public void quitBrowser(Scenario scenario) {
    if(scenario.isFailed()){
      TakesScreenshot screenshot = WebdriverInitializer.driver;
      byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
      scenario.attach(imageByte, "image/png", scenario.getId());
    }
    WebdriverInitializer.quit();
  }
}
