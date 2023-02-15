package com.reber.catchvalorantagents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView remainingTime,point;
    ImageView imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
    int score;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        remainingTime = findViewById(R.id.remainingTime);
        point = findViewById(R.id.point);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        score = 0;
        imageArray = new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8,imageView9};

        hideImages();
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainingTime.setText("Remaining Time: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                remainingTime.setText("Time is UP!");
                handler.removeCallbacks(runnable);
                for (ImageView agents : imageArray) {
                    agents.setVisibility(View.INVISIBLE);
                }
                endGameScreen();
            }
        }.start();
        //oncreate
    }
    public void hideImages() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView agents : imageArray) {
                    agents.setVisibility(View.INVISIBLE);

            }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,400);


        }


        };
        handler.post(runnable);

    }
    public void increasePoint(View view){
        score++;
        point.setText("Your Score: "+ score + " Points");
    }
    public void endGameScreen(){
        Intent intent = new Intent(this,EndGameScreen.class);
        String asd = point.getText().toString();
        intent.putExtra("playerscore",asd);
        finish();
        startActivity(intent);
    }

}
