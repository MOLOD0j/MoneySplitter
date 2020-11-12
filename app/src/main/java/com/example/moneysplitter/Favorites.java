package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Favorites extends AppCompatActivity {

    private ImageButton ProfFav, Event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        addListenerOnButton();
    }

    public void addListenerOnButton () {

        ProfFav = (ImageButton) findViewById(R.id.ProfFav);
        Event = (ImageButton) findViewById(R.id.Event);

        ProfFav.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Profile");
                        startActivity(intent);
                    }
                }
        );

        Event.setOnClickListener(
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