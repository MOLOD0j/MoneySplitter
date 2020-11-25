package com.example.moneysplitter.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class ServerRequest {
    private static ServerRequest instance;

    public static synchronized ServerRequest getInstance() {
        if (instance == null) {
            instance = new ServerRequest();
        }
        return instance;
    }

    public void Send(Context currentContext, String transitionContextName, String errorText, JSONObject jsonBody) {
        RequestQueue requestQueue = Volley.newRequestQueue(currentContext);
        String URL = "http://...";
        final String requestBody = jsonBody.toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> { // ответ от сервера
            Log.i("VOLLEY", response);
            Intent intent = new Intent(transitionContextName);
            currentContext.startActivity(intent);
        }, error -> { // Если не все обязательные поля заполнены
            Log.e("VOLLEY", error.toString());
            Toast.makeText(currentContext, errorText, Toast.LENGTH_LONG).show();
        }) {
            @Override
            public String getBodyContentType() { // формат запроса
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() { //если есть соединение с сервером добавить в тело запроса данные
                return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
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
}


