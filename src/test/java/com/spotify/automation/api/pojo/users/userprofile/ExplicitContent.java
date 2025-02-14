package com.spotify.automation.api.pojo.users.userprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExplicitContent {

    @JsonProperty("filter_enabled")
    private boolean filterEnabled;

    @JsonProperty("filter_locked")
    private boolean filterLocked;
}