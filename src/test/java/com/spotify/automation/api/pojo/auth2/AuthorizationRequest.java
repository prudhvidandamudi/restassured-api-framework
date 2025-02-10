package com.spotify.automation.api.pojo.auth2;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)  // Excludes null fields during serialization
public class AuthorizationRequest {

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("response_type")
    private String responseType;

    @JsonProperty("redirect_uri")
    private String redirectUri;

    @JsonProperty("state")
    private String state;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("show_dialog")
    private boolean showDialog;
}
