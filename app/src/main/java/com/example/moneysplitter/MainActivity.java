package com.example.moneysplitter;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;



public class MainActivity extends AppCompatActivity {

    private Button butInput;
    private Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        }
        addListenerOnButton();
    }
    public void addListenerOnButton () {
        butInput = (Button) findViewById(R.id.butInput);
        registration = (Button) findViewById(R.id.registration);

        butInput.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.LoginIn");
                        startActivity(intent);
                    }
                }
        );

        registration.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Registration");
                        startActivity(intent);
                    }
                }
        );
    };

}