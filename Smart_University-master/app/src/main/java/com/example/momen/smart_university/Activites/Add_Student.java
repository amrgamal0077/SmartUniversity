package com.example.momen.smart_university.Activites;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

public class Add_Student extends AppCompatActivity {

    String student_name;
    Spinner department_spinner;
    EditText student_name_id,student_id,section_id;
    String year;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String depart;
    String name;
    @NonNull String id;
    @NonNull String section;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student);

        department_spinner = findViewById(R.id.spinner_department);
        final ArrayAdapter<CharSequence> arrayAdapter_spec = ArrayAdapter.createFromResource(this, R.array.specialize, android.R.layout.simple_spinner_item);
        department_spinner.setAdapter(arrayAdapter_spec);
        student_name_id = findViewById(R.id.student_name_id);
        student_id = findViewById(R.id.student_id);
        section_id = findViewById(R.id.section_id);


        firebaseDatabase  = FirebaseDatabase.getInstance();
        year = getIntent().getStringExtra("Year");
        if (getIntent().getStringExtra("name")!=null) {
            student_name = getIntent().getStringExtra("name");
            DatabaseReference databaseReference1=firebaseDatabase.getReference().child("Students").child(year);
            databaseReference1.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {

                    Students students = dataSnapshot.getValue(Students.class);
                    if (students.getS_name().equals(student_name)){
                        name = students.getS_name();
                        id = students.getS_id() ;
                        Toast.makeText(Add_Student.this, id, Toast.LENGTH_SHORT).show();
                        section = students.getSection_num();
                        depart = students.getDepartment();

                        department_spinner.setSelection(arrayAdapter_spec.getPosition(depart));
                        student_name_id.setText(student_name);
                        section_id.setText(section);
                        student_id.setText(id);
                    }
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

        }
        databaseReference = firebaseDatabase.getReference().child("Students").child(year);

    }

    public void save(View view) {
        depart =  department_spinner.getSelectedItem().toString();
        name = student_name_id.getText().toString();
        id =  student_id.getText().toString() ;
        section = section_id.getText().toString() ;
        databaseReference.child(name).setValue(new Students(id,name,depart,section,null,changeYearToInt(year)));
        Toast.makeText(this, "Student is added", Toast.LENGTH_SHORT).show();
    }
    private int changeYearToInt(String year){
        if (year.equals("First"))
            return 1;
        else if (year.equals("Second"))
            return 2;
        else if (year.equals("Third"))
            return 3;
        else if (year.equals("Fourth"))
            return 4;
        else
            return -1;
    }
}
