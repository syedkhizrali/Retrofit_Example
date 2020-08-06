package com.retrofitexample.interfaces;

import com.retrofitexample.model.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/todos/1")
    Call<Model> getData();
}
