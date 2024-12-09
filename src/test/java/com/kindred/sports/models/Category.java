package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not mapped in Sport
public class Category {
   @Getter
    @JsonProperty("identifier")
    private String identifier;

    @Getter
    @JsonProperty("categoryRn")
    private String categoryRn;

    @Getter
    @JsonProperty("header")
    private String header;
}
