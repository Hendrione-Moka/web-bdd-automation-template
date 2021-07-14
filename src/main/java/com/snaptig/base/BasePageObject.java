package com.snaptig.base;

import com.snaptig.properties.WebDriverProperties;
import com.snaptig.webdriverpool.WebdriverInitializer;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.snaptig.base.BasePageObject")
public class BasePageObject {

  @Autowired
  WebDriverProperties webDriverProperties;

  public ChromeDriver getDriver() {
    return WebdriverInitializer.getDriver();
  }

  public void openAt(String path) {
    this.getDriver().get(path);
  }

  public Integer getExplicitTimeout() {
    return webDriverProperties.getExplicitTimeout();
  }

  public void setPageLoadTimeout(Integer seconds) {
    getDriver().manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
  }

  public void setScriptTimeout(Integer seconds) {
    getDriver().manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS);
  }

  public WebElement waitUntil(ExpectedCondition<WebElement> conditions, Integer timeout) {
    WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
    return wait.until(conditions);
  }

  public WebElement waitUntil(ExpectedCondition<WebElement> conditions) {
    return waitUntil(conditions, getExplicitTimeout());
  }

  public List<WebElement> waitAllUntil(ExpectedCondition<List<WebElement>> conditions,
      Integer timeout) {
    WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
    return wait.until(conditions);
  }

  public List<WebElement> waitAllUntil(ExpectedCondition<List<WebElement>> conditions) {
    return waitAllUntil(conditions, getExplicitTimeout());
  }

  public WebElement waitUntilClickable(By by) {
    return waitUntil(ExpectedConditions.elementToBeClickable(by), getExplicitTimeout());
  }

  public WebElement waitUntilClickable(By by, Integer timeout) {
    return waitUntil(ExpectedConditions.elementToBeClickable(by), timeout);
  }

  public WebElement waitUntilVisible(By by) {
    return waitUntil(ExpectedConditions.visibilityOfElementLocated(by), getExplicitTimeout());
  }

  public WebElement waitUntilVisible(By by, Integer timeout) {
    return waitUntil(ExpectedConditions.visibilityOfElementLocated(by), timeout);
  }

  public WebElement waitUntilPresent(By by) {
    return waitUntil(ExpectedConditions.presenceOfElementLocated(by), getExplicitTimeout());
  }

  public WebElement waitUntilPresent(By by, Integer timeoutInSeconds) {
    return waitUntil(ExpectedConditions.presenceOfElementLocated(by), timeoutInSeconds);
  }

  public List<WebElement> waitUntilAllPresent(By by) {
    return waitAllUntil(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
  }

  public List<WebElement> waitUntilAllPresent(By by, Integer timeoutInSeconds) {
    return waitAllUntil(ExpectedConditions.presenceOfAllElementsLocatedBy(by), timeoutInSeconds);
  }

  public Boolean waitUntilInvisible(By by, Integer timeout) {
    WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
  }

  public Boolean waitUntilInvisible(By by) {
    return waitUntilInvisible(by, getExplicitTimeout());
  }

  public void clickOn(By by, Integer timeoutInSeconds) {
    waitUntilClickable(by, timeoutInSeconds).click();
  }

  public void clickOn(By by) {
    clickOn(by, getExplicitTimeout());
  }

  public WebElement find(By by) {
    return waitUntilPresent(by);
  }

  public WebElement find(String cssSelector) {
    return find(By.cssSelector(cssSelector));
  }

  public List<WebElement> findAll(By by) {
    return waitUntilAllPresent(by);
  }

  public List<WebElement> findAll(String cssSelector) {
    return waitUntilAllPresent(By.cssSelector(cssSelector));
  }

  public void typeOn(By by, String text) {
    WebElement element = waitUntilVisible(by);
    element.clear();
    element.sendKeys(text);
  }

  public void clear(By by) {
    waitUntilVisible(by).clear();
  }

  public Actions withActions() {
    return new Actions(getDriver());
  }

  public void maximize() {
    getDriver().manage().window().maximize();
  }

  public void fullScreen() {
    getDriver().manage().window().fullscreen();
  }

  public void setScreenSize(Integer width, Integer height) {
    Dimension d = new Dimension(width, height);
    getDriver().manage().window().setSize(d);
  }

  public String getTitle() {
    return getDriver().getTitle();
  }

  public Object evaluateJavascript(String script, Object args) {
    JavascriptExecutor jse = ((JavascriptExecutor) getDriver());
    return jse.executeScript(script, args);
  }

  public Alert getAlert() {
    return getDriver().switchTo().alert();
  }

  public void switchToDefaultContent() {
    getDriver().switchTo().defaultContent();
  }

  public List<String> getWindowHandles() {
    return new ArrayList<>(getDriver().getWindowHandles());
  }

  public void switchTo(String name) {
    getDriver().switchTo().window(name);
  }

  public String getCurrentUrl() {
    return getDriver().getCurrentUrl();
  }

  public void selectByVisibleText(By by, String text) {

    new Select(find(by)).selectByVisibleText(text);
  }

  public void selectByVisibleText(String cssSelector, String text) {
    new Select(find(cssSelector)).selectByVisibleText(text);
  }

  public void selectByValue(String cssSelector, String value) {
    new Select(find(cssSelector)).selectByValue(value);
  }

  public void selectByValue(By by, String value) {
    new Select(find(by)).selectByValue(value);
  }

  public void selectByIndex(String cssSelector, Integer index) {
    new Select(find(cssSelector)).selectByIndex(index);
  }

  public void selectByIndex(By by, Integer index) {
    new Select(find(by)).selectByIndex(index);
  }

  public void deselectAll(String cssSelector) {
    new Select(find(cssSelector)).deselectAll();
  }

  public void deselectAll(By by) {
    new Select(find(by)).deselectAll();
  }

  public Select select(By by) {
    return new Select(find(by));
  }

  public Select select(String cssSelector) {
    return new Select(find(cssSelector));
  }

  public Boolean isDisplayed(By by) {
    return find(by).isDisplayed();
  }

  public Boolean isDisplayed(String cssSelector) {
    return find(cssSelector).isDisplayed();
  }

  public Boolean isEnabled(By by) {
    return find(by).isEnabled();
  }

  public Boolean isEnabled(String cssSelector) {
    return find(cssSelector).isEnabled();
  }

  public String getText(By by) {
    return find(by).getText();
  }

  public String getText(String cssSelector) {
    return find(cssSelector).getText();
  }

  public String getAttribute(By by, String attributeName) {
    return find(by).getAttribute(attributeName);
  }

  public String getAttribute(String cssSelector, String attributeName) {
    return find(cssSelector).getAttribute(attributeName);
  }

  public void waitABit(Integer seconds) {
    try {
      Thread.sleep(Duration.ofSeconds(seconds).toMillis());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void waitABit(Integer waitTime, TemporalUnit unit) {
    try {
      Thread.sleep(Duration.of(waitTime, unit).toMillis());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public TouchActions getTouchActions() {
    return new TouchActions(getDriver());
  }

}
