package com.example.rajatha.my_tracker;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class Login extends AppCompatActivity {
    String User,Name;
    String mPassword,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText UserName = (EditText) findViewById(R.id.UserName);
        final EditText Password = (EditText) findViewById(R.id.Password);
        final Button Login = (Button) findViewById(R.id.Login1);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User = UserName.getText().toString();
                mPassword = Password.getText().toString();

                Boolean DBexists= doesDatabaseExist(getBaseContext(),User);
                if(DBexists){
                    if(loginstatus()){
                        Toast.makeText(getBaseContext(), "Login Successful!!!", Toast.LENGTH_SHORT).show();
                        Intent mainActivity= new Intent(Login.this,MainActivity.class);
                        Bundle b = new Bundle();
                        b.putString("UserName",User);
                        b.putString("Password",mPassword);
                        mainActivity.putExtras(b);
                        startActivity(mainActivity);
                        finish();

                    }else {

                        Toast.makeText(getBaseContext(),"Wrong Password!!! ",Toast.LENGTH_LONG).show();
                       finish();
                    }

                }else {

                    Toast.makeText(getBaseContext(), "User name doesn't exists,Kindly Register!!!", Toast.LENGTH_SHORT).show();
                }


            }
        });



}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Login.this,FrontActivity.class));
    }

    private static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }

     private boolean loginstatus(){
         UserDataBase DB = new UserDataBase(getBaseContext(),User);
         Cursor CR = DB.getInformation(DB);
         CR.moveToFirst();
         boolean loginstatus=false;
         do{

             if(User.equals(CR.getString(0))&& mPassword.equals(CR.getString(1)))
             {
                 loginstatus=true;
                 Name =CR.getString(0);
                 password=CR.getString(1);
             }
         }while(CR.moveToNext());

         return loginstatus;

     }

}
