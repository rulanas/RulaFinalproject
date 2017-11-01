package com.example.hp1.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener{

    Button cal;
    EditText fcal, scal, tcal;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        cal=(Button)findViewById(R.id.cal);
        fcal=(EditText)findViewById(R.id.fcal);
        scal=(EditText)findViewById(R.id.scal);
        tcal=(EditText)findViewById(R.id.tcal);
        result=(TextView)findViewById(R.id.result);


        cal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==cal){

            int val = Integer.parseInt( fcal.getText().toString() );
            int va2 = Integer.parseInt( scal.getText().toString() );
            int va3 = Integer.parseInt( tcal.getText().toString() );


             if(val+va2+va3>=2000)
                 result.setText("you reached the the required amount of CALORIES");
            if(val+va2+va3<2000)
                result.setText("you didn't reached the the required amount of CALORIES");
        }
    }
}
