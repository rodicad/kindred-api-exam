package com.kindred.sports.services;

import com.kindred.sports.base.ApiClient;
import com.kindred.sports.models.CategoryResponse;
import io.restassured.response.Response;

import java.util.Map;

public class CategoriesService extends ApiClient {
    public CategoryResponse getCategoriesForSport(String category) {
        Response response = get("/lobby", Map.of("category", category, "clientOffset", "-60", "_typ", "GetLobbyPageView") );
        return response.as(CategoryResponse.class);
    }

}
