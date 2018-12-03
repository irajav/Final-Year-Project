package com.example.barang.fyp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register();
        registerWG();
        wandererlogin();

    }

    private void register() {
        TextView registerNow = (TextView) findViewById(R.id.registerNow);
        registerNow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
    }

    private void registerWG()
    {
        TextView registerNow = (TextView) findViewById(R.id.registerNowWG);
        registerNow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
    }


    private void wandererlogin()
    {
        Button wandererBtn = (Button)findViewById(R.id.wandererBtn);
        wandererBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,WandererLogin.class));
            }
        });
    }



}

