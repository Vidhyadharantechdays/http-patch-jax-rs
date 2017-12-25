Feature: Test Person API
Background:
* url apiUrl
  Scenario: Navigate to Get person
    Given path 'person'
    When method GET
    Then status 200
