package com.kindred.sports.tests;

import com.kindred.sports.base.BaseTest;

public class LobbyTests extends BaseTest {

//    @Test(description = "Test that the number of available sports is not zero")
//    public void testNumberOfAvailableSports() throws JsonProcessingException {
//        String baseUrl = "https://sportsbff-ams.kindredext.net/sports-api/api/v1/views/az-menu";
//        Response response = RestAssured.given().header("Jurisdiction", "EE")
//                .queryParam("_typ", "GetAZMenuView")
//                .when()
//                .get(baseUrl);
//        assertThat (response.statusCode(),equalTo(200));
//
//        // Map the response directly to SportsResponse
//        SportResponse sportsResponse = response.as(SportResponse.class);
//        List<Sport> sports = sportsResponse.getItems();
//
//
//        // Print each sport
//        sports.forEach(sport ->
//                System.out.println("Sport: " + sport.getName() + ", Key: " + sport.getSportKey())
//        );
//    }
}
