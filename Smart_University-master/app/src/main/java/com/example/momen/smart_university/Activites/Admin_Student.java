package com.example.momen.smart_university.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.momen.smart_university.Adapter.StudentListAdapter;
import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Student.Students;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Admin_Student extends AppCompatActivity implements StudentListAdapter.StudentClickListener {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecyclerView recyclerViewStudent;
    List<Students> students;
    String year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__student);
        year = getIntent().getStringExtra("year");
        students = new ArrayList<>();
        recyclerViewStudent = findViewById(R.id.admin_student_recycler);
        recyclerViewStudent.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference().child("Students").child(year);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Students student = dataSnapshot.getValue(Students.class);
                students.add(student);
                StudentListAdapter studentListAdapter = new StudentListAdapter(students, Admin_Student.this,Admin_Student.this);
                recyclerViewStudent.setAdapter(studentListAdapter);

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







        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Admin_Student.this,Add_Student.class);
                intent.putExtra("Year",year);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onListItemClick(int position) {
        Intent intent = new Intent(Admin_Student.this,Add_Student.class);
        intent.putExtra("Year",year);
        intent.putExtra("name",students.get(position).getS_name());
        startActivity(intent);
    }
}
