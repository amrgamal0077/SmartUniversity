package com.example.momen.smart_university.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.momen.smart_university.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class AllowAttendance extends AppCompatActivity {
    private TextView code;
    private Button generate_code;
    private int  num_random;
    private RadioButton allow,not_allow;
    private RadioGroup rg;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allow_attendance);
        code= findViewById(R.id.code);
        generate_code=findViewById(R.id.generate_code);
        rg = findViewById(R.id.rg);
        allow = findViewById(R.id.allow);
        not_allow = findViewById(R.id.not_allow);
        generate_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random= new Random();
                num_random=random.nextInt(1000);
                firebaseDatabase=FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference().child("doctor").child("Momen").child("subject");
                databaseReference.child("code").setValue(num_random);
                code.setText(String.valueOf(num_random));
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.allow)
                    databaseReference.child("available").setValue(true);
                else if (checkedId == R.id.not_allow)
                    databaseReference.child("available").setValue(false);
            }
        });

    }
}
