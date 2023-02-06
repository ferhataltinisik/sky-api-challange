Feature: Internal Server Error Tests
  This feature includes tests that test the Sky Internal Server Error  RESTFul services


  Scenario: Verify Internal Server Error GET response from API for GET method
    Given the user makes a request GET to an API endpoint
    When the server encounters an error and returns a 500 Internal Server Error response
    Then the response should include a JSON object


  Scenario: Verify Internal Server Error response from API for POST method
    Given the user makes a POST request to an API endpoint
    When the server encounters an error and returns a 500 Internal Server Error response
    Then the response should include a JSON object with the requested data

  Scenario: Verify Internal Server Error the latest response from API
    Given the user makes a GET request to the latest internal server error API endpoint
    When the server encounters an error and returns a 200 Internal Server Error response
    Then the response should include a JSON object with the requested data and last updated time

