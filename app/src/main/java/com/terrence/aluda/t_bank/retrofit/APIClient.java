package com.terrence.aluda.t_bank.retrofit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .callTimeout(100, TimeUnit.MINUTES)
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://laravel.terrence-aluda.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        //builder.client(httpClient.build());

        return retrofit;
    }

}
