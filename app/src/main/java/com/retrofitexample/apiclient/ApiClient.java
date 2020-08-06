package com.retrofitexample.apiclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retrofitexample.interfaces.ApiInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static HttpLoggingInterceptor.Level HTTPLogLevel = HttpLoggingInterceptor.Level.BODY;
    private ApiInterface apiInterface;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public ApiClient() {
        Gson gson = new GsonBuilder()
                .setDateFormat("'yyyy'-'mm'-'dd'")
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HTTPLogLevel);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("https://jsonplaceholder.typicode.com/")
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiInterface = retrofit.create(ApiInterface.class);

    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }
}
