package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        }
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