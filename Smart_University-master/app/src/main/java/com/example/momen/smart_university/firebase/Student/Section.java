package com.example.momen.smart_university.firebase.Student;

public class Section extends Lecture{

    public boolean section_available;

    public Section(boolean section_available)
    {
        this.section_available=section_available;


    }

    public Section()
    {


    }


    public void setSection_available(boolean section_available) {
        this.section_available = section_available;
    }

    public boolean getSection_available() {
           return section_available;

    }

}
