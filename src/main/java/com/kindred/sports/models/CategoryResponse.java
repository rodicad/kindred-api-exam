package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponse {
    @JsonProperty("view")
    private View view;

    public List<Match> getMatches() {
        return view.matches;
    }
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not mapped in Sport
    private static class View {
        @JsonProperty("matches")
        private List<Match> matches;
    }







}
