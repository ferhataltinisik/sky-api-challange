package testData;

import com.github.javafaker.Faker;

import java.util.UUID;

public class CreateTestData {

    String customerId = UUID.randomUUID().toString();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String address = faker.address().fullAddress();
    String phoneNumber = faker.numerify("7#########");

    public Customer createCustomer(){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setPhoneNumber(phoneNumber);
        return customer;
    }

}
