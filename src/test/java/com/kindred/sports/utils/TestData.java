package com.kindred.sports.utils;

import java.util.Map;


public class TestData {
    private String testName;



    private String sportName;
    private Map<String, String> queryParams;
    private String propositionType;

    public String getTestName() {
        return testName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public String getPropositionType() {
        return propositionType;
    }

    public void setPropositionType(String propositionType) {
        this.propositionType = propositionType;
    }
}
