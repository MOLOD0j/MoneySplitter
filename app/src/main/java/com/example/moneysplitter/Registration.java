package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registration extends AppCompatActivity {

    //private Button BackStart;
    private Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        addListenerOnButton();
    }
    public void addListenerOnButton () {
      //  BackStart = (Button) findViewById(R.id.BackStart);
        Next = (Button) findViewById(R.id.Next);

       /* BackStart.setOnClickListener(               !!!!!!!!!1НЕ РАБОТАЕТ ВОЗВРАТ!!!!!!!!!!!!!!!!
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Main");
                        startActivity(intent);
                    }
                }
        );*/

        Next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.RegistrationAddPhoto");
                        startActivity(intent);
                    }
                }
        );
    };
}