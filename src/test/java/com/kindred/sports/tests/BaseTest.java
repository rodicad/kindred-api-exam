package com.kindred.sports.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kindred.sports.utils.TestData;
import lombok.Getter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

public class BaseTest {
    private String apiBaseUrl;
    private String apiLobbyPath;
    private String apiMenuPath;

    private String apiContestPagePath;

    @Getter
    private Map<String, String> headers;
    private final Properties props;

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
            headers = mapper.readValue(headersJson, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse default headers from config.", e);
        }
    }

    @BeforeMethod
    public void logTestName(Method m, Object[] testData) {
        String testName="";

        if (testData != null && testData.length > 0) {
            for (Object param : testData) {
                if (param instanceof TestData) { // Check if the parameter is an instance of TestData
                    testName =((TestData) param).getTestName();
                }
            }
        } else {
            testName = m.getAnnotation(Test.class).description();
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Starting Test: " + m.getName() + " - Test Case: " + testName);
        System.out.println("--------------------------------------------------");
    }



    @AfterMethod
    public void afterEachTest(Method m, ITestResult result) {
        System.out.println("--------------------------------------------------");
        System.out.println("Finished test: " + m.getName());

        // Check the test result status
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Status: SUCCESS ✅");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Status: FAILURE ❌");
            System.out.println("Reason: " + result.getThrowable().getMessage());
        } else if (result.getStatus() == ITestResult.SKIP) {
            System.out.println("Status: SKIPPED ⚠️");
            System.out.println("Reason: " + result.getThrowable().getMessage());
        }
        System.out.println("--------------------------------------------------");
    }


}
