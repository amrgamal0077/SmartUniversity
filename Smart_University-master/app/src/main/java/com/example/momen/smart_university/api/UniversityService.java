package com.example.momen.smart_university.api;

import com.example.momen.smart_university.Request.RequestUniversity;
import com.example.momen.smart_university.Response.ResponseUniversity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Momen on 6/9/2019.
 */

public interface UniversityService {
    @Headers({"Authorization: key=AIzaSyDbCAjd0zHLReJk48vByhLarGdxhEqjxuc",
            "Content-Type:application/json"})
    @POST("fcm/send")
    Call<ResponseUniversity> sendData(@Body RequestUniversity requestSquawk);
}
