package com.blinkmind;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// QuizActivity2.java
public class QuizActivity2 extends AppCompatActivity {

    private TextView questionText;
    private Button option1, option2, option3;
    private Button nextButton;
    private int currentQuestion = 0;
    private int score = 0;

    // Array pertanyaan java
    private String[] questions = {
            "Insert the missing part of the code below this :\n" +
                    "public class Main {\n" +
                    "    public static ____ main(String[] args) {\n" +
                    "        System.out._______(\"Hello World\");\n" +
                    "    }\n" +
                    "}",

            "\n\n\n                  What is an int in Java?",

            "\n\n     Which method is often used to print\n" +
                    "     text in Java?",

            "\n\nA file containing a class called MyClass should be saved as:",

            "\n\nbyte, short, int, long, float, double, boolean and char are called:"
    };

    // Array pilihan jawaban
    private String[][] options = {
            {"void & println", "cout & print", "echo & writeline"},
            {"A data type representing decimals.", "A data type representing integers.", "A data type representing strings."},
            {"println()", "printline()", "echo()"},
            {"MyClass.jv", "MyClass.java", "MyClass.js"},
            {"Special", "Exclusive", "Primitive"}
    };

    // Array jawaban benar
    private String[] correctAnswers = {
            "void & println",
            "A data type representing integers.",
            "println()",
            "MyClass.java",
            "Primitive"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        // Inisialisasi views
        questionText = findViewById(R.id.textSoalJava);
        option1 = findViewById(R.id.btnSoal1A);
        option2 = findViewById(R.id.btnSoal1B);
        option3 = findViewById(R.id.btnSoal1C);
        nextButton = findViewById(R.id.next1Java);

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
                    Intent intent = new Intent(QuizActivity2.this, HasilActivity.class);
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
