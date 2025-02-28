package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;
}
