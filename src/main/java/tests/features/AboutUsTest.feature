Feature: About us features
  Scenario: Open about us
    Given System is landed on home page
    When Click on About us from top menu
    Then About us should be opened

  Scenario: Verify values of items
    Given System is landed on home page
    When Click on About us from top menu
    Then About us should be opened
    Then Verify that HQ is San Francisko
    Then Verify that founded is 2007
    Then Verify that Size is 450+
    Then Verify that Consulting Offices is Amsterdam, Berlin, Copenhagen, London, Denver, Zurich
    Then Verify that Engineering Hubs is Sarajevo, Belgrade, Skopje, Novi Sad, Nis
    Then Verify that Clients are 100+

  Scenario: Verify URL
    Given System is landed on home page
    When Click on About us from top menu
    Then About us should be opened
    Then URL should be https://symphony.is/about-us
