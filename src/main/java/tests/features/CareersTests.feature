Feature: Careers features
  Scenario: Open careers
    Given System is landed on home page
    When Click on Careers from top menu
    Then Careers menu should be opened
    When Click on Current openings from menu
    Then Current openings should be opened
    Then Verify that Skopje is on list
    When Click on Skopje
    Then Only position for Skopje should be appears
    When Click on first career position
    Then The new windows should be opened in new windows

