package com.example.rajatha.my_tracker;

/**
 * Created by Rajatha on 02-May-2017.
 */

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class History extends Fragment{
    private String User, Password;
    public static History newInstance(String Name, String Password){

        History mHistory= new History();
        Bundle args = new Bundle();
        if(args!=null){
            args.putString("UserName",Name);
            args.putString("Password",Password);
            mHistory.setArguments(args);
        }
        return mHistory;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){

            User = getArguments().getString("UserName");
            Password = getArguments().getString("Password");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.history, container, false);
        return rootView;
    }
}
