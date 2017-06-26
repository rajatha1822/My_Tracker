package com.example.rajatha.my_tracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by Rajatha on 03-May-2017.
 */

public class DinnerReaderAsync extends AsyncTask<Context,Void,ArrayList<Dinner>> {

    ArrayList<Dinner>mlist=new ArrayList<>();

    @Override
    protected ArrayList<Dinner> doInBackground(Context... params) {
        FoodDataBase mhelper=new FoodDataBase(params[0]);
        String selectQuery="SELECT  * FROM " + FoodContract.DrinksTable.TABLE_NAME;
        SQLiteDatabase dbase = mhelper.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Dinner mDinner = new Dinner();

                mDinner.setmID(cursor.getInt(0));
                mDinner.setmItem(cursor.getString(1));
                mDinner.setmCalories(cursor.getString(2));
                mDinner.setmQuantity(cursor.getString(3));
                mDinner.setmTCalories(cursor.getString(4));
                mlist.add(mDinner);
            }while (cursor.moveToNext());

        }

        return mlist;
    }

    @Override
    protected void onPostExecute(ArrayList<Dinner> dinners) {
        super.onPostExecute(dinners);
    }
}
