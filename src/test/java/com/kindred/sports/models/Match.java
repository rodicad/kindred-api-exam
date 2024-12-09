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
    private List<Category> matchCategories;

    @JsonProperty("contestGroups")
    private List<ContestGroup> contestGroups;

    public List<ContestGroup> getContestGroups() {
        return contestGroups;
    }


    public String getCategoryRn() {
        return categoryRn;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<Category> getCategories() {
        return matchCategories;


    }
}