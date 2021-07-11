@AddQuote
Feature: Add Quote 4

  @smoke
  Scenario: Add Quote with background color yellow 4
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "Yellow"
    And User click button add quote
    Then User see quote "There is a will there is a way"

  Scenario: Add Quote with background color cyan 4
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "Cyan"
    And User click button add quote
    Then User see quote "There is a will there is a way"

  Scenario: Add Quote with background color white 4
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "White"
    And User click button add quote
    Then User see quote "There is a will there is a way"

  Scenario: Add Quote with background color magenta 4
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "Magenta"
    And User click button add quote
    Then User see quote "There is a will there is a way"

  Scenario: Add Quote with background color blue 4
    Given User open atlas web playground page
    When User input quote "There is a will there is a way"
    And User select color "Blue"
    And User click button add quote
    Then User see quote "There is a will there is a way"