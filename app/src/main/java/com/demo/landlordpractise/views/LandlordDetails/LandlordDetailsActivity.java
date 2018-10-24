package com.demo.landlordpractise.views.LandlordDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.landlordpractise.AndroidApplication;
import com.demo.landlordpractise.R;
import com.demo.landlordpractise.models.Landlord;
import com.demo.landlordpractise.repositories.base.Repository;


public class LandlordDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_KEY = "LANDLORD_EXTRA_KEY";

    private LandlordDetailsFragment mLandlordDetailsFragment;
    private LandlordDetailsPresenter mLandlordDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_details);

        Repository<Landlord> repository = AndroidApplication.getRepository(
                Landlord.class, Landlord[].class);

        mLandlordDetailsPresenter = new LandlordDetailsPresenter(repository);

        Intent intent = getIntent();
        Landlord landlord = (Landlord) intent.getSerializableExtra(LandlordDetailsActivity.EXTRA_KEY);
        mLandlordDetailsPresenter.setLandlordId(landlord.getId());

        mLandlordDetailsFragment = LandlordDetailsFragment.newInstance();
        mLandlordDetailsFragment.setPresenter(mLandlordDetailsPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_details, mLandlordDetailsFragment)
                .commit();


    }
}
