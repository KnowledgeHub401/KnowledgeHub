package com.study.quizzler.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.study.quizzler.MainActivity;
import com.study.quizzler.R;

public class SignInPageActivity extends AppCompatActivity {

    private EditText etUsernameSignIn;
    private EditText etPasswordSignIn;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        etUsernameSignIn = findViewById(R.id.etUsernameSignIn);
        etPasswordSignIn = findViewById(R.id.etPasswordSignIn);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(v -> {
            String username = etUsernameSignIn.getText().toString().trim();
            String password = etPasswordSignIn.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(SignInPageActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                signInUser(username, password);
            }
        });
    }

    private void signInUser(String username, String password) {
        Amplify.Auth.signIn(
                username,
                password,
                result -> {
                    // Sign-in successful
                    runOnUiThread(() -> {
                        Toast.makeText(SignInPageActivity.this, "Sign-in successful", Toast.LENGTH_SHORT).show();
                        Log.i("Sign in success", result.toString());
                        navigateToMainActivity();
                    });
                },
                error -> {
                    // Sign-in failed
                    runOnUiThread(() -> {
                        Toast.makeText(SignInPageActivity.this, "Sign-in failed. Please try again.", Toast.LENGTH_SHORT).show();
                        Log.i("Sign up error", error.toString());
                    });
                }
        );
    }

   private void navigateToMainActivity() {
        Intent intent = new Intent(SignInPageActivity.this, MainActivity.class);
       startActivity(intent);
       finish();
   }

    public void onSignUpClicked(View view) {
        Intent intent = new Intent(SignInPageActivity.this, SignUpPageActivity.class);
        startActivity(intent);
    }
}

