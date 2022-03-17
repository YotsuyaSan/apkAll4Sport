package com.example.all4sport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button connection_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_page);

        this.connection_btn = (Button) findViewById(R.id.btn);

        EditText login = (EditText) findViewById(R.id.login);
        EditText pwd = (EditText) findViewById(R.id.pwd);
        
        this.connection_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String token = null;
                try {
                    String url = "http://192.168.81.2:3000/connection/user/" + login + "/pswd/" + pwd;
                    token = APIConnection.get(url);
                    switchActivity(token);
                    Toast toast = Toast.makeText(MainActivity.this, token, Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("aaaaaaa", token);
                } catch (IOException e) {
                    Log.e("OEEEEEEEEEE C'EST LA D", e.toString());
                }
            }
        });

    }


    private void switchActivity(String token) {
        Intent switchActivityIntent = new Intent(this, QRCodeScanner.class);
        switchActivityIntent.putExtra("token", token);
        startActivity(switchActivityIntent);
    }

}