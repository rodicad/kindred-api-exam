package com.kindred.sports.tests;

import com.kindred.sports.api.StatusCode;
import com.kindred.sports.base.BaseTest;
import com.kindred.sports.models.Sport;
import com.kindred.sports.services.SportsService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LobbyTests extends BaseTest {

    private final SportsService sportsService = new SportsService();
    private Response sportResponse;


    @Test(description = "Test that the number of available sports is not zero")
    public void testGetAvailableSports() {
        sportResponse = sportsService.getAvailableSports(getMenuURL(),getHeaders());
        Assert.assertEquals(sportResponse.statusCode(), StatusCode.CODE_200.code, "Expected"+ StatusCode.CODE_200.code+"status code, but got: "+sportResponse.statusCode());
        List<Sport> sports= sportsService.parseSportResponse(sportResponse).getSports();
        Assert.assertNotNull(sports, "Sports list should not be null");
        Assert.assertTrue(sports.size() > 0, "Sports list should not be empty");
        System.out.println("Sports list size: "+sports.size());
    }

    @Test(description = "Validate Response Headers")
    public void testResponseHeaders() {
        sportResponse = sportsService.getAvailableSports(getMenuURL(),getHeaders());
        String contentType = sportResponse.getHeader("Content-Type");
        Assert.assertEquals(contentType, "application/json", "Content-Type is not application/json!");
    }

    @Test(description = "Validate response time")
    public void testResponseTime() {
        sportResponse = sportsService.getAvailableSports(getMenuURL(),getHeaders());

        long responseTime = sportResponse.getTime();
        Assert.assertTrue(responseTime < 2000, "Response time exceeds 2000ms!");
    }



}
