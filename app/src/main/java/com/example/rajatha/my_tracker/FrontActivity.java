package com.example.rajatha.my_tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class FrontActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Button Login=(Button)findViewById(R.id.Login);
        final Button Register=(Button)findViewById(R.id.Register);
         Login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent login= new Intent(FrontActivity.this,Login.class);
                 startActivity(login);
             }
         });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent register= new Intent(FrontActivity.this,Register.class);
                startActivity(register);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}


