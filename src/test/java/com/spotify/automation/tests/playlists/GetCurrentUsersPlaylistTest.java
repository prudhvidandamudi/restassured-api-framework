package com.spotify.automation.tests.playlists;

import com.spotify.automation.api.application.PlaylistApi;
import com.spotify.automation.api.pojo.playlists.PlaylistItemsResponse;
import com.spotify.automation.api.utils.ApiResponse;
import com.spotify.automation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCurrentUsersPlaylistTest extends BaseTest {

    @Test
    public void shouldRetrievePlaylistsSuccessfully() {
       ApiResponse<PlaylistItemsResponse>  response = PlaylistApi.getCurrentUsersPlaylist(accessToken);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNotNull(response.data().getItems(), "Playlist items should not be null");
    }

    @Test
    public void shouldReturnLimitedNumberOfPlaylists() {
        int limit = 5;
        int offset = 0;

        ApiResponse<PlaylistItemsResponse> response = PlaylistApi.getCurrentUsersPlaylist(accessToken, limit, offset);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNotNull(response.data().getItems(), "Playlist items should not be null");
        Assert.assertEquals(response.data().getItems().size(), limit);
    }

    @Test
    public void shouldReturnPaginatedPlaylists() {
        int limit = 5;
        int offset = 5;

        ApiResponse<PlaylistItemsResponse> response = PlaylistApi.getCurrentUsersPlaylist(accessToken, limit, offset);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNotNull(response.data().getItems(), "Playlist items should not be null");
        Assert.assertEquals(response.data().getLimit(), limit);
        Assert.assertEquals(response.data().getOffset(), offset);

        if (response.data().getTotal() > limit + offset) {
            Assert.assertNotNull(response.data().getNext(), "Next page URL should be present");
        } else {
            Assert.assertNull(response.data().getNext(), "Next page URL should be null when no more items exist");
        }
    }
}
