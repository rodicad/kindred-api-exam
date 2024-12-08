package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not mapped in Sport
public class Sport {
    @JsonProperty("displayName") // Map "displayName" to "name"
    private String name;
    @JsonProperty("key") // Map "key" from JSON
    private String sportKey;
}