package com.spotify.automation.api.utils;

import com.spotify.automation.api.pojo.error.ErrorResponse;

public record ApiResponse<T>(int statusCode, T data, ErrorResponse error) {

    public ApiResponse(int statusCode, T data) {
        this(statusCode, data, null); // Success response
    }

    public ApiResponse(int statusCode, ErrorResponse error) {
        this(statusCode, null, error); // Failure response
    }
}


