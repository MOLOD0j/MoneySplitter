package com.example.moneysplitter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class LoginIn extends AppCompatActivity {

    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        }

        addListenerOnButton();
    }


    public void addListenerOnButton () {
        enter = (Button) findViewById(R.id.inProfile);

        enter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Intent intent = new Intent("com.example.moneysplitter.Profile");
                        //startActivity(intent);
                                                /*//экземпляр класса SharedPreferences
                        //MODE_PRIVATE - режим работы
                        SharedPreferences prefs=getApplicationContext().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                        //файл настроек с таким именем "myPrefs" будет создан при вызове метода edit() (если его не существует)
                        //и фиксировании изменений с помощью метода commit()
                        //commit - устарел, лучше apply
                        SharedPreferences.Editor editor=prefs.edit();
                        //пример строки
                        String token = "some_jwt_token";
                        //записываем значение
                        editor.putString( "jwt_token", token );
                        editor.apply();

                        //проверим
                        String result = "";

                        prefs=getApplicationContext().getSharedPreferences("myPrefs",Context.MODE_PRIVATE);
                        result = prefs.getString("jwt_token","not found");

                        Toast toast = Toast.makeText(getApplicationContext(), result,Toast.LENGTH_SHORT);
                        toast.show();*/

                    }
                }
        );
    };
}