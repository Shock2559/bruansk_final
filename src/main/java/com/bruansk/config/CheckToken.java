package com.bruansk.config;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckToken {

    static public int checkToken(String token) throws Exception {
        URL url = new URL("https://tt.kaboom.pro/api/Auth/user/check");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", token);
        connection.setRequestProperty("Content-Type", "application/json");

        return connection.getResponseCode();
    }

}
