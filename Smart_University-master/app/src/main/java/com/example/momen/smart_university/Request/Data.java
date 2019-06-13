package com.example.momen.smart_university.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Momen on 6/9/2019.
 */

public class Data {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("message")
    @Expose
    private String message;

    public Data(String title,String message){
        this.title = title;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }
}
