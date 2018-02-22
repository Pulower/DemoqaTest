Feature: DatePickerFeature
  This feature tests date picker functionality

  Scenario: Choosing present date
    Given I navigate to http://demoqa.com/datepicker/
    And I set present date April 24 2020
    Then I see correct present date in text field

  Scenario: Choosing past date
    Given I navigate to http://demoqa.com/datepicker/
    And I set past date January 1 2017
    Then I see correct past date in text field