package com.example.all4sport;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

public class QRCodeScanner extends AppCompatActivity {


    Button btScan;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scanner);

        //Initialize intent integrator
        IntentIntegrator intentIntegrator = new IntentIntegrator(
                QRCodeScanner.this
        );
        //Set prompt text
        intentIntegrator.setPrompt("For flash use volume up key");
        intentIntegrator.setCaptureActivity(CaptureActivityPortrait.class);
        //Set beep
        intentIntegrator.setBeepEnabled(true);
        //Locked orientation
        intentIntegrator.setOrientationLocked(false);
        //Initiate scan
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //Initialize intent result
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode,data
        );
        //Check condition
        if(intentResult.getContents() != null) {

            switchActivity(intentResult.getContents());
        }else{
            //When result content is null
            //Display toast
            Toast.makeText(getApplicationContext(), "OOPS... You did not scan anything", Toast.LENGTH_SHORT).show();
        }
    }

    private void switchActivity(String str) {
        Intent switchActivityIntent = new Intent(this, PageProduit.class);
        switchActivityIntent.putExtra("value", str);
        startActivity(switchActivityIntent);
    }
}