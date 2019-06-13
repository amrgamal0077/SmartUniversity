package com.example.momen.smart_university.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Student.Students;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ChildEventListener listener;
    private EditText editText;
    private boolean chk = false;
    private List<Students> studentsList;
    private Spinner spinner;
    String year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Smart University");
        firebaseDatabase = FirebaseDatabase.getInstance();
        editText = (EditText)findViewById(R.id.id_Et);
        studentsList = new ArrayList<>();
        spinner = findViewById(R.id.spinner_login);

    }
    public void click(View view) {

        year = spinner.getSelectedItem().toString();

        if (!year.equals("Select year")) {
            databaseReference = firebaseDatabase.getReference().child("Students").child(year);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot loginSnapshot : dataSnapshot.getChildren()){
                        Students students = loginSnapshot.getValue(Students.class);
                        studentsList.add(students);
                    }
                    for (int i = 0; i < studentsList.size(); i++) {
                        if (studentsList.get(i).getS_id().equals(editText.getText().toString())) {
                            StudentName.name = studentsList.get(i).getS_name();
                            StudentName.year = year;
                            chk = true;
                        }
                    }
                    if (chk) {
                        Intent intent = new Intent(Login.this, Student_Profile.class);
                        startActivity(intent);
                    } else Toast.makeText(Login.this, "student is not exist", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
        else
            Toast.makeText(this, "please select year", Toast.LENGTH_SHORT).show();
    }

}
