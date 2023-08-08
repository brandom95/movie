package com.example.movfinal;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MovieInfoFetcher {
    private static final String API_URL = "http://www.omdbapi.com/?apikey=6d5b780b";

    public static MovieSearchResult searchMovies(String movieName) {
        OkHttpClient client = new OkHttpClient();
        String apiUrl = "http://www.omdbapi.com/?s=" + movieName + "&apikey=6d5b780b";

        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                Gson gson = new Gson();
                return gson.fromJson(responseBody, MovieSearchResult.class);
            } else {
                System.out.println("API call failed: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the OkHttpClient after use
        client.dispatcher().executorService().shutdown();
        return null;
    }

    public static MovieInfo fetchMovieInfo(String movieTitle) {
        String apiUrl = API_URL + "&t=" + movieTitle;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                Gson gson = new Gson();
                return gson.fromJson(responseBody, MovieInfo.class);
            } else {
                System.out.println("API call failed: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the OkHttpClient after use
        client.dispatcher().executorService().shutdown();
        return null;
    }
}
