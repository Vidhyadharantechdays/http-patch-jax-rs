Feature: Test for REST API upload test.
Background:
* url apiUrl
  
  Scenario: Test for text file upload 
    Given path 'upload/fileupload'
    Given multipart file myFile = { read: 'classpath:com/labkit/test/personapi/upload-test-sample.txt'}
    When method post
    Then status 200
  
