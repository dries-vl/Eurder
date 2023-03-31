//package com.driesvl.eurder.integration;
//
//import com.driesvl.eurder.EurderApplication;
//import com.driesvl.eurder.customer.repository.CustomerRepository;
//import io.restassured.RestAssured;
//import jakarta.annotation.PostConstruct;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static io.restassured.http.ContentType.JSON;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = EurderApplication.class)
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
//class CustomerIntegrationTest {
//    @Autowired
//    private MockMvc mvc;
//    @Autowired
//    private CustomerRepository customerRepository;
//    @LocalServerPort
//    private int port;
//    private final String uri = "http://localhost:";
//
//    @Test
//    public void givenCustomers_whenGetCustomer_thenStatus200()
//            throws Exception {
//
//        createTestCustomer("bob");
//
//        mvc.perform(get("/api/employees")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].name", is("bob")));
//    }
//}
