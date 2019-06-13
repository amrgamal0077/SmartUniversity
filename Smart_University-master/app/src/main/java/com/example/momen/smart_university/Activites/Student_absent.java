package com.example.momen.smart_university.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.Doctor;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Student_absent extends AppCompatActivity {

    private DatabaseReference reference1;
    private DatabaseReference reference2;
    private ChildEventListener listener;
    private Button btn;
    private EditText editText;
    private TextView textView;
    private int code = 0;
    private String name = "";
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_absent);
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference1 = firebaseDatabase.getReference().child("doctor");
        databaseReference = firebaseDatabase.getReference().child("Attendances");
        setTitle("Absence");
        //Map<String,Doctor> map = new HashMap();
        //map.put("doctor1",new Doctor(2,"khaled",new subject("cs",105,"first","sunday",false,new Questions("ask","answer"))));
        //String key =reference1.push().getKey();
        //Doctor doctor = new Doctor(2,"Khaled",new subject("cs",105,"second","monday",false,new Questions("ask","answer")));
        //reference1.child("khaled").setValue(doctor);


        textView = (TextView) findViewById(R.id.code);
        btn = (Button) findViewById(R.id.finish) ;
        editText = (EditText) findViewById(R.id.editText);

      listener = new ChildEventListener() {
          @Override
          public void onChildAdded(DataSnapshot dataSnapshot, String s) {
              Doctor doctor = dataSnapshot.getValue(Doctor.class);
              if(doctor.getName().matches("Momen")){
                if(!doctor.getSubject().getAvailable())
                    btn.setVisibility(View.INVISIBLE);
                else
                {
                    btn.setVisibility(View.VISIBLE);
                    code = doctor.getSubject().getCode();
                }
            }
          }

          @Override
          public void onChildChanged(DataSnapshot dataSnapshot, String s) {

              Doctor doctor = dataSnapshot.getValue(Doctor.class);
              if(doctor.getName().matches("Momen")){
                  if(!doctor.getSubject().getAvailable())
                      btn.setVisibility(View.INVISIBLE);
                  else
                  {
                      btn.setVisibility(View.VISIBLE);
                      code = doctor.getSubject().getCode();
                  }
              }
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
      };
      reference1.addChildEventListener(listener);


    }

    public void done(View view){

        if(Integer.parseInt(editText.getText().toString()) == code)
        {
            Toast.makeText(this, "you are attendance", Toast.LENGTH_SHORT).show();
            databaseReference.push().setValue(StudentName.name);

        }

    }



}
