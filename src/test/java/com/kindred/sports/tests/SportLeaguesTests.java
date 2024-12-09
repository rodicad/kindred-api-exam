package com.kindred.sports.tests;

import com.kindred.sports.api.StatusCode;
import com.kindred.sports.models.Match;
import com.kindred.sports.services.MatchesService;
import com.kindred.sports.utils.TestData;
import com.kindred.sports.utils.TestDataFile;
import com.kindred.sports.utils.TestDataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SportLeaguesTests extends BaseTest {
    private final MatchesService matchesService = new MatchesService();

    @BeforeClass
    public void printSuiteDescription() {
        System.out.println("Executing Test Suite: Sport Leagues Test Suite");
        System.out.println("Description: This suite validates  API calls against specific sport leagues, provided  in the sportleagues.json data file. .");
    }



    @Test(dataProvider = "getTestData", dataProviderClass = TestDataProvider.class)
    @TestDataFile("sportleagues.json")
    public void testPropositionTypeSportLeague(TestData testData) {
        Response matchResponse = matchesService.get(getLobbyURL(), getHeaders(), testData.getQueryParams());
        Assert.assertEquals(matchResponse.statusCode(), StatusCode.CODE_200.code, "Expected " + StatusCode.CODE_200.code + " status code, but got: " + matchResponse.statusCode());

        List<Match> matches = matchesService.parseMatchResponse(matchResponse).getMatches();

        if (matches != null) {
            matchesService.processMatches(matches);
            for (Match match : matches) {
                match.getContestGroups().forEach(contestGroup ->
                        contestGroup.getContests().forEach(contest -> {
                            boolean exists = contest.getPropositions().stream()
                                    .anyMatch(proposition -> testData.getPropositionType().equals(proposition.getPropositionType()));
                            assertTrue(exists, "In league: "+testData.getQueryParams().get("category")+", none of the " + contestGroup.getContests().size() + " contests, has a propositionType: " +
                                    testData.getPropositionType());
                        })
                );
            }

        } else {
            System.out.println("No matches found");
        }
    }
}
