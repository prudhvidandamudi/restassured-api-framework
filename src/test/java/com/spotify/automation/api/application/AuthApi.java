package com.spotify.automation.api.application;

import com.spotify.automation.api.pojo.auth2.RefreshTokenResponse;
import com.spotify.automation.api.utils.ApiResponse;
import com.spotify.automation.api.utils.ConfigManager;
import com.spotify.automation.api.utils.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

@Getter
public class AuthApi {
    private final String tokenUrl = "https://accounts.spotify.com/api/token";
    private final String clientId = ConfigManager.get("client_id");
    private final String clientSecret = ConfigManager.get("client_secret");
    private final String refreshToken = ConfigManager.get("refresh_token");

    private AuthApi() {}

    public static AuthApi getInstance() {
        return new AuthApi();
    }


    /**
     * Refreshes the Access Token using the stored Refresh Token.
     */
    public static ApiResponse<RefreshTokenResponse> refreshAccessToken() {
        RequestSpecification requestSpec = SpecBuilder.getTokenRequestSpec();

        Response response = RestAssured.given().spec(requestSpec).post();

        return SpecBuilder.extractResponse(response, RefreshTokenResponse.class);
    }
}
