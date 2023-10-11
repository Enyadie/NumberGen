package com.example.numbergen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

     TextView mainView;
     Button randomButton;
     Button countButton;
     Button toastButton;

     TextView view1;
    
     Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 = findViewById(R.id.view1);
        mainView = findViewById(R.id.mainview);
        randomButton = findViewById(R.id.button3);
        countButton = findViewById(R.id.button2);
        toastButton = findViewById(R.id.button);// Add semicolon here
        intent = new Intent(this, MainActivity2.class);

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText("Your random number is generating");
                int randomNumber = generateRandomNumber();
                showToast(String.valueOf(randomNumber));
            }


        });

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               view1.setText("Your random number is generating");
             startActivity(intent);
            }


        });

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setText("Counting from 1 - 15");
                countNumbersUsingThread();

            }
        });
    }

    private int generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(15) + 1; // Generates a random number between 1 and 15
        return randomNumber;
    }

    private void countNumbersUsingThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    final int count = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mainView.setText(String.valueOf(count));
                        }
                    });

                    try {
                        Thread.sleep(1000); // Delay for 1 second (1000 milliseconds)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void showToast(final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
