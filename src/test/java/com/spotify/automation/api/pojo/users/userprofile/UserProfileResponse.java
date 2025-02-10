package com.spotify.automation.api.pojo.users.userprofile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.automation.api.pojo.common.ExternalUrls;
import com.spotify.automation.api.pojo.common.Followers;
import com.spotify.automation.api.pojo.common.Image;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfileResponse {

    @JsonProperty("country")
    private String country;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("explicit_content")
    private ExplicitContent explicitContent;

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

    @JsonProperty("product")
    private String product;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;
}

