package com.example.momen.smart_university.firebase.Student;

/**
 * Created by Momen on 11/12/2018.
 */

public class Students {
    public Subjects subjects;
    public String section_num;
    public String s_id;
    public String department;
    public String s_name;
    public int year;
    public Students() {
    }

    public Students(String S_id, String S_name, String Specialization, String Section, Subjects subjects, int year) {
        this.subjects=subjects;
        s_id = S_id;
        s_name = S_name;
        department = Specialization;
        section_num = Section;
        this.year = year;
    }

//get and set

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }
    public String getS_name() {
        return s_name;
    }
    public void setS_name(String s_name) {
        this.s_name = s_name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getSection_num() {
        return section_num;
    }
    public void setSection_num(String section_num) {
        this.section_num = section_num;
    }
    public String getS_id() {
        return s_id;
    }

}
