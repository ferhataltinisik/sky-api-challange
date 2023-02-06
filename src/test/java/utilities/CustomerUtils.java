package utilities;

import io.restassured.response.Response;
import testData.Customer;

public class CustomerUtils extends BaseUtils{

    public static Response getCustomerDetails() {
        String url = ConfigurationReader.get("baseUri") + ConfigurationReader.get("internal_server_end_point");
        return sendRequest(BaseUtils.GET, url, null);
    }

    public static Response createCustomer(Customer customer) {
        String url = ConfigurationReader.get("baseUri") + ConfigurationReader.get("internal_server_end_point");
        System.out.println("url -> " + url);
        String payload = createJSONPayload(customer).toString();
        return sendRequest( BaseUtils.POST, url, payload);
    }

}
