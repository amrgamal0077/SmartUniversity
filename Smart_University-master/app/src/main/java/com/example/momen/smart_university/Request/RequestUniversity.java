package com.example.momen.smart_university.Request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Momen on 6/9/2019.
 */

public class RequestUniversity {
    @SerializedName("data")
    private Data data;
    @SerializedName("to")
    private String to;

    public RequestUniversity(String to , Data data){
        this.to = to;
        this.data = data;
    }

    public void setData(Data data){
        this.data = data;
    }

    public Data getData(){
        return data;
    }

    public void setTo(String to){
        this.to = to;
    }

    public String getTo(){
        return to;
    }
}
