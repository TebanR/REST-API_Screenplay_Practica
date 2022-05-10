Feature: Create user in web service
  As a user of the service
  i need to test the http statements of the page
  to validate its functionality.

  Scenario: CreateUser
    Given that the user is in the service
    When the user registers with his credentials name "morpheus" and job "leader"
    Then the user should see a success response code and build id