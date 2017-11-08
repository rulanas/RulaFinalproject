package com.example.hp1.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AllRecipeActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton a,b,c,d,e,f,j,h,i,g,k,l,m,n,o,p,q,r,s,t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

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
        i = (ImageButton) findViewById(R.id.i);
        i.setOnClickListener(this);
        j = (ImageButton) findViewById(R.id.j);
        j.setOnClickListener(this);
        k = (ImageButton) findViewById(R.id.k);
        k.setOnClickListener(this);
        l = (ImageButton) findViewById(R.id.l);
        l.setOnClickListener(this);
        m = (ImageButton) findViewById(R.id.m);
        m.setOnClickListener(this);
        n = (ImageButton) findViewById(R.id.n);
        n.setOnClickListener(this);
        o = (ImageButton) findViewById(R.id.o);
        o.setOnClickListener(this);
        p = (ImageButton) findViewById(R.id.p);
        p.setOnClickListener(this);
        q = (ImageButton) findViewById(R.id.q);
        q.setOnClickListener(this);
        r = (ImageButton) findViewById(R.id.r);
        r.setOnClickListener(this);
        s = (ImageButton) findViewById(R.id.s);
        s.setOnClickListener(this);
        t = (ImageButton) findViewById(R.id.t);
        t.setOnClickListener(this);




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
        startActivity(i);
    }
}
