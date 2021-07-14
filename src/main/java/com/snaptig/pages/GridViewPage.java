package com.snaptig.pages;

import com.snaptig.base.BasePageObject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("com.snaptig.pages.GridViewPage")
public class GridViewPage extends BasePageObject {

  public String getQuoteText(int index) {
    List<WebElement> quotes = findAll(By.name("quoteText"));
    WebElement quoteKedua = quotes.get(index);
    String actualQuote = quoteKedua.getText();
    return actualQuote;
  }

}
