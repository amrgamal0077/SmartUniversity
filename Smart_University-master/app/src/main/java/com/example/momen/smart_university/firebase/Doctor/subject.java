package com.example.momen.smart_university.firebase.Doctor;

/**
 * Created by Momen on 10/23/2018.
 */

public class subject {
    public String name;
    public int code;
    public String year;
    public String department;
    public boolean section_check;
    public boolean available;
    public int number_of_lec;
    public QuizModel quizModel;
    public Note note;
    public Student_Absence student_absence;

    public subject(){}

    public subject(String name,int code,String year,String department,boolean available,QuizModel quizModel,int number_of_lec,boolean section_check,Student_Absence student_absence,Note note)
    {
        this.student_absence=student_absence;
        this.name = name;
        this.code = code;
        this.year = year;
        this.available = available;
        this.department=department;
        this.quizModel=quizModel;
        this.number_of_lec =number_of_lec;
        this.section_check=section_check;
        this.note = note;
    }

    public boolean isSection_check() {
        return section_check;
    }

    public void setSection_check(boolean section_check) {
        this.section_check = section_check;
    }

    public Student_Absence getStudent_absence() {
        return student_absence;
    }

    public void setStudent_absence(Student_Absence student_absence) {
        this.student_absence = student_absence;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean getAvailable() {
        return available;
    }

    public int getNumber_of_lec() {
        return number_of_lec;
    }

    public Note getNote() {
        return note;
    }

    public QuizModel getQuizModel() {
        return quizModel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void setNumber_of_lec(int number_of_lec) {
        this.number_of_lec = number_of_lec;
    }

    public void setQuizModel(QuizModel quizModel) {
        this.quizModel = quizModel;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
