package com.example.mymarq;

import android.content.Intent;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Ehall_F1 extends AppCompatActivity {

    private TouchImageView image;
    private TextView scrollPositionTextView;
    private TextView zoomedRectTextView;
    private TextView currentZoomTextView;
    private DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ehall__f1);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String floornum = intent.getStringExtra(EngineeringHall.EXTRA_MESSAGE);


        //
        // DecimalFormat rounds to 2 decimal places.
        //
        df = new DecimalFormat("#.##");
        scrollPositionTextView = (TextView) findViewById(R.id.scroll_position);
        zoomedRectTextView = (TextView) findViewById(R.id.zoomed_rect);
        currentZoomTextView = (TextView) findViewById(R.id.current_zoom);
        switch (floornum){
            case "Floor 1": image = findViewById(R.id.FL1); break;
            case "Floor 2": image = findViewById(R.id.FL2); break;
            case "Floor 3": image = findViewById(R.id.FL3); break;
            case "Floor 4": image = findViewById(R.id.FL4); break;
            case "Lower Level": image = findViewById(R.id.FLB); break;
            default: throw new IllegalArgumentException("Invalid Floor");
        }
        /*if(floornum.equals("Floor 1"))
        {
            image = findViewById(R.id.FL1);
        }
        else if(floornum.equals("Floor 2"))
        {
            image = findViewById(R.id.FL2);
        }
        else if(floornum.equals("Floor 3"))
        {
            image = findViewById(R.id.FL3);
        }
        else if(floornum.equals("Floor 4"))
        {
            image = findViewById(R.id.FL4);
        }
        else if(floornum.equals("Lower Level"))
        {
            image = findViewById(R.id.FLB);
        }*/
        image.setVisibility(View.VISIBLE);
        //
        // Set the OnTouchImageViewListener which updates edit texts
        // with zoom and scroll diagnostics.
        //
        image.setOnTouchImageViewListener(new TouchImageView.OnTouchImageViewListener() {

            @Override
            public void onMove() {
                PointF point = image.getScrollPosition();
                RectF rect = image.getZoomedRect();
                float currentZoom = image.getCurrentZoom();
                boolean isZoomed = image.isZoomed();
                scrollPositionTextView.setText("x: " + df.format(point.x) + " y: " + df.format(point.y));
                zoomedRectTextView.setText("left: " + df.format(rect.left) + " top: " + df.format(rect.top)
                        + "\nright: " + df.format(rect.right) + " bottom: " + df.format(rect.bottom));
                currentZoomTextView.setText("getCurrentZoom(): " + currentZoom + " isZoomed(): " + isZoomed);
            }
        });


        //Used for testing if the Strings were coming from the previous string
        /* Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(floornum);
        */
    }
}
