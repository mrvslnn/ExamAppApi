Feature: moderator

  Scenario: Moderator create
    Given I have a request as "superadmin" to create a "moderator"
    Then verify created user with 201 status code

  Scenario: Get moderators by id
    Given I have a request to get moderator with id 155
    When verify user with status code 200

  Scenario: Topic Create
    Given I have a request as "moderator" to create "topic"
    Then  verify created topic with status code 201

  Scenario:Subject create
    Given Given I have a request as "moderator" to create "subject"
    Then verify created subject with status code 201