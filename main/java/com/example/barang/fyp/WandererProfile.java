package com.example.barang.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class WandererProfile extends AppCompatActivity {

    ImageView imgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wandererprofile);

        imgbtn = (ImageView) findViewById(R.id.planView);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTrip();
            }
        });
    }

    private void createTrip()
    {

        startActivity(new Intent(WandererProfile.this, CreateTrip.class));
    }

}