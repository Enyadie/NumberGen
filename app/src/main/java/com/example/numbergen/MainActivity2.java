package com.example.numbergen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity {
     Button privious;
     TextView view1;

     TextView mainView;



    int generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(15) + 1; // Generates a random number between 1 and 15
        return randomNumber;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        view1 = findViewById(R.id.view1);
        mainView = findViewById(R.id.mainv);

        view1.setText("Your random number is generating");
        int randomNumber = generateRandomNumber();

        mainView.setText(""+randomNumber);

        privious =(Button) findViewById(R.id.button5);

        privious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}