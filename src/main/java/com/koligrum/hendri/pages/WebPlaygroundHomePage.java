package com.koligrum.hendri.pages;

import com.koligrum.hendri.base.BasePageObject;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component("com.koligrum.hendri.pages.WebPlaygroundHomePage")
public class WebPlaygroundHomePage extends BasePageObject {

  public void openPage() {
    getDriver().get("http://bdd.atlasid.tech/");
  }

  public void inputQuote(String quote) {
    WebElement inputQuote = getDriver().findElementByCssSelector("#inputQuote");
    inputQuote.sendKeys(quote);
  }

  public void selectColor(String color) {
    WebElement selectColor = getDriver().findElementByXPath("//select[@id='colorSelect']");
    Select select = new Select(selectColor);
    select.selectByVisibleText(color);
  }

  public void clickButtonAddQuote() {
    WebElement buttonAddQuote = getDriver().findElementById("buttonAddQuote");
    buttonAddQuote.click();
  }

  public void clickPoweredByLink() {
    WebElement poweredByLink = getDriver().findElementById("poweredBy");
    poweredByLink.click();
  }

  public String getAtlasTitle() {
    List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
    getDriver().switchTo().window(windows.get(1));
    String title = getDriver().getTitle();
    return title;
  }

}
