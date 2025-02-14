package com.spotify.automation.api.utils;

import com.spotify.automation.api.application.AuthApi;
import com.spotify.automation.api.pojo.error.ErrorResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SpecBuilder {
    public static final String BASE_URL = "https://api.spotify.com/v1";

    /**
     * Builds a standard request specification with authorization.
     */
    public static RequestSpecification getRequestSpec(String accessToken) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Authorization", "Bearer " + accessToken)
                .setContentType("application/json")
//                .log(LogDetail.URI)
//                .log(LogDetail.METHOD)
                .build();
    }

    public static RequestSpecification getTokenRequestSpec() {
        AuthApi authApi = AuthApi.getInstance();

        return new RequestSpecBuilder()
                .setBaseUri(authApi.getTokenUrl())
                .setContentType("application/x-www-form-urlencoded")
                .addFormParam("grant_type", "refresh_token")
                .addFormParam("refresh_token", authApi.getRefreshToken())
                .addFormParam("client_id", authApi.getClientId())
                .addFormParam("client_secret", authApi.getClientSecret())
                .log(LogDetail.URI)
                .log(LogDetail.METHOD)
                .build();
    }

    /**
     * Generic method to deserialize API responses into specified POJO classes.
     */
    public static <T> ApiResponse<T> extractResponse(Response response, Class<T> responseClass) {
        try {
            Response validatedResponse = response.then()
                    .spec(new ResponseSpecBuilder()
                            .expectContentType("application/json")
                            .log(LogDetail.STATUS)
                            .build())
                    .extract()
                    .response();

            int statusCode = validatedResponse.statusCode();

            if (statusCode >= 200 && statusCode < 300) {
                T responseBody = validatedResponse.as(responseClass);
                return new ApiResponse<>(statusCode, responseBody); // Success
            } else {
                ErrorResponse errorResponse = validatedResponse.as(ErrorResponse.class);
                return new ApiResponse<>(statusCode, errorResponse); // Failure
            }
        } catch (Exception e) {
            System.err.println("Failed to parse API response. Raw response: " + response.getBody().asString());
            throw new RuntimeException("API request failed with status: " + response.statusCode(), e);
        }
    }
}
