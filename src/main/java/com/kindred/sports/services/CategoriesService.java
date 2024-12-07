package com.kindred.sports.services;

import com.kindred.sports.base.ApiClient;
import com.kindred.sports.models.MatchResponse;
import io.restassured.response.Response;

import java.util.Map;

public class CategoriesService extends ApiClient {
    public MatchResponse getCategoriesForSport(String category) {
        Response response = get("/lobby", Map.of("category", category, "clientOffset", "-60", "_typ", "GetLobbyPageView") );
        return response.as(MatchResponse.class);
    }


    public MatchResponse getContestsForSportCategory(String category) {
        Response response = get("/lobby", Map.of("category", category, "clientOffset", "-60", "_typ", "GetLobbyPageView") );;
        return response.as(MatchResponse.class);
    }

}
