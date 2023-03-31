/*
package com.driesvl.eurder.integration;

import com.driesvl.eurder.EurderApplication;
import com.driesvl.eurder.authorization.repository.domain.Role;
import com.driesvl.eurder.authorization.repository.domain.User;
import com.driesvl.eurder.customer.repository.domain.Address;
import com.driesvl.eurder.customer.repository.domain.Customer;
import com.driesvl.eurder.customer.repository.domain.Name;
import com.driesvl.eurder.item.api.dto.CreateItemDTO;
import com.driesvl.eurder.item.repository.domain.Item;
import com.driesvl.eurder.order.api.dto.CreateOrderDTO;
import com.driesvl.eurder.order.api.dto.ItemGroupDTO;
import com.driesvl.eurder.order.repository.domain.Order;
import nonapi.io.github.classgraph.json.JSONSerializer;
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
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EurderApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
//@Import(CustomerTestContextConfiguration.class)
class OrderIntegrationTest {
    private final String uri = "http://localhost:";
    @Autowired
    private MockMvc mockMvc;
    @LocalServerPort
    private int port;

    @Test
    void addingOrderReturnsStatusCodeCreated() throws Exception {
        HttpHeaders header = getAdminHeaders("gertje@gmail.com", "pwd");
        CreateOrderDTO createOrderDTO = makeCreateOrderDTO();

        mockMvc.perform(
                        post(uri + port + "/order")
                                .contentType("application/json")
                                .content(JSONSerializer.serializeObject(createOrderDTO))
                                .headers(header))
                .andExpect(status().isCreated());
    }

    private HttpHeaders getAdminHeaders(String user, String password) {
        String basic = "Basic " + Base64.getEncoder().encodeToString((user + ":" + password).getBytes());
        Map<String, String> map = new HashMap<>();
        map.put("authorization", basic);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(map);
        return httpHeaders;
    }

    private CreateOrderDTO makeCreateOrderDTO() {
        return new CreateOrderDTO(new HashMap<>(Map.of(UUID.fromString("d7b17e43-e76f-4d63-9b05-3f4268b16a33"), 1,
                UUID.fromString("40a380d4-0b54-4442-ac20-bce13ed83844"), 2)));
    }
}*/
