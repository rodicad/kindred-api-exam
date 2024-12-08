package com.kindred.sports.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiClient {
    private final RequestSpecification requestSpecification;

    // Constructor to initialize common configurations, e.g., headers
    public ApiClient() {
        // Initialize common request configuration
        this.requestSpecification = given();
    }
    public Response get(String url) {
        return executeGetRequest(url, null, null);
    }

    public Response get(String url, Map<String,String> headers) {
        return executeGetRequest(url, headers, null);

    }


    public Response get(String url, Map<String, String> headers,Map<String,String> queryParams) {
        return executeGetRequest(url, headers,  queryParams);

    }


    // Helper method to execute the GET request with optional headers and query parameters
    private Response executeGetRequest(String url, Map<String, String> headers, Map<String, String> queryParams) {
        RequestSpecification request = requestSpecification;

        // Add custom headers if provided
        if (headers != null) {
            request.headers(headers);
        }

        // Add query parameters if provided
        if (queryParams != null) {
            request.queryParams(queryParams);
        }

        // Optionally log request details
        request.log().all();

        // Execute GET request
        return request.get(url);
    }

}
