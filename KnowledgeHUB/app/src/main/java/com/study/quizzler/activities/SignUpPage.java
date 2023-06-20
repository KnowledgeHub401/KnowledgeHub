package com.study.quizzler.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.study.quizzler.R;

public class SignUpPage extends AppCompatActivity {

    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        Button btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(v -> {
            String name = etUsername.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(SignUpPage.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                    signUpUser(name, email, password);
                Toast.makeText(SignUpPage.this, "Sign-up successful", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void signUpUser(String name, String email, String password) {
        AuthSignUpOptions options = AuthSignUpOptions.builder()
                .userAttribute(AuthUserAttributeKey.email(), email)
                .build();

        Amplify.Auth.signUp(name, password, options,
                result -> {
                    // Sign-up successful
                    runOnUiThread(() -> {
                        Toast.makeText(SignUpPage.this, "Sign-up successful", Toast.LENGTH_SHORT).show();
                        // You can navigate to another activity or perform additional actions here
                    });
                },
                error -> {
                    // Sign-up failed
                    runOnUiThread(() -> {
                        Toast.makeText(SignUpPage.this, "Sign-up failed. Please try again.", Toast.LENGTH_SHORT).show();
                        // You can display specific error messages or handle different error cases here
                    });
                });
    }

}