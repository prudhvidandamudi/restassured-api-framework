package com.spotify.automation.api.pojo.playlists.createplaylists;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * POJO for individual track items in a playlist.
 */
@Data
@Builder
public class TrackItem {

    @JsonProperty("added_at")
    private String addedAt;

    @JsonProperty("added_by")
    private Owner addedBy;

    @JsonProperty("is_local")
    private Boolean isLocal;

    @JsonProperty("track")
    private Track track;
}