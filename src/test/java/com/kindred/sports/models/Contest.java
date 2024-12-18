package com.kindred.sports.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contest {
    @JsonProperty("contestKey")
    private String contestKey;

    @JsonProperty("name")
    private String name;

    @Getter
    @JsonProperty("propositions")
    private List<Proposition> propositions;


}
