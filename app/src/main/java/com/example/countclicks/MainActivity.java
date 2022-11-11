package com.example.countclicks;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onTouchEvent(MotionEvent event) {
        GestureDetector gestureDetector;
        gestureDetector = new GestureDetector(this, new GestureListener());
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    int counter = 0 ;

    public void increaseCount(View view){
        counter = counter + 1 ;
        display(counter);
    }

    public void display(int counter){
        TextView displayInt = findViewById(R.id.text1);
        displayInt.setGravity(Gravity.CENTER);
        displayInt.setText("Total Clicks " + counter) ;


    }

    public void resetCount(View view){
        counter = 0 ;
        display(counter);
    }

    public void changeFont(View view) {
        TextView text = (TextView) findViewById(R.id.text1);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/arial.ttf");
        text.setTypeface(type);

    }
    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void changeColor(View view) {
        TextView text = (TextView) findViewById(R.id.text1);
        text.setTextAppearance(R.color.purple_500);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
            Toast.makeText(MainActivity.this, "Long pressed", Toast.LENGTH_SHORT).show();
        }
    }

}