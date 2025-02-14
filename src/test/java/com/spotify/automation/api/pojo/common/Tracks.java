package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tracks {

    @JsonProperty("href")
    private String href;

    @JsonProperty("limit")
    private Integer limit;

    @JsonProperty("next")
    private String next;

    @JsonProperty("offset")
    private Integer offset;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("items")
    private List<TrackItem> items;
}
