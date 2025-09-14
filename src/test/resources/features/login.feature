Feature: Login and User Management Tests

  @login
  Scenario: Test login functionality
    Given I am logged in with username "Admin" and password "admin123"
    Then I should be on the dashboard page

  @priority=1
  Scenario: Navigate to Admin page
    Given I am logged in with username "Admin" and password "admin123"
    Given I am on the admin page

  @priority=2
  Scenario: Check records count
    Given I am logged in with username "Admin" and password "admin123"
    Given I am on the admin page
    When I check the records count
    Then I should get the current records count

  @priority=3
  Scenario: Add new record
    Given I am logged in with username "Admin" and password "admin123"
    Given I am on the admin page
    And I have the record count before addition
    When I add a new record
    Then the record count should increase by one

  @priority=4
  Scenario: Search for item
    Given I am logged in with username "Admin" and password "admin123"
    Given I am on the admin page
    When I search for an item
    Then the search should be successful

  @priority=5
  Scenario: Delete user
    Given I am logged in with username "Admin" and password "admin123"
    Given I am on the admin page
    And I have the record count before addition
    When I delete a user
    Then the record count should decrease by one