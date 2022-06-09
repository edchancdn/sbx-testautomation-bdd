Feature: Test UI of testautomation.ca
  Scenario: User clicks on the Actions link and lands on the Actions page.
    Given User has access to url "https://testautomation.ca".
    When User clicks on the Actions link.
    Then Actions page should load and have a title of "TestAutomation | Actions".