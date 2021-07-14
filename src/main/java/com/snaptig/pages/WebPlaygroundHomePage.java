package com.snaptig.pages;

import com.snaptig.base.BasePageObject;
import java.util.List;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component("com.snaptig.pages.WebPlaygroundHomePage")
public class WebPlaygroundHomePage extends BasePageObject {

  public void openPage() {
    openAt("http://bdd.atlasid.tech/");
  }

  public void inputQuote(String quote) {
    typeOn(By.cssSelector("#inputQuote"), quote);
  }

  public void selectColor(String color) {
    selectByVisibleText(By.xpath("//select[@id='colorSelect']"), color);
  }

  public void clickButtonAddQuote() {
    clickOn(By.id("buttonAddQuote"));
  }

  public void clickPoweredByLink() {
    clickOn(By.id("poweredBy"));
  }

  public String getAtlasTitle() {
    List<String> windows = getWindowHandles();
    getDriver().switchTo().window(windows.get(1));
    return getTitle();
  }

}
