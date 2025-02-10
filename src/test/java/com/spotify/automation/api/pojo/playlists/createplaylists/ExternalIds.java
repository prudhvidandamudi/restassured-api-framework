package com.spotify.automation.api.pojo.playlists.createplaylists;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExternalIds {

    @JsonProperty("isrc")
    private String isrc;

    @JsonProperty("ean")
    private String ean;

    @JsonProperty("upc")
    private String upc;
}
