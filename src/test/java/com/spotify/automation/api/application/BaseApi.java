package com.spotify.automation.api.application;

import com.spotify.automation.api.utils.ApiResponse;
import com.spotify.automation.api.utils.SpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;

public class BaseApi {
    /**
     * Generic method to send a GET request.
     * @param endpoint API endpoint.
     * @param responseClass Response class to deserialize response.
     * @param requestSpec Request Specification.
     * @return Deserialized response object.
     */
    protected static <T> ApiResponse<T> get(String endpoint, Class<T> responseClass, RequestSpecification requestSpec) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get(endpoint);

        return SpecBuilder.extractResponse(response, responseClass);
    }

    /**
     * Generic method to send a POST request with a request body.
     * @param endpoint API endpoint.
     * @param requestBody Request body object.
     * @param responseClass Response class to deserialize response.
     * @param requestSpec Request Specification.
     * @return Deserialized response object.
     */
    protected static <T, R> ApiResponse<T> post(String endpoint, R requestBody, Class<T> responseClass, RequestSpecification requestSpec) {
        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post(endpoint);

        return SpecBuilder.extractResponse(response, responseClass);
    }

    /**
     * Generic method to send a PUT request with a request body.
     * @param endpoint API endpoint.
     * @param requestBody Request body object.
     * @param responseClass Response class to deserialize response.
     * @return Deserialized response object.
     */
    protected static <T, R> ApiResponse<T> put(String endpoint, R requestBody, Class<T> responseClass, RequestSpecification requestSpec) {

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .put(endpoint);

        return SpecBuilder.extractResponse(response, responseClass);
    }

    /**
     * Generic method to send a DELETE request.
     * @param endpoint API endpoint.
     * @param requestSpec Request Specification.
     * @return Response object.
     */
    protected static Response delete(String endpoint, RequestSpecification requestSpec) {
        return given()
                .spec(requestSpec)
                .when()
                .delete(endpoint);
    }
}
