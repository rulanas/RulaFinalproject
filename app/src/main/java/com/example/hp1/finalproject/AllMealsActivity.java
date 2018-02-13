package com.example.hp1.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllMealsActivity extends AppCompatActivity {
    ListView mealsList;
    DBHandling db;
    ArrayList<DailyMeal> dailyMeals = new ArrayList<DailyMeal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_meals);

        db = DBHandling.getsInstance(this);
        dailyMeals = db.getData();

        mealsList = (ListView) findViewById(R.id.lvMeals);
        ArrayAdapter<DailyMeal> adapter = new ArrayAdapter<DailyMeal>(this,android.R.layout.simple_list_item_1,dailyMeals);
        mealsList.setAdapter(adapter);
    }
}
