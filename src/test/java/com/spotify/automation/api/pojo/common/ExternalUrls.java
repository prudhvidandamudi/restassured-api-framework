package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * POJO for external URLs (e.g., Spotify link).
 */
@Data
@Builder
public class ExternalUrls {

    @JsonProperty("spotify")
    private String spotify;
}
