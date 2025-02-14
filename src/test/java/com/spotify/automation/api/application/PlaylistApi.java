package com.spotify.automation.api.application;

import com.spotify.automation.api.pojo.playlists.CreatePlaylistRequest;
import com.spotify.automation.api.pojo.playlists.CreatePlaylistResponse;
import com.spotify.automation.api.pojo.playlists.PlaylistItemsResponse;
import com.spotify.automation.api.utils.ApiResponse;
import com.spotify.automation.api.utils.SpecBuilder;
import io.restassured.specification.RequestSpecification;

public class PlaylistApi extends BaseApi {
    private static final String PLAYLIST_ENDPOINT = "/users/{user_id}/playlists";
    private static final String CURRENT_USERS_PLAYLIST = "/me/playlists";


    public static ApiResponse<CreatePlaylistResponse> createPlaylistApi(String accessToken, String userId, CreatePlaylistRequest createPlaylistRequest) {
        String url = PLAYLIST_ENDPOINT.replace("{user_id}", userId);
        RequestSpecification requestSpecification = SpecBuilder.getRequestSpec(accessToken);
        return post(url, createPlaylistRequest, CreatePlaylistResponse.class, requestSpecification);
    }

    public static ApiResponse<PlaylistItemsResponse> getCurrentUsersPlaylist(String accessToken) {
        RequestSpecification requestSpecification = SpecBuilder.getRequestSpec(accessToken);
        return get(CURRENT_USERS_PLAYLIST, PlaylistItemsResponse.class, requestSpecification);
    }

    public static ApiResponse<PlaylistItemsResponse> getCurrentUsersPlaylist(String accessToken, int limit, int offset) {
        RequestSpecification requestSpecification = SpecBuilder.getRequestSpec(accessToken);
        requestSpecification
                .queryParam("limit", limit)
                .queryParam("offset", offset);


        return get(CURRENT_USERS_PLAYLIST, PlaylistItemsResponse.class, requestSpecification);
    }
}
