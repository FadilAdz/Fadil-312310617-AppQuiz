package com.blinkmind;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tombol untuk Quiz (C++)
        Button btnQuiz1 = findViewById(R.id.cplus);
        btnQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman soal C++
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

// Tombol untuk Quiz (Java)
        Button btnQuiz2 = findViewById(R.id.java);
        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tambahkan log
                Log.d("MainActivity", "Quiz Java button clicked");
                Intent intent = new Intent(MainActivity.this, QuizActivity2.class);
                startActivity(intent);
            }
        });

        // Tombol untuk Quiz (Python)
        Button btnQuiz3 = findViewById(R.id.python);
        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman soal Python
                Intent intent = new Intent(MainActivity.this, QuizActivity3.class);
                startActivity(intent);
            }
        });

            Logout = findViewById(R.id.Logout);
            Logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showLogoutConfirmation();
                }
            });
        }

        private void showLogoutConfirmation() {
            // Keluar / Logout  dari Aplikasi
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Keluar Aplikasi");
            builder.setMessage("Apakah kamu yakin ingin keluar aplikasi?");
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Keluar dari aplikasi
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    System.exit(0);
                }
            });
            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Tidak jadi keluar aplikasi
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
