package com.demo.landlordpractise.views.LandlordList;

import com.demo.landlordpractise.models.Landlord;

import java.util.List;

public interface LandlordListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showLandlords(List<Landlord> landlords);

        void showEmptyLandlordsList();

        void showError(Exception e);

        void showLoading();

        void hideLoading();

        void showLandlordDetails(Landlord landlord);
    }

    interface Presenter {
        void subscribe(View view);

        void loadLandlords();

        void selectLandlord(int position);
    }

    interface Navigator {
        void navigateWith(Landlord landlord);
    }
}
