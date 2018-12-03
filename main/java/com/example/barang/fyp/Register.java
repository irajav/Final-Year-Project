package com.example.barang.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {

    Button regBtn;
    EditText regUsername, regPass, regFirstName, regLastName, regEmail, regPhone;
    private Wanderer wanderer;
    DatabaseReference databaseWanderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        databaseWanderer = FirebaseDatabase.getInstance().getReference("wanderers");
        regBtn = (Button)findViewById(R.id.regBtn);
        regUsername = (EditText)findViewById(R.id.regUsername);
        regPass = (EditText)findViewById(R.id.regPass);
        regFirstName = (EditText)findViewById(R.id.regFirstName);
        regLastName = (EditText)findViewById(R.id.regLastName);
        regEmail = (EditText)findViewById(R.id.regEmail);
        regPhone = (EditText)findViewById(R.id.regPhone);

        regBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addWanderer();

            }
        });

    }

    private void addWanderer()
    {
        String user = regUsername.getText().toString().trim();
        String password = regPass.getText().toString().trim();
        String firstName = regFirstName.getText().toString().trim();
        String lastName = regLastName.getText().toString().trim();
        String email = regEmail.getText().toString().trim();
        String phone = regPhone.getText().toString().trim();

        if(!TextUtils.isEmpty(user) || !TextUtils.isEmpty(password) || !TextUtils.isEmpty(firstName) || !TextUtils.isEmpty(lastName) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(phone) )
        {
            String id = databaseWanderer.push().getKey();
            Wanderer wanderer = new Wanderer(id, user, password, firstName, lastName, email, phone );

            databaseWanderer.child(id).setValue(wanderer);

            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(Register.this,MainActivity.class));

        }
        else
        {
            Toast.makeText(this, "Everything must be filled in!", Toast.LENGTH_SHORT).show();
        }
    }

}

