package com.example.momen.smart_university.firebase.Doctor;
/**
 * Created by Momen on 10/23/2018.
 */

public class Doctor {


    private int id;
    private String name;
    private subject subject;
    private Office_Hour office_hour;

    public Doctor(){}

    public Doctor(int id,String name,subject subject,Office_Hour office_hour ){

        this.id=id;
        this.name=name;
        this.subject=subject;
        this.office_hour=office_hour;
    }

    public Office_Hour getOffice_hour() {
        return office_hour;
    }

    public subject getSubject() {
        return subject;
    }

    public void setOffice_hour(Office_Hour office_hour) {
        this.office_hour = office_hour;
    }

    public void setSubject(subject subject) {
        this.subject = subject;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
