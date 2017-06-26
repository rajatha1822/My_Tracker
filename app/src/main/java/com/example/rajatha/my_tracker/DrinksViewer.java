package com.example.rajatha.my_tracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DrinksViewer extends AppCompatActivity {
    FoodDataBase mHelper;
    private ArrayList<Drinks> mDrinks;
    private DrinksAdapter madapter;
    private String UserName,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_viewer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            UserName = bundle.getString("UserName");
            Password = bundle.getString("Password");

        }
        mDrinks =new ArrayList<>();
        ListView listView=(ListView)findViewById(R.id.Drinks_ListView);
        if(savedInstanceState==null){

            DrinksReaderAsync mReader=new DrinksReaderAsync();
            try {
                mDrinks =mReader.execute(getBaseContext()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        madapter= new DrinksAdapter(this, mDrinks);
        listView.setAdapter(madapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drinks mparcable=(Drinks) madapter.getItem(position);
                Intent parcableIntent= new Intent(DrinksViewer.this,FeedingDataBase.class);
                Bundle b= new Bundle();
                b.putParcelable("Drinks",mparcable);
                b.putString("UserName",UserName);
                b.putString("Password",Password);
                parcableIntent.putExtras(b);
                startActivity(parcableIntent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mBackPressed= new Intent(DrinksViewer.this,MainActivity.class);
        Bundle b = new Bundle();
        b.putString("UserName",UserName);
        b.putString("Password",Password);
        mBackPressed.putExtras(b);
        startActivity(mBackPressed);
    }
}
