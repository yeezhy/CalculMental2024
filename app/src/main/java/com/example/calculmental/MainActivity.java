package com.example.calculmental;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import com.example.calculmental.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boutonJouer = findViewById(R.id.button_play);
        boutonJouer.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });
        Button boutonScores = findViewById(R.id.button_score);
        boutonScores.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, ScoresActivity.class);
            startActivity(intent);
        });
        Button boutonAPropos = findViewById(R.id.button_apropos);
        boutonAPropos.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
    }

}