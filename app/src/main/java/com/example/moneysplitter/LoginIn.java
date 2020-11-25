package com.example.moneysplitter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moneysplitter.utils.ServerRequest;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginIn extends AppCompatActivity {

    private Button enter;
    private EditText login;
    private EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        enter = (Button) findViewById(R.id.inProfile);
        login = (EditText) findViewById(R.id.editTextTextEmailAddress);
        pass = (EditText) findViewById(R.id.editTextTextPassword);


        enter.setOnClickListener(v -> {// метод создание запроса
                    //todo задизейблить кнопку от многочисленного нажатия на неё, чтобы не отправлялось куча запросов на сервак
                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody.put("Login: ", login);
                        jsonBody.put("Password", pass);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String transitionContextName = "com.example.moneysplitter.Profile";
                    String errorText = "Невырный логин или пароль";
                    ServerRequest.getInstance().Send(this, transitionContextName, errorText, jsonBody);
                }
        );
    }

    public EditText getLogin() {
        return login;
    }

    public void setLogin(EditText login) {
        this.login = login;
    }

    public EditText getPass() {
        return pass;
    }

    public void setPass(EditText pass) {
        this.pass = pass;
    }


}


