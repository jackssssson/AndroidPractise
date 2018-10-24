package com.demo.landlordpractise.views.LandlordList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.demo.landlordpractise.AndroidApplication;
import com.demo.landlordpractise.R;
import com.demo.landlordpractise.models.Landlord;
import com.demo.landlordpractise.repositories.base.Repository;
import com.demo.landlordpractise.views.BaseDrawerActivity;
import com.demo.landlordpractise.views.LandlordDetails.LandlordDetailsActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class LandlordListActivity extends BaseDrawerActivity implements LandlordListContracts.Navigator {
    public static final long IDENTIFIER = 363;

    @Inject
    private LandlordListFragment mLandlordListFragment;

    @Inject
    private LandlordListContracts.Presenter mLandlordListPresenter;

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_list);


        mLandlordListFragment.setNavigator(this);
        mLandlordListFragment.setPresenter(mLandlordListPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_fragment, mLandlordListFragment)
                .commit();

        //setUpDrawer();

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolBar;
    }

    @Override
    public void navigateWith(Landlord landlord) {
        Intent intent = new Intent(this, LandlordDetailsActivity.class);

        intent.putExtra(LandlordDetailsActivity.EXTRA_KEY, landlord);

        startActivity(intent);
    }
}
