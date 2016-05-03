package com.lab.bus.tracker;

/**
 * Created by ravi on 03-May-16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
public class mydbhandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "Registration";
    private static final String TABLE_PRODUCTS = "Registrationtable";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_STUDENTNAME ="_studentname";
    private static final String COLUMN_ENROLL= "_enroll";
    private static final String COLUMN_FNAME = "_fname";
    private static final String COLUMN_USERNAME = "_username";
    private static final String COLUMN_PASSWORD = "_password";
    private Context getContext;

    public mydbhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE "+ TABLE_PRODUCTS + "("+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_STUDENTNAME + " TEXT,"+
                COLUMN_ENROLL + " INTEGER,"+
                COLUMN_FNAME + " TEXT,"+
                COLUMN_USERNAME + " TEXT,"+
                COLUMN_PASSWORD + " TEXT" +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ DATABASE_NAME);
        onCreate(db);
    }

    public void dbadd(dbaccess register){
        ContentValues content = new ContentValues();

        content.put(COLUMN_STUDENTNAME,register.get_studentname());
        content.put(COLUMN_ENROLL,register.get_enroll());
        content.put(COLUMN_FNAME,register.get_fname());
        content.put(COLUMN_USERNAME,register.get_username());
        content.put(COLUMN_PASSWORD,register.get_password());

        try {
            long var = 0L;

            SQLiteDatabase db = this.getWritableDatabase();

            db.insert(TABLE_PRODUCTS, null, content);
              Toast.makeText(getContext,"Your data has been recorded",Toast.LENGTH_LONG).show();
            db.close();
        }catch (Exception e){
            //Log.e(String.valueOf(tas),"Problem is here");

            Toast.makeText(getContext,"hello ",Toast.LENGTH_SHORT).show();
        }
    }
}
