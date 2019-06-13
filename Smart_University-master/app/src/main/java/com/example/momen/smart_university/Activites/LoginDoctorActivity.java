package com.example.momen.smart_university.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.Doctor;
import com.example.momen.smart_university.firebase.Doctor.DoctorName;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class LoginDoctorActivity extends AppCompatActivity {

    EditText id_doc_et;
    List<Doctor> doctors;
    boolean chk = false;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Doctors");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_doctor);

        id_doc_et = findViewById(R.id.id_doc_et);

        doctors = new ArrayList<>();


    }

    public void click(View view) {
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Doctor doctor = dataSnapshot.getValue(Doctor.class);
                doctors.add(doctor);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if (doctors.size() != 0) {
            Toast.makeText(this, String.valueOf(doctors.get(1).getId()), Toast.LENGTH_SHORT).show();
            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getId() == Integer.parseInt(id_doc_et.getText().toString())) {
                    DoctorName.doctorName = doctors.get(i).getName();
                    chk = true;
                }
            }
            if (chk) {
                Intent intent = new Intent(LoginDoctorActivity.this, DocorActivity.class);
                startActivity(intent);
            } else Toast.makeText(this, "doctor is not exist", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "No Internet Found", Toast.LENGTH_SHORT).show();
    }
}
