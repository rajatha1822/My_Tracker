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

public class DinnerViewer extends AppCompatActivity {
    private ArrayList<Dinner> mDinner;
    private DinnerAdapter madapter;
    private String UserName,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner_viewer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            UserName = bundle.getString("UserName");
            Password = bundle.getString("Password");

        }
        mDinner=new ArrayList<>();
        ListView listView=(ListView)findViewById(R.id.D_ListView);
        if(savedInstanceState==null){

            DinnerReaderAsync mReader=new DinnerReaderAsync();
            try {
                mDinner=mReader.execute(getBaseContext()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        madapter= new DinnerAdapter(this,mDinner);
        listView.setAdapter(madapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dinner mparcable=(Dinner) madapter.getItem(position);
                Intent parcableIntent= new Intent(DinnerViewer.this,FeedingDataBase.class);
                Bundle b= new Bundle();
                b.putParcelable("Dinner",mparcable);
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
        Intent mBackPressed= new Intent(DinnerViewer.this,MainActivity.class);
        Bundle b = new Bundle();
        b.putString("UserName",UserName);
        b.putString("Password",Password);
        mBackPressed.putExtras(b);
        startActivity(mBackPressed);
    }
}
