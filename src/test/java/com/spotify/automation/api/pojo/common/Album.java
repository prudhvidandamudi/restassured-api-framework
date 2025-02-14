package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
