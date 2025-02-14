package com.spotify.automation.api.application;

import com.spotify.automation.api.pojo.users.userprofile.UserProfileResponse;
import com.spotify.automation.api.utils.ApiResponse;
import com.spotify.automation.api.utils.SpecBuilder;
import io.restassured.specification.RequestSpecification;

public class UsersApi extends BaseApi{
    private static final String USER_URL = "/me";

    public static ApiResponse<UserProfileResponse> getUser(String accessToken) {
        RequestSpecification requestSpecification = SpecBuilder.getRequestSpec(accessToken);
        return get(USER_URL, UserProfileResponse.class, requestSpecification);
    }
}
