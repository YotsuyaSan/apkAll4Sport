package com.example.all4sport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

public class PageProduit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String product = null;

        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("value");

        try {
            String url = "http://192.168.81.2:3000/produits/get/" + str;
            product = APIConnection.get(url);
            Log.e("Produit: ", product);
        } catch (IOException e) {
            Log.e("Error: ", e.toString());
        }

        setContentView(R.layout.activity_page_produit);
    }
}