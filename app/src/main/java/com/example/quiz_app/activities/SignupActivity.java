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

public class SignupActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        Button LOGIN;
        LOGIN = findViewById(R.id.btnSignup);
        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


            Button btnsignup;
            btnsignup = findViewById(R.id.btnSignup);
            btnsignup.setOnClickListener(new View.OnClickListener() {
            private String CPassword;

            @Override
            public void onClick(View v) {
                Signup();
            }

            private void Signup(){
                String email,Password,confirmpassword,name;
                EditText edit1, edit2, edit3, edit4;
                edit1 = findViewById(R.id.etEmailAddress);
                edit2 = findViewById(R.id.etPassword);
                edit3 = findViewById(R.id.etconfrmPassword);
                edit4 = findViewById(R.id.etname);
                email = edit1.getText().toString();
                Password = edit2.getText().toString();
                confirmpassword = edit3.getText().toString();
                name = edit4.getText().toString();
                if(email.isEmpty() || Password.isEmpty())
                {
                    Toast.makeText(SignupActivity.this, "oops!Email and Password cant be empty", Toast.LENGTH_SHORT).show();
                }
                if(!Password.equals(confirmpassword))
                {
                    Toast.makeText(SignupActivity.this, "Password is not same!", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(SignupActivity.this, "Signup successfully!", Toast.LENGTH_SHORT).show();
                            TextView main;
                            main = findViewById(R.id.btnSignup);
                            main.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                        }
                        else
                            {
                            Toast.makeText(SignupActivity.this, "Signup failed", Toast.LENGTH_SHORT).show();
                        }


            }
        });

    }



});
    }

}