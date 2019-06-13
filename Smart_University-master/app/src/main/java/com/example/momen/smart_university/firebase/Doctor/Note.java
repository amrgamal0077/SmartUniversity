package com.example.momen.smart_university.firebase.Doctor;

public class Note {
    public  String content;

    public  Note(){

    }
    public  Note(String content){
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
