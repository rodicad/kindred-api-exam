package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not mapped in Sport
public class Category {
    @JsonProperty("identifier") //
    private String identifier;  // Category name

    @JsonProperty("categoryRn")
    private String categoryRn;

    @JsonProperty("header")
    private String header;

    public String getCategoryRn() {
        return categoryRn;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getHeader() {
        return header;
    }
}
