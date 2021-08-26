package com.example.pawedapp.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pawedapp.APIModels.AuthResponse;
import com.example.pawedapp.APIModels.UserModels;
import com.example.pawedapp.MainActivity;
import com.example.pawedapp.R;
import com.example.pawedapp.Retrofit.API;
import com.example.pawedapp.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginPage extends AppCompatActivity {

    EditText userName,password;
    Button login;
    private API api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login_page);


        userName=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);


        Retrofit retrofit = RetrofitClient.getRetrofit();
        api = retrofit.create(API.class);






        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userName.getText().toString().equals("")) {
                    Toast.makeText(login.getContext(), "enter a username first", Toast.LENGTH_LONG).show();

                }
                if (password.getText().toString().equals("")) {
                    Toast.makeText(login.getContext(), "enter a password to Login!", Toast.LENGTH_LONG).show();


                }
                loginUser();
            }
        });


    }


    private void loginUser() {
        UserModels user=new UserModels(userName.getText().toString().trim(),password.getText().toString().trim());
        //ab call ko use krenge

        Call<AuthResponse> loginCall=api.doLogin(user);

        loginCall.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(LoginPage.this,"Success\nUserID"+response.body().getId(),Toast.LENGTH_SHORT).show();

                    SharedPreferences sharedPreferences=getSharedPreferences("PawedPref",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();

                    editor.putString("TOKEN",response.body().getToken());
                    editor.putString("USERID",response.body().getId());
                    editor.commit();


                    startActivity(new Intent(LoginPage.this, MainActivity.class));





                }else
                {if(response.code()==401){
                    Toast.makeText(LoginPage.this,"Failed\nCode:"+response.code(),Toast.LENGTH_SHORT).show();
                }}
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Toast.makeText(LoginPage.this,"Failed\nError:"+t.toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }}