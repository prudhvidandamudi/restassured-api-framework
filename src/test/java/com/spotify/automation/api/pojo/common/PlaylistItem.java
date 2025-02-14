package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaylistItem {

    @JsonProperty("collaborative")
    private boolean collaborative;

    @JsonProperty("description")
    private String description;

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

    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("public")
    private boolean isPublic;

    @JsonProperty("snapshot_id")
    private String snapshotId;

    @JsonProperty("tracks")
    private Tracks tracks;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;
}
