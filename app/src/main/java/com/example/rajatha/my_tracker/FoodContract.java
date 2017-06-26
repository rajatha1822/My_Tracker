package com.example.rajatha.my_tracker;

import android.provider.BaseColumns;

/**
 * Created by Rajatha on 02-May-2017.
 */

public final class FoodContract {

    private FoodContract() {
    }

    public static class BreakFastTable implements BaseColumns {


        public static final String TABLE_NAME="BreakFast";
        public static final String COLUMN_ITEM="FoodItem";
        public static final String COLUMN_CALORIES="Calories";
        public static final String COLUMN_QUANTITY="Quantity";
        public static final String COLUMN_TCALORIES="TotalCalories";


    }

    public static class LunchTable implements BaseColumns {

        public static final String TABLE_NAME="Lunch";
        public static final String COLUMN_ITEM="FoodItem";
        public static final String COLUMN_CALORIES="Calories";
        public static final String COLUMN_QUANTITY="Quantity";
        public static final String COLUMN_TCALORIES="TotalCalories";



    }

    public static class SnacksTable implements BaseColumns {
        public static final String TABLE_NAME="Snacks";
        public static final String COLUMN_ITEM="FoodItem";
        public static final String COLUMN_CALORIES="Calories";
        public static final String COLUMN_QUANTITY="Quantity";
        public static final String COLUMN_TCALORIES="TotalCalories";


    }

    public static class DrinksTable implements BaseColumns {
        public static final String TABLE_NAME="Drinks";
        public static final String COLUMN_ITEM="FoodItem";
        public static final String COLUMN_CALORIES="Calories";
        public static final String COLUMN_QUANTITY="Quantity";
        public static final String COLUMN_TCALORIES="TotalCalories";


    }

    public static class JunkTable implements BaseColumns {
        public static final String TABLE_NAME="Junk";
        public static final String COLUMN_ITEM="FoodItem";
        public static final String COLUMN_CALORIES="Calories";
        public static final String COLUMN_QUANTITY="Quantity";
        public static final String COLUMN_TCALORIES="TotalCalories";


    }

    public static class Dinner implements BaseColumns {
        public static final String TABLE_NAME="Dinner";
        public static final String COLUMN_ITEM="FoodItem";
        public static final String COLUMN_CALORIES="Calories";
        public static final String COLUMN_QUANTITY="Quantity";
        public static final String COLUMN_TCALORIES="TotalCalories";

    }
}
