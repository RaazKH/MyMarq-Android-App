package com.example.mymarq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EngineeringHall extends AppCompatActivity {

    //This String is important to pass the button text between classes
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering_hall);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Ehall_F1.class);
        Button b = (Button)v;
        String buttonText = b.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, buttonText);

        startActivity(intent);


       // b.setVisibility(View.INVISIBLE);


        /* This was used when different intents would be used for each floor
        if(buttonText.equals("Floor 1")) {
            startActivity(intent);
        }
        */
    }
}
