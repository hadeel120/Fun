package com.example.fun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsernameLogin, editTextPasswordLogin;
    private CheckBox checkBoxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsernameLogin = findViewById(R.id.editTextUsernameLogin);
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin);
        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean rememberMe = preferences.getBoolean("rememberMe", false);
        if (rememberMe) {
            String savedUsername = preferences.getString("username", "");
            String savedPassword = preferences.getString("password", "");
            editTextUsernameLogin.setText(savedUsername);
            editTextPasswordLogin.setText(savedPassword);
            checkBoxRememberMe.setChecked(true);
        }
    }

    public void loginUser() {
        String enteredUsername = editTextUsernameLogin.getText().toString();
        String enteredPassword = editTextPasswordLogin.getText().toString();
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String storedUsername = preferences.getString("username", "");
        String storedPassword = preferences.getString("password", "");

        if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("rememberMe", checkBoxRememberMe.isChecked());
            editor.apply();
            startSelectionActivity();
        } else {

            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void startSelectionActivity() {
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
        finish();
    }
}
