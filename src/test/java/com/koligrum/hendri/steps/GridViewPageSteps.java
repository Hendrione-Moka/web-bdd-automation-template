package com.koligrum.hendri.steps;

import com.koligrum.hendri.pages.GridViewPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class GridViewPageSteps {

  @Autowired
  GridViewPage gridViewPage;

  @Then("User see quote {string}")
  public void userSeeQuote(String quote) {
    String actualQuote = gridViewPage.getQuoteText(1);
    Assert.assertEquals(quote, actualQuote);
  }
}
