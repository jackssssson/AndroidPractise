package com.demo.landlordpractise.views.LandlordDetails;

import com.demo.landlordpractise.async.AsyncRunner;
import com.demo.landlordpractise.models.Landlord;
import com.demo.landlordpractise.repositories.base.Repository;

import java.io.IOException;

public class LandlordDetailsPresenter implements LandlordsDetailsContracts.Presenter {
    private final Repository<Landlord> mLandlordRepository;
    private LandlordsDetailsContracts.View mView;
    private int mLandlordId;

    public LandlordDetailsPresenter(Repository<Landlord> landlordRepository) {
        mLandlordRepository = landlordRepository;
    }

    @Override
    public void subscribe(LandlordsDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadLandlords() {

        mView.showLoading();
        AsyncRunner.runInBackGround(() -> {
            try {
                Landlord landlord = mLandlordRepository.getById(mLandlordId);
                mView.showLandlord(landlord);
            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }

            mView.hideLoading();
        });
    }

    public void setLandlordId(int landlordId){
        mLandlordId = landlordId;
    }
}
