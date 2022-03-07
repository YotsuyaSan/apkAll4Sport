package com.example.all4sport;

import android.os.StrictMode;
import android.util.Log;

import java.io.IOException;
import okhttp3.*;


public abstract class APIConnection {
    public static String get(String url) throws IOException {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            OkHttpClient client = new OkHttpClient().newBuilder().build();

            Request request = new Request.Builder().url(url).method("GET", null).addHeader("Content-Type", "application/json").build();

            Response response = client.newCall(request).execute();

            return response.body().string();
        } catch (Exception e) {
            Log.e("Connection error: ", e.toString());
            return ("Error");
        }
    }
}