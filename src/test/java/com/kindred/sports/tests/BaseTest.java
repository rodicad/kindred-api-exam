package com.kindred.sports.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kindred.sports.utils.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

public class BaseTest {
    private String apiBaseUrl;
    private String apiLobbyPath;
    private String apiMenuPath;

    private String apiContestPagePath;
    private Map<String, String> headers;
    private Properties props;

    public BaseTest() {
        props = new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            apiBaseUrl = props.getProperty("api.base.url");
            apiLobbyPath = props.getProperty("api.lobby.path");
            apiMenuPath = props.getProperty("api.menu.path");
            apiContestPagePath = props.getProperty("api.contest-page.path");
            setHeaders();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getMenuURL() {
        return apiBaseUrl + apiMenuPath;
    }

    public String getLobbyURL() {
        return apiBaseUrl + apiLobbyPath;
    }

    public String getContestURL() {
        return apiBaseUrl + apiContestPagePath;
    }


    private void setHeaders() {
        String headersJson = props.getProperty("headers");
        ObjectMapper mapper = new ObjectMapper();
        try {
            headers = mapper.readValue(headersJson, new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse default headers from config.", e);
        }
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    @BeforeMethod
    public void logTestName(Method m, Object[] testData) {

        if (testData != null && testData.length > 0) {
            for (Object param : testData) {
                if (param instanceof TestData) { // Check if the parameter is an instance of TestData
                     TestData test = (TestData) param;
                    System.out.println("--------------------------------------------------");
                    System.out.println("Starting Test: " + m.getName() + " - Test Case: " + test.getTestName());
                    System.out.println("--------------------------------------------------");

                }
            }
        }
    }


    @AfterMethod
    public void afterEachTest(Method m) {
        System.out.println("--------------------------------------------------");
        System.out.println("Finished test: " + m.getName());
        System.out.println("--------------------------------------------------");
    }


//    @BeforeMethod
//    public void logTestName(ITestResult result) {
//
//        // Access DataProvider parameters (if present)
//        Object[] parameters = result.getParameters();
//        if (parameters != null && parameters.length > 0) {
//            for (Object param : parameters) {
//                if (param instanceof TestData) { // Replace TestData with your actual parameter class
//                    TestData testData = (TestData) param;
//                    System.out.println("Test Case: " + testData.getTestName());
//                }
//            }
//        }
//    }

}
