Feature: RegistrationFeature
  This feature deals with registration functionality
  Scenario: Registration with correct and uncorrect data
    Given I navigate to http://demoqa.com/
    And I go to registration page
    When I fill all fields
    And I click register button
    And I see correct registration message
    And I fill again with the same data
    And I click register button
    And I see Username Already Exist message
    And I change username
    And I click register button
    And I see Email address already exist message
    And I change email address
    And I click register button
    Then I see correct registration message