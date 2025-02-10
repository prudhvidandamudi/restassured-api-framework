package com.spotify.automation.api.pojo.playlists.createplaylists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatePlaylistRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("public")
    private Boolean isPublic;

    @JsonProperty("collaborative")
    private Boolean isCollaborative;

    @JsonProperty("description")
    private String description;
}
