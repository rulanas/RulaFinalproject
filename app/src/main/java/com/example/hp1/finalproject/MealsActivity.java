package com.example.hp1.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MealsActivity extends AppCompatActivity implements View.OnClickListener{

    Button cal;
    EditText fcal, scal, tcal;
    TextView result;
    DBHandling db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);


        cal=(Button)findViewById(R.id.cal);
        fcal=(EditText)findViewById(R.id.fcal);
        scal=(EditText)findViewById(R.id.scal);
        tcal=(EditText)findViewById(R.id.tcal);
        result=(TextView)findViewById(R.id.result);

        cal.setOnClickListener(this);

        db = new DBHandling(this);

    }

    @Override
    public void onClick(View v) {
        if(v==cal){

            Date d = new Date();
            CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());

            int val = Integer.parseInt( fcal.getText().toString() );
            int va2 = Integer.parseInt( scal.getText().toString() );
            int va3 = Integer.parseInt( tcal.getText().toString() );


             if(val+va2+va3>=2000)
                 result.setText("you reached the required amount of CALORIES");
            if(val+va2+va3<2000)
                result.setText("you didn't reached the required amount of CALORIES");

            db.addMeal(new DailyMeal(0,"Meal "+s,val, va2, va3, val+va2+va3));
        }
    }
}
