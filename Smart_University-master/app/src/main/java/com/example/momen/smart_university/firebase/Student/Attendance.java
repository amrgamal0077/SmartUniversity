package com.example.momen.smart_university.firebase.Student;

import java.util.List;

/**
 * Created by Momen on 11/12/2018.
 */

public class Attendance {
    public Attendance(){}
    public Attendance(List<String> dates)
    {
        this.dates=dates;
    }
    List<String> dates;



    public List<String> getDate() {
        return dates;
    }

    public void setDate(List<String> dates) {
        this.dates = dates;
    }
}
