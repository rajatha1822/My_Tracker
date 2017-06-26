package com.example.rajatha.my_tracker;

/**
 * Created by Rajatha on 02-May-2017.
 */


import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Tracker extends Fragment implements View.OnClickListener {


    private String UserName, Password;
    Date date = new Date();
    String today = DateFormat.getDateInstance().format(date);
    Double mBreakFast=new Double(0);
    Double mLunch=new Double(0);
    Double mDinner= new Double(0);
    Double mSnacks=new Double(0);
    Double mJunks=new Double(0);
    Double mDrinks=new Double(0);
    Double TotalCalories=new Double(0);

    public static Tracker newInstance(String Name, String Password){

        Tracker mTracker= new Tracker();
        Bundle args = new Bundle();
        if(args!=null){

            args.putString("UserName",Name);
            args.putString("Password",Password);
            mTracker.setArguments(args);
        }
        return mTracker;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments()!=null){

            UserName = getArguments().getString("UserName");
            Password = getArguments().getString("Password");
        }

        TotalCalories();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tracker, container, false);

        ImageButton Breakfast=(ImageButton)rootView.findViewById(R.id.breakfast);
        ImageButton Lunch=(ImageButton)rootView.findViewById(R.id.Lunch);
        ImageButton Snacks=(ImageButton)rootView.findViewById(R.id.Snacks);
        ImageButton Dinner=(ImageButton)rootView.findViewById(R.id.Dinner);
        ImageButton Junk=(ImageButton)rootView.findViewById(R.id.Junk);
        ImageButton Drinks=(ImageButton)rootView.findViewById(R.id.Coffee);
        TextView date=(TextView)rootView.findViewById(R.id.Date);
        date.setText(today);
        TextView Name=(TextView)rootView.findViewById(R.id.T_Name);
        TextView Calories=(TextView)rootView.findViewById(R.id.T1_Calories);
        Calories.setText(TotalCalories.toString());
        Name.setText("Welcome "+UserName);
        Breakfast.setOnClickListener(this);
        Lunch.setOnClickListener(this);
        Dinner.setOnClickListener(this);
        Drinks.setOnClickListener(this);
        Junk.setOnClickListener(this);
        Snacks.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.breakfast:
                Intent mBreakFast= new Intent(getActivity(),BreakFastViewer.class);
                Bundle b = new Bundle();
                b.putString("UserName",UserName);
                b.putString("Password",Password);
                mBreakFast.putExtras(b);
                startActivity(mBreakFast);
                break;
            case R.id.Lunch:
                Intent mLunch= new Intent(getActivity(),LunchViewer.class);
                Bundle L = new Bundle();
                L.putString("UserName",UserName);
                L.putString("Password",Password);
                mLunch.putExtras(L);
                startActivity(mLunch);
                break;
            case R.id.Snacks:
                Intent mSnacks= new Intent(getActivity(),SnacksViewer.class);
                Bundle S = new Bundle();
                S.putString("UserName",UserName);
                S.putString("Password",Password);
                mSnacks.putExtras(S);
                startActivity(mSnacks);
                break;
            case R.id.Dinner:
                Intent mDinner= new Intent(getActivity(),DinnerViewer.class);
                Bundle D = new Bundle();
                D.putString("UserName",UserName);
                D.putString("Password",Password);
                mDinner.putExtras(D);
                startActivity(mDinner);
                break;
            case R.id.Junk:
                Intent mJunk= new Intent(getActivity(),JunksViewer.class);
                Bundle J = new Bundle();
                J.putString("UserName",UserName);
                J.putString("Password",Password);
                mJunk.putExtras(J);
                startActivity(mJunk);
                break;
            case R.id.Coffee:
                Intent mDrinks= new Intent(getActivity(),DrinksViewer.class);
                Bundle Drinks = new Bundle();
                Drinks.putString("UserName",UserName);
                Drinks.putString("Password",Password);
                mDrinks.putExtras(Drinks);
                startActivity(mDrinks);
                break;


        }
    }

    public void TotalCalories(){

        UserDataBase DP= new UserDataBase(getActivity(),UserName);
        Boolean DateExists=DP.CheckDateExists(DP);
        if(!DateExists){
            DP.AddDate(DP);
        }

        mBreakFast=DP.RetrieveBreakFast(DP);
        mLunch=DP.RetrieveLunch(DP);
        mDinner=DP.RetrieveDinner(DP);
        mSnacks=DP.RetrieveSnacks(DP);
        mJunks=DP.RetrieveJunks(DP);
        mDrinks=DP.RetrieveDrinks(DP);

        if(mBreakFast==null){
            mBreakFast=0.0;
        }else if(mLunch==null){
            mLunch=0.0;
        }else if(mDinner==null){
            mDinner=0.0;
        }else if(mSnacks==null){
            mSnacks=0.0;
        }else if(mJunks==null){
            mJunks=0.0;

        }else if(mDrinks==null) {
            mDrinks=0.0;
        }



        TotalCalories=mBreakFast+mLunch+mDinner+mSnacks+mJunks+mDrinks;



    }


}
