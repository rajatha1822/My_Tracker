package com.example.rajatha.my_tracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by Rajatha on 03-May-2017.
 */

public class SnackReaderAsync extends AsyncTask<Context,Void,ArrayList<Snacks>> {
    ArrayList<Snacks>mlist=new ArrayList<>();
    @Override
    protected ArrayList<Snacks> doInBackground(Context... params) {
        FoodDataBase mhelper = new FoodDataBase(params[0]);
        String selectQuery = "SELECT  * FROM " + FoodContract.SnacksTable.TABLE_NAME;
        SQLiteDatabase dbase = mhelper.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Snacks mSnacks = new Snacks();

                mSnacks.setmID(cursor.getInt(0));
                mSnacks.setmItem(cursor.getString(1));
                mSnacks.setmCalories(cursor.getString(2));
                mSnacks.setmQuantity(cursor.getString(3));
                mSnacks.setmTCalories(cursor.getString(4));
                mlist.add(mSnacks);
            } while (cursor.moveToNext());

        }

        return mlist;

        }

    @Override
    protected void onPostExecute(ArrayList<Snacks> snackses) {
        super.onPostExecute(snackses);
    }
}
