package com.example.fun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SelectionActivity extends AppCompatActivity {

    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        textViewWelcome = findViewById(R.id.textViewWelcome);
        displayWelcomeMessage();
    }

    private void displayWelcomeMessage() {
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        
        if (!username.isEmpty()) {
            String welcomeMessage = "Welcome " + username;
            textViewWelcome.setText(welcomeMessage);
        }
    }

    public void showJokeActivity(android.view.View view) {
        Intent intent = new Intent(this, JokeActivity.class);
        startActivity(intent);
    }

    public void showActivityActivity(android.view.View view) {
        Intent intent = new Intent(this, ActivityActivity.class);
        startActivity(intent);
    }
}
