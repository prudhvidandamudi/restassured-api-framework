package com.spotify.automation.api.pojo.playlists.createplaylists;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.automation.api.pojo.common.ExternalUrls;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
