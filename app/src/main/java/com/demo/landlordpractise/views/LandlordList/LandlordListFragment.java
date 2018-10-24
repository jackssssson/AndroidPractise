package com.demo.landlordpractise.views.LandlordList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.demo.landlordpractise.R;
import com.demo.landlordpractise.models.Landlord;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordListFragment extends Fragment
        implements AdapterView.OnItemClickListener, LandlordListContracts.View {

    @BindView(R.id.lv_landlord)
    ListView mLandLordListView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    private ArrayAdapter<Landlord> mLandLordAdapter;


    private LandlordListContracts.Navigator mNavigator;
    private LandlordListContracts.Presenter mPresenter;

    public LandlordListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landlord_list,
                container, false);

        ButterKnife.bind(this, view);

        mLandLordAdapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()),
                android.R.layout.simple_list_item_1);

        mLandLordListView.setAdapter(mLandLordAdapter);
        mLandLordListView.setOnItemClickListener(this);


        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadLandlords();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mPresenter.selectLandlord(position);
        Landlord landlordClass = new Landlord("Jivko", "6");
        mLandLordAdapter.add(landlordClass);
        mNavigator.navigateWith(landlordClass);
    }

    public static LandlordListFragment newInstance() {
        return new LandlordListFragment();
    }

    @Override
    public void setPresenter(LandlordListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLandlords(List<Landlord> landlords) {
        mLandLordAdapter.clear();
        List<Landlord> names = new ArrayList<>(landlords);


        runOnUi(() -> mLandLordAdapter.addAll(names));
    }

    @Override
    public void showEmptyLandlordsList() {
        runOnUi(() -> Toast.makeText(getContext(),
                "No landlords", Toast.LENGTH_LONG).show());
    }

    @Override
    public void showError(Exception e) {
        runOnUi(() -> Toast.makeText(getContext(),
                "Error", Toast.LENGTH_LONG).show());
    }

    @Override
    public void showLoading() {
        runOnUi(() -> {
            mLandLordListView.setVisibility(View.GONE);
            mLoadingView.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public void hideLoading() {
        runOnUi(() -> {
            mLandLordListView.setVisibility(View.VISIBLE);
            mLoadingView.setVisibility(View.GONE);
        });
    }

    @Override
    public void showLandlordDetails(Landlord landlord) {
        runOnUi(() -> mNavigator.navigateWith(landlord));
    }

    void setNavigator(LandlordListContracts.Navigator navigator){
        mNavigator = navigator;
    }

    private void runOnUi(Runnable action){
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }
}
