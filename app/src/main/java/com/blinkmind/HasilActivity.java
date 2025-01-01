package com.blinkmind;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// ResultActivity.java
public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        int score = getIntent().getIntExtra("SCORE", 0);
        int totalQuestions = getIntent().getIntExtra("TOTAL_QUESTIONS", 0);
        int wrongAnswers = totalQuestions - score; // Menghitung jawaban yang salah

        TextView correct = findViewById(R.id.correct);
        correct.setText("Correct Answer : " + score);

        TextView wrong = findViewById(R.id.wrong);  // TextView untuk menampilkan jawaban salah
        wrong.setText("Wrong Answer : " + wrongAnswers);

        Button retryButton = findViewById(R.id.home_btn);
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(HasilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

