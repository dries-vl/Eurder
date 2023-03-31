package com.driesvl.eurder.integration;

import com.driesvl.eurder.EurderApplication;
import com.driesvl.eurder.item.api.dto.CreateItemDTO;
import com.driesvl.eurder.item.repository.domain.Item;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EurderApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
//@Import(CustomerTestContextConfiguration.class)
class ItemIntegrationTest {
    private final String uri = "http://localhost:";
    @Autowired
    private MockMvc mockMvc;
    @LocalServerPort
    private int port;

    @Test
    void addingItemReturnsStatusCodeCreated()
            throws Exception {

        Item item = makeItem();
        CreateItemDTO createItem = makeCreateItemDTO();
        HttpHeaders header = getAdminHeaders("admin@mail.com", "pwd");

        mockMvc.perform(
                        post(uri + port + "/item")
                                .contentType("application/json")
                                .content(JSONSerializer.serializeObject(createItem))
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

    private CreateItemDTO makeCreateItemDTO() {
        return new CreateItemDTO("Test item", "Test descr", 10.00, 15);
    }

    private Item makeItem() {
        return new Item("Test item", "Test descr", 10.00, 15);
    }
}