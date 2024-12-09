package com.kindred.sports.tests;

import com.kindred.sports.api.StatusCode;
import com.kindred.sports.models.ContestResponse;
import com.kindred.sports.models.Proposition;
import com.kindred.sports.services.ContestService;
import com.kindred.sports.utils.TestData;
import com.kindred.sports.utils.TestDataFile;
import com.kindred.sports.utils.TestDataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class SportContestTests extends BaseTest {
    private final ContestService contestService = new ContestService();
    private Response contestResponse;


    @BeforeSuite
    public void printSuiteDescription() {
        System.out.println("Executing Test Suite: Sports Contest Test Suite");
        System.out.println("Description: This suite validates  API calls against specific contest IDs, provided  in the contestkeys.json data file. .");
    }


    @Test(dataProvider = "getTestData", dataProviderClass = TestDataProvider.class)
    @TestDataFile("contestkeys.json")
    public void testMissingHeadersInContest(TestData testData) {
        contestResponse = contestService.get(getContestURL(), null, testData.getQueryParams());
        Assert.assertEquals(contestResponse.statusCode(), StatusCode.CODE_404.code);

        String errorMessage = contestResponse.jsonPath().getString("error.message");
        Assert.assertTrue(errorMessage.contains("No contest found"), "Error message is incorrect");


    }
    @Test(dataProvider = "getTestData", dataProviderClass = TestDataProvider.class)
    @TestDataFile("contestkeys.json")
    public void testInvalidJurisdiction(TestData testData) {
        getHeaders().put("Jurisdiction", "invalid");
        contestResponse = contestService.get(getContestURL(), getHeaders(), testData.getQueryParams());
        Assert.assertEquals(contestResponse.statusCode(), StatusCode.CODE_404.code);

        String errorMessage = contestResponse.jsonPath().getString("error.message");
        Assert.assertTrue(errorMessage.contains("No contest found"), "Error message is incorrect");

    }

    @Test(dataProvider = "getTestData", dataProviderClass = TestDataProvider.class)
    @TestDataFile("contestkeys.json")
    public void testPropositionTypeInSpecificContest(TestData testData) {
        contestResponse = contestService.get(getContestURL(), getHeaders(), testData.getQueryParams());
        Assert.assertEquals(contestResponse.statusCode(), StatusCode.CODE_200.code, "Expected " + StatusCode.CODE_200.code + " status code, but got: " + contestResponse.statusCode());

        ContestResponse contest = contestService.parseContestResponse(contestResponse);
        List<Proposition> propositions = contest.getContest().getPropositions();
        System.out.println("Propositions count: " + propositions.size());


    }


}
