package com.example.quiz_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz_app.R;
import com.example.quiz_app.activities.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginintroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginintro);

        FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();

            if(firebaseAuth.getCurrentUser() != null)
            {
                Toast.makeText(this, "USER IS ALREADY LOGGED IN!", Toast.LENGTH_SHORT).show();
                try {
                    redirect("MAIN");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        Button btnStartQuiz;
        btnStartQuiz = findViewById(R.id.btnStartQuiz);
        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    redirect("LOGIN");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void redirect(String main) throws Exception {
        if (main.equals("LOGIN"))
        {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
        }
        else if (main.equals("MAIN"))
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

        }
        else
        {
            throw new Exception("No Path Exist");

        }

    }

}