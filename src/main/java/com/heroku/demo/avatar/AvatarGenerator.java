package com.heroku.demo.avatar;

public class AvatarGenerator {
    public static final String HTTPS_API_ADORABLE_IO_AVATARS_URL = "https://api.adorable.io/avatars/50/";

    public static String getAvatar(String hash) {
        return HTTPS_API_ADORABLE_IO_AVATARS_URL + hash;
    }
}
