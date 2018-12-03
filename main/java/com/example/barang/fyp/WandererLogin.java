package com.example.barang.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WandererLogin extends AppCompatActivity {

    EditText loginWUsername, loginWPassword;
    Button loginWButton;

    DatabaseReference databaseWanderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wandererlogin);

        loginWUsername = findViewById(R.id.loginWUsername);
        loginWPassword = findViewById(R.id.loginWPassword);
        loginWButton = findViewById(R.id.loginWBtn);
        loginWButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    String pass;

    private void login()
    {
        String user = loginWUsername.getText().toString().trim();
        pass = loginWPassword.getText().toString().trim();

        FirebaseDatabase.getInstance().getReference().child("wanderers").orderByChild("wandererUser").equalTo(user).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {

                        for(DataSnapshot user : dataSnapshot.getChildren()) {
                            Wanderer wanderer = user.getValue(Wanderer.class);


                            if (wanderer.wandererPass.equals(pass)) {
                                Toast.makeText(WandererLogin.this, "Login successful!", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(WandererLogin.this, WandererProfile.class));
                            } else {
                                Toast.makeText(WandererLogin.this, "Incorrect Password.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else
                    {

                        Toast.makeText(WandererLogin.this, "User does not exist.", Toast.LENGTH_SHORT).show();
                    }
                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }



