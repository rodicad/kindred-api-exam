package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not mapped in Sport
public class View {
    @JsonProperty("matches")
    private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }
}