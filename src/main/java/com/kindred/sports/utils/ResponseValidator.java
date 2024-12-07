//package com.kindred.sports.utils;
//
//import io.restassured.response.Response;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ResponseValidator {
//
//    /**
//     * Validates if the response has the expected status code.
//     *
//     * @param response The API response.
//     * @param expectedStatusCode The expected HTTP status code.
//     */
//    public static void validateStatusCode(Response response, int expectedStatusCode) {
//        int actualStatusCode = response.statusCode();
//        assertEquals(expectedStatusCode, actualStatusCode, "Expected status code: " + expectedStatusCode + " but got: " + actualStatusCode);
//    }
//
//    /**
//     * Validates if a specific field exists in the response body.
//     *
//     * @param response The API response.
//     * @param fieldName The field name to check in the response.
//     */
//    public static void validateFieldExistence(Response response, String fieldName) {
//        //boolean fieldExists = response.jsonPath().getBoolean(fieldName);
//       // assertTrue(fieldExists, "Field '" + fieldName + "' does not exist in the response.");
//    }
//
//    /**
//     * Validates if the response body contains a specific value.
//     *
//     * @param response The API response.
//     * @param value The value to check for in the response body.
//     */
//    public static void validateResponseContains(Response response, String value) {
//        String responseBody = response.asString();
//        assertTrue(responseBody.contains(value), "Response does not contain the expected value: " + value);
//    }
//
//    /**
//     * Validates if the response is not empty.
//     *
//     * @param response The API response.
//     */
//    public static void validateNonEmptyResponse(Response response) {
//        String responseBody = response.asString();
//        assertFalse(responseBody.isEmpty(), "Response body is empty.");
//    }
//
//    /**
//     * Validate that the response has a JSON content type.
//     *
//     * @param response The API response.
//     */
//    public static void validateJsonResponse(Response response) {
//        String contentType = response.header("Content-Type");
//        assertTrue(contentType.contains("application/json"), "Expected Content-Type to be JSON, but got: " + contentType);
//    }
//}
