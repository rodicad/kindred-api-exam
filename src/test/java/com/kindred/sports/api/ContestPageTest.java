package com.kindred.sports.api;

public class ContestPageTest {

//    @Test
//    public void testMissingHeaders() {
//        // Base URI for the API
//        RestAssured.baseURI = "https://sportsbff-ams.kindredext.net";
//
//        // API Call without headers
//        Response response = given()
//                .queryParam("_typ", "GetContestWithPricesReq")
//                .queryParam("contestKey", "cc0a4a6a9c4e6dd181c6b27961d80f2f")
//                .get("/sports-api/api/v1/views/contestpage");
//
//        // Validate 404 response
//        response.then().statusCode(404);
//
//        // Print the response for debugging
//        System.out.println("Response: " + response.prettyPrint());
//    }
//
//    @Test
//    public void testWithHeaders() {
//        // Add the required headers
//        Response response = given()
//                .header("Authorization", "Bearer YOUR_TOKEN_HERE")
//                .header("Content-Type", "application/json")
//                .queryParam("_typ", "GetContestWithPricesReq")
//                .queryParam("contestKey", "cc0a4a6a9c4e6dd181c6b27961d80f2f")
//                .get("/sports-api/api/v1/views/contestpage");
//
//        // Validate the success response
//        response.then().statusCode(200)
//                .body("data", notNullValue());
//
//        // Print the response for debugging
//        System.out.println("Response: " + response.prettyPrint());
//    }
}
