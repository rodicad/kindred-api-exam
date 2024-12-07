package com.kindred.sports.tests;


import com.kindred.sports.base.BaseTest;
import com.kindred.sports.models.SportResponse;
import com.kindred.sports.services.SportsService;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class SportsTests extends BaseTest {
    private final SportsService sportsService = new SportsService();

    @Test(description = "Test that the number of available sports is not zero")
    public void testGetAvailableSports() {
        SportResponse sportResponse = sportsService.getAvailableSports();
        Assert.assertNotNull(sportResponse.getItems(), "Sports list should not be null");
        Assert.assertTrue(sportResponse.getItems().size() > 0, "Sports list should not be empty");
    }






    @Step
    public void assertStatusCode(int actual, int expected) {
        assertThat (actual,equalTo(expected));
    }



}
