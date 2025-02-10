package com.spotify.automation.api.pojo.playlists.createplaylists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.automation.api.pojo.common.ExternalUrls;
import com.spotify.automation.api.pojo.common.Followers;
import com.spotify.automation.api.pojo.common.Image;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * POJO for Create Playlist API Response.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatePlaylistResponse {

    @JsonProperty("collaborative")
    private Boolean collaborative;

    @JsonProperty("description")
    private String description;

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    @JsonProperty("followers")
    private Followers followers;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("images")
    private List<Image> images;

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("public")
    private Boolean isPublic;

    @JsonProperty("snapshot_id")
    private String snapshotId;

    @JsonProperty("tracks")
    private Tracks tracks;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;
}