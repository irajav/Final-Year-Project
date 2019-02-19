package com.example.barang.wanderlust;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterNow extends AppCompatActivity {

    Button registerBtn, registerCancel;
    EditText regUsername, regPassword, regFirstName, regLastName, regEmail, regNumber;
    DatabaseHelper myDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        myDatabaseHelper = new DatabaseHelper(this);
        registerBtn = (Button)findViewById(R.id.btRegister);
        regUsername = (EditText)findViewById(R.id.userinput);
        regPassword = (EditText)findViewById(R.id.passwordinput);
        regFirstName = (EditText)findViewById(R.id.nameinput);
        regLastName = (EditText)findViewById(R.id.lastnameinput);
        regEmail = (EditText)findViewById(R.id.emailinput);
        regNumber = (EditText)findViewById(R.id.numberinput);
        registerCancel = (Button)findViewById(R.id.btCancel);

        InsertCustomer();

    }

    private void InsertCustomer()
    {

        registerBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {

                        String insert_regUsername = regUsername.getText().toString();
                        String insert_regPassword = regPassword.getText().toString();
                        String insert_regFirstName = regFirstName.getText().toString();
                        String insert_regLastName = regLastName.getText().toString();
                        String insert_regAddress = regEmail.getText().toString();
                        String insert_regNumber = regNumber.getText().toString();

                        if (insert_regUsername.equals("")
                                || insert_regPassword.equals("")
                                || insert_regFirstName.equals("")
                                || insert_regLastName.equals("")
                                || insert_regAddress.equals("")
                                || insert_regNumber.equals(""))
                        {
                            Toast.makeText(getApplicationContext(), "Sorry you can't have empty fields!", Toast.LENGTH_SHORT).show();
                        }
                        //checks if the username already exists or if the username is already taken
                        else if (myDatabaseHelper.checkUser(insert_regUsername))
                        {
                            Toast.makeText(getApplicationContext(), "Choose another username.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            //insert customers to the users table
                            myDatabaseHelper.insertData(insert_regUsername, insert_regPassword, insert_regFirstName, insert_regLastName, insert_regAddress, insert_regNumber,0);

                            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(RegisterNow.this, MainActivity.class));
                            finish();
                        }
                    }
                }
        );

        registerCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterNow.this, MainActivity.class));
                finish();
            }
        });
    }
}
