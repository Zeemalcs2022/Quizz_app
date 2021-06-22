package com.example.quiz_app.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        TextView SINUP;
        SINUP = findViewById(R.id.btnSignUp);
        SINUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Button btnlogin;

        btnlogin = findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }

            private void Login() {
                String email, Password;
                EditText edit1, edit2;
                edit1 = findViewById(R.id.etEmailAddress);
                edit2 = findViewById(R.id.etPassword);
                email = edit1.getText().toString();
                Password = edit2.getText().toString();
                if (email.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "oops!Email and Password cant be empty", Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.signInWithEmailAndPassword(email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login successfully!", Toast.LENGTH_SHORT).show();
                            TextView main;
                            main = findViewById(R.id.btnLogin);
                            main.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        } else {
                            Toast.makeText(LoginActivity.this, "Login Failed!User not Exit....", Toast.LENGTH_SHORT).show();
                        }


                    }


                });


            }
        });

    }
}