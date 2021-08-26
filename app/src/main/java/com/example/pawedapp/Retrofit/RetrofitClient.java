package com.example.pawedapp.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static Retrofit retrofit=null;
    public static final String BASE_URL="https://pawedu-backend.herokuapp.com/api/";

    public RetrofitClient(){

    }

    public static Retrofit getRetrofit(){
        if(retrofit==null){
            Gson gson=new GsonBuilder().setLenient().create();

            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

//                    converter jo jason ko java object me convert parsal banayga//by library convereter gson
        }

        return retrofit;
    }

}


/////////1st step completed building the singleton instance class for retrofit.

///now create an api ...for endpoints ---where we have to mention all the API's