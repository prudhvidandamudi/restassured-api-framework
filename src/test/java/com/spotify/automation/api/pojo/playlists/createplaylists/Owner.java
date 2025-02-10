package com.spotify.automation.api.pojo.playlists.createplaylists;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.automation.api.pojo.common.ExternalUrls;
import com.spotify.automation.api.pojo.common.Followers;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Owner {

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    @JsonProperty("followers")
    private Followers followers;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("display_name")
    private String displayName;
}