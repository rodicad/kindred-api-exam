package com.kindred.sports.api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ContestPageAPI {

    private static final String BASE_URL = "https://sportsbff-ams.kindredext.net/sports-api/api/v1/views/contestpage";

    /**
     * Sends a GET request to the contest page API.
     *
     * @param contestKey The contest key for the specific event.
     * @param authToken  The authorization token for accessing the API.
     * @return The response from the API.
     */
    public Response getContestPageData(String contestKey, String authToken) {
        // Set up the request specification (headers, base URI, etc.)
        RequestSpecification request = RestAssured.given();

        // Add necessary headers
        request.header("Authorization", "Bearer " + authToken);
        request.header("Content-Type", "application/json");

        // Add query parameters
        request.queryParam("_typ", "GetContestWithPricesReq");
        request.queryParam("contestKey", contestKey);

        // Send the GET request and return the response
        Response response = request.get(BASE_URL);

        // Return the response object so the test can verify it
        return response;
    }

    /**
     * Example: Fetch and return a contest page's response as a String (for easier assertion in tests).
     *
     * @param contestKey The contest key for the specific event.
     * @param authToken  The authorization token for accessing the API.
     * @return The contest page's data in string format.
     */
    public String getContestPageDataAsString(String contestKey, String authToken) {
        Response response = getContestPageData(contestKey, authToken);
        return response.asString();  // Converts the response body to a string
    }
}
