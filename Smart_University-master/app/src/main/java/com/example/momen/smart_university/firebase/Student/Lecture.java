package com.example.momen.smart_university.firebase.Student;

import java.util.List;

public class Lecture {
    public List<Float> quizDegrees;
    public String name;
    public List<String> attendances;
    public int num_lecture;


    public Lecture() {

    }
    public Lecture(String Sub_name,  List<String> attendances,List<Float> quizDegrees,int num_lecture)

    {
        this.quizDegrees=quizDegrees;
        this.attendances=attendances;
         this.name =Sub_name;
        this.num_lecture=num_lecture;

    }

    public int getNum_lecture() {
        return num_lecture;
    }

    public void setNum_lecture(int num_lecture) {
        this.num_lecture = num_lecture;
    }

    public List<String> getAttendances() {
        return attendances;
    }

    public List<Float> getQuizDegrees() {
        return quizDegrees;
    }

    public void setAttendances(List<String> attendances) {
        this.attendances = attendances;
    }

    public void setQuizDegrees(List<Float> quiz) {
        this.quizDegrees = quizDegrees;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }


}
