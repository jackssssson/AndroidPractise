package com.demo.landlordpractise.services;

import com.demo.landlordpractise.models.Landlord;
import com.demo.landlordpractise.services.base.LandlordService;

import java.util.List;

public class HttpLandlordService implements LandlordService {
    @Override
    public List<Landlord> getAllLandlords() {
        return null;
    }

    @Override
    public List<Landlord> filterByName(String namePattern) {
        return null;
    }

    @Override
    public Landlord getDetailsById(int id) {
        return null;
    }
}
