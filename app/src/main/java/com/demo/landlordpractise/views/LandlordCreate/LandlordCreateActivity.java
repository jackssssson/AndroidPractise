package com.demo.landlordpractise.views.LandlordCreate;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.demo.landlordpractise.R;
import com.demo.landlordpractise.views.BaseDrawerActivity;

public class LandlordCreateActivity extends BaseDrawerActivity {
    public  static final long IDENTIFIER = 953;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_create);

        mToolBar = findViewById(R.id.drawer_toolbar);
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolBar;
    }
}
