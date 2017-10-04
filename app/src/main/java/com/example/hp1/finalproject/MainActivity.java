package com.example.hp1.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText username, password;
    Button signup, login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        signup=(Button)findViewById(R.id.signup);
        login=(Button)findViewById(R.id.login);
        signup.setOnClickListener(this);
        login.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v==signup){
            Intent i=new Intent(this,Main3Activity.class);
            startActivity(i);
        }
        if(v==login){
            String user=username.getText().toString()
                    ,pass=password.getText().toString();
            if((!user.equals(""))&&(!pass.equals("")))
            {
                Intent i1=new Intent(this,Main2Activity.class);
                startActivity(i1);
            }
            else{
                AlertDialog.Builder builder= new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("login");
                builder.setMessage("you missed something");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }
        }
    }
}
