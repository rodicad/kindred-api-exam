package com.kindred.sports.services;

import com.kindred.sports.base.ApiClient;
import com.kindred.sports.models.SportResponse;
import io.restassured.response.Response;

public class SportsService extends ApiClient {
    public SportResponse getAvailableSports() {
        Response response = get("/az-menu");
        return response.as(SportResponse.class);
    }


}
