package com.demo.landlordpractise;

import android.app.Application;

import com.demo.landlordpractise.http.HttpRequester;
import com.demo.landlordpractise.http.OkHttpHttpRequester;
import com.demo.landlordpractise.models.Landlord;
import com.demo.landlordpractise.parser.GsonJsonParser;
import com.demo.landlordpractise.parser.base.JsonParser;
import com.demo.landlordpractise.repositories.HttpRepository;
import com.demo.landlordpractise.repositories.base.Repository;

import java.util.HashMap;
import java.util.Map;

public class AndroidApplication extends Application {
    public static Repository<Landlord> landlordRepository;
    private static HttpRequester httpRequester;
    private static JsonParser<Landlord> landlordJsonParser;
    private static Map<String, Repository> repositoriesMap;
    private static Map<String, JsonParser> jsonParsersMap;

    static {
        repositoriesMap = new HashMap<>();
        jsonParsersMap = new HashMap<>();
    }

    public static <T> Repository<T> getRepository(Class<T> tClass, Class<T[]> arrayClass){
        String classKey = tClass.getSimpleName();

        if (!repositoriesMap.containsKey(classKey)){
            HttpRequester httpRequester = getHttpRequester();
            JsonParser<T> jsonParser = getJsonParser(tClass, arrayClass);

            Repository<T> repository = new HttpRepository<>(
                    getServerBaseUrl(),
                    httpRequester,
                    jsonParser
            );

            repositoriesMap.put(classKey, repository);
        }

        return repositoriesMap.get(classKey);
    }

    private static <T> JsonParser<T> getJsonParser(Class<T> tClass, Class<T[]> arrayClass) {
        String classKey = tClass.getSimpleName();

        if (!jsonParsersMap.containsKey(classKey)){
            JsonParser<T> jsonParser = new GsonJsonParser<>(tClass, arrayClass);
            jsonParsersMap.put(classKey, jsonParser);
        }

        return jsonParsersMap.get(classKey);
    }

    public static Repository<Landlord> getLandlordRepository(){
        if (landlordRepository == null){
            HttpRequester httpRequester = getHttpRequester();
            JsonParser<Landlord> jsonParser = getLandlordJsonParser();

            landlordRepository = new HttpRepository<>(
                        getServerBaseUrl(),
                    httpRequester,
                    jsonParser
            );
        }

        return landlordRepository;
    }

    private static JsonParser<Landlord> getLandlordJsonParser() {
        if (landlordJsonParser == null){
            landlordJsonParser = new GsonJsonParser<>(Landlord.class, Landlord[].class);
        }

        return landlordJsonParser;
    }

    public static HttpRequester getHttpRequester(){
        if (httpRequester == null){
            httpRequester = new OkHttpHttpRequester();
        }

        return httpRequester;
    }

    public static String getServerBaseUrl(){
        return "";
    }
}
