package com.example.rajatha.my_tracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by Rajatha on 03-May-2017.
 */

public class BreakFastReaderAsync extends AsyncTask<Context,Void,ArrayList<BreakFast>> {

    ArrayList<BreakFast>mlist=new ArrayList<>();

    @Override
    protected ArrayList<BreakFast> doInBackground(Context... params) {
        FoodDataBase mhelper = new FoodDataBase(params[0]);
        String selectQuery = "SELECT  * FROM " + FoodContract.BreakFastTable.TABLE_NAME;
        SQLiteDatabase dbase = mhelper.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                BreakFast mBreakFast = new BreakFast();
                mBreakFast.setmID(cursor.getInt(0));
                mBreakFast.setmItem(cursor.getString(1));
                mBreakFast.setmCalories(cursor.getString(2));
                mBreakFast.setmQuantity(cursor.getString(3));
                mBreakFast.setmTCalories(cursor.getString(4));
                mlist.add(mBreakFast);
            } while (cursor.moveToNext());

        }

        return mlist;
    }

    @Override
    protected void onPostExecute(ArrayList<BreakFast> breakFasts) {
        super.onPostExecute(breakFasts);
    }
}
