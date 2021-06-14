package com.example.wrcomic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    //    variable login
    EditText username, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        etPassword = findViewById(R.id.etPassword);
        Button buttonLogin = findViewById(R.id.btnLogin);


        buttonLogin.setOnClickListener(v -> {
            if (username.length() == 0) {
                username.setError("Username Must be filled");
                return;
            } if (username.length()<4 || username.length()>8) {
                username.setError("Username length must be greater than 4 and less than 8");
                return;
            } if (etPassword.length() == 0) {
                etPassword.setError("Password Must be filled");
                return;
            }

            login();
        });

    }

//    move page
    private void login() {
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);

        Bundle b = new Bundle();
        b.putString("username", username.getText().toString());
        intent.putExtras(b);

        startActivity(intent);
    }
}