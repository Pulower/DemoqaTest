Feature: FramesAndWindowsFeature
  This feature tests switching between frames and windows

  Scenario: Switching windows
    Given I navigate to http://demoqa.com/frames-and-windows/
    When I click NewBrowserTab
    And I switch to child window
    And I back to homepage
    And I switch to parent window
    And I back to homepage
    And I switch to child window
    And I close child window
    Then Windows count should be 1