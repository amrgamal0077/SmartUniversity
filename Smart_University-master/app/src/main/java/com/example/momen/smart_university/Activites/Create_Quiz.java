package com.example.momen.smart_university.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.momen.smart_university.R;

public class Create_Quiz extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Create Quiz");
        setContentView(R.layout.activity_create__quiz);
        Spinner spinner_subjects=findViewById(R.id.spinner_subjects);
        editText  = findViewById(R.id.quiz_name);
        Spinner spinner_year=findViewById(R.id.spinner_year);
        Spinner spinner_spec=findViewById(R.id.spinner_spec);
        ArrayAdapter<CharSequence> arrayAdapter= ArrayAdapter.createFromResource(this,R.array.year,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_year.setAdapter(arrayAdapter);
        ArrayAdapter<CharSequence> arrayAdapter_spec= ArrayAdapter.createFromResource(this,R.array.specialize,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_spec.setAdapter(arrayAdapter_spec);
        ArrayAdapter<CharSequence> arrayAdapter_subject= ArrayAdapter.createFromResource(this,R.array.subjects,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_subjects.setAdapter(arrayAdapter_subject);
        Button button=findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Create_Quiz.this,Create_Question.class);
                if(!editText.getText().equals(null)||!editText.getText().equals("")) {
                    intent.putExtra("QuizName", editText.getText().toString());
                    startActivity(intent);
                }
                else Toast.makeText(Create_Quiz.this, "Enter the name of Quize", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
