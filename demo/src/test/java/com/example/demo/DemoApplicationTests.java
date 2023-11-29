package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:1790"; // Set your Spring Boot application base URL
    }


    @Test
    public void runApiTests() {
        File postmanCollection = new File("/home/libsys/eclipse-workspace/testing/New Collection.postman_collection.json");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .log().all() // Log request details
                .when()
                .get("/list") // Your actual API endpoint
                .then()
                .log().all() // Log response details
                .statusCode(200); 
    }
    @Test
    public void testCreatePerson() {
        // Create a sample person for testing
        Map<String, String> person = new HashMap<>();
        
        person.put("firstName", "bby");
        person.put("lastName", "don");
       
        

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(person)
                .when()
                .post("/create")
                .then()
                .statusCode(200); 
    }
}
