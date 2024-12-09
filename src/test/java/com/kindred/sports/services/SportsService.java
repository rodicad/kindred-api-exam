package com.kindred.sports.services;

import com.kindred.sports.api.ApiClient;
import com.kindred.sports.models.SportResponse;
import io.restassured.response.Response;

public class SportsService extends ApiClient {

//   // public Response getAvailableSports(String url, Map<String, String> headers) {
//        return get(url, headers);
//    }

    public SportResponse parseSportResponse(Response response) {
        return response.as(SportResponse.class);
    }


}
