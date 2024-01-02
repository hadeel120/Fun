package com.example.fun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private TextView textViewLoginPrompt;
    private Button buttonGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        textViewLoginPrompt = findViewById(R.id.textViewLoginPrompt);
        buttonGoToLogin = findViewById(R.id.buttonGoToLogin);


        if (hasAccount()) {
            textViewLoginPrompt.setVisibility(View.VISIBLE);
            buttonGoToLogin.setVisibility(View.VISIBLE);


            buttonGoToLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToLogin();
                }
            });
        }


        Button buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    public void registerUser() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();

        editor.apply();


        startSelectionActivity();
    }

    private boolean hasAccount() {
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        return preferences.contains("username") && preferences.contains("password");
    }

    private void startSelectionActivity() {
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
