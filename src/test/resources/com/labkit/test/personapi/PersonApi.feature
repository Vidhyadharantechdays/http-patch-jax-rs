Feature: Test Person API
  Scenario: Navigate to Get person
    Given url 'http://http-patch-vidhya.1d35.starter-us-east-1.openshiftapps.com/v1/person'
    When method GET
    Then status 200
