package com.example.momen.smart_university.firebase.Student;

import com.example.momen.smart_university.firebase.Student.Attendance;

/**
 * Created by Momen on 11/12/2018.
 */

public class Subjects  {

    public Lecture lecture;
    public Degree  degree;
    public Section section;

    public Subjects( )
    {

    }
    public Subjects( Lecture lecture, Degree  degree, Section section)
    {

        this.degree=degree;
        this.lecture=lecture;
        this.section=section;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Degree getDegree() {
        return degree;
    }


    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
