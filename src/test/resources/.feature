@All
Feature: Check reqres.in

  @Smoke @Sanity #@Defect
  Scenario: Verify that GET request return status code 200
    Given I have server by url "https://reqres.in"
    When I send GET request on endpoint "/api/users" with page 2
    Then I check if status code is 200

  @Sanity
  Scenario Outline: Check POST method return status code 201
    Given I have server by url "https://reqres.in"
    When I register new user with user name "<name>" and job "<job>"
    Then I check if status code is <code>
    Examples:
      | name  | job  | code |
      | vasya | qa   | 201  |
      | petya | dev  | 201  |
      | kolya | auto | 201  |

  @Sanity
  Scenario: Check POST Response Body Not Null
    Given I have server by url "https://reqres.in"
    When I send an empty body
    Then I check if the response doesn't has name and job fields
