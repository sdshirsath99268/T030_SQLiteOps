package com.example.t030_sqliteops;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbName";
    public static final int DATABASE_VERSION = 1;
    public static final String QUERY =
            "CREATE TABLE " + UserContract.NewUserInfo.TABLE_NAME + "(" +
                              UserContract.NewUserInfo.NAME_KEY + " TEXT, " +
                              UserContract.NewUserInfo.CONTACT_KEY + " TEXT, " +
                              UserContract.NewUserInfo.EMAIL_KEY + " TEXT);" ;


    public UserDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("SQLite", "Database Created or Opned");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY);
        Log.d("SQLite","TABLE created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //add
    public void addInformation(String name, String contact , String email, SQLiteDatabase sqLiteDatabase){
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.NAME_KEY, name);
        contentValues.put(UserContract.NewUserInfo.CONTACT_KEY, contact);
        contentValues.put(UserContract.NewUserInfo.EMAIL_KEY, email);
        sqLiteDatabase.insert(UserContract.NewUserInfo.TABLE_NAME , null , contentValues);
        Log.d("SQLite" , "Data Inserted");
    }

    //view
    public Cursor getInfos(SQLiteDatabase sqLiteDatabase){
        Cursor cursor;
        String[] columns = {UserContract.NewUserInfo.NAME_KEY, UserContract.NewUserInfo.CONTACT_KEY, UserContract.NewUserInfo.EMAIL_KEY};
        cursor = sqLiteDatabase.query(UserContract.NewUserInfo.TABLE_NAME, columns, null, null, null, null, null);
        return cursor;
    }
    //delete

    //update


}
