package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Events extends AppCompatActivity {

    private Button go_to_new_room;
    private Button go_to_room;
    private ImageButton ProfFav;
    private ImageButton Favor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        }
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        go_to_new_room = (Button) findViewById(R.id.button);
        go_to_room = (Button) findViewById(R.id.inProfile);
        ProfFav = (ImageButton) findViewById(R.id.imageButton2);
        Favor = (ImageButton) findViewById(R.id.imageButton4);

        go_to_new_room.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.NewRoom");
                        startActivity(intent);
                    }
                }
        );
        go_to_room.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Room");
                        startActivity(intent);
                    }
                }
        );

        ProfFav.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Favorites");
                        startActivity(intent);
                    }
                }
        );

        Favor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Profile");
                        startActivity(intent);
                    }
                }
        );
    }
}