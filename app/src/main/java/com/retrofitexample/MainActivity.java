package com.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.retrofitexample.apiclient.ApiClient;
import com.retrofitexample.interfaces.ApiInterface;
import com.retrofitexample.model.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView tv_title, tv_id;
    ApiInterface apiInterface = new ApiClient().getApiInterface();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //method calls
        init();
        retrofitCall();
        //method calls
    }

    private void init() {
        tv_title = findViewById(R.id.tv_title);
        tv_id = findViewById(R.id.tv_id);
    }

    private void retrofitCall(){
        Call<Model> call = apiInterface.getData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Model model = response.body();
                tv_title.setText(model.getTitle());
                tv_id.setText(model.getId().toString());

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }
}