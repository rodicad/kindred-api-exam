package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not mapped in Sport
public class Match {
    @Getter
    @JsonProperty("identifier") //
    private String identifier;  // Country name

    @Getter
    @JsonProperty("categoryRn")
    private String categoryRn;

    @Getter
    @JsonProperty("children")
    private List<Category> matchCategories;

    @Getter
    @JsonProperty("contestGroups")
    private List<ContestGroup> contestGroups;

}