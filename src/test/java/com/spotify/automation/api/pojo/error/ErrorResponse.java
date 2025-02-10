package com.spotify.automation.api.pojo.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    @JsonProperty("error")
    private ErrorDetail error;  // Nested error object


    @Data
    @Builder
    public static class ErrorDetail {

        @JsonProperty("status")
        private int status;  // HTTP status code

        @JsonProperty("message")
        private String message;  // Error message description
    }
}
