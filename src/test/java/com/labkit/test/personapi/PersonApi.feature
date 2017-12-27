Feature: Test Person API
Background:
* url apiUrl
  
  Scenario: Test for PUT person
    Given path 'person'
    And request {"name":"Vidhya","age":29,"locale":"en","twitter":"VidhyaJava","email":"it.vidhyadharan@gmail.com"}
    And header Accept = 'application/json'   
    When method put
    And header Content-Type = 'application/json'        
    Then status 204
