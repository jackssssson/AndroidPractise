package com.demo.landlordpractise.views.LandlordDetails;

import com.demo.landlordpractise.models.Landlord;

public interface LandlordsDetailsContracts {
    interface View {
        void showLandlord(Landlord landlord);

        void setPresenter(Presenter presenter);

        void showError(Exception e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadLandlords();
    }
}
