package com.spotify.automation.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    @JsonProperty("followers")
    private Followers followers;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("display_name")
    private String displayName;
}