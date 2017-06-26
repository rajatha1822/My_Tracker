package com.example.rajatha.my_tracker;

import android.provider.BaseColumns;

/**
 * Created by Rajatha on 04-May-2017.
 */

public class UserContract {
    private UserContract(){}

    public static class PersonalTable implements BaseColumns{

        public static final String TABLE_NAME="PersonalDetails";
        public static final String COLUMN_NAME="Name";
        public static final String COLUMN_GENDER="Gender";
        public static final String COLUMN_AGE="Age";
        public static final String COLUMN_WEIGHT="Weight";
        public static final String COLUMN_HEIGHT="Height";
        public static final String COLUMN_CBMI="CBMI";
        public static final String COLUMN_TBMI="TBMI";
        public static final String COLUMN_PASSWORD="Password";
    }

    public static class HistoryTable implements BaseColumns{
        public static final String TABLE_NAME="HistoryDetails";
        public static final String COLUMN_DATE="Date";
        public static final String COLUMN_TBF="TBreakFast";
        public static final String COLUMN_TL="TLunch";
        public static final String COLUMN_TS="TSnacks";
        public static final String COLUMN_TJ="TJunks";
        public static final String COLUMN_TDrinks="TDrinks";
        public static final String COLUMN_TDinner="TDinner";
        public static final String COLUMN_TCalories="TCalories";

    }
}
