package com.example.momen.smart_university.firebase.Doctor;

import java.util.List;

/**
 * Created by Momen on 12/3/2018.
 */

public class QuizModel {
    private boolean pushed;
    private List<Questions> questions;
    private float time;
    private  int total_degree;
    public QuizModel(){
    }

    public QuizModel(boolean pushed,List<Questions> questions,float time,int total_degree){
        this.time=time;
        this.pushed = pushed;
        this.questions =questions;
        this.total_degree=total_degree;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getTotal_degree() {
        return total_degree;
    }

    public void setTotal_degree(int total_degree) {
        this.total_degree = total_degree;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public void setPushed(boolean pushed) {
        this.pushed = pushed;
    }

    public boolean getPushed() {
        return pushed;
    }

}
