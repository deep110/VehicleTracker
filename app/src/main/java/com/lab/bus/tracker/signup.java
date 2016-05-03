package com.lab.bus.tracker;

import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    EditText sname;
    EditText enroll;
    EditText fname;
    EditText username;
    EditText password;
    mydbhandler handle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sname = (EditText)findViewById(R.id.editText);
        enroll = (EditText)findViewById(R.id.editText2);
        fname = (EditText)findViewById(R.id.editText3);
        username = (EditText)findViewById(R.id.editText4);
        password = (EditText)findViewById(R.id.editText5);
        handle = new mydbhandler(this,null,null,1);
    }

    public void clicked(View v){
        dbaccess register = new dbaccess(sname.getText().toString(), Integer.parseInt(enroll.getText().toString()),
        fname.getText().toString(),username.getText().toString(),password.getText().toString());

        handle.dbadd(register);
    }

}
