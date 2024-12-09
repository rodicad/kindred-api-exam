package com.kindred.sports.services;

import com.kindred.sports.api.ApiClient;
import com.kindred.sports.models.SportResponse;
import io.restassured.response.Response;

public class SportsService extends ApiClient {

    public SportResponse parseSportResponse(Response response) {
        return response.as(SportResponse.class);
    }


}
