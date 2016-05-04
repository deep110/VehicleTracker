package com.lab.bus.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.home_time_text) EditText mTime;
    @Bind(R.id.editText6 )EditText pass;

    @Bind(R.id.home_register_btn)Button mTimeRegisterBtn;

    @Bind(R.id.button)Button registerb;

    @Bind(R.id.home_tracking_btn)Button mTrackingBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mTimeRegisterBtn.setOnClickListener(this);
        mTrackingBtn.setOnClickListener(this);
        //mTime = (EditText)findViewById(R.id.editText6);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_register_btn:
                break;

            case R.id.home_tracking_btn:
                String userid = mTime.getText().toString();
                String password = pass.getText().toString();
                //if (userid=="admin" && password=="admin123"){
                Intent intent = new Intent(this, MapActivity.class);
                startActivity(intent);

        //else{
        //  Toast.makeText(getApplicationContext(),"Login Credentials are wrong ",Toast.LENGTH_LONG).show();
        //}
        break;
    }
    }
    public void register(View v){

        Intent i = new Intent(this,signup.class);
        startActivity(i);
    }
}
