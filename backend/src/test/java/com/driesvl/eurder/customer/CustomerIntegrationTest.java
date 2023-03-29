package com.driesvl.eurder.customer;

import io.restassured.RestAssured;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerIntegrationTest {
    @LocalServerPort
    private int port;
    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:";
    }

    @Test
    void getAllMembersReturnsAListOfMembers() {
        RestAssured.given()
                .baseUri(uri)
                .port(port)
                .auth()
                .preemptive()
                .basic("7be5de12-c8be-11ed-afa1-0242ac120002", "")
                .accept(JSON)
                .when()
                .get("/customer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.UNAUTHORIZED.value());
    }
}
