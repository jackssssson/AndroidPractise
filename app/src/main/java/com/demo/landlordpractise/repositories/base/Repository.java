package com.demo.landlordpractise.repositories.base;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public interface Repository<T> {
    List<T> getAll() throws IOException;

    T add(T item) throws IOException;

    T getById(int mLandlordId) throws IOException;
}
