package com.example.momen.smart_university.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Momen on 6/9/2019.
 */

public class UniversityRetofit {
    private static Retrofit retrofit = null;



    public static Retrofit getRetrofit(){
        if (retrofit == null){

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .writeTimeout(10, TimeUnit.MINUTES)
                    .readTimeout(10, TimeUnit.MINUTES)
                    .addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://fcm.googleapis.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            return retrofit;

        }
        return retrofit;
    }
}
