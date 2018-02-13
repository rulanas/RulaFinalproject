package com.example.hp1.finalproject;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hp1 on 27/09/2017.
 */

public class CustomAdapterDaily extends ArrayAdapter<DailyMeal> {

    private int resource;

    public CustomAdapterDaily(Context context, int resource, List<DailyMeal> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater imageInflater = LayoutInflater.from(getContext());
        View cuView = imageInflater.inflate(resource, parent, false );

        DailyMeal meal = getItem(position);
        TextView tvMeal = (TextView) cuView.findViewById(R.id.tvDayTitle);
        tvMeal.setText(meal.getDay());

        TextView tvTotal = (TextView) cuView.findViewById(R.id.tvTotal);
        tvTotal.setText(meal.getTotal()+"");

        return cuView;
    }
}

