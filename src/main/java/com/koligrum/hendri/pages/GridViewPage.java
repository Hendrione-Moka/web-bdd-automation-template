package com.koligrum.hendri.pages;

import com.koligrum.hendri.base.BasePageObject;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("com.koligrum.hendri.pages.GridViewPage")
public class GridViewPage extends BasePageObject {

  public String getQuoteText(int index) {
    List<WebElement> quotes = getDriver().findElementsByName("quoteText");
    WebElement quoteKedua = quotes.get(index);
    String actualQuote = quoteKedua.getText();
    return actualQuote;
  }

}
