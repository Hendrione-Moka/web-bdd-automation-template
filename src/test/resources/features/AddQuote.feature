@AddQuote1
Feature: Add Quote

  @smoke1
  Scenario: Add Quote with background color yellow
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "Yellow"
    And User click button add quote
    Then User see quote "There is a will there is a way"

  Scenario: Add Quote with background color cyan
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "Cyan"
    And User click button add quote
    Then User see quote "There is a will there is a way"

  Scenario: Add Quote with background color white
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "White"
    And User click button add quote
    Then User see quote "There is a will there is a way"

  Scenario: Add Quote with background color magenta
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "Magenta"
    And User click button add quote
    Then User see quote "There is a will there is a way"

  Scenario: Add Quote with background color blue
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "Blue"
    And User click button add quote
    Then User see quote "There is a will there is a way"