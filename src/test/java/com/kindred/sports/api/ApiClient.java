package com.kindred.sports.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public ApiClient() {
        System.out.println("created apli client");
    }

    public Response get(String url) {
        return executeGetRequest(url, null, null);
    }

    public Response get(String url, Map<String, String> headers) {
        return executeGetRequest(url, headers, null);
    }

    public Response get(String url, Map<String, String> headers, Map<String, String> queryParams) {
        return executeGetRequest(url, headers, queryParams);
    }

    /**
     * Executes a GET request with the provided URL, headers, and query parameters.
     */
// Helper method to execute the GET request with optional headers and query parameters
    private Response executeGetRequest(String url, Map<String, String> headers, Map<String, String> queryParams) {
        RequestSpecification requestSpec = new RequestSpecBuilder().build();

        // Add custom headers if provided
        if (headers != null && !headers.isEmpty()) {
            requestSpec.headers(headers);
        }

        // Add query parameters if provided
        if (queryParams != null && !queryParams.isEmpty()) {
            requestSpec.queryParams(queryParams);
        }

        // Optionally log request details
        requestSpec.log().uri();
        requestSpec.log().headers();
        requestSpec.log().params();

        // Execute GET request
        return given(requestSpec).get(url);
    }
}
