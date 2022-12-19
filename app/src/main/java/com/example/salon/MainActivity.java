package com.example.salon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginbtn);
        db = new database(this);

        String use = username.getText().toString();
        String pass = password.getText().toString();
        if(TextUtils.isEmpty(use) || TextUtils.isEmpty(pass)){
            Toast.makeText(MainActivity.this,"All filde Required",Toast.LENGTH_LONG).show();
        }else{
            Boolean checkusernamepass = db.checkusernamepass(use,pass);
            if(checkusernamepass == true){
                Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
            }
        }

    }

}