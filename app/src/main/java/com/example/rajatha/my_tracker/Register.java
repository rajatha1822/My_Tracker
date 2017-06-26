package com.example.rajatha.my_tracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Register extends AppCompatActivity {
    Float mWeight;
    Float mHeight;
    TextView CBMI;
    String UserName,Password,CPassword;
    String nGender,nAge,nWeight,nHeight,nCBMI,nTBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText Name=(EditText)findViewById(R.id.UName);
        final EditText Gender=(EditText)findViewById(R.id.Gender);
        final EditText Age=(EditText)findViewById(R.id.Age);
        final EditText Weight=(EditText)findViewById(R.id.Weight);
        final EditText Height=(EditText)findViewById(R.id.Height);
        CBMI=(TextView) findViewById(R.id.GBMI);
        final EditText TBMI=(EditText)findViewById(R.id.T_BMI);
        final EditText PassWord=(EditText)findViewById(R.id.Password);
        final EditText CPassWord=(EditText)findViewById(R.id.CPassword);
        final Button Generate=(Button)findViewById(R.id.G_BMI);
        final Button Register=(Button)findViewById(R.id.Reg);
        Register.setEnabled(false);

        Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mWeight=Float.parseFloat(Weight.getText().toString());
                mHeight=Float.parseFloat(Height.getText().toString());
                Float BMI=(mWeight/(mHeight*mHeight));
                CBMI.setText(BMI.toString());
                Register.setEnabled(true);

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserName=Name.getText().toString().trim();
                Password=PassWord.getText().toString().trim();
                CPassword=CPassWord.getText().toString().trim();
                nGender=Gender.getText().toString().trim();
                nAge=Age.getText().toString().trim();
                nWeight=Weight.getText().toString().trim();
                nHeight=Height.getText().toString().trim();
                nCBMI=CBMI.getText().toString().trim();
                nTBMI=TBMI.getText().toString().trim();
               if(!(doesDatabaseExist(getBaseContext(),UserName))) {
                   if (!(Password.equals(CPassword))) {

                       Toast.makeText(getBaseContext(), "Passwords are not matching", Toast.LENGTH_SHORT).show();
                       Name.setText(" ");
                       PassWord.setText(" ");
                       CPassWord.setText(" ");
                   } else {


                       UserDataBase DB = new UserDataBase(getBaseContext(), UserName);
                       DB.AddPersonalDetails(DB, UserName, nGender, nAge, nWeight, nHeight, nCBMI, nTBMI, Password);
                       Toast.makeText(getBaseContext(), "Successfully Registered !!!", Toast.LENGTH_SHORT).show();
                       Intent mainActivity = new Intent(Register.this, MainActivity.class);
                       Bundle b = new Bundle();
                       b.putString("UserName", UserName);
                       b.putString("Password", Password);
                       mainActivity.putExtras(b);
                       startActivity(mainActivity);
                       finish();

                   }
               }
               else{
                   Toast.makeText(getBaseContext(),"UserName already exists,select a new one", Toast.LENGTH_SHORT).show();
                   Name.setText(" ");
                   PassWord.setText(" ");
                   CPassWord.setText(" ");
               }



            }
        });
    }

    private static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
}
