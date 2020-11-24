package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


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

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://...";
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("Login: ", login);
            jsonBody.put("Password", pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String requestBody = jsonBody.toString();


        enter.setOnClickListener(v -> {
            //todo задизейблить кнопку от многочисленного нажатия на неё, чтобы не отправлялось куча запросов на сервак
                    // метод создание запроса
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> { // ответ от сервера
                        Log.i("VOLLEY", response);
                        Intent intent = new Intent("com.example.moneysplitter.Profile"); // если ответ пришёл верный, то переходим на профиль
                        startActivity(intent);
                    }, error -> { // если получен ответ от сервера и он говорит что ошибка
                        Log.e("VOLLEY", error.toString());
                        //todo добавить запись на жкране что логин\пароль не вырные

                    }) {
                        @Override
                        public String getBodyContentType() { // формат запроса
                            return "application/json; charset=utf-8";
                        }

                        @Override
                        public byte[] getBody() throws AuthFailureError { //если есть соединение с сервером добавить в тело запроса данные
                            try {
                                return requestBody == null ? null : requestBody.getBytes("utf-8");
                            } catch (UnsupportedEncodingException uee) {
                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                                return null;
                            }
                        }

                        @Override
                        protected Response<String> parseNetworkResponse(NetworkResponse response) { //обработка ответа (парсинг ответа и проврека кода насколько я понял)
                            String responseString = "";
                            if (response != null) {
                                responseString = String.valueOf(response.statusCode);
                                // can get more details such as response.headers
                            }
                            return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                        }
                    };

                    requestQueue.add(stringRequest);
                }
        );
    }

    ;

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


