package com.example.hp1.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RecipeDetailsActivity extends AppCompatActivity {

    TextView tvRecipeDetails;
    String recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        tvRecipeDetails = (TextView) findViewById(R.id.tvRecipeDetails);

        Intent  i = getIntent();
        recipe = i.getStringExtra("recipe");
        loadRecipe(recipe);
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
        try{
            temp="";
            all="";

            //open a channel for file reading
            in= new InputStreamReader(is);
            br= new BufferedReader(in);
            //while end of file not reached
            //readline() reads one line at a time
            while((temp=br.readLine())!=null)
                all+=temp+"\n";//concatinate all lines to a string
            is.close();//file close
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        tvRecipeDetails.setText(all);
    }
}
