package com.example.rajatha.my_tracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by Rajatha on 03-May-2017.
 */

public class LunchReaderAsync extends AsyncTask<Context,Void,ArrayList<Lunch>> {
    ArrayList<Lunch> mList = new ArrayList<>();

    @Override
    protected ArrayList<Lunch> doInBackground(Context... params) {
        FoodDataBase mhelper = new FoodDataBase(params[0]);
        String selectQuery = "SELECT  * FROM " + FoodContract.LunchTable.TABLE_NAME;
        SQLiteDatabase dbase = mhelper.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Lunch mLunch = new Lunch();

                mLunch.setmID(cursor.getInt(0));
                mLunch.setmItem(cursor.getString(1));
                mLunch.setmCalories(cursor.getString(2));
                mLunch.setmQuantity(cursor.getString(3));
                mLunch.setmTCalories(cursor.getString(4));
                mList.add(mLunch);
            } while (cursor.moveToNext());

        }

        return mList;
    }

    @Override
    protected void onPostExecute(ArrayList<Lunch> lunches) {
        super.onPostExecute(lunches);
    }
}
