package com.demo.landlordpractise.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.demo.landlordpractise.views.LandlordCreate.LandlordCreateActivity;
import com.demo.landlordpractise.views.LandlordList.LandlordListActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseDrawerActivity extends AppCompatActivity {

    private void setUpDrawer() {
        PrimaryDrawerItem listLandlordsItem = new PrimaryDrawerItem()
                .withIdentifier(LandlordListActivity.IDENTIFIER)
                .withName("Landlords");

        PrimaryDrawerItem createLandlordItem = new PrimaryDrawerItem()
                .withIdentifier(LandlordCreateActivity.IDENTIFIER)
                .withName("Create landlord");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getDrawerToolbar())
                .addDrawerItems(

                        listLandlordsItem,
                        new DividerDrawerItem(),
                        createLandlordItem
                )
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    long identifier = drawerItem.getIdentifier();
                    if (getIdentifier() == identifier) {
                        return false;
                    }

                    Intent intent = getNextIntent(identifier);

                    if (intent == null) {
                        return false;
                    }

                    startActivity(intent);
                    return true;
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        Map<Long, Intent> mIdentifierToIntents = new HashMap<>();

        mIdentifierToIntents.put(LandlordListActivity.IDENTIFIER,
                new Intent(
                        BaseDrawerActivity.this,
                        LandlordListActivity.class));

        mIdentifierToIntents.put(LandlordCreateActivity.IDENTIFIER,
                new Intent(
                        BaseDrawerActivity.this,
                        LandlordCreateActivity.class));

        if (!mIdentifierToIntents.containsKey(identifier)) {
            return null;
        }

        return mIdentifierToIntents.get(identifier);
    }

    protected abstract long getIdentifier();

    protected abstract Toolbar getDrawerToolbar();

    @Override
    protected void onStart() {
        super.onStart();
        setUpDrawer();
    }
}
