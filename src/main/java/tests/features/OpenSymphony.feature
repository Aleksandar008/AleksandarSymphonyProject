Feature: Basic test
Scenario: Open Home Page
    Given Open chrome and navigate to "https://symphony.is"
    When Open "https://symphony.is" click on Accept cookies
    Then Cookies should gone
