package com.example.momen.smart_university.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Momen on 6/9/2019.
 */

public class ResponseUniversity {
    @SerializedName("canonical_ids")
    @Expose
    private int canonical_ids;
    @SerializedName("success")
    @Expose
    private int success;
    @SerializedName("failure")
    @Expose
    private int failure;
    @SerializedName("results")
    @Expose
    private List<ResultsItem> results;
    @SerializedName("multicast_id")
    @Expose
    private long multicast_id;

    public void setCanonicalIds(int canonicalIds){
        this.canonical_ids = canonicalIds;
    }

    public int getCanonicalIds(){
        return canonical_ids;
    }

    public void setSuccess(int success){
        this.success = success;
    }

    public int getSuccess(){
        return success;
    }

    public void setFailure(int failure){
        this.failure = failure;
    }

    public int getFailure(){
        return failure;
    }

    public void setResults(List<ResultsItem> results){
        this.results = results;
    }

    public List<ResultsItem> getResults(){
        return results;
    }

    public void setMulticastId(long multicastId){
        this.multicast_id = multicastId;
    }

    public long getMulticastId(){
        return multicast_id;
    }

    @Override
    public String toString(){
        return
                "ResponseUniversity{" +
                        "canonical_ids = '" + canonical_ids + '\'' +
                        ",success = '" + success + '\'' +
                        ",failure = '" + failure + '\'' +
                        ",results = '" + results + '\'' +
                        ",multicast_id = '" + multicast_id + '\'' +
                        "}";
    }
}
