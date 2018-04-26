package com.example.mymarq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Button_Activity extends AppCompatActivity {

    public static final String BUILDING_NAME = "com.example.myfirstapp.MESSAGE";
    public static final String FLOOR_NUMBER = "com.example.myfirstapp.MESSAGE";
    private String building = "None";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_);

        Intent intent = getIntent();
        String buildingName = intent.getStringExtra(EngineeringHall.EXTRA_MESSAGE); //This line fetches the building name from the previous activity

        //Depending on what the string(building name) is, the correct buttons will be displayed
        building = buildingName;
        if(buildingName.equals("Alumni Memorial Union")||buildingName.equals("Olin Engineering"))
        {
            findViewById(R.id.button_4).setVisibility(View.VISIBLE);
            findViewById(R.id.button_5).setVisibility(View.VISIBLE);
        }
        else if(buildingName.equals("Haggerty Hall") || buildingName.equals("Cudahy Hall") || buildingName.equals("Engineering Hall"))
        {
            findViewById(R.id.button_b).setVisibility(View.VISIBLE);
            findViewById(R.id.button_4).setVisibility(View.VISIBLE);
        }
        else if(buildingName.equals("Marquette Hall") || buildingName.equals("Memorial Library"))
        {
            findViewById(R.id.button_b).setVisibility(View.VISIBLE);
            findViewById(R.id.button_4).setVisibility(View.VISIBLE);
            findViewById(R.id.button_5).setVisibility(View.VISIBLE);
        }
        else if(buildingName.equals("Raynor Library"))
        {
            findViewById(R.id.button_b).setVisibility(View.VISIBLE);
        }
    }

    public void onClick(View v) {
        Button b = (Button)v;
        String buttonText = b.getText().toString();
        Intent intent;
        switch (building){      //choses which activity to send user to based on selection
            case "Alumni Memorial Union": intent = new Intent(this, amu_floors.class); intent.putExtra(BUILDING_NAME, building); break;
            case "Cudahy Hall": intent = new Intent(this, cudahy_floors.class); intent.putExtra(BUILDING_NAME, building); break;
            case "Engineering Hall": intent = new Intent(this, Ehall_F1.class); intent.putExtra(BUILDING_NAME, building); break;
            case "Haggerty Hall": intent = new Intent(this, haggerty_floors.class); intent.putExtra(BUILDING_NAME, building); break;
            case "Marquette Hall": intent = new Intent(this, marquette_floors.class); intent.putExtra(BUILDING_NAME, building); break;
            case "Memorial Library": intent = new Intent(this, memorial_floors.class); intent.putExtra(BUILDING_NAME, building); break;
            case "Olin Engineering": intent = new Intent(this, olin_floors.class); intent.putExtra(BUILDING_NAME, building); break;
            case "Raynor Library": intent = new Intent(this, raynor_floors.class); intent.putExtra(BUILDING_NAME, building); break;
            default: intent = new Intent(this, MainActivity.class); break;
        }

        intent.putExtra(FLOOR_NUMBER, buttonText);
        startActivity(intent);
    }
}