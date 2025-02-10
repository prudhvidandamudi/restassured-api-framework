package com.spotify.automation.api.pojo.auth2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorizationResponse {

    @JsonProperty("code")
    private String code;

    @JsonProperty("error")
    private String error;

    @JsonProperty("state")
    private String state;
}

