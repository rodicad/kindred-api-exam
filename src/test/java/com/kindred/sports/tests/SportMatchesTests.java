package com.kindred.sports.tests;

import com.kindred.sports.api.StatusCode;
import com.kindred.sports.models.Match;
import com.kindred.sports.services.MatchesService;
import com.kindred.sports.utils.TestData;
import com.kindred.sports.utils.TestDataFile;
import com.kindred.sports.utils.TestDataProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class SportMatchesTests extends BaseTest {
    private MatchesService matchesService = new MatchesService();



    @Test(dataProvider = "getTestData", dataProviderClass = TestDataProvider.class)
    @TestDataFile("sportcategories.json")
    public void testPropositionTypeInCategory(TestData testData) {
        Response matchResponse =matchesService.get(getLobbyURL(), getHeaders(), testData.getQueryParams());
        Assert.assertEquals(matchResponse.statusCode(), StatusCode.CODE_200.code, "Expected " + StatusCode.CODE_200.code + " status code, but got: " + matchResponse.statusCode());
        List<Match> matches = matchesService.parseMatchResponse(matchResponse).getMatches();
        matchesService.processMatches(matches);

        if (matches != null) {
            for (Match match : matches) {
                match.getContestGroups().forEach(contestGroup ->
                        contestGroup.getContests().forEach(contest -> {
                            boolean exists = contest.getPropositions().stream()
                                    .anyMatch(proposition -> testData.getPropositionType().equals(proposition.getPropositionType()));
                            assertTrue(exists, "None of the " + contestGroup.getContests().size() + " contests, has a propositionType: " +
                                    testData.getPropositionType());
                        })
                );
            }

        }
    }

    //@Test(dataProvider = "getTestData", dataProviderClass = TestDataProvider.class)
    //@TestDataFile("sportcategories.json")
    @Test
    public void testMissingHeadersInContest() {

        String url = "https://sportsbff-ams.kindredext.net/sports-api/api/v1/views/contest-page";
        // Second request with query parameters passed in Map
//        Map<String, String> params = Map.of(
//                "category", "football:italy:serie_a",
//                "clientOffset", "-60",
//                "_typ", "GetLobbyPageView"
//        );
        Map<String, String> params = Map.of(
                "_typ", "GetContestWithPricesReq",
                "contestKey", "cc0a4a6a9c4e6dd181c6b27961d80f2f"
        );


        //String urll="https://sportsbff-ams.kindredext.net/sports-api/api/v1/views/lobby";
        Response response = RestAssured.given()
                .queryParams(params)
                .header("Jurisdiction", "UK")
                .log().all().get(url);
        System.out.println("response: " + response.statusCode());
        System.out.println("response: " + response.asString());


//        matchResponse = matchesService.getContestsForSportCategory(getLobbyURL(),null, testData.getQueryParams());
//        System.out.println("Status code: "+matchResponse.statusCode());
//        System.out.println("response: "+matchResponse.jsonPath().getString("error.message"));
    }

    @Test
    public void testInavlidJurisdiction() {
        //TODO
    }

//    @Test(dataProvider = "getTestData", dataProviderClass = TestDataProvider.class)
//    @TestDataFile("contestkeys.json")
//    public void testPropositionTypeInSpecificContest(TestData testData) {
//        ContestService contestService = new ContestService();
//        Response contestResponse = contestService.get(getContestURL(), getHeaders(), testData.getQueryParams());
//        ContestResponse contest = contestService.parseContestResponse(contestResponse);
//        List<Proposition> propositions = contest.getContest().getPropositions();
//        System.out.println("Propositions count: " + propositions.size());
//
//        Assert.assertEquals(contestResponse.statusCode(), StatusCode.CODE_200.code, "Expected " + StatusCode.CODE_200.code + " status code, but got: " + contestResponse.statusCode());
//
//    }


}
