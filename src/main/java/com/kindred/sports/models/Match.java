package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not mapped in Sport
public class Match {
    @JsonProperty("identifier") //
    private String identifier;  // Country name

    @JsonProperty("categoryRn")
    private String categoryRn;

    @JsonProperty("children")
    private List<CategoryResponse.Category> matchCategories; // Nested leagues

    public List<CategoryResponse.Category> getCategories() {
        return matchCategories;
    }
}