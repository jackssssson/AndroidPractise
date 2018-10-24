package com.demo.landlordpractise.views.LandlordList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.demo.landlordpractise.R;
import com.demo.landlordpractise.models.Landlord;

public class LandlordListAdapter extends ArrayAdapter<Landlord> {

    LandlordListAdapter(@NonNull Context context) {
        super(context, -1);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.landlord_item, parent, false);

        TextView nameTextView = view.findViewById(R.id.tv_name);
        TextView secretIdentity = view.findViewById(R.id.tv_secret_identity);

        Landlord landlord = getItem(position);

        nameTextView.setText(landlord.getName());
        nameTextView.setText(landlord.getSecretIdentity());

        return view;
    }
}
