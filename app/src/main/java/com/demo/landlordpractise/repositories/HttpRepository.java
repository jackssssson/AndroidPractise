package com.demo.landlordpractise.repositories;

import com.demo.landlordpractise.http.HttpRequester;
import com.demo.landlordpractise.parser.base.JsonParser;
import com.demo.landlordpractise.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpRepository<T> implements Repository<T> {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<T> mJsonParser;

    public HttpRepository(String serverUrl, HttpRequester httpRequester,
                          JsonParser<T> jsonParser) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }

    @Override
    public List<T> getAll() throws IOException {
        String jsonArray = mHttpRequester.get(mServerUrl);
        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public T add(T item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String responceBody = mHttpRequester.post(mServerUrl, requestBody);
        return mJsonParser.fromJson(responceBody);
    }

    @Override
    public T getById(int mLandlordId) throws IOException {
        String url = "";
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
    }
}
