package com.demo.landlordpractise.http;

import java.io.IOException;

public interface HttpRequester {
    String get(String url) throws IOException;
    String post(String url, String body) throws IOException;
}
