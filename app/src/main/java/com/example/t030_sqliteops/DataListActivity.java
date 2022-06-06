package com.example.t030_sqliteops;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {

    ListView listView ;
    UserDbHelper userDbHelper ;
    SQLiteDatabase sqLiteDatabase ;
    Cursor cursor ;
    DataListAdapter dataListAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        listView = (ListView) findViewById(R.id.list1);
        dataListAdapter = new DataListAdapter(DataListActivity.this, R.layout.fetch_layout);
        listView.setAdapter(dataListAdapter);

        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        cursor = userDbHelper.getInfos(sqLiteDatabase);

        if(cursor.moveToFirst()){
            do{
                String name, contact, email ;
                name = cursor.getString(0);
                contact = cursor.getString(1);
                email = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(name,contact,email);
                dataListAdapter.add(dataProvider);

            } while (cursor.moveToNext());
        }

    }
}