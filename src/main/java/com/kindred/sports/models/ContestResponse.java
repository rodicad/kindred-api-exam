package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContestResponse {
    @JsonProperty
    private List<Proposition> propositions;

    private List<ContestGroup> contestGroups;

    public List<ContestGroup> getContestGroups() {
        return CategoryResponse.View.contestGroups;
    }
}
