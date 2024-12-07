package com.kindred.sports.base;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public Response get(String endpoint) {
        System.out.println("endpoint: "+ endpoint);
        return given()
                .header("Jurisdiction", "EE")
                .get(endpoint);
    }

    public Response get(String endpoint, Map<String,String> queryParams) {
        return given()
                .header("Jurisdiction", "EE")
                .queryParams(queryParams)
                .get(endpoint);
    }
}
