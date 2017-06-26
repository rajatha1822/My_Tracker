package com.example.rajatha.my_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Rajatha on 04-May-2017.
 */

public class UserDataBase extends SQLiteOpenHelper {



    public static final int DATABASE_VERSION=1;
    private static final String TAG="UserDataBase Database";
    Date date = new Date();
    private String TODAY = DateFormat.getDateInstance().format(date);
    private String TODAY_FORMAT=TODAY.replaceAll(" ","_");
    Double Value;
    private static final String SQL_CREATE_PERSONAL="CREATE TABLE IF NOT EXISTS " + UserContract.PersonalTable.TABLE_NAME + " (" +
            UserContract.PersonalTable._ID + " INTEGER PRIMARY KEY," +
            UserContract.PersonalTable.COLUMN_NAME + " TEXT," +
            UserContract.PersonalTable.COLUMN_GENDER + " TEXT," +
            UserContract.PersonalTable.COLUMN_AGE + " TEXT," +
            UserContract.PersonalTable.COLUMN_WEIGHT + " TEXT," +
            UserContract.PersonalTable.COLUMN_HEIGHT + " TEXT," +
            UserContract.PersonalTable.COLUMN_CBMI + " TEXT," +
            UserContract.PersonalTable.COLUMN_TBMI + " TEXT," +
            UserContract.PersonalTable.COLUMN_PASSWORD + " TEXT);";
    private static final String SQL_CREATE_HISTORY="CREATE TABLE IF NOT EXISTS " + UserContract.HistoryTable.TABLE_NAME + " (" +
            UserContract.HistoryTable._ID + " INTEGER PRIMARY KEY," +
            UserContract.HistoryTable.COLUMN_DATE + " TEXT," +
            UserContract.HistoryTable.COLUMN_TBF + " DOUBLE," +
            UserContract.HistoryTable.COLUMN_TL + " DOUBLE," +
            UserContract.HistoryTable.COLUMN_TDinner + " DOUBLE," +
            UserContract.HistoryTable.COLUMN_TS + " DOUBLE," +
            UserContract.HistoryTable.COLUMN_TJ + " DOUBLE," +
            UserContract.HistoryTable.COLUMN_TDrinks+ " DOUBLE," +
            UserContract.HistoryTable.COLUMN_TCalories + " DOUBLE);";
    private static final String SQL_DELETE_PERSONAL="DROP TABLE IF EXISTS " + UserContract.PersonalTable.TABLE_NAME;
    private static final String SQL_DELETE_HISTORY="DROP TABLE IF EXISTS " + UserContract.HistoryTable.TABLE_NAME;

    public UserDataBase(Context context,String Database){

        super(context,Database,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PERSONAL);
        db.execSQL(SQL_CREATE_HISTORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PERSONAL);
        db.execSQL(SQL_DELETE_HISTORY);
        onCreate(db);

    }

    public void AddPersonalDetails(UserDataBase mDHelper,String Name,String Gender,String Age, String Weight, String Height,String CBMI,String TBMI,String Password){
        SQLiteDatabase db=mDHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(UserContract.PersonalTable.COLUMN_NAME,Name);
        values.put(UserContract.PersonalTable.COLUMN_GENDER,Gender);
        values.put(UserContract.PersonalTable.COLUMN_AGE,Age);
        values.put(UserContract.PersonalTable.COLUMN_WEIGHT,Weight);
        values.put(UserContract.PersonalTable.COLUMN_HEIGHT,Height);
        values.put(UserContract.PersonalTable.COLUMN_CBMI,CBMI);
        values.put(UserContract.PersonalTable.COLUMN_TBMI,TBMI);
        values.put(UserContract.PersonalTable.COLUMN_PASSWORD,Password);
        long newRowId=db.insert(UserContract.PersonalTable.TABLE_NAME,null,values);
    }

    public Cursor getInformation(UserDataBase dop) {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {UserContract.PersonalTable.COLUMN_NAME, UserContract.PersonalTable.COLUMN_PASSWORD};
        Cursor CR = SQ.query(UserContract.PersonalTable.TABLE_NAME, coloumns, null, null, null, null, null);
        return CR;
    }

    public Cursor getUserProfile(UserDataBase dop) {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {UserContract.PersonalTable.COLUMN_NAME, UserContract.PersonalTable.COLUMN_GENDER,UserContract.PersonalTable.COLUMN_AGE,UserContract.PersonalTable.COLUMN_WEIGHT,UserContract.PersonalTable.COLUMN_HEIGHT,UserContract.PersonalTable.COLUMN_CBMI,UserContract.PersonalTable.COLUMN_TBMI};
        Cursor CR = SQ.query(UserContract.PersonalTable.TABLE_NAME, coloumns, null, null, null, null, null);
        return CR;
    }

    public boolean CheckDateExists(UserDataBase dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String CheckDate ="SELECT * FROM " + UserContract.HistoryTable.TABLE_NAME + " WHERE " + UserContract.HistoryTable.COLUMN_DATE + " =?";
        String[] Date={TODAY_FORMAT};
        Cursor cursor= SQ.rawQuery(CheckDate,Date);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
            /*Record Doesn't Exists*/
        }
        cursor.close();
        return true;
    }
     public void AddDate(UserDataBase dop){
         SQLiteDatabase db=dop.getWritableDatabase();
         ContentValues values=new ContentValues();
         values.put(UserContract.HistoryTable.COLUMN_DATE,TODAY_FORMAT);
         long newRowId=db.insert(UserContract.HistoryTable.TABLE_NAME,null,values);


     }

     public void AddBreakFast(UserDataBase dop,Double Total){
         SQLiteDatabase db=dop.getWritableDatabase();
         String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
         String[] Date={TODAY_FORMAT};
         ContentValues values=new ContentValues();
         values.put(UserContract.HistoryTable.COLUMN_TBF,Total);
         long newRowId=db.update(UserContract.HistoryTable.TABLE_NAME,values,selection,Date);

     }
    public void AddLunch(UserDataBase dop,Double Total){
        SQLiteDatabase db=dop.getWritableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] Date={TODAY_FORMAT};
        ContentValues values=new ContentValues();
        values.put(UserContract.HistoryTable.COLUMN_TL,Total);
        long newRowId=db.update(UserContract.HistoryTable.TABLE_NAME,values,selection,Date);

    }

    public void AddDinner(UserDataBase dop,Double Total){
        SQLiteDatabase db=dop.getWritableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] Date={TODAY_FORMAT};
        ContentValues values=new ContentValues();
        values.put(UserContract.HistoryTable.COLUMN_TDinner,Total);
        long newRowId=db.update(UserContract.HistoryTable.TABLE_NAME,values,selection,Date);

    }

    public void AddSnacks(UserDataBase dop,Double Total){
        SQLiteDatabase db=dop.getWritableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] Date={TODAY_FORMAT};
        ContentValues values=new ContentValues();
        values.put(UserContract.HistoryTable.COLUMN_TS,Total);
        long newRowId=db.update(UserContract.HistoryTable.TABLE_NAME,values,selection,Date);

    }

    public void AddJunks(UserDataBase dop,Double Total){
        SQLiteDatabase db=dop.getWritableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] Date={TODAY_FORMAT};
        ContentValues values=new ContentValues();
        values.put(UserContract.HistoryTable.COLUMN_TJ,Total);
        long newRowId=db.update(UserContract.HistoryTable.TABLE_NAME,values,selection,Date);

    }

    public void AddDrinks(UserDataBase dop,Double Total){
        SQLiteDatabase db=dop.getWritableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] Date={TODAY_FORMAT};
        ContentValues values=new ContentValues();
        values.put(UserContract.HistoryTable.COLUMN_TDrinks,Total);
        long newRowId=db.update(UserContract.HistoryTable.TABLE_NAME,values,selection,Date);

    }


     public Double RetrieveBreakFast(UserDataBase dop){
         SQLiteDatabase SQ = dop.getReadableDatabase();
         String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
         String[] col={UserContract.HistoryTable.COLUMN_TBF};
         String[] Date={TODAY_FORMAT};
         Cursor cr=SQ.query(UserContract.HistoryTable.TABLE_NAME,col,selection,Date,null,null,null);

         if(cr.getCount()>0){
             cr.moveToFirst();
             Value =cr.getDouble(0);
         }

         return Value;

     }
    public Double RetrieveLunch(UserDataBase dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] col={UserContract.HistoryTable.COLUMN_TL};
        String[] Date={TODAY_FORMAT};
        Cursor cr=SQ.query(UserContract.HistoryTable.TABLE_NAME,col,selection,Date,null,null,null);

        if(cr.getCount()>0){
            cr.moveToFirst();
            Value =cr.getDouble(0);
        }

        return Value;

    }

    public Double RetrieveDinner(UserDataBase dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] col={UserContract.HistoryTable.COLUMN_TDinner};
        String[] Date={TODAY_FORMAT};
        Cursor cr=SQ.query(UserContract.HistoryTable.TABLE_NAME,col,selection,Date,null,null,null);

        if(cr.getCount()>0){
            cr.moveToFirst();
            Value =cr.getDouble(0);
        }

        return Value;

    }
    public Double RetrieveSnacks(UserDataBase dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] col={UserContract.HistoryTable.COLUMN_TS};
        String[] Date={TODAY_FORMAT};
        Cursor cr=SQ.query(UserContract.HistoryTable.TABLE_NAME,col,selection,Date,null,null,null);

        if(cr.getCount()>0){
            cr.moveToFirst();
            Value =cr.getDouble(0);
        }

        return Value;

    }

    public Double RetrieveJunks(UserDataBase dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] col={UserContract.HistoryTable.COLUMN_TJ};
        String[] Date={TODAY_FORMAT};
        Cursor cr=SQ.query(UserContract.HistoryTable.TABLE_NAME,col,selection,Date,null,null,null);

        if(cr.getCount()>0){
            cr.moveToFirst();
            Value =cr.getDouble(0);
        }

        return Value;

    }
    public Double RetrieveDrinks(UserDataBase dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String selection = UserContract.HistoryTable.COLUMN_DATE +" LIKE ?";
        String[] col={UserContract.HistoryTable.COLUMN_TDrinks};
        String[] Date={TODAY_FORMAT};
        Cursor cr=SQ.query(UserContract.HistoryTable.TABLE_NAME,col,selection,Date,null,null,null);

        if(cr.getCount()>0){
            cr.moveToFirst();
            Value =cr.getDouble(0);
        }

        return Value;

    }

}
