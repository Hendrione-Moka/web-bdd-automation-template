package com.snaptig.pages;

import com.snaptig.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

@Component("com.snaptig.pages.TableViewPage")
public class TableViewPage extends BasePageObject {

  public void clickTableView() {
    clickOn(By.id("tableView"));
  }

  public void hoverShowTableBtn() {
    WebElement buttonShowTable = find(By.id("buttonShowTable"));
    Actions actions = new Actions(getDriver());
    actions.moveToElement(buttonShowTable).pause(5000).build().perform();
  }

  public boolean isTableShow() {
    WebElement table = waitUntilPresent(By.id("tableQuote"), 15);
    boolean result = table.isDisplayed();
    return result;
  }

  public void clickButtonShowTableAfterTenSec() {
    clickOn(By.id("buttonShowAfterTen"));
  }
}
