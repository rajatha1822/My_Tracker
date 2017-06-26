package com.example.rajatha.my_tracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by Rajatha on 03-May-2017.
 */

public class JunkReaderAsync extends AsyncTask<Context,Void,ArrayList<Junks>> {
    ArrayList<Junks>mlist=new ArrayList<>();
    @Override
    protected ArrayList<Junks> doInBackground(Context... params) {
        FoodDataBase mhelper = new FoodDataBase(params[0]);
        String selectQuery = "SELECT  * FROM " + FoodContract.JunkTable.TABLE_NAME;
        SQLiteDatabase dbase = mhelper.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Junks mJunks = new Junks();

                mJunks.setmID(cursor.getInt(0));
                mJunks.setmItem(cursor.getString(1));
                mJunks.setmCalories(cursor.getString(2));
                mJunks.setmQuantity(cursor.getString(3));
                mJunks.setmTCalories(cursor.getString(4));

                mlist.add(mJunks);
            } while (cursor.moveToNext());

        }

        return mlist;
    }

    @Override
    protected void onPostExecute(ArrayList<Junks> junkses) {
        super.onPostExecute(junkses);
    }
}
