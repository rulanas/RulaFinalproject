package com.example.hp1.finalproject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener{

    Button btreset;
    ListView lvItems;
    ArrayList<Item> items = new ArrayList<Item>();
    ImageView[][] imvWater=new ImageView[3][3];
    int[][] imvWater_id={{R.id.im1,R.id.im2,R.id.im3},{R.id.im4,R.id.im5,R.id.im6},{R.id.im7,R.id.im8,R.id.im9}};
    private NotificationCompat.Builder builder;
    private Button btnNotify;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++) {
                imvWater[i][j] = (ImageView) findViewById(imvWater_id[i][j]);
                imvWater[i][j].setOnClickListener(this);
            }

        lvItems=(ListView)findViewById(R.id.lvItems);
        btreset=(Button)findViewById(R.id.btreset);

        items.add(new Item("First Item",R.drawable.fo));
        items.add(new Item("Second Item",R.drawable.ch));
        items.add(new Item("Third Item",R.drawable.spor));
        items.add(new Item("Third Item",R.drawable.info));

        btreset.setOnClickListener(this);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_row, items);
        lvItems.setAdapter(adapter);

        lvItems.setOnItemClickListener(this);







        btnNotify = (Button) findViewById(R.id.btnNotify);

        //create builder object
        builder = new NotificationCompat.Builder(this);

        //customize the builder
        builder.setSmallIcon(R.drawable.a);
        builder.setContentTitle("Notification Title");
        builder.setContentText("Click here to go back ");

        //
        Intent bIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, bIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add as notification
                NotificationManager manager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
                manager.notify(0, builder.build());
            }
        });
    }









    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(position==0)
        {
            Intent i3=new Intent(this,MealsActivity.class);
            startActivity(i3);
        }


        if(position==1)
        {
            Intent i4 = new Intent(this,AllRecipeActivity.class);
            startActivity(i4);
        }

        if(position==2)
        {
            Intent i5 = new Intent(this,ExercisesActivity.class);
            startActivity(i5);
        }

        if(position==3)
        {
            Intent i6 = new Intent(this,InfoActivity.class);
            startActivity(i6);
        }
    }

    @Override
    public void onClick(View v) {
        if(v==btreset) {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    imvWater[i][j].setImageResource(R.drawable.water);
        }
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++) {
                if(v==imvWater[i][j])
                    imvWater[i][j].setImageResource(R.drawable.ve);
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                AlertDialog.Builder builder= new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("loguot");
                builder.setMessage("are you sure you want to logout");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent i2 = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(i2);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();

                break;
            case R.id.settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
