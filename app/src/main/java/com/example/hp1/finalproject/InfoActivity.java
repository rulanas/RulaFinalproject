package com.example.hp1.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    ListView lvDeailyMeals;
    DBHandling db;
    ArrayList<DailyMeal> meals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        lvDeailyMeals = (ListView) findViewById(R.id.lvDeailyMeals);
        db = DBHandling.getsInstance(this);
        meals = db.getData();

        CustomAdapterDaily adapterDaily = new CustomAdapterDaily(this, R.layout.custom_row_meal, meals);
        lvDeailyMeals.setAdapter(adapterDaily);
    }
}
