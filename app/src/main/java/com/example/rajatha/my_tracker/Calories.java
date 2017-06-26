package com.example.rajatha.my_tracker;

/**
 * Created by Rajatha on 08-May-2017.
 */

public class Calories {

    private Double mBreakFast;
    private Double mLunch;
    private Double mDinner;
    private Double mSnacks;
    private Double mJunks;
    private Double mDrinks;
    private Double TCalories;
    private String mDate;

    public void setmBreakFast(Double mBreakFast){
        this.mBreakFast=mBreakFast;
    }

    public void setmLunch(Double mLunch){
        this.mLunch=mLunch;
    }

    public void setmDinner(Double mDinner){
        this.mDinner=mDinner;
    }

    public void setmSnacks(Double mSnacks) {
        this.mSnacks = mSnacks;
    }

    public void setmJunks(Double mJunks) {
        this.mJunks = mJunks;
    }

    public void setmDrinks(Double mDrinks) {
        this.mDrinks = mDrinks;
    }

    public void setTCalories(Double TCalories) {
        this.TCalories = TCalories;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public Double getmBreakFast() {
        return mBreakFast;
    }

    public Double getmLunch() {
        return mLunch;
    }

    public Double getmDinner() {
        return mDinner;
    }

    public Double getmSnacks() {
        return mSnacks;
    }

    public Double getmJunks() {
        return mJunks;
    }

    public Double getmDrinks() {
        return mDrinks;
    }

    public Double getTCalories() {
        return TCalories;
    }

    public String getmDate() {
        return mDate;
    }

    public Double getTotal(){
        return mBreakFast+mLunch+mDinner+mSnacks+mJunks+mDrinks;

    }
}
