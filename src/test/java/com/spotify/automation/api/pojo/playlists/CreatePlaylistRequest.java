package com.spotify.automation.api.pojo.playlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
