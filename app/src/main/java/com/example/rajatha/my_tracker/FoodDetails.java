package com.example.rajatha.my_tracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Rajatha on 03-May-2017.
 */

public final class FoodDetails {

    private FoodDetails(){}

    public static class BreakFastDetails{


        public static ArrayList<BreakFast> addBreakFast(){
            ArrayList<BreakFast> mBreakFast=new ArrayList<>();
            BreakFast b1=new BreakFast("Idly","39","1","39");
            mBreakFast.add(b1);
            BreakFast b2=new BreakFast("Sambar","154","1","154");
            mBreakFast.add(b2);
            BreakFast b3=new BreakFast("Coconut Chutney","60","1","60");
            mBreakFast.add(b3);
            BreakFast b4=new BreakFast("Butter","300","1","300");
            mBreakFast.add(b4);
            BreakFast b5=new BreakFast("Ketchup","268","1","268");
            mBreakFast.add(b5);
            BreakFast b6=new BreakFast("Vada","170","1","170");
            mBreakFast.add(b6);
            BreakFast b7=new BreakFast("Masala Dosa","387","1","387");
            mBreakFast.add(b7);
            BreakFast b8=new BreakFast("Onion Dosa","300","1","300");
            mBreakFast.add(b8);
            BreakFast b9=new BreakFast("Plain Dosa","197","1","197");
            mBreakFast.add(b9);
            BreakFast b10=new BreakFast("Butter Dosa","700","1","700");
            mBreakFast.add(b10);
            BreakFast b11=new BreakFast("Poha","150","1","150");
            mBreakFast.add(b11);
            BreakFast b12=new BreakFast("Shavigeh","190","1","190");
            mBreakFast.add(b12);
            BreakFast b13=new BreakFast("Akki Roti","125","1","125");
            mBreakFast.add(b13);
            BreakFast b14=new BreakFast("Rave Idly","70","1","70");
            mBreakFast.add(b14);
            BreakFast b15=new BreakFast("Upma","80","1","80");
            mBreakFast.add(b15);
            BreakFast b16=new BreakFast("Rave Dose","83","1","83");
            mBreakFast.add(b16);
            BreakFast b17=new BreakFast("Ragi Dose","87","1","87");
            mBreakFast.add(b17);
            BreakFast b18=new BreakFast("Godhi Dose","149","1","149");
            mBreakFast.add(b18);
            BreakFast b19=new BreakFast("Ragi Idly" ,"55","1","55");
            mBreakFast.add(b19);
            return mBreakFast;
        }
    }

    public static class LunchDetails{
        private LunchDetails(){};
        public static ArrayList<Lunch> addLunchDetails(){
            ArrayList<Lunch> mLunch=new ArrayList<>();
            Lunch b1=new Lunch("Idly","39","1","39");
            mLunch.add(b1);
            return mLunch;
        }

    }
    public static class DinnerDetails {
        private DinnerDetails() {}
        public static ArrayList<Dinner> addDinnerDetails() {
            ArrayList<Dinner> mDinner = new ArrayList<>();
            Dinner b1 = new Dinner("Idly", "39", "1", "39");
            mDinner.add(b1);
            return mDinner;
        }
    }
        public static class SnacksDetails{
            private SnacksDetails(){}
            public static ArrayList<Snacks> addSnacksDetails(){
                ArrayList<Snacks> mSnacks=new ArrayList<>();
                Snacks b1=new Snacks("Idly","39","1","39");
                mSnacks.add(b1);
                return mSnacks;
            }

        }

    public static class JunksDetails{
        private JunksDetails(){}
        public static ArrayList<Junks> addJunksDetails(){
            ArrayList<Junks> mJunks=new ArrayList<>();
            Junks b1=new Junks("Idly","39","1","39");
            mJunks.add(b1);
            return mJunks;
        }

    }

    public static class DrinksDetails{
        private DrinksDetails(){}
        public static ArrayList<Drinks> addDrinksDetails(){
            ArrayList<Drinks> mDrinks=new ArrayList<>();
            Drinks b1=new Drinks("Idly","39","1","39");
            mDrinks.add(b1);
            return mDrinks;
        }

    }

}
