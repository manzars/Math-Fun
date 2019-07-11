package com.example.mathfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class activity_score extends AppCompatActivity {

    TextView txtView;
    ImageButton btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        txtView = (TextView) findViewById(R.id.finalScore);
        final int score = getIntent().getIntExtra("score", 0);
        txtView.setText("Current Score: " + score);

        btnShare = (ImageButton) findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, "This game is Awesome, My final score was " + score + ". Can you break it?");
                startActivity(i);
                Toast.makeText(activity_score.this, "Hope you'll break my record, which is " + score + ".", Toast.LENGTH_LONG).show();
            }
        });

    }
}
