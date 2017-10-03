package com.example.hp1.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lvItems;
    ArrayList<Item> items = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvItems=(ListView)findViewById(R.id.lvItems);

        items.add(new Item("Third Item",R.drawable.settings));
        items.add(new Item("Third Item",R.drawable.fo));
        items.add(new Item("Third Item",R.drawable.spor));
        items.add(new Item("Third Item",R.drawable.ch));
        items.add(new Item("Third Item",R.drawable.info));


        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_row, items);
        lvItems.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
