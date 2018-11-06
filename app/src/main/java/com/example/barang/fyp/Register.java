package com.example.barang.fyp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity {

    Button regBtn;
    EditText regUsername, regPass, regFirstName, regLastName, regEmail, regPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        regBtn = (Button)findViewById(R.id.regBtn);
        regUsername = (EditText)findViewById(R.id.regUsername);
        regPass = (EditText)findViewById(R.id.regPass);
        regFirstName = (EditText)findViewById(R.id.regFirstName);
        regLastName = (EditText)findViewById(R.id.regLastName);
        regEmail = (EditText)findViewById(R.id.regEmail);
        regPhone = (EditText)findViewById(R.id.regPhone);

    }


}
