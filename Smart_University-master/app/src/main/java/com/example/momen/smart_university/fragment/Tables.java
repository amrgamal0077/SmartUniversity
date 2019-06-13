package com.example.momen.smart_university.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.subject;
import com.example.momen.smart_university.firebase.Table.Table_model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Momen on 6/9/2019.
 */

public class Tables extends Fragment {

    Spinner spec,doc,year,day;
    EditText from,to,secNum,subject,room;
    Button save;
    DatabaseReference referenceDoc,referenceTable;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.table_fragment,container,false);
        spec = view.findViewById(R.id.spinner_spec);
        doc = view.findViewById(R.id.spinner_doc);
        year = view.findViewById(R.id.spinner_year);
        day = view.findViewById(R.id.spinner_day);
        from = view.findViewById(R.id.from);
        to = view.findViewById(R.id.to);
        secNum = view.findViewById(R.id.secNum);
        subject = view.findViewById(R.id.sub);
        room = view.findViewById(R.id.roomNum);
        save = view.findViewById(R.id.save_table);

        referenceDoc = FirebaseDatabase.getInstance().getReference().child("Doctors").child("momen").child("Subjects");
        referenceTable = FirebaseDatabase.getInstance().getReference().child("Table");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                referenceTable.child(subject.getText().toString()).setValue(new Table_model("momen",subject.getText().toString(),
                        Integer.parseInt(room.getText().toString()),Float.parseFloat(from.getText().toString()),Float.parseFloat(to.getText().toString())
                        ,Integer.parseInt(secNum.getText().toString()),year.getSelectedItem().toString(),day.getSelectedItem().toString()));


                referenceDoc.child(subject.getText().toString()).setValue(new subject(subject.getText().toString(),0,
                        year.getSelectedItem().toString(),
                        spec.getSelectedItem().toString(),false,null,0,true,
                        null,null));



            }
        });
        return view;
    }
}
