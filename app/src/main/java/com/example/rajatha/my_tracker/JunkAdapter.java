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

public class JunkAdapter extends BaseAdapter {
    ArrayList<Junks> mJunk;
    Context mContext;

    public JunkAdapter(Context context,ArrayList<Junks> mJunk){
        mContext=context;
        this.mJunk=mJunk;

    }
    @Override
    public int getCount() {
        return mJunk.size();
    }

    @Override
    public Object getItem(int position) {
        return mJunk.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Junks mDisplayBF=(Junks) getItem(position);
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
