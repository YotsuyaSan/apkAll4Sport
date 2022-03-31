package com.example.all4sport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
                String res;
                try {
                    String url = "http://192.168.81.2:3000/connection/user/" + login.getText() + "/pswd/" + pwd.getText();
                    res = APIConnection.get(url);

                    JSONArray mJsonArray = new JSONArray(res);
                    JSONObject mJsonObject = mJsonArray.getJSONObject(0);

                    String token = mJsonObject.getString("token");
                    if (!token.equals("null")) {
                        switchActivity(token);
                    } else {
                        Toast toto = Toast.makeText( MainActivity.this, "Identifiant ou mot de passe incorrect", Toast.LENGTH_LONG);
                        toto.show();
                    }

                    Log.e("Token", token);
                } catch (IOException | JSONException e) {
                    Log.e("Error", e.toString());
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