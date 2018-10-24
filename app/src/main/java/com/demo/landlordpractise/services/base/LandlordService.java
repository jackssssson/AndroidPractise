package com.demo.landlordpractise.services.base;

import com.demo.landlordpractise.models.Landlord;

import java.util.List;

public interface LandlordService {
    List<Landlord> getAllLandlords();

    List<Landlord> filterByName(String namePattern);

    Landlord getDetailsById(int id);
}
