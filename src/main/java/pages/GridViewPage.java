package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GridViewPage {

  ChromeDriver driver;

  public GridViewPage(ChromeDriver driver) {
    this.driver = driver;
  }

  public String getQuoteText(int index){
    List<WebElement> quotes = driver.findElementsByName("quoteText");
    WebElement quoteKedua = quotes.get(index);
    String actualQuote = quoteKedua.getText();
    return actualQuote;
  }

}
