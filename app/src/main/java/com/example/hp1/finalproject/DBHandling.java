package com.example.hp1.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.util.ULocale;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Hp1 on 23/01/2018.
 */

public class DBHandling extends SQLiteOpenHelper {

    private static DBHandling sInstance;

    public static final int DATABASE_VERSION = 4;

    //database name
    public static final String DATABASE_NAME = "diet.db";

    //data table name
    public static final String TABLE_DIET = "meals";

    //column names
    public static final String COL_ID = "id";
    public static final String COL_DAY = "day";
    public static final String COL_CAL1 = "cal1";
    public static final String COL_CAL2 = "cal2";
    public static final String COL_CAL3 = "cal3";
    public static final String COL_TOTAL = "total";

    //constuctor
    public DBHandling(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // p3ola bt3tene emkanye eno atwjh l2ubykt mn kul lm7lkot, bshrt enu mykunshn 7da esa 3m bst3mlo
    public static synchronized DBHandling getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBHandling(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //in case table already exists need to drop then re-build
        //save query to creat table in database according to requirement in a string variable
        String query = "CREATE TABLE " + TABLE_DIET
                + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_DAY + " TEXT,"
                + COL_CAL1 + " INTEGER,"
                + COL_CAL2 + " INTEGER,"
                + COL_CAL3 + " INTEGER, "
                + COL_TOTAL + " INTEGER"
                + ");";


        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DIET);
            Log.d("QUERY", query);
            Log.d("QUERY", query);
            Log.d("QUERY", query);
            db.execSQL(query);
        } catch (Exception e) {
            Log.d("Couldn't add table", e.getMessage());
            Log.d("QUERY", query);
            Log.d("QUERY", query);
        }

    }


    //this method must be implemented as part of implementing the interface SQLiteOpenHelper
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DIET);
        onCreate(db);

    }

    //add user to the database method
    public void addMeal(DailyMeal meal) {
        //creat ContentValue containning values to be updated in this
        ContentValues values = new ContentValues();

        values.put(COL_DAY, meal.getDay());
        values.put(COL_CAL1, meal.getCal1());
        values.put(COL_CAL2, meal.getCal2());
        values.put(COL_CAL3, meal.getCal3());
        values.put(COL_TOTAL, meal.getTotal());


        //create SQLitedatabase object to enable writing/reading in dtaabase
        SQLiteDatabase db = getWritableDatabase();
        Long id = db.insert(TABLE_DIET, null, values);
        meal.setId(id); //update the iser id according to the auto incremented id in the DB

        //logging for debugging purposes
        Log.d("ID", "Meal id: " + id + " added to DB");

        //close connection to database
        db.close();


    }

    //search data from DB
    public ArrayList<DailyMeal> getData() {
        String[] r = new String[6];
        int[] col = new int[6];
        String query = "SELECT * FROM " + TABLE_DIET;

        ArrayList<DailyMeal> m = new ArrayList<DailyMeal>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        col[0]=c.getColumnIndex(COL_ID);
        col[1]=c.getColumnIndex(COL_DAY);
        col[2]=c.getColumnIndex(COL_CAL1);
        col[3]=c.getColumnIndex(COL_CAL2);
        col[4]=c.getColumnIndex(COL_CAL3);
        col[5]=c.getColumnIndex(COL_TOTAL);


        while(!c.isAfterLast()){
            for(int i=0; i<col.length; i++){
                r[i]=c.getString(col[i]);
            }

            m.add(new DailyMeal(Long.parseLong(r[0]), r[1], Integer.parseInt(r[2]) ,Integer.parseInt(r[3]) ,Integer.parseInt(r[4]), Integer.parseInt(r[5])));

            c.moveToNext();
        }

        return m;
    }
}
