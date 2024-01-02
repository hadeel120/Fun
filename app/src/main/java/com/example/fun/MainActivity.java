package com.example.fun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (isUserLoggedIn()) {
            startSelectionActivity();
        } else {

            if (hasAccount()) {
                startLoginActivity();
            }
        }
    }

    public void goToRegistration(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }


    private boolean isUserLoggedIn() {
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        return preferences.getBoolean("rememberMe", false);
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


    private void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
