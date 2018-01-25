Feature: Test for REST API upload test.
Background:
* url apiUrl
  
  Scenario: Test for text file upload via binary
    Given path 'upload/fileupload'
    And request read('upload-test-sample.txt')
    And header Content-Type = 'application/octet-stream'    
    When method post
    Then status 200
    And match response == 30  
