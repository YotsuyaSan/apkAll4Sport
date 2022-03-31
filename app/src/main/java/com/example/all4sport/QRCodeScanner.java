package com.example.all4sport;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

public class QRCodeScanner extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "QRCodeScanner";

    BottomNavigationView bottomNavigationView;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scanner);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.scanner_button);
    }

    Scanner scannerFragment = new Scanner();
    Localisation localisationFragment = new Localisation();
    ListeProduits listeProduitsFragment = new ListeProduits();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.scanner_button:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, scannerFragment).commit();
                return true;

            case R.id.nav_produits:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, listeProduitsFragment).commit();
                return true;
            case R.id.disconnect_button:
                switchActivity();
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void switchActivity() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        switchActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(switchActivityIntent);
    }
}