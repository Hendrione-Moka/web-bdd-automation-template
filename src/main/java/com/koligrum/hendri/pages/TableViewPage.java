package com.koligrum.hendri.pages;

import com.koligrum.hendri.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("com.koligrum.hendri.pages.TableViewPage")
public class TableViewPage extends BasePageObject {

  public void clickTableView() {
    WebElement tableViewTab = getDriver().findElementById("tableView");
    tableViewTab.click();
  }

  public void hoverShowTableBtn() {
    WebElement buttonShowTable = getDriver().findElementById("buttonShowTable");
    Actions actions = new Actions(getDriver());
    actions.moveToElement(buttonShowTable).pause(5000).build().perform();
  }

  public boolean isTableShow() {
    By locatorTable = By.id("tableQuote");
    WebDriverWait wait = new WebDriverWait(getDriver(), 15, 1000);
    WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTable));
//    WebElement table = driver.findElementById("tableQuote");
    boolean result = table.isDisplayed();
    return result;
  }

  public void clickButtonShowTableAfterTenSec() {
    WebElement buttonYellow = getDriver().findElementById("buttonShowAfterTen");
    buttonYellow.click();
  }
}
