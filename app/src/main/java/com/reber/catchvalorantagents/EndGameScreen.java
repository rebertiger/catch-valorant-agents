package com.reber.catchvalorantagents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndGameScreen extends AppCompatActivity {
    TextView scoreboard;

    String userscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game_screen);
        Intent intent = getIntent();
        userscore = intent.getStringExtra("playerscore");
        scoreboard = findViewById(R.id.scoreboard);
        scoreboard.setText(userscore);

    }
    public void playAgain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void mainMenu(View view){
        Intent intent = new Intent(this,MainMenu.class);
        startActivity(intent);
    }
}