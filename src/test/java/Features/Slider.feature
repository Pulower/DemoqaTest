Feature: SliderFeature
  This feature deals with slider funcionality

  Scenario Outline: Changing slider position
    Given I navigate to http://demoqa.com/slider/
    When I reset slider
    And move slider to <SliderPosition>
    Then I check <SliderRange>

    Examples:
      | SliderPosition | SliderRange |
      | 1              | 0%          |
      | 2              | 11.1111%    |
      | 3              | 22.2222%    |
      | 4              | 33.3333%    |
      | 5              | 44.4444%    |
      | 6              | 55.5556%    |
      | 7              | 66.6667%    |
      | 8              | 77.7778%    |
      | 9              | 88.8889%    |
      | 10             | 100%        |