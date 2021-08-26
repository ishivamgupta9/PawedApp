package com.example.pawedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
String token,uid;
SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPref= getSharedPreferences("pawedUPref", Context.MODE_PRIVATE);

        token=sharedPref.getString("TOKEN","");
        uid=sharedPref.getString("USERID","");
        Toast.makeText(this,token,Toast.LENGTH_SHORT).show();

    }
}