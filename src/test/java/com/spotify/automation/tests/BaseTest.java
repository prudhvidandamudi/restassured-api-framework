package com.spotify.automation.tests;

import com.spotify.automation.api.utils.TokenManager;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static String accessToken;

    @BeforeClass
    public void setup() {
        System.out.println("Setting up BaseTest...");

        accessToken = TokenManager.getAccessToken();
        System.out.println("Access Token: " + accessToken);
    }
}