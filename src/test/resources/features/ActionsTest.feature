Feature: Test UI of testautomation.ca
  Scenario: User clicks on the Actions link and lands on the Actions page.
    Given User has access to url "https://testautomation.ca".
    When User clicks on the Actions link.
    Then Actions page should load and have a title of "TestAutomation | Actions".

  Scenario: User goes to Actions page and double-clicks on a button to see a delayed message.
    Given User has access to url "https://testautomation.ca".
    When User clicks on the Actions link.
    And User double-clicks on the button with delayed message.
    Then User should eventually see the delayed message "Message delayed: Button double-clicked".