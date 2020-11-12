package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewPosition extends AppCompatActivity {

    private Button go_to_event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_position);
        addListenerOnButton ();
    }
    public void addListenerOnButton (){
        go_to_event = (Button)findViewById(R.id.button3);

        go_to_event.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent ("com.example.moneysplitter.NewRoom");
                        startActivity(intent);
                    }
                }
        );
    }
}