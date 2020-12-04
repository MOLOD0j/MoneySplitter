package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private Button Next;
    private EditText Text1;
    private EditText Text2;
    private RadioButton Radio1;
    private RadioButton Radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        }
        addListenerOnButton();
    }
    public void addListenerOnButton () {
        Next = (Button) findViewById(R.id.Next);
        Text1 = (EditText) findViewById(R.id.editTextNumberPassword);
        Text2 = (EditText) findViewById(R.id.editTextNumberPassword2);

        Next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String pass = String.valueOf(Text1.getText());
                        String pass2 = String.valueOf(Text2.getText());

                        if (pass.length() < 8 || pass2.length() < 8){
                            Toast toast = Toast.makeText(getApplicationContext(), "Пароль должен быть не менее 8 символов",Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else if (!pass.equals(pass2)) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Пароли не совпадают",Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else{
                            Intent intent = new Intent("com.example.moneysplitter.RegistrationAddPhoto");
                            startActivity(intent);
                        }

                    }
                }
        );
    };
}