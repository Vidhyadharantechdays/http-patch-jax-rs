Feature: Test Person API
Background:
* url apiUrl
  
  Scenario: Test for PUT person
    Given path 'person'
    And request {"name":"Vidhya","age":29,"locale":"en","twitter":"VidhyaJava","email":"it.vidhyadharan@gmail.com"}
    And header Accept = 'application/json'   
    When method PUT
    And header Content-Type = 'application/json'        
    Then status 204
  Scenario: Navigate to Get person
    Given path 'person'
    When method GET
    Then status 200
    And match response == {"name":"Vidhya","age":29,"locale":"en","twitter":"VidhyaJava","email":"it.vidhyadharan@gmail.com"}
  Scenario: Test for POST person
    Given path 'person'
    And request {"name":"Vidhya","age":29,"locale":"en","twitter":"VidhyaJava","email":"it.vidhyadharan@gmail.com"}
    And header Accept = 'application/json'   
    When method post
    And header Content-Type = 'application/json'        
    Then status 204
  Scenario: Test for PATCH METHOD 
    Given path 'person'
    And request [{ "op": "remove", "path": "/email" }, {"op":"replace", "path": "/name", "value": "Vidhyadharan Deivamani" }]
    And header Accept = 'application/json'   
    When method PATCH
    And header Content-Type = 'application/json-patch+json'        
    Then status 200