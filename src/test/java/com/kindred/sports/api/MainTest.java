package com.kindred.sports.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MainTest {
    public static void main(String[] args) {
        String brokenUrl = "https://sportsbff-ams.kindredext.net/sports-api/api/v1/views/contest-page?_typ=GetContestWithPricesReq&contestKey=cc0a4a6a9c4e6dd181c6b27961d80f2f";
        String comparisonUrl = "https://www.unibet.ee/betting/odds/sportlobby/default/Football/football:italy:serie_a";
        Response response = (Response) RestAssured.given() // Log request and response
                //.header("Jurisdiction","EE")
                .when()
                .get(brokenUrl);

        // Print the response headers and body for debugging
        System.out.println("Status Code: " + response.getStatusCode());
//        System.out.println("Response Headers: " + response.getHeaders());
//        List<String> propositionTypes = response.jsonPath().getList("contest.propositions.propositionType");
//        System.out.println( propositionTypes.contains("1x2"));


//        String baseUrl = "https://sportsbff-ams.kindredext.net/sports-api/api/v1/views/lobby";
//        given().header("Jurisdiction", "EE")
//                .queryParam("category", "football:italy:serie_a")
//        .when()
//                .get(baseUrl)
//        .then()
//                .log().all()
//                .assertThat()
//                    .statusCode(200)
//                    .body("view.matches.size()", equalTo(7))
//                    .body("view.matches.contestGroups.contests.propositions.size()", equalTo(7));



//        Response response = given()
//                    .header("Jurisdiction", "EE")
//                    //.queryParam("_typ", "GetLobbyPageView")
//                    .queryParam("category", "football:italy:serie_b")  // Serie A football
//                    //.queryParam("clientOffset", "-60")  // Adjust time zone if necessary
//                .when()
//                    .get(baseUrl);
//
//        response.then().statusCode(201);



        // Print the response body to check the match details
//        System.out.println("Response Body: " + response.getBody().asString());
//
//
//        // Optionally, extract specific match data from the response if the structure is known
//        // Example of extracting a list of matches (adjust the path based on actual response)
//        List<Map<String, Object>> matches = response.jsonPath().getList("view.matches");
//        everyItem(matches.get("contestGroups").get("contests")).satisfies(match -> {
//        System.out.println(matches.size());



    }
}