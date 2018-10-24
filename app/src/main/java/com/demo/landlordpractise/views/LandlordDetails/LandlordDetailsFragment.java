package com.demo.landlordpractise.views.LandlordDetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.landlordpractise.R;
import com.demo.landlordpractise.models.Landlord;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordDetailsFragment extends Fragment implements LandlordsDetailsContracts.View{


    private LandlordsDetailsContracts.Presenter mPresenter;
    private TextView mNameTextView;
    private TextView mSecretIdentityTextView;

    public LandlordDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landlord_details, container, false);

        mNameTextView = view.findViewById(R.id.tv_name);
        mSecretIdentityTextView = view.findViewById(R.id.tv_secret_identity);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadLandlords();
    }

    @Override
    public void showLandlord(Landlord landlord) {
        runOnUi(() -> {
            mNameTextView.setText(landlord.getName());
            mSecretIdentityTextView.setText(landlord.getSecretIdentity());
        });
    }

    private void runOnUi(Runnable action) {
        getActivity().runOnUiThread(action);
    }

    @Override
    public void setPresenter(LandlordsDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Exception e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    public static LandlordDetailsFragment newInstance() {
        return new LandlordDetailsFragment();
    }
}
