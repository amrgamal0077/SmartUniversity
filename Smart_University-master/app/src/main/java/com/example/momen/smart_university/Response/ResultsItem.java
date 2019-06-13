package com.example.momen.smart_university.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Momen on 6/9/2019.
 */

public class ResultsItem {
    @SerializedName("message_id")
    @Expose
    private String message_id;

    public void setMessageId(String messageId){
        this.message_id = messageId;
    }

    public String getMessageId(){
        return message_id;
    }

    @Override
    public String toString(){
        return
                "ResultsItem{" +
                        "message_id = '" + message_id + '\'' +
                        "}";
    }
}
