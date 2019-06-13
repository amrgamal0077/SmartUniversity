package com.example.momen.smart_university.Activites;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.momen.smart_university.Adapter.StudentListAdapter;
import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.Doctor;
import com.example.momen.smart_university.firebase.Student.Students;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDoctor extends AppCompatActivity {

    EditText doctor_name,doctor_id;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String name,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        doctor_id = findViewById(R.id.doctor_id);
        doctor_name = findViewById(R.id.doctor_name);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Doctors");

        Button save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = doctor_name.getText().toString();
                id =  doctor_id.getText().toString() ;
                databaseReference.child(name).setValue(new Doctor(Integer.valueOf(id) ,name,null,null));
                reset();
            }
        });

    }


    private void reset()
    {
        this.doctor_name.setText("");
        this.doctor_id.setText("");
    }
}