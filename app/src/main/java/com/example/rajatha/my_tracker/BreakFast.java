package com.example.rajatha.my_tracker;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajatha on 02-May-2017.
 */

public class BreakFast implements Parcelable {

    private int mID;
    private String mItem;
    private String mCalories;
    private String mQuantity;
    private String mTCalories;

    public BreakFast(){
        mID =0;
        mItem=" ";
        mCalories=" ";
        mQuantity=" ";
        mTCalories=" ";

     }

     public BreakFast(Parcel P){

         this.mID=P.readInt();
         this.mItem=P.readString();
         this.mCalories=P.readString();
         this.mQuantity=P.readString();
         this.mTCalories=P.readString();
     }

     public BreakFast(String mItem,String mCalories,String mQuantity,String mTCalories){
         this.mItem=mItem;
         this.mCalories=mCalories;
         this.mQuantity=mQuantity;
         this.mTCalories=mTCalories;

     }

    public String getTotalCalories(String calories,String Quantity){
        Float cal=Float.parseFloat(calories);
        int Quant=Integer.parseInt(Quantity);
        String Total=Float.toString(cal*Quant);
        return Total;
    }

     public void setmID(int mID){
         this.mID=mID;
     }

     public void setmCalories(String mCalories){
         this.mCalories=mCalories;
     }

     public void setmQuantity(String mQuantity){

         this.mQuantity=mQuantity;
     }

     public void setmItem(String mItem){
         this.mItem=mItem;
     }
     public void setmTCalories(String mTCalories){

         this.mTCalories=mTCalories;
     }

     public int getmID(){
         return mID;
     }

     public String getmItem(){
         return mItem;
     }

     public  String getmCalories(){
         return mCalories;
     }

     public String getmQuantity(){
         return mQuantity;
     }

     public String getmTCalories(){
         return mTCalories;
     }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(mID);
        dest.writeString(mItem);
        dest.writeString(mCalories);
        dest.writeString(mQuantity);
        dest.writeString(mTCalories);


    }

    public static final Parcelable.Creator<BreakFast> CREATOR = new Parcelable.Creator<BreakFast>() {
        @Override
        public BreakFast createFromParcel(Parcel source) {
            return new BreakFast(source);
        }

        @Override
        public BreakFast[] newArray(int size) {
            return new BreakFast[0];
        }
    };
}
