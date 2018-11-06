package com.example.barang.fyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class WandererLogin extends AppCompatActivity {

    EditText loginUsername, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wanderer_login);

        loginUsername = (EditText)findViewById(R.id.loginUsername);
        loginPassword = (EditText)findViewById(R.id.loginPassword);
    }

    public void OnLogin(View view)
    {
        String username = loginUsername.getText().toString();
        String password = loginPassword.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }
}
