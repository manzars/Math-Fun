package com.example.mathfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class activity_game extends AppCompatActivity {

    TextView txtViewResult;
    TextView txtViewQuestion;
    TextView txtScore;
    TextView txtTime;
    ImageButton btnIncorrect;
    ImageButton btnCorrect;
    int seconds = 59;
    int score = 0;
    boolean stopTimer = false;
    boolean isResultCorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        txtScore = (TextView) findViewById(R.id.txtScore);
        txtTime = (TextView) findViewById(R.id.txtTime);
        txtViewQuestion = (TextView) findViewById(R.id.txtViewQuestion);
        txtViewResult = (TextView) findViewById(R.id.txtViewResult);
        btnCorrect = (ImageButton) findViewById(R.id.btnCorrect);
        btnIncorrect = (ImageButton) findViewById(R.id.btnIncorrect);
        timer();
        btnCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(true);
            }
        });

        btnIncorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(false);
            }
        });
        generateQuestion();
    }

    public void generateQuestion(){
        isResultCorrect = true;
        Random rand = new Random();
        int a = rand.nextInt(100);
        int b = rand.nextInt(100);
        int result = a + b;
        float f = rand.nextFloat();
        if(f > 0.5){
            result = rand.nextInt(100);
            isResultCorrect = false;
        }
        txtViewQuestion.setText(a + " + " + b);
        txtViewResult.setText("= " + result);

    }

    public void verifyAnswer(boolean answer){
        if(answer == isResultCorrect){
            score += 5;
            txtScore.setText("SCORE: " + score);
        }else{
            Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
        }
        generateQuestion();
    }

    private void timer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                txtTime.setText("TIME: " + seconds);
                seconds--;
                if(seconds < 0){
                    Intent i = new Intent(activity_game.this, activity_score.class);
                    i.putExtra("score", score);
                    startActivity(i);
                    stopTimer = true;
                }else{
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopTimer = false;
        finish();
    }
}
