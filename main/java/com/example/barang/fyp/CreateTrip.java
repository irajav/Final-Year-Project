package com.example.barang.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CreateTrip extends AppCompatActivity {

    Button createbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createtrip);

        createbtn = (Button)findViewById(R.id.createitineraryBtn);
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDays();
            }
        });

    }

    private void viewDays()
    {
        startActivity(new Intent(CreateTrip.this, SelectDays.class));
    }


}