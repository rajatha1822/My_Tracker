package com.example.rajatha.my_tracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by Rajatha on 03-May-2017.
 */

public class DrinksReaderAsync extends AsyncTask<Context,Void,ArrayList<Drinks>> {
    ArrayList<Drinks>mlist=new ArrayList<>();
    @Override
    protected ArrayList<Drinks> doInBackground(Context... params) {
        FoodDataBase mhelper = new FoodDataBase(params[0]);
        String selectQuery = "SELECT  * FROM " + FoodContract.DrinksTable.TABLE_NAME;
        SQLiteDatabase dbase = mhelper.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Drinks mDrinks = new Drinks();

                mDrinks.setmID(cursor.getInt(0));
                mDrinks.setmItem(cursor.getString(1));
                mDrinks.setmCalories(cursor.getString(2));
                mDrinks.setmQuantity(cursor.getString(3));
                mDrinks.setmTCalories(cursor.getString(4));
                mlist.add(mDrinks);
            } while (cursor.moveToNext());

        }

        return mlist;

        }

    @Override
    protected void onPostExecute(ArrayList<Drinks> drinkses) {
        super.onPostExecute(drinkses);
    }
}
