package com.example.t030_sqliteops;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {

    EditText name, contact, email ;
    Button save ;
    Context context = this ;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        name = (EditText) findViewById(R.id.edittextname);
        contact = (EditText) findViewById(R.id.edittextcontact);
        email = (EditText) findViewById(R.id.edittextemail);
        save = (Button) findViewById(R.id.buttonsave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NAME = name.getText().toString();
                String CONTACT = contact.getText().toString();
                String EMAIL = email.getText().toString();

                userDbHelper = new UserDbHelper(context);
                sqLiteDatabase = userDbHelper.getWritableDatabase();
                userDbHelper.addInformation(NAME , CONTACT , EMAIL , sqLiteDatabase);
                Toast.makeText(getApplicationContext(), "Row Inserted", Toast.LENGTH_SHORT).show();
                userDbHelper.close();
            }
        });

    }
}