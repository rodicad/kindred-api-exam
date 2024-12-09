package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchResponse {
    @JsonProperty("view")
    private View view;

    public List<Match> getMatches() {
        return view.getMatches();
    }


}
