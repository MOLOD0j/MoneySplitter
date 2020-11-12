package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Room extends AppCompatActivity {

    private ImageButton go_to_events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        addListenerOnButton ();
    }

    public void addListenerOnButton (){
        go_to_events = (ImageButton)findViewById(R.id.EventBack);

        go_to_events.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent ("com.example.moneysplitter.Events");
                        startActivity(intent);
                    }
                }
        );
    }
}