package com.kindred.sports.services;

import com.kindred.sports.base.ApiClient;
import io.restassured.response.Response;

public class ContestService extends ApiClient {
    public ContestResponse getContestsForSportCategory(String category) {
        Response response = get("/lobby", Map.of("category", category, "clientOffset", "-60", "_typ", "GetLobbyPageView") );
        return response.as(MatchResponse.class);
    }

}
