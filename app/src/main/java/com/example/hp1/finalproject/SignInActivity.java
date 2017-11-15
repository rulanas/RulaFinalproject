package com.example.hp1.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{
    private Bitmap bitmap;

    private ImageView imageView;
    Button btCamera,btGalery, submit;
    EditText name, pass3,height, age ;

    static final int SELECT_IMAGE=1;
    static final int TAKE_IMAGE=0;


    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        height =(EditText) findViewById(R.id.height);
        pass3 =(EditText) findViewById(R.id.pass3);
        age =(EditText) findViewById(R.id.age);
        name =(EditText) findViewById(R.id.name);
        submit =(Button) findViewById(R.id.submit);
        btCamera =(Button) findViewById(R.id.btCamera);
        btGalery = (Button) findViewById(R.id.btGalery);
        imageView=(ImageView) findViewById(R.id.imageView);

        btCamera.setOnClickListener(this);
        btGalery.setOnClickListener(this);
        submit.setOnClickListener(this);

        preferences  = this.getSharedPreferences("profile",MODE_PRIVATE);

        name.setText(preferences.getString("user",null));
        pass3.setText(preferences.getString("pass",null));
        age.setText(preferences.getString("old",null));
        height.setText(preferences.getString("height",null));


        String path = preferences.getString("image",null);
        if(path != null) {
            bitmap = BitmapFactory.decodeFile(path);
            imageView.setImageBitmap(bitmap);
        }

        if(!hasCamera()){
            btCamera.setEnabled(false);
        }
    }
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    @Override
    public void onClick(View v) {

       if(v==submit) {
           SharedPreferences.Editor editor = preferences.edit();
           String user = name.getText().toString(), pass = pass3.getText().toString(), old = age.getText().toString(),
                   heightt = height.getText().toString();
                   editor.putString("user",user);
           editor.putString("pass",pass);
           editor.putString("old",old);
           editor.putString("height",heightt);
           if ((!user.equals("")) && (!pass.equals("")) && (!old.equals("") && (!heightt.equals("")))) {
               Intent i4 = new Intent(this, HomeActivity.class);
               startActivity(i4);
           } else {
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
           editor.commit();
       }

        if(v==btCamera){
            //start another activity and receive a result back in case the activity exists return 0
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,TAKE_IMAGE );
        }if(v==btGalery){
            Intent i = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, SELECT_IMAGE);
        }
    }

    /**
     *  The resultCode will be RESULT_CANCELED if the activity explicitly returned that, didn't return any result, or crashed during its operation.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKE_IMAGE && resultCode == RESULT_OK) {
            Bundle extra = data.getExtras();
            bitmap = (Bitmap) extra.get("data");
            saveImage(bitmap);
            imageView.setImageBitmap(bitmap);
        } else if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            Toast.makeText(getApplicationContext(), targetUri.toString(), Toast.LENGTH_LONG).show();
            Bitmap bitmap;
            try {

                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));

                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

        public File saveImage(Bitmap bitmap) {


            SharedPreferences.Editor editor = preferences.edit();

            File root = Environment.getExternalStorageDirectory();// internal storage launching .
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath=root.getAbsolutePath()+"/DCIM/Camera/IMG"+timeStamp+".jpg";

            editor.putString("image",filePath);
            editor.commit();

            File file=new File(filePath);
                try {
                    // if gallary nit full create a file and save images
                    file.createNewFile();// create new file to save image.
                    FileOutputStream ostream = new FileOutputStream(file);//saves root in this file
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);// compass bitmap in file
                    ostream.close();// close
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Faild to save image", Toast.LENGTH_SHORT).show();
                }
                return file;
            }

        }





