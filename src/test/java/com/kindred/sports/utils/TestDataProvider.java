package com.kindred.sports.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class TestDataProvider {
    /** +
     *
     * @param m
     * @return
     * @throws JSONException
     */


    @DataProvider
    public Object[][] getTestData(Method m) throws JSONException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Retrieve the TestDataFile annotation
        TestDataFile annotation = m.getAnnotation(TestDataFile.class);
        if (annotation == null) {
            throw new IllegalArgumentException("TestDataFile annotation is missing for method: " + m.getName());
        }
// Read the specified JSON file
        String filePath = "src/test/resources/" + annotation.value();
        // Read the JSON file into a list of TestData objects
        List<TestData> testDataList = objectMapper.readValue(
                new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, TestData.class)
        );

        // Convert List to Object[][] for DataProvider
        Object[][] data = new Object[testDataList.size()][1];
        for (int i = 0; i < testDataList.size(); i++) {
            data[i][0] = testDataList.get(i);
        }
        return data;
    }
}

