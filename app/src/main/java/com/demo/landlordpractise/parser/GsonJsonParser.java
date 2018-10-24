package com.demo.landlordpractise.parser;

import com.demo.landlordpractise.parser.base.JsonParser;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class GsonJsonParser<T> implements JsonParser<T> {

    private final Class<T> mClass;
    private final Class<T[]> mArrayClass;
    private final Gson mGson;

    public GsonJsonParser(Class<T> tClass, Class<T[]> arrayClass) {
        mClass = tClass;
        mArrayClass = arrayClass;
        mGson = new Gson();
    }

    @Override
    public List<T> fromJsonArray(String jsonString) {
        T[] result = mGson.fromJson(jsonString, mArrayClass);
        return Arrays.asList(result);
    }

    @Override
    public T fromJson(String jsonString) {
        return mGson.fromJson(jsonString, mClass);
    }

    @Override
    public String toJson(T object) {
        return mGson.toJson(object);
    }
}
