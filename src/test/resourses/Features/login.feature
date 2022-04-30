Feature:Login

  @Login1
  Scenario: User should be able to login with valid credentials
    Given make a request for all user
    When verify if the login successful