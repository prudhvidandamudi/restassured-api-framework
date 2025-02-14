package com.spotify.automation.api.utils;

import com.spotify.automation.api.application.AuthApi;
import com.spotify.automation.api.pojo.auth2.RefreshTokenResponse;
import com.spotify.automation.api.pojo.error.ErrorResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.Instant;

public class TokenManager {
    private static String accessToken;
    private static Instant expiryTime;

    public static String getAccessToken() {
        if (accessToken == null || isTokenExpired()) {
            refreshAccessToken();
        }
        return  accessToken;
    }

    private static  boolean isTokenExpired() {
        return Instant.now().isAfter(expiryTime);
    }

    private static void refreshAccessToken() {
        ApiResponse<RefreshTokenResponse> tokenResponse = AuthApi.refreshAccessToken();
        expiryTime = Instant.now().plusSeconds(tokenResponse.data().getExpiresIn());
        accessToken = tokenResponse.data().getAccessToken();
    }
}
