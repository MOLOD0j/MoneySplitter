package com.example.moneysplitter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button Friends;
    private Button ExpensesIncome;
    private Button Settings;
    private Button Feedback;
    private Button FAQ;
    private ImageButton Favorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton () {
        Friends = (Button) findViewById(R.id.Friends);
        ExpensesIncome = (Button) findViewById(R.id.ExpensesIncome);
        Settings = (Button) findViewById(R.id.Settings);
        Feedback = (Button) findViewById(R.id.Feedback);
        FAQ = (Button) findViewById(R.id.FAQ);
        Favorites = (ImageButton) findViewById(R.id.Favorites);

        Friends.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Friends");
                        startActivity(intent);
                    }
                }
        );

        ExpensesIncome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.ExpensesIncome");
                        startActivity(intent);
                    }
                }
        );

        Settings.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Settings");
                        startActivity(intent);
                    }
                }
        );

        Feedback.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Feedback");
                        startActivity(intent);
                    }
                }
        );

        FAQ.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.FAQ");
                        startActivity(intent);
                    }
                }
        );

        Favorites.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.moneysplitter.Favorites");
                        startActivity(intent);
                    }
                }
        );
    };

}