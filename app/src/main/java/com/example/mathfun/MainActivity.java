package com.example.mathfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btnMathPlay, btnMathRate, btnMathShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMathPlay = (ImageButton) findViewById(R.id.btnMathPlay);
        btnMathShare = (ImageButton) findViewById(R.id.btnMathShare);
        btnMathRate = (ImageButton) findViewById(R.id.btnMathRate);

        btnMathPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, activity_game.class);
                startActivity(i);
            }
        });

        btnMathPlay.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(MainActivity.this, "This Is long press", Toast.LENGTH_LONG).show();

                return false;
            }
        });

        btnMathShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, "Just Maths: Fun Way to learn. https://www.googleplay.com");
                startActivity(i);
            }
        });

        btnMathRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You can open in google play and rate my app", Toast.LENGTH_LONG);
            }
        });

    }
}
