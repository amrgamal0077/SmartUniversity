package com.example.momen.smart_university.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.momen.smart_university.fragment.Mon;
import com.example.momen.smart_university.fragment.Sun;
import com.example.momen.smart_university.fragment.Thurs;
import com.example.momen.smart_university.fragment.Tues;
import com.example.momen.smart_university.fragment.Wed;

public class PageAdapter extends FragmentPagerAdapter {
    private int numoftab;
    private String docOrStu;
    public PageAdapter(FragmentManager fm,int numoftab,String docOrStu ) {
        super(fm);
        this.docOrStu = docOrStu;
        this.numoftab=numoftab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Sun.getType(docOrStu);
            case 1:
                return Mon.getType(docOrStu);
            case 2:
                return Tues.getType(docOrStu);
            case 3:
                return Wed.getType(docOrStu);
            case 4:
                return Thurs.getType(docOrStu);
            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "sun";
            case 1:
                return "Mon";
            case 2:
                return "Tues";
            case 3:
                return "Wed" ;
            case 4:
                return "Thurs";


        }
        return "";
    }
    @Override
    public int getCount() {
        return numoftab;
    }
}
