package com.kindred.sports.base;

import io.restassured.RestAssured;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://sportsbff-ams.kindredext.net/sports-api/api/v1/views";
    }

    @BeforeMethod
    public void printDescription(ITestResult result) {
        String description = result.getMethod().getDescription();
        System.out.println("Starting Test: " + description);
    }
}
