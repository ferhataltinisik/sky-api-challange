package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import testData.Customer;
import utilities.AssertUtils;
import utilities.CustomerUtils;
import testData.*;

import java.util.UUID;


public class InternalServerErrorTests {
    Response response = null;
    Customer customer = null;

    @Given("the user makes a request GET to an API endpoint")
    public void theUserMakesARequestGETToAnAPIEndpoint() {
        response= CustomerUtils.getCustomerDetails();
    }

    @When("the server encounters an error and returns a {int} Internal Server Error response")
    public void the_server_encounters_an_error_and_returns_a_internal_server_error_response(Integer responseCode) {
        AssertUtils.assertEquals(response.statusCode(), responseCode);
    }

    @Then("the response should include a JSON object")
    public void theResponseShouldIncludeAJSONObject() {
        AssertUtils.assertNotNull(response.jsonPath().get("errors[0].timestamp"));
        AssertUtils.assertEquals(response.jsonPath().get("errors[0].type"), "FAILURE");
        AssertUtils.assertEquals(response.jsonPath().get("errors[0].code"), "internal_server_error");
        AssertUtils.assertEquals(response.jsonPath().get("errors[0].message"), "500 Internal Server Error");

    }

    @Given("the user makes a POST request to an API endpoint")
    public void theUserMakesAPOSTRequestToAnAPIEndpoint() {

        CreateTestData createTestData = new CreateTestData();
        customer = createTestData.createCustomer();
        response= CustomerUtils.createCustomer(customer);

    }

    @Then("the response should include a JSON object with the requested data")
    public void theResponseShouldIncludeAJSONObjectWithTheRequestedData() {
        AssertUtils.assertNotNull(response.jsonPath().get("errors[0].timestamp"));
        AssertUtils.assertEquals(response.jsonPath().get("errors[0].type"), "FAILURE");
        AssertUtils.assertEquals(response.jsonPath().get("errors[0].code"), "internal_server_error");
        AssertUtils.assertEquals(response.jsonPath().get("errors[0].message"), "Failed to convert value of type java.lang.String to required type java.util.UUID");
        AssertUtils.assertEquals(response.jsonPath().get("errors[1].receivedRequest[0]"), customer.getCustomerId());
        AssertUtils.assertEquals(response.jsonPath().get("errors[1].receivedRequest[0]"), customer.getFirstName());
        AssertUtils.assertEquals(response.jsonPath().get("errors[1].receivedRequest[0]"), customer.getLastName());
        AssertUtils.assertEquals(response.jsonPath().get("errors[1].receivedRequest[0]"), customer.getAddress());
        AssertUtils.assertEquals(response.jsonPath().get("errors[1].receivedRequest[0]"), customer.getPhoneNumber());
    }

    @Given("the user makes a GET request to the latest internal server error API endpoint")
    public void theUserMakesAGETRequestToTheLatestInternalServerErrorAPIEndpoint() {
        response= CustomerUtils.getTheLatestInternalServerError();
    }
    @Then("the response should include a JSON object with the requested data and last updated time")
    public void theResponseShouldIncludeAJSONObjectWithTheRequestedDataAndLastUpdatedTime() {
        AssertUtils.assertNotNull(response.jsonPath().get("data[0].lastUpdated"));
        AssertUtils.assertNotNull(response.jsonPath().get("data[1].receivedRequest[0].customerId"));
        AssertUtils.assertNotNull(response.jsonPath().get("data[1].receivedRequest[0].firstName"));
        AssertUtils.assertNotNull(response.jsonPath().get("data[1].receivedRequest[0].lastName"));
        AssertUtils.assertNotNull(response.jsonPath().get("data[1].receivedRequest[0].address"));
        AssertUtils.assertNotNull(response.jsonPath().get("data[1].receivedRequest[0].phoneNumber"));
    }


}
