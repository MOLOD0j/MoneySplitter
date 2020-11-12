package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewRoom extends AppCompatActivity {

    private Button go_back, go_new_position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_room);
        addListenerOnButton ();
    }
    public void addListenerOnButton (){
        go_back = (Button)findViewById(R.id.button2);
        go_back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent ("com.example.moneysplitter.Events");
                        startActivity(intent);
                    }
                }
        );

        go_new_position = (Button)findViewById(R.id.button8);
        go_new_position.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent ("com.example.moneysplitter.NewPosition");
                        startActivity(intent);
                    }
                }
        );
    }
}