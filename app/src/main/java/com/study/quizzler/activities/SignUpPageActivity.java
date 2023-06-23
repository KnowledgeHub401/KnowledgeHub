package com.study.quizzler.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.study.quizzler.R;

public class SignUpPageActivity extends AppCompatActivity {

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
                Toast.makeText(SignUpPageActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                signUpUser(name, email, password);
//                Toast.makeText(SignUpPage.this, "Sign-up successful", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void signUpUser(String username, String email, String password) {
        AuthSignUpOptions options = AuthSignUpOptions.builder()
                .userAttribute(AuthUserAttributeKey.email(), email)
                .build();

        Amplify.Auth.signUp(username, password, options,
                result -> {
                    // Sign-up successful
                    runOnUiThread(() -> {
                        Toast.makeText(SignUpPageActivity.this, "Sign-up successful", Toast.LENGTH_SHORT).show();
                        Log.i("Sign up success", result.toString());
                        showConfirmationDialog(username);
                    });
                },
                error -> {
                    // Sign-up failed
                    runOnUiThread(() -> {
                        Toast.makeText(SignUpPageActivity.this, "Sign-up failed. Please try again.", Toast.LENGTH_SHORT).show();
                        Log.i("Sign up error", error.toString());
                    });
                });
    }

    private void showConfirmationDialog(String username) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Sign Up");
        builder.setMessage("Please enter the confirmation code:");

        EditText etConfirmationCode = new EditText(this);
        builder.setView(etConfirmationCode);

        builder.setPositiveButton("Confirm", ((dialog, which) -> {
            String confirmationCode = etConfirmationCode.getText().toString().trim();
            confirmSignUp(username, confirmationCode);
        }));

        builder.setNegativeButton("Cancel", ((dialog, which) -> {

        }));

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void confirmSignUp(String username, String confirmationCode) {

        Amplify.Auth.confirmSignUp(username, confirmationCode,
                result -> {
                    runOnUiThread(() -> {
                        Toast.makeText(SignUpPageActivity.this, "Confirmation Successful", Toast.LENGTH_SHORT).show();
                        navigateToSignInPage();
                    });
                },
                error -> runOnUiThread(() -> Toast.makeText(SignUpPageActivity.this, "Confirmation failed. Please try again", Toast.LENGTH_SHORT).show()));
    }

    private void navigateToSignInPage() {
        Intent intent = new Intent(SignUpPageActivity.this, SignInPageActivity.class);
        startActivity(intent);
        finish();
    }

}