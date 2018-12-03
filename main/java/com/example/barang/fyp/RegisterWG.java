package com.example.barang.fyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class RegisterWG extends AppCompatActivity {

    Button regWGBtn;
    EditText regWGUsername, regWGPass, regWGFirstName, regWGLastName, regWGEmail, regWGPhone, regWGlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerwg);

        regWGBtn = (Button)findViewById(R.id.regWGBtn);
        regWGUsername = (EditText)findViewById(R.id.regWGUsername);
        regWGPass = (EditText)findViewById(R.id.regWGPass);
        regWGFirstName = (EditText)findViewById(R.id.regWGFirstName);
        regWGLastName = (EditText)findViewById(R.id.regWGLastName);
        regWGEmail = (EditText)findViewById(R.id.regWGEmail);
        regWGPhone = (EditText)findViewById(R.id.regWGPhone);
        regWGlocation = (EditText)findViewById(R.id.regWGLocation);

    }

}