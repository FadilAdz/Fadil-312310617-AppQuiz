package com.blinkmind;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// QuizActivity3.java
public class QuizActivity3 extends AppCompatActivity {

    private TextView questionText;
    private Button option1, option2, option3;
    private Button nextButton;
    private int currentQuestion = 0;
    private int score = 0;

    // Array pertanyaan python
    private String[] questions = {
            "\nInsert the missing part of the code below this :\n\n" +
                    "_____(\"Hello, World!\")",

            "\n\nIf x = 5, what is a correct syntax for printing the data type of the variable x?\n",

            "The following code example would print the data type of x, what data type would that be?\n\n" +
                    "x = 5\n" +
                    "print(type(x))\n",

            "\n\nWhat is a correct way to declare a Python variable?",

            "\nWhat will be the result of the following code :\n\n" +
                    "x = 'Welcome'\n" +
                    "print(x[3])"
    };

    // Array pilihan jawaban
    private String[][] options = {
            {"console.log", "cout", "print"},
            {"print(dtype(x))", "print(x.dtype())", "print(type(x))"},
            {"int", "string", "boolean"},
            {"var x = 5", "x = 5", "$x = 5"},
            {"Wel", "c", "Welcome Welcome Welcome"}
    };

    // Array jawaban benar
    private String[] correctAnswers = {
            "print",
            "print(type(x))",
            "int",
            "x = 5",
            "c"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        // Inisialisasi views
        questionText = findViewById(R.id.textSoalPython);
        option1 = findViewById(R.id.btnSoal1A);
        option2 = findViewById(R.id.btnSoal1B);
        option3 = findViewById(R.id.btnSoal1C);
        nextButton = findViewById(R.id.next1Python);

        // Set pertanyaan pertama
        displayQuestion(currentQuestion);

        // Event handlers untuk tombol opsi
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option1.getText().toString());
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option2.getText().toString());
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option3.getText().toString());
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestion++;
                if (currentQuestion < questions.length) {
                    displayQuestion(currentQuestion);
                } else {
                    // Kuis selesai, tampilkan skor
                    Intent intent = new Intent(QuizActivity3.this, HasilActivity.class);
                    intent.putExtra("SCORE", score);
                    intent.putExtra("TOTAL_QUESTIONS", questions.length);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void displayQuestion(int questionIndex) {
        questionText.setText(questions[questionIndex]);
        option1.setText(options[questionIndex][0]);
        option2.setText(options[questionIndex][1]);
        option3.setText(options[questionIndex][2]);

        // Reset warna tombol
        option1.setBackgroundResource(android.R.color.white);
        option2.setBackgroundResource(android.R.color.white);
        option3.setBackgroundResource(android.R.color.white);

        // Reset enable tombol
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);

        // Sembunyikan tombol Next sampai jawaban dipilih
        nextButton.setVisibility(View.INVISIBLE);
    }

    private void checkAnswer(String selectedAnswer) {
        nextButton.setVisibility(View.VISIBLE);

        // Disable semua tombol opsi setelah jawaban dipilih
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);

        if (selectedAnswer.equals(correctAnswers[currentQuestion])) {
            score++;
            // Tandai jawaban benar dengan warna hijau
            if (option1.getText().toString().equals(selectedAnswer)) {
                option1.setBackgroundResource(android.R.color.holo_green_light);
            } else if (option2.getText().toString().equals(selectedAnswer)) {
                option2.setBackgroundResource(android.R.color.holo_green_light);
            } else {
                option3.setBackgroundResource(android.R.color.holo_green_light);
            }
        } else {
            // Tandai jawaban salah dengan warna merah
            if (option1.getText().toString().equals(selectedAnswer)) {
                option1.setBackgroundResource(android.R.color.holo_red_light);
            } else if (option2.getText().toString().equals(selectedAnswer)) {
                option2.setBackgroundResource(android.R.color.holo_red_light);
            } else {
                option3.setBackgroundResource(android.R.color.holo_red_light);
            }

            // Tandai jawaban yang benar dengan warna hijau
            if (option1.getText().toString().equals(correctAnswers[currentQuestion])) {
                option1.setBackgroundResource(android.R.color.holo_green_light);
            } else if (option2.getText().toString().equals(correctAnswers[currentQuestion])) {
                option2.setBackgroundResource(android.R.color.holo_green_light);
            } else {
                option3.setBackgroundResource(android.R.color.holo_green_light);
            }
        }
    }
}
