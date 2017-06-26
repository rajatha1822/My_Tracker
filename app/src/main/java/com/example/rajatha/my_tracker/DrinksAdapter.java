package com.example.rajatha.my_tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rajatha on 03-May-2017.
 */

public class DrinksAdapter extends BaseAdapter {
    ArrayList<Drinks> mDrinks;
    Context mContext;

    public DrinksAdapter(Context context,ArrayList<Drinks> mDrinks){
        mContext=context;
        this.mDrinks=mDrinks;

    }
    @Override
    public int getCount() {
        return mDrinks.size();
    }

    @Override
    public Object getItem(int position) {
        return mDrinks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Drinks mDisplayBF=(Drinks) getItem(position);
        View mView;
        LayoutInflater layoutInflater=(LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            mView=layoutInflater.inflate(R.layout.bfview,null);

        }else {

            mView=convertView;
        }
        TextView mDisplay=(TextView )mView.findViewById(R.id.BF_Display);
        mDisplay.setText(mDisplayBF.getmItem());


        return mView;
    }
}
