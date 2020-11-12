package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                        Intent intent = new Intent("com.example.moneysplitter.Events");
                        startActivity(intent);
                    }
                }
        );
    };
}