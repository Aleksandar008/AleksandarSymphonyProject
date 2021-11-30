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
    Then Verify on new window that info for location, title and type are same as prevous screen

    Scenario: Write all open position in txt file
      Given System is landed on home page
      When Click on Careers from top menu
      Then Careers menu should be opened
      When Click on Current openings from menu
      Then Current openings should be opened
      Then Write all open position in .txt file

  Scenario: Count all open position
    Given System is landed on home page
    When Click on Careers from top menu
    Then Careers menu should be opened
    When Click on Current openings from menu
    Then Current openings should be opened
    Then Count all opened position and also count by location and assert it.

    Scenario: Count all open position fail scenario and send screenshot via email  Given System is landed on home page
      When Click on Careers from top menu
      Then Careers menu should be opened
      When Click on Current openings from menu
      Then Current openings should be opened
      Then Count all opened position and also count by location and assert it.
      Then Take a screenshot
      When Click on gmail.com
      Then Enter credential
      When login in mail
      Then Sent mail within screenshot

