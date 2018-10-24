package com.demo.landlordpractise.views.LandlordList;

import com.demo.landlordpractise.async.AsyncRunner;
import com.demo.landlordpractise.models.Landlord;
import com.demo.landlordpractise.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class LandlordListPresenter implements LandlordListContracts.Presenter {
    private final Repository<Landlord> mLandLordRepositories;
    private LandlordListContracts.View mView;
    private List<Landlord> mLandlords;

    LandlordListPresenter(Repository<Landlord> landlordRepository) {
        mLandLordRepositories = landlordRepository;
    }

    @Override
    public void subscribe(LandlordListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadLandlords() {
        mView.showLoading();
        AsyncRunner.runInBackGround(() -> {
            try {
                 mLandlords = mLandLordRepositories.getAll();

                if (mLandlords.isEmpty()) {
                    mView.showEmptyLandlordsList();
                } else {
                    mView.showLandlords(mLandlords);
                }
            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }
            mView.hideLoading();
        });
    }

    @Override
    public void selectLandlord(int position) {

        Landlord landlord = mLandlords.get(position);
        mView.showLandlordDetails(landlord);
    }
}
