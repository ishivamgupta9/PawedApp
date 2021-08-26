package com.example.pawedapp.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.pawedapp.R;

public class RegisterPage extends AppCompatActivity {


    EditText userName,password,name,breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
    }
}