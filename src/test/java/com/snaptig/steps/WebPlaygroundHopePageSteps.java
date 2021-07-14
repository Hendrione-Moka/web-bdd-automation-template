package com.snaptig.steps;

import com.snaptig.pages.WebPlaygroundHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class WebPlaygroundHopePageSteps {

  @Autowired
  WebPlaygroundHomePage homePage;

  @Given("User open atlas web playground page")
  public void userOpenAtlasWebPlaygroundPage() {
    homePage.openPage();
  }

  @When("User input quote {string}")
  public void userInputQuote(String quote) {
    homePage.inputQuote(quote);
  }

  @And("User select color {string}")
  public void userSelectColor(String color) {
    homePage.selectColor(color);
  }

  @And("User click button add quote")
  public void userClickButtonAddQuote() {
    homePage.clickButtonAddQuote();
  }

}
