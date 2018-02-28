package com.example.hp1.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ExercisesActivity extends AppCompatActivity implements View.OnClickListener{

    Button btv1, btv2, btv3, btv4, btr;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);


        btr=(Button)findViewById(R.id.btr);
        btv1=(Button)findViewById(R.id.btv1);
        btv2=(Button)findViewById(R.id.btv2);
        btv3=(Button)findViewById(R.id.btv3);
        btv4=(Button)findViewById(R.id.btv4);

        btv1.setOnClickListener(this);
        btv2.setOnClickListener(this);
        btv3.setOnClickListener(this);
        btv4.setOnClickListener(this);
        btr.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        if (v == btv1) {
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=uuUzyXUgXpk")));
            Log.i("Video", "Video Playing....");

        }
        if (v == btv2) {
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=cWaxxvYsgcY")));
            Log.i("Video", "Video Playing....");

        }
        if (v == btv3) {
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=EsUMzKc9e6g")));
            Log.i("Video", "Video Playing....");

        }
        if (v == btv4) {
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=CsNFfIqQLYA")));
            Log.i("Video", "Video Playing....");

        }

        if (v == btr) {
            Intent v1 = new Intent(this,HomeActivity.class);
            startActivity(v1);

        }

    }
}
