package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

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
    public void addListenerOnButton () {
        Next = (Button) findViewById(R.id.Next);
        FName = (EditText) findViewById(R.id.FName);
        SecName = (EditText) findViewById(R.id.SecName);
        Email = (EditText) findViewById(R.id.Email);
        Phone = (EditText) findViewById(R.id.Phone);
        PassOriginal = (EditText) findViewById(R.id.PassOriginal);
        PassCopy = (EditText) findViewById(R.id.PassCopy);
        if (PassOriginal == PassCopy){
            Password = PassOriginal;
        }
        else {
            //todo проверить совпадают ли пароли. Если нет, придумать как остановить всё и выдать ошибку
        }
        Age = (EditText) findViewById(R.id.year);
        Male = (RadioButton) findViewById(R.id.male);
        Female = (RadioButton) findViewById(R.id.female);
        if (Male == null){
            Gender = Female;
        }
        else{
            Gender = Male;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://...";
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
        final String requestBody = jsonBody.toString();

        Next.setOnClickListener(v -> {// метод создание запроса
                    //todo задизейблить кнопку от многочисленного нажатия на неё, чтобы не отправлялось куча запросов на сервак
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> { // ответ от сервера
                        Log.i("VOLLEY", response);
                        Intent intent = new Intent("com.example.moneysplitter.RegistrationAddPhoto");
                        startActivity(intent);
                    }, error -> { // Если не все обязательные поля заполнены
                        Log.e("VOLLEY", error.toString());
                        Toast.makeText(
                                Registration.this, "Заполните все обязателььные поля", Toast.LENGTH_LONG
                        ).show();
                    }) {
                        @Override
                        public String getBodyContentType() { // формат запроса
                            return "application/json; charset=utf-8";
                        }

                        @Override
                        public byte[] getBody() { //если есть соединение с сервером добавить в тело запроса данные
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
    };
}