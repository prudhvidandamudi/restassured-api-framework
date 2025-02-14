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
public class Image {

    @JsonProperty("url")
    private String url;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("width")
    private Integer width;
}
