package com.example.hp1.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecipeDetailsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lvRecipe;
    TextView tvRecipeDetails;
    ArrayList<String> arRecipe = new ArrayList<String>();
    String recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        lvRecipe = (ListView) findViewById(R.id.lvRecipe);
     //   tvRecipeDetails = (TextView) findViewById(R.id.tvRecipeDetails);

        Intent  i = getIntent();
        recipe = i.getStringExtra("recipe");
        loadRecipe(recipe);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arRecipe);
        lvRecipe.setAdapter(adapter);
        lvRecipe.setOnItemClickListener(this);
    }
    private void loadRecipe(String recipe){
        InputStream is=null;
        InputStreamReader in;
        BufferedReader br;

        String temp="", all="";

        if(recipe.equals("greenpizza")){
            is=getResources().openRawResource(R.raw.greenpizza);
        }
        if(recipe.equals("chicken")){
            is=getResources().openRawResource(R.raw.chicken);
        }
        if(recipe.equals("creamypasta")){
            is=getResources().openRawResource(R.raw.creamypasta);
        }
        if(recipe.equals("mozzarella")){
            is=getResources().openRawResource(R.raw.mozzarella);
        }
        if(recipe.equals("soupwithpesto")){
            is=getResources().openRawResource(R.raw.soupwithpesto);
        }
        if(recipe.equals("whitebeansalad")){
            is=getResources().openRawResource(R.raw.whitebeansalad);
        }
        if(recipe.equals("swedishmeat")){
            is=getResources().openRawResource(R.raw.swedishmeat);
        }
        if(recipe.equals("shrimpboy")){
            is=getResources().openRawResource(R.raw.shrimpboy);
        }
        if(recipe.equals("hotchile")){
            is=getResources().openRawResource(R.raw.hotchile);
        }
        if(recipe.equals("chili")){
            is=getResources().openRawResource(R.raw.chili);
        }
        if(recipe.equals("eggsalad")){
            is=getResources().openRawResource(R.raw.eggsalad);
        }
        if(recipe.equals("turkey")){
            is=getResources().openRawResource(R.raw.turkey);
        }
        try{
            temp="";
            all="";

            //open a channel for file reading
            in= new InputStreamReader(is);
            br= new BufferedReader(in);
            //while end of file not reached
            //readline() reads one line at a time
            while((temp=br.readLine())!=null) {
                all += temp + "\n";//concatinate all lines to a string
                arRecipe.add(temp);
            }
            is.close();//file close
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
      //  tvRecipeDetails.setText(all);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
