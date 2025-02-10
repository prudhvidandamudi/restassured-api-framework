package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * POJO for followers data.
 */
@Data
@Builder
public class Followers {

    @JsonProperty("href")
    private String href;

    @JsonProperty("total")
    private int total;
}