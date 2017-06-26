package com.example.rajatha.my_tracker;

/**
 * Created by Rajatha on 02-May-2017.
 */

import android.database.Cursor;
import android.icu.text.DecimalFormat;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends Fragment  {

private String User, Password,mGender,mAge,mWeight,mHeight,mBMI,mTBMI;

    public static Profile newInstance(String Name, String Password){

        Profile mProfile= new Profile();
        Bundle args = new Bundle();
        if(args!=null){

            args.putString("UserName",Name);
            args.putString("Password",Password);
            mProfile.setArguments(args);
        }
        return mProfile;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null) {
            User = getArguments().getString("UserName");
            Password = getArguments().getString("Password");
            UserDataBase DP=new UserDataBase(getActivity(),User);
            Cursor CR= DP.getUserProfile(DP);
            if(CR.getCount()>0) {
                CR.moveToFirst();
                mGender = CR.getString(1);
                mAge = CR.getString(2);
                mWeight = CR.getString(3);
                mHeight = CR.getString(4);
                mBMI = CR.getString(5);
                mTBMI = CR.getString(6);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile, container, false);

        TextView Name=(TextView)rootView.findViewById(R.id.pName);
        TextView Gender=(TextView)rootView.findViewById(R.id.pGender);
        TextView Age=(TextView)rootView.findViewById(R.id.pAge);
        TextView Height=(TextView)rootView.findViewById(R.id.pHeight);
        TextView Weight=(TextView)rootView.findViewById(R.id.pWeight);
        TextView BMI=(TextView)rootView.findViewById(R.id.pCBMI);
        TextView Target=(TextView)rootView.findViewById(R.id.pTBMI);
        Name.setText(User);
        Gender.setText(mGender);
        Age.setText(mAge);
        Weight.setText(mWeight);
        Height.setText(mHeight);
        BMI.setText(mBMI);
        Target.setText(mTBMI);
        return rootView;
    }
}

