package com.example.hp1.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AllRecipeActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton a,b,c,d,e,f,j,h,g,k,n,r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_pic);

        a = (ImageButton) findViewById(R.id.a);
        a.setOnClickListener(this);
        b = (ImageButton) findViewById(R.id.b);
        b.setOnClickListener(this);
        c = (ImageButton) findViewById(R.id.c);
        c.setOnClickListener(this);
        d = (ImageButton) findViewById(R.id.d);
        d.setOnClickListener(this);
        e = (ImageButton) findViewById(R.id.e);
        e.setOnClickListener(this);
        f = (ImageButton) findViewById(R.id.f);
        f.setOnClickListener(this);
        g = (ImageButton) findViewById(R.id.g);
        g.setOnClickListener(this);
        h = (ImageButton) findViewById(R.id.h);
        h.setOnClickListener(this);

        j = (ImageButton) findViewById(R.id.j);
        j.setOnClickListener(this);
        k = (ImageButton) findViewById(R.id.k);
        k.setOnClickListener(this);

        n = (ImageButton) findViewById(R.id.n);
        n.setOnClickListener(this);

        r = (ImageButton) findViewById(R.id.r);
        r.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, RecipeDetailsActivity.class);
        if (v == a) {
            i.putExtra("recipe", "greenpizza");
        }
        if (v == b){
            i.putExtra("recipe", "chicken");
    }

        if (v == c){
            i.putExtra("recipe", "creamypasta");
        }

        if (v == d){
            i.putExtra("recipe", "swedishmeat");
        }

        if (v == e){
            i.putExtra("recipe", "mozzarella");
        }

        if (v == f){
            i.putExtra("recipe", "soupwithpesto");
        }


        if (v == g){
            i.putExtra("recipe", "whitebeansalad");
        }



        if (v == h){
            i.putExtra("recipe", "shrimpboy");
        }

        if (v == r){
            i.putExtra("recipe", "hotchile");
        }

        if (v == j){
            i.putExtra("recipe", "eggsalad");
        }

        if (v == k){
            i.putExtra("recipe", "chili");
        }

        if (v == n){
            i.putExtra("recipe", "turkey");
        }

        startActivity(i);
    }
}
