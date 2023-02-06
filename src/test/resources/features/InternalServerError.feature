Feature: Order Tests
  This feature includes tests that test the store order RESTFul services


  Scenario: Verify Internal Server Error GET response from API for GET method
    Given the user makes a request GET to an API endpoint
    When the server encounters an error and returns a 500 Internal Server Error response
#    Then the response should include a JSON object


  Scenario: Verify Internal Server Error response from API for POST method
    Given the user makes a POST request to an API endpoint
    When the server encounters an error and returns a 500 Internal Server Error response
    Then the response should include a JSON object with the requested data



  Scenario: A pet order should be completed successfully by a user
    Given the endpoint is up
#    When i post an order for a pet by orderId 12
#    Then the status code returns 200
#    And pet order is completed and status set as "placed" successfully

#  Scenario: An order for an nonexistent pet should not be completed by a user
#    Given the endpoint is up
#    When i post an order for a pet by orderId 100
#    Then successful response code returns
#    And unavailable pet order is not completed successfully

#
#  Scenario: Display order details successfully
#    Given the endpoint is up
#    When i try to get order details by orderId 1
#    Then order details should be able to displayed for orderId 1 successfully
##
##
#  Scenario Outline: Details should not be displayed for nonexistent order id
#    Given the endpoint is up
#    When i try to get order details by orderId 400
#    Then error message should be received "<error message>"
#
#    Examples:
#      | error message |
#      | Order not found |
#
#  Scenario: Delete an order successfully
#    Given the endpoint is up
#    When i try to delete order details by orderId 4
#    Then order should be deleted successfully
#
#
#  Scenario: Delete a unavailable order
#    Given the endpoint is up
#    When i try to delete order details by orderId 500
#    Then verify unavailable order
