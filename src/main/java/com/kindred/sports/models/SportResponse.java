package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SportResponse {
    @JsonProperty("items")
    private List<Sport> items;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not mapped in Sport
    public static class Sport {
        @JsonProperty("displayName") // Map "displayName" to "name"
        private String name;
        @JsonProperty("key") // Map "key" from JSON
        private String sportKey;
    }

}
