package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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