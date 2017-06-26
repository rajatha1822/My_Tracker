package com.example.rajatha.my_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Rajatha on 02-May-2017.
 */

public class FoodDataBase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="FoodDataBase";
    private static final String TAG="FoodDataBase Database";
    private SQLiteDatabase dbase;
    private ArrayList<BreakFast>mBreakFast=new ArrayList<>();
    private ArrayList<Lunch>mLunch=new ArrayList<>();
    private ArrayList<Dinner>mDinner=new ArrayList<>();
    private ArrayList<Snacks>mSnacks=new ArrayList<>();
    private ArrayList<Junks>mJunks=new ArrayList<>();
    private ArrayList<Drinks>mDrinks=new ArrayList<>();
    private static final String SQL_CREATE_BREAKFAST="CREATE TABLE IF NOT EXISTS " + FoodContract.BreakFastTable.TABLE_NAME + " (" +
            FoodContract.BreakFastTable._ID + " INTEGER PRIMARY KEY," +
            FoodContract.BreakFastTable.COLUMN_ITEM + " TEXT," +
            FoodContract.BreakFastTable.COLUMN_CALORIES + " TEXT," +
            FoodContract.BreakFastTable.COLUMN_QUANTITY + " TEXT," +
            FoodContract.BreakFastTable.COLUMN_TCALORIES + " TEXT);";

    private static final String SQL_CREATE_LUNCH="CREATE TABLE IF NOT EXISTS " + FoodContract.LunchTable.TABLE_NAME + " (" +
            FoodContract.LunchTable._ID + " INTEGER PRIMARY KEY," +
            FoodContract.LunchTable.COLUMN_ITEM + " TEXT," +
            FoodContract.LunchTable.COLUMN_CALORIES + " TEXT," +
            FoodContract.LunchTable.COLUMN_QUANTITY + " TEXT," +
            FoodContract.LunchTable.COLUMN_TCALORIES + " TEXT);";

    private static final String SQL_CREATE_SNACKS="CREATE TABLE IF NOT EXISTS " + FoodContract.SnacksTable.TABLE_NAME + " (" +
            FoodContract.SnacksTable._ID + " INTEGER PRIMARY KEY," +
            FoodContract.SnacksTable.COLUMN_ITEM + " TEXT," +
            FoodContract.SnacksTable.COLUMN_CALORIES + " TEXT," +
            FoodContract.SnacksTable.COLUMN_QUANTITY + " TEXT," +
            FoodContract.SnacksTable.COLUMN_TCALORIES + " TEXT);";

    private static final String SQL_CREATE_DINNER="CREATE TABLE IF NOT EXISTS " + FoodContract.Dinner.TABLE_NAME + " (" +
            FoodContract.Dinner._ID + " INTEGER PRIMARY KEY," +
            FoodContract.Dinner.COLUMN_ITEM + " TEXT," +
            FoodContract.Dinner.COLUMN_CALORIES + " TEXT," +
            FoodContract.Dinner.COLUMN_QUANTITY + " TEXT," +
            FoodContract.Dinner.COLUMN_TCALORIES + " TEXT);";

    private static final String SQL_CREATE_JUNK="CREATE TABLE IF NOT EXISTS " + FoodContract.JunkTable.TABLE_NAME + " (" +
            FoodContract.JunkTable._ID + " INTEGER PRIMARY KEY," +
            FoodContract.JunkTable.COLUMN_ITEM + " TEXT," +
            FoodContract.JunkTable.COLUMN_CALORIES + " TEXT," +
            FoodContract.JunkTable.COLUMN_QUANTITY + " TEXT," +
            FoodContract.JunkTable.COLUMN_TCALORIES + " TEXT);";

    private static final String SQL_CREATE_DRINKS="CREATE TABLE IF NOT EXISTS " + FoodContract.DrinksTable.TABLE_NAME + " (" +
            FoodContract.DrinksTable._ID + " INTEGER PRIMARY KEY," +
            FoodContract.DrinksTable.COLUMN_ITEM + " TEXT," +
            FoodContract.DrinksTable.COLUMN_CALORIES + " TEXT," +
            FoodContract.DrinksTable.COLUMN_QUANTITY + " TEXT," +
            FoodContract.DrinksTable.COLUMN_TCALORIES + " TEXT);";

    private static final String SQL_DELETE_BREAKFAST="DROP TABLE IF EXISTS " + FoodContract.BreakFastTable.TABLE_NAME;
    private static final String SQL_DELETE_LUNCH="DROP TABLE IF EXISTS " + FoodContract.LunchTable.TABLE_NAME;
    private static final String SQL_DELETE_DINNER="DROP TABLE IF EXISTS " + FoodContract.Dinner.TABLE_NAME;
    private static final String SQL_DELETE_SNACKS="DROP TABLE IF EXISTS " + FoodContract.SnacksTable.TABLE_NAME;
    private static final String SQL_DELETE_JUNKS="DROP TABLE IF EXISTS " + FoodContract.JunkTable.TABLE_NAME;
    private static final String SQL_DELETE_DRINKS="DROP TABLE IF EXISTS " + FoodContract.DrinksTable.TABLE_NAME;


    public FoodDataBase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_BREAKFAST);
        db.execSQL(SQL_CREATE_LUNCH);
        db.execSQL(SQL_CREATE_DINNER);
        db.execSQL(SQL_CREATE_DRINKS);
        db.execSQL(SQL_CREATE_SNACKS);
        db.execSQL(SQL_CREATE_JUNK);
        mBreakFast=FoodDetails.BreakFastDetails.addBreakFast();
        this.addBreakFast(mBreakFast,db);
        mLunch=FoodDetails.LunchDetails.addLunchDetails();
        this.addLunch(mLunch,db);
        mDinner=FoodDetails.DinnerDetails.addDinnerDetails();
        this.addDinner(mDinner,db);
        mDrinks=FoodDetails.DrinksDetails.addDrinksDetails();
        this.addDrinks(mDrinks,db);
        mSnacks=FoodDetails.SnacksDetails.addSnacksDetails();
        this.addSnacks(mSnacks,db);
        mJunks=FoodDetails.JunksDetails.addJunksDetails();
        this.addJunks(mJunks,db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_BREAKFAST);
        db.execSQL(SQL_DELETE_LUNCH);
        db.execSQL(SQL_DELETE_DINNER);
        db.execSQL(SQL_DELETE_DRINKS);
        db.execSQL(SQL_DELETE_JUNKS);
        db.execSQL(SQL_DELETE_SNACKS);
        onCreate(db);
    }

    private void addBreakFast(ArrayList<BreakFast> mBF,SQLiteDatabase db){
        for(BreakFast mbreakFast: mBF){
            addBreakFast(mbreakFast,db);
        }
    }
    private void addLunch(ArrayList<Lunch> mL,SQLiteDatabase db){
        for(Lunch mLunch: mL){
            addLunch(mLunch,db);
        }
    }
    private void addDinner(ArrayList<Dinner> mD,SQLiteDatabase db){
        for(Dinner mDinner: mD){
            addDinner(mDinner,db);
        }
    }
    private void addSnacks(ArrayList<Snacks> mS,SQLiteDatabase db){
        for(Snacks mSnacks: mS){
            addSnacks(mSnacks,db);
        }
    }
    private void addJunks(ArrayList<Junks> mJ,SQLiteDatabase db){
        for(Junks mJunks: mJ){
            addJunks(mJunks,db);
        }
    }
    private void addDrinks(ArrayList<Drinks> mD,SQLiteDatabase db){
        for(Drinks mDrinks: mD){
            addDrinks(mDrinks,db);
        }
    }

    public void addBreakFast(BreakFast food,SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(FoodContract.BreakFastTable.COLUMN_ITEM,food.getmItem());
        values.put(FoodContract.BreakFastTable.COLUMN_CALORIES,food.getmCalories());
        values.put(FoodContract.BreakFastTable.COLUMN_QUANTITY,food.getmQuantity());
        values.put(FoodContract.BreakFastTable.COLUMN_TCALORIES,food.getmTCalories());
        db.insert(FoodContract.BreakFastTable.TABLE_NAME, null, values);

    }
    public void addLunch(Lunch food,SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(FoodContract.LunchTable.COLUMN_ITEM,food.getmItem());
        values.put(FoodContract.LunchTable.COLUMN_CALORIES,food.getmCalories());
        values.put(FoodContract.LunchTable.COLUMN_QUANTITY,food.getmQuantity());
        values.put(FoodContract.LunchTable.COLUMN_TCALORIES,food.getmTCalories());
        db.insert(FoodContract.LunchTable.TABLE_NAME, null, values);

    }

    public void addDinner(Dinner food,SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(FoodContract.Dinner.COLUMN_ITEM,food.getmItem());
        values.put(FoodContract.Dinner.COLUMN_CALORIES,food.getmCalories());
        values.put(FoodContract.Dinner.COLUMN_QUANTITY,food.getmQuantity());
        values.put(FoodContract.Dinner.COLUMN_TCALORIES,food.getmTCalories());
        db.insert(FoodContract.Dinner.TABLE_NAME, null, values);

    }

    public void addSnacks(Snacks food,SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(FoodContract.SnacksTable.COLUMN_ITEM,food.getmItem());
        values.put(FoodContract.SnacksTable.COLUMN_CALORIES,food.getmCalories());
        values.put(FoodContract.SnacksTable.COLUMN_QUANTITY,food.getmQuantity());
        values.put(FoodContract.SnacksTable.COLUMN_TCALORIES,food.getmTCalories());
        db.insert(FoodContract.SnacksTable.TABLE_NAME, null, values);

    }
    public void addJunks(Junks food,SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(FoodContract.JunkTable.COLUMN_ITEM,food.getmItem());
        values.put(FoodContract.JunkTable.COLUMN_CALORIES,food.getmCalories());
        values.put(FoodContract.JunkTable.COLUMN_QUANTITY,food.getmQuantity());
        values.put(FoodContract.JunkTable.COLUMN_TCALORIES,food.getmTCalories());
        db.insert(FoodContract.JunkTable.TABLE_NAME, null, values);

    }
    public void addDrinks(Drinks food,SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(FoodContract.DrinksTable.COLUMN_ITEM,food.getmItem());
        values.put(FoodContract.DrinksTable.COLUMN_CALORIES,food.getmCalories());
        values.put(FoodContract.DrinksTable.COLUMN_QUANTITY,food.getmQuantity());
        values.put(FoodContract.DrinksTable.COLUMN_TCALORIES,food.getmTCalories());
        db.insert(FoodContract.DrinksTable.TABLE_NAME, null, values);

    }



}
