package com.example.momen.smart_university.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.momen.smart_university.Activites.Admin_Student;
import com.example.momen.smart_university.R;

/**
 * Created by Momen on 3/18/2019.
 */

public class Students extends Fragment {

    Button firstBtn,secondBtn,thirdBtn,fourthBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.student_fragment,container,false);
        firstBtn = view.findViewById(R.id.first_id);
        secondBtn = view.findViewById(R.id.second_id);
        thirdBtn = view.findViewById(R.id.third_id);
        fourthBtn = view.findViewById(R.id.fourth_id);
        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Admin_Student.class);
                intent.putExtra("year","First");
                startActivity(intent);
            }
        });
        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Admin_Student.class);
                intent.putExtra("year","Second");
                startActivity(intent);
            }
        });
        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Admin_Student.class);
                intent.putExtra("year","Third");
                startActivity(intent);
            }
        });
        fourthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Admin_Student.class);
                intent.putExtra("year","Fourth");
                startActivity(intent);
            }
        });
        return view;
    }
}
