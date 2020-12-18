package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationAddPhoto extends AppCompatActivity {

    private Button BackReg;
    private Button NextEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_add_photo);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        }
        addListenerOnButton();
    }
    public void addListenerOnButton () {
        BackReg = (Button) findViewById(R.id.BackReg);
        NextEvents = (Button) findViewById(R.id.NextEvents);

        BackReg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Registration");
                        startActivity(intent);
                    }
                }
        );

        NextEvents.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Profile");
                        startActivity(intent);
                    }
                }
        );
    };
}