package com.example.pawedapp.Retrofit;

import com.example.pawedapp.APIModels.AuthResponse;
import com.example.pawedapp.APIModels.UserModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

////    now create an api ...for endpoints ---where we have to mention all the API's
//    ----login ek end point hai aur register ek jaise to hrkaa hum instance bnaynge


// Login APi

    @POST ("login")
    Call<AuthResponse> doLogin(@Body UserModels user);



//    Register Api

    @POST("register")
    Call<AuthResponse> registerUser(@Body UserModels user);

//    Get ALl Users


//    Get User By Id





}
