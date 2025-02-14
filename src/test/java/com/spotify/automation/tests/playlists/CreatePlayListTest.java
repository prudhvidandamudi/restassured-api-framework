package com.spotify.automation.tests.playlists;

import com.spotify.automation.api.application.PlaylistApi;
import com.spotify.automation.api.application.UsersApi;
import com.spotify.automation.api.pojo.playlists.CreatePlaylistRequest;
import com.spotify.automation.api.pojo.playlists.CreatePlaylistResponse;
import com.spotify.automation.api.pojo.users.userprofile.UserProfileResponse;
import com.spotify.automation.api.utils.ApiResponse;
import com.spotify.automation.api.utils.data.FakeDataGenerator;
import com.spotify.automation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreatePlayListTest extends BaseTest {
    private String userId;

    @BeforeClass
    public void createPlayListSetUp() {
      ApiResponse<UserProfileResponse>  userProfileResponse = UsersApi.getUser(accessToken);
        Assert.assertEquals(userProfileResponse.statusCode(), 200);
        userId = userProfileResponse.data().getId();
    }

    @Test
    public void shouldCreatePlaylistWithValidData() {
        String playlistName = FakeDataGenerator.generatePlaylistName();
        String description = FakeDataGenerator.generateDescription();
        boolean isPublic = true;

        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .name(playlistName)
                .description(description)
                .isPublic(isPublic)
                .build();

        ApiResponse<CreatePlaylistResponse> response = PlaylistApi.createPlaylistApi(accessToken, userId, request);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.data().getName(), playlistName);
        Assert.assertEquals(response.data().getDescription(), description);
        Assert.assertEquals(response.data().getIsPublic(), isPublic);
    }

    @Test
    public void shouldCreatePrivatePlaylistSuccessfully() {
        String playlistName = FakeDataGenerator.generatePlaylistName();
        String description = FakeDataGenerator.generateDescription();
        boolean isPublic = false;

        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .name(playlistName)
                .description(description)
                .isPublic(isPublic)
                .build();

        ApiResponse<CreatePlaylistResponse> response = PlaylistApi.createPlaylistApi(accessToken, userId, request);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.data().getIsPublic(), isPublic);
    }

    @Test
    public void shouldCreateCollaborativePlaylistWhenPublicIsFalse() {
        String playlistName = FakeDataGenerator.generatePlaylistName();
        String description = FakeDataGenerator.generateDescription();
        boolean isPublic = false;
        boolean collaborative = true;

        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .name(playlistName)
                .description(description)
                .isPublic(isPublic)
                .isCollaborative(collaborative)
                .build();

        ApiResponse<CreatePlaylistResponse> response = PlaylistApi.createPlaylistApi(accessToken, userId, request);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.data().getIsPublic(), isPublic);
        Assert.assertEquals(response.data().getCollaborative(), collaborative);
    }

    @Test
    public void shouldAllowCreatingMultipleDuplicatePlaylists() {
        int numberOfPlaylists = 2; // Define how many playlists to create
        String playlistName = FakeDataGenerator.generatePlaylistName();
        String description = FakeDataGenerator.generateDescription();
        for (int i = 1; i <= numberOfPlaylists; i++) {

            boolean isPublic = true;

            CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                    .name(playlistName)
                    .description(description)
                    .isPublic(isPublic)
                    .build();

            ApiResponse<CreatePlaylistResponse> response = PlaylistApi.createPlaylistApi(accessToken, userId, request);

            Assert.assertEquals(response.statusCode(), 201);
            Assert.assertNotNull(response.data().getId(), "Playlist ID should not be null");
        }
    }

    @Test
    public void shouldCreatePlaylistWithLongDescription() {
        String playlistName = FakeDataGenerator.generatePlaylistName();
        String description = FakeDataGenerator.generateLongDescription();
        boolean isPublic = true;

        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .name(playlistName)
                .description(description)
                .isPublic(isPublic)
                .build();

        ApiResponse<CreatePlaylistResponse> response = PlaylistApi.createPlaylistApi(accessToken, userId, request);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertNotNull(response.data().getId(), "Playlist ID should not be null");
        Assert.assertEquals(response.data().getDescription(), description);
    }

    @Test
    public void shouldCreatePlaylistWithSpecialCharactersInName() {
        // Generate a playlist name with special characters
        String specialCharName = "🎵My Playlist!@#$%^&*()_+";
        String description = FakeDataGenerator.generateDescription();

        // Create a request body
        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .name(specialCharName)
                .description(description)
                .isPublic(true)
                .build();

        // Call Playlist API
        ApiResponse<CreatePlaylistResponse> response = PlaylistApi.createPlaylistApi(accessToken, userId, request);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertNotNull(response.data().getId(), "Playlist ID should not be null");
        Assert.assertEquals(response.data().getName(), specialCharName);
    }

    @Test
    public void shouldReturnBadRequestWhenCreatingPlaylistWithoutName() {
        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .name("") // Empty name
                .description("Testing missing name")
                .isPublic(true)
                .build();

        ApiResponse<CreatePlaylistResponse> response = PlaylistApi.createPlaylistApi(accessToken, userId, request);

        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    public void shouldReturnForbiddenWhenCreatingPlaylistWithInvalidUserId() {
        userId = "INVALID_USER_ID";

        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .name("Valid Name")
                .description("Testing invalid user ID")
                .isPublic(true)
                .build();

        ApiResponse<CreatePlaylistResponse> response = PlaylistApi.createPlaylistApi(accessToken, userId, request);

        Assert.assertEquals(response.statusCode(), 403);
    }

    @Test
    public void shouldReturnUnauthorizedWhenCreatingPlaylistWithoutAuth() {
        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .name("Valid Name")
                .description("Testing missing authentication")
                .isPublic(true)
                .build();

        ApiResponse<CreatePlaylistResponse> response = PlaylistApi.createPlaylistApi("BadToken", userId, request);

        Assert.assertEquals(response.statusCode(), 401);
    }
}
