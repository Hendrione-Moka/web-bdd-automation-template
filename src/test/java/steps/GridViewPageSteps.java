package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GridViewPage;
import webdriverpool.WebdriverInitializer;

public class GridViewPageSteps {

  GridViewPage gridViewPage = new GridViewPage(WebdriverInitializer.driver);

  @Then("User see quote {string}")
  public void userSeeQuote(String quote) {
    String actualQuote = gridViewPage.getQuoteText(1);
    Assert.assertEquals(quote, actualQuote);
  }
}
