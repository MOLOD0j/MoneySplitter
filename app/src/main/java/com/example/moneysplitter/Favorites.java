package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Favorites extends AppCompatActivity {

    private ImageButton Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        addListenerOnButton();
    }

    public void addListenerOnButton () {

        Profile = (ImageButton) findViewById(R.id.Profile);

        Profile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("android.intent.action.MAIN");
                        startActivity(intent);
                    }
                }
        );
    };
}