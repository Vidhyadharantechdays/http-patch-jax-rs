Feature: Test Person API
Background:
* url apiUrl
  Scenario: Navigate to Get person
    Given path 'person'
    When method GET
    Then status 200
    And match response == {"name":"Vidhya","age":29,"locale":"en","twitter":"VidhyaJava","email":"it.vidhyadharan@gmail.com"}
