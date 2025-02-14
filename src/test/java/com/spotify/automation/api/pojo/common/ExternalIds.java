package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalIds {

    @JsonProperty("isrc")
    private String isrc;

    @JsonProperty("ean")
    private String ean;

    @JsonProperty("upc")
    private String upc;
}
