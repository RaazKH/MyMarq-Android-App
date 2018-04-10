package com.example.mymarq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ehall_F1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ehall__f1);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String floornum = intent.getStringExtra(EngineeringHall.EXTRA_MESSAGE);

        if(floornum.equals("Floor 1"))
        {
            findViewById(R.id.FL1).setVisibility(View.VISIBLE);
        }
        else if(floornum.equals("Floor 2"))
        {
            findViewById(R.id.FL2).setVisibility(View.VISIBLE);
        }
        else if(floornum.equals("Floor 3"))
        {
            findViewById(R.id.FL3).setVisibility(View.VISIBLE);
        }
        else if(floornum.equals("Floor 4"))
        {
            findViewById(R.id.FL4).setVisibility(View.VISIBLE);
        }
        else if(floornum.equals("Lower Level"))
        {
            findViewById(R.id.FLB).setVisibility(View.VISIBLE);
        }



        //Used for testing if the Strings were coming from the previous string
        /* Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(floornum);
        */
    }
}
