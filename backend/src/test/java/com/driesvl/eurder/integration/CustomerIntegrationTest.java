package com.driesvl.eurder.integration;

import com.driesvl.eurder.EurderApplication;
import com.driesvl.eurder.authorization.repository.domain.Role;
import com.driesvl.eurder.authorization.repository.domain.User;
import com.driesvl.eurder.customer.repository.domain.Address;
import com.driesvl.eurder.customer.repository.domain.Customer;
import com.driesvl.eurder.customer.repository.domain.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EurderApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
//@Import(CustomerTestContextConfiguration.class)
class CustomerIntegrationTest {
    private final String uri = "http://localhost:";
    @Autowired
    private MockMvc mockMvc;
    @LocalServerPort
    private int port;

    @Test
    void givenCustomers_whenGetCustomer_thenStatus200()
            throws Exception {

        HttpHeaders header = getAdminHeaders("admin@mail.com", "pwd");

        mockMvc.perform(
                        get(uri + port + "/customer")
                                .contentType("application/json")
                                .headers(header))
                .andExpect(status().isOk());
    }

    private HttpHeaders getAdminHeaders(String user, String password) {
        String basic = "Basic " + Base64.getEncoder().encodeToString((user + ":" + password).getBytes());
        Map<String, String> map = new HashMap<>();
        map.put("authorization", basic);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(map);
        return httpHeaders;
    }

    private Customer makeCustomer() {
        User user = new User("testusermail@mail.com", "pwd", Role.CUSTOMER);
        Name name = new Name("Testfirstname", "Testlastname");
        String phoneNumber = "0467952134";
        Address address = new Address("teststreet", "1", "Testcity");
        return new Customer(user, name, phoneNumber, address);
    }
}
