package com.kindred.sports.tests;

import com.kindred.sports.base.BaseTest;
import com.kindred.sports.models.SportResponse;
import com.kindred.sports.services.SportsService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LobbyTests extends BaseTest {

    private final SportsService sportsService = new SportsService();

    @Test(description = "Test that the number of available sports is not zero")
    public void testGetAvailableSports() {
        SportResponse sportResponse = sportsService.getAvailableSports();
        Assert.assertNotNull(sportResponse.getItems(), "Sports list should not be null");
        Assert.assertTrue(sportResponse.getItems().size() > 0, "Sports list should not be empty");
    }


}
