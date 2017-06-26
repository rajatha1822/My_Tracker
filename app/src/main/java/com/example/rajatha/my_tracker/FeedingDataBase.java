package com.example.rajatha.my_tracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FeedingDataBase extends AppCompatActivity {

    private static String TAG="FeedingDataBase";
    private Double cal,Total,value;
    private int Quant,Checked;
    private Boolean bBreakFast=false,bLunch=false,bDinner=false,bSnacks=false,bJunks=false,bDrinks=false;
    private String UserName,Password;
    private Button TotalCal,AddMore,Done;
    private TextView Calories,TCalories,Item;
    private EditText Qunatity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"Oncreate is called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding_data_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mButtonInitilization();
        AddMore.setEnabled(false);
        Done.setEnabled(false);

        mIntent();


        TotalCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculation();
            }

        });

        AddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMore();
            }

        });

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnDone();

            }
        });


    }
    private void mButtonInitilization(){
        Item=(TextView)findViewById(R.id.F_Item);
        Calories=(TextView)findViewById(R.id.F_calories);
        Qunatity =(EditText) findViewById(R.id.F_Quantity);
        TCalories=(TextView)findViewById(R.id.F_TCalories);
        TotalCal=(Button)findViewById(R.id.F_TCal);
        AddMore=(Button)findViewById(R.id.F_AddMore);
        Done=(Button)findViewById(R.id.F_Done);
    }

    private void Calculation(){
        try{
            cal=Double.parseDouble(Calories.getText().toString());
        }
        catch(NumberFormatException ex){
            cal=1.0;
        }
        try{
            Quant=Integer.parseInt(Qunatity.getText().toString());
        }catch (NumberFormatException ex){
            Quant=1;
        }
        Total=cal*Quant;
        String TotalCal=Double.toString(Total);
        TCalories.setText(TotalCal);
        AddMore.setEnabled(true);
        Done.setEnabled(true);

    }

    private void mIntent(){
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            UserName = bundle.getString("UserName");
            Password = bundle.getString("Password");
            final BreakFast mBreakFast=(BreakFast) getIntent().getExtras().getParcelable("BreakFast");
            if(mBreakFast!=null) {
                Item.setText(mBreakFast.getmItem());
                Calories.setText(mBreakFast.getmCalories().toString());
                bBreakFast=true;
            }
            Lunch mLunch=(Lunch)getIntent().getExtras().getParcelable("Lunch");
            if(mLunch!=null) {
                Item.setText(mLunch.getmItem());
                Calories.setText(mLunch.getmCalories().toString());
                bLunch=true;
            }
            Dinner mDinner=(Dinner)getIntent().getExtras().getParcelable("Dinner");
            if(mDinner!=null) {
                Item.setText(mDinner.getmItem());
                Calories.setText(mDinner.getmCalories().toString());
                bDinner=true;
            }
            Snacks mSnacks=(Snacks)getIntent().getExtras().getParcelable("Snacks");
            if(mSnacks!=null) {
                Item.setText(mSnacks.getmItem());
                Calories.setText(mSnacks.getmCalories().toString());
                bSnacks=true;
            }


            Junks mJunks=(Junks)getIntent().getExtras().getParcelable("Junks");
            if(mJunks!=null) {
                Item.setText(mJunks.getmItem());
                Calories.setText(mJunks.getmCalories().toString());
                bJunks=true;
            }

            Drinks mDrinks=(Drinks) getIntent().getExtras().getParcelable("Drinks");
            if(mDrinks!=null) {
                Item.setText(mDrinks.getmItem());
                Calories.setText(mDrinks.getmCalories().toString());
                bDrinks=true;

            }

        }



    }

    private void addMore(){
        if (bBreakFast) {
            Intent IBreakfast = new Intent(FeedingDataBase.this, BreakFastViewer.class);
            AddToDataBase();
            AddTBreakFast();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            IBreakfast.putExtras(b);
            startActivity(IBreakfast);
        } else if (bLunch) {
            Intent ILunch = new Intent(FeedingDataBase.this, LunchViewer.class);
            AddToDataBase();
            AddTLunch();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            ILunch.putExtras(b);
            startActivity(ILunch);

        } else if (bDinner) {
            Intent IDinner = new Intent(FeedingDataBase.this, DinnerViewer.class);
            AddToDataBase();
            AddTDinner();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            IDinner.putExtras(b);
            startActivity(IDinner);


        } else if (bSnacks) {
            Intent ISnacks = new Intent(FeedingDataBase.this, SnacksViewer.class);
            AddToDataBase();
            AddTSnacks();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            ISnacks.putExtras(b);
            startActivity(ISnacks);

        } else if (bJunks) {
            Intent IJunks = new Intent(FeedingDataBase.this, JunksViewer.class);
            AddToDataBase();
            AddTJunks();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            IJunks.putExtras(b);
            startActivity(IJunks);


        } else if (bDrinks) {
            Intent IDrinks = new Intent(FeedingDataBase.this, DrinksViewer.class);
            AddToDataBase();
            AddTDrinks();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            IDrinks.putExtras(b);
            startActivity(IDrinks);
        }

    }

    public void AddToDataBase(){
        UserDataBase DP= new UserDataBase(getBaseContext(),UserName);
        Boolean DateExists=DP.CheckDateExists(DP);
        if(!DateExists){
            DP.AddDate(DP);
        }
    }

    public void AddTBreakFast(){
        UserDataBase DP= new UserDataBase(getBaseContext(),UserName);
        try{
            value=DP.RetrieveBreakFast(DP);

        }catch(NumberFormatException ex){
            value=0.0;

        }
        Double NewValue=value+Total;
        DP.AddBreakFast(DP,NewValue);

    }

    public void AddTLunch(){
        UserDataBase DP= new UserDataBase(getBaseContext(),UserName);
        try{
            value=DP.RetrieveLunch(DP);

        }catch(NumberFormatException ex){
            value=0.0;

        }
        Double NewValue=value+Total;
        DP.AddLunch(DP,NewValue);

    }

    public void AddTDinner(){
        UserDataBase DP= new UserDataBase(getBaseContext(),UserName);
        try{
            value=DP.RetrieveDinner(DP);

        }catch(NumberFormatException ex){
            value=0.0;

        }
        Double NewValue=value+Total;
        DP.AddDinner(DP,NewValue);

    }
    public void AddTSnacks(){
        UserDataBase DP= new UserDataBase(getBaseContext(),UserName);
        try{
            value=DP.RetrieveSnacks(DP);

        }catch(NumberFormatException ex){
            value=0.0;

        }
        Double NewValue=value+Total;
        DP.AddSnacks(DP,NewValue);

    }
    public void AddTJunks(){
        UserDataBase DP= new UserDataBase(getBaseContext(),UserName);
        try{
            value=DP.RetrieveJunks(DP);

        }catch(NumberFormatException ex){
            value=0.0;

        }
        Double NewValue=value+Total;
        DP.AddJunks(DP,NewValue);

    }
    public void AddTDrinks(){
        UserDataBase DP= new UserDataBase(getBaseContext(),UserName);
        try{
            value=DP.RetrieveDrinks(DP);

        }catch(NumberFormatException ex){
            value=0.0;

        }
        Double NewValue=value+Total;
        DP.AddDrinks(DP,NewValue);

    }

    public void OnDone(){
        if (bBreakFast) {
            Intent IBreakfast = new Intent(FeedingDataBase.this, MainActivity.class);
            AddToDataBase();
            AddTBreakFast();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            IBreakfast.putExtras(b);
            startActivity(IBreakfast);
        } else if (bLunch) {
            Intent ILunch = new Intent(FeedingDataBase.this,MainActivity.class);
            AddToDataBase();
            AddTLunch();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            ILunch.putExtras(b);
            startActivity(ILunch);

        } else if (bDinner) {
            Intent IDinner = new Intent(FeedingDataBase.this,MainActivity.class);
            AddToDataBase();
            AddTDinner();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            IDinner.putExtras(b);
            startActivity(IDinner);


        } else if (bSnacks) {
            Intent ISnacks = new Intent(FeedingDataBase.this,MainActivity.class);
            AddToDataBase();
            AddTSnacks();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            ISnacks.putExtras(b);
            startActivity(ISnacks);

        } else if (bJunks) {
            Intent IJunks = new Intent(FeedingDataBase.this,MainActivity.class);
            AddToDataBase();
            AddTJunks();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            IJunks.putExtras(b);
            startActivity(IJunks);


        } else if (bDrinks) {
            Intent IDrinks = new Intent(FeedingDataBase.this,MainActivity.class);
            AddToDataBase();
            AddTDrinks();
            Bundle b = new Bundle();
            b.putString("UserName",UserName);
            b.putString("Password",Password);
            IDrinks.putExtras(b);
            startActivity(IDrinks);
        }



    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mBackPressed= new Intent(FeedingDataBase.this,MainActivity.class);
        Bundle b = new Bundle();
        b.putString("UserName",UserName);
        b.putString("Password",Password);
        mBackPressed.putExtras(b);
        startActivity(mBackPressed);
    }
}


