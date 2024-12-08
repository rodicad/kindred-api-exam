package com.kindred.sports.tests;

import com.kindred.sports.api.StatusCode;
import com.kindred.sports.base.BaseTest;
import com.kindred.sports.models.Match;
import com.kindred.sports.services.MatchesService;
import com.kindred.sports.utils.TestData;
import com.kindred.sports.utils.TestDataFile;
import com.kindred.sports.utils.TestDataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class MatchTests extends BaseTest {
    private final MatchesService matchesService = new MatchesService();
    private Response matchResponse;

    @Test(dataProvider = "getTestData", dataProviderClass = TestDataProvider.class)
    @TestDataFile("sports.json")
    public void testSportHasMatches(TestData testData) throws IOException {
        matchResponse =matchesService.getMatchesForSport(getLobbyURL(),getHeaders(), testData.getQueryParams());
        Assert.assertEquals(matchResponse.statusCode(),StatusCode.CODE_200.code, "Expected 200 status code, but got: "+matchResponse.statusCode());

        List<Match> matches= matchesService.parseMatchResponse(matchResponse).getMatches();
        Assert.assertNotNull(matches, "Match categories should not be null");

        if (matches.size() > 0) {
            for (Match match : matches) {
                Assert.assertTrue(match.getMatchCategories().size() > 0, "There should be matches for " + testData.getQueryParams().get("category"));
                System.out.println(" match_id:  " + match.getIdentifier() + " has: " + match.getMatchCategories().size() + " categories");
            }

        }
    }

    @Test(description = "Validate error handling for invalid sport name")
    public void testInvalidCategoryError() {
        Response matchResponse =matchesService.getMatchesForSport(getLobbyURL(),getHeaders(), Map.of("category", "invalidSportName"));
        Assert.assertEquals(matchResponse.getStatusCode(), 400, "Expected 400 Bad Request status code!");
        String errorMessage = matchResponse.jsonPath().getString("message");
        Assert.assertTrue(errorMessage.contains("Invalid category"), "Error message is incorrect");
    }

    @Test(description = "Validate error handling for invalid sport name")
    public void testMissingHeadersError() {
        Response matchResponse =matchesService.get(getLobbyURL());
        Assert.assertEquals(matchResponse.getStatusCode(), 400, "Expected 400 Bad Request status code!");
        String errorMessage = matchResponse.jsonPath().getString("message");
        System.out.println("response msg: "+matchResponse.asPrettyString());
        Assert.assertTrue(errorMessage.contains("Invalid category"), "Error message is incorrect");
    }



}
