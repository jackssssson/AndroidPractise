package com.demo.landlordpractise.http;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHttpRequester implements HttpRequester {

    @Override
    public String get(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("")
                .build();


        Response response = client.newCall(request).execute();
        String body = response.body().string();

        return body;
    }

    @Override
    public String post(String url, String bodyString) throws IOException {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), bodyString );

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .post(body)
                .url("")
                .build();


        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        return responseBody;
    }
}
