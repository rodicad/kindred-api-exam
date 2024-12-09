package com.kindred.sports.services;

import com.kindred.sports.api.ApiClient;
import com.kindred.sports.models.ContestResponse;
import io.restassured.response.Response;

public class ContestService extends ApiClient {

    public ContestResponse parseContestResponse(Response response) {
        return response.as(ContestResponse.class);
    }


}
