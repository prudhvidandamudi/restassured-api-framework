package com.spotify.automation.api.utils.data;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
    private static final Faker faker = new Faker();

    public static String generatePlaylistName() {
        return faker.book().title() + " Playlist";
    }

    public static String generateDescription() {
        return faker.lorem().sentence();
    }

    public static String generateLongDescription() {
        return faker.lorem().paragraph(5);
    }

    public static String generateUserName() {
        return faker.name().fullName();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }
}
