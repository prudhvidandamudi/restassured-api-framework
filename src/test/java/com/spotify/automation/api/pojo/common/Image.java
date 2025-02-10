package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * POJO for image objects in user profile.
 */
@Data
@Builder
public class Image {

    @JsonProperty("url")
    private String url;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("width")
    private Integer width;
}
