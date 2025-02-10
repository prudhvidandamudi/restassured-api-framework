package com.spotify.automation.api.pojo.playlists.createplaylists;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.automation.api.pojo.common.ExternalUrls;
import com.spotify.automation.api.pojo.common.Image;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Album {

    @JsonProperty("album_type")
    private String albumType;

    @JsonProperty("total_tracks")
    private Integer totalTracks;

    @JsonProperty("available_markets")
    private List<String> availableMarkets;

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("images")
    private List<Image> images;

    @JsonProperty("name")
    private String name;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("artists")
    private List<Artist> artists;
}
