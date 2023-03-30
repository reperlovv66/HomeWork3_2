package com.example.homework3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int xPos = 0;
    private int yPos = 0;
    private ImageView cat;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        cat = findViewById(R.id.cat);
        btn = findViewById(R.id.Button);

        cat.setAlpha(0f);
        cat.setTranslationX(rdm(-400, 400));
        cat.setTranslationY(rdm(-400, 400));

        Toast toast = Toast.makeText(this, R.string.FindCat, Toast.LENGTH_SHORT);
        toast.show();

        cat.setOnTouchListener(touchListener);
        btn.setOnClickListener(buttonClick);
    }

    View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(cat.getAlpha() != 0){
                cat.setAlpha(0f);
                cat.setTranslationX(rdm(-400, 400));
                cat.setTranslationY(rdm(-400, 400));
            } else
                cat.setAlpha(1f);
        }
    };

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            cat.setAlpha(1f);
            return false;
        }
    };

    int rdm(int a, int b){
        return (int) (( Math.random() * (b-a) ) + a);
    }
}