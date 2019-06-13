package com.example.momen.smart_university.firebase.Doctor;

import android.text.Editable;

/**
 * Created by Momen on 10/23/2018.
 */

public class Questions {

    public String question;
    public String answer1;
    public String answer2;
    public String answer3;
    public String answer4;
    public String correctAnswer;
    public float degree;

    public  Questions(){}

    public Questions(String question,String answer1,String answer2,String answer3,String answer4,String correctAnswer,float degree)
    {
        this.degree=degree;
        this.question=question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;

    }
    public Questions(Editable text, Editable answer1Text, Editable answer2Text, Editable answer3Text, Editable answer4Text, Editable correctText){}


    public float getDegree() {
        return degree;
    }

    public void setDegree(float degree) {
        this.degree = degree;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {this.answer3 = answer3;}

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }


}
