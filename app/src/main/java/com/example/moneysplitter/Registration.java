package com.example.moneysplitter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moneysplitter.utils.ServerRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Registration extends AppCompatActivity {

    private Button Next;
    private EditText FName, SecName, Email, Phone, PassOriginal, PassCopy, Age, Password;
    private RadioButton Gender, Male, Female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        Next = (Button) findViewById(R.id.Next);
        FName = (EditText) findViewById(R.id.FName);
        SecName = (EditText) findViewById(R.id.SecName);
        Email = (EditText) findViewById(R.id.Email);
        Phone = (EditText) findViewById(R.id.Phone);
        PassOriginal = (EditText) findViewById(R.id.PassOriginal);
        PassCopy = (EditText) findViewById(R.id.PassCopy);
        if (PassOriginal == PassCopy) {
            Password = PassOriginal;
        } else {
            //todo проверить совпадают ли пароли. Если нет, придумать как остановить всё и выдать ошибку
        }
        Age = (EditText) findViewById(R.id.year);
        Male = (RadioButton) findViewById(R.id.male);
        Female = (RadioButton) findViewById(R.id.female);
        if (Male == null) {
            Gender = Female;
        } else {
            Gender = Male;
        }


        Next.setOnClickListener(v -> {// метод создание запроса
                    //todo задизейблить кнопку от многочисленного нажатия на неё, чтобы не отправлялось куча запросов на сервак
                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody.put("Name: ", FName);
                        jsonBody.put("Surname: ", SecName);
                        jsonBody.put("Email: ", Email);
                        jsonBody.put("Phone: ", Phone);
                        jsonBody.put("Password: ", Password);
                        jsonBody.put("Age: ", Age);
                        jsonBody.put("Gender: ", Gender);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String transitionContextName = "com.example.moneysplitter.RegistrationAddPhoto";
                    String errorText = "Заполните все обязателььные поля";
                    ServerRequest.getInstance().Send(this, transitionContextName, errorText, jsonBody);
                }
        );
    }

    ;
}