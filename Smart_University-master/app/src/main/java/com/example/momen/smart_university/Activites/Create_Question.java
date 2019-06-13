package com.example.momen.smart_university.Activites;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.Questions;
import com.example.momen.smart_university.firebase.Doctor.QuizModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Create_Question extends AppCompatActivity {

    EditText question,answer1,answer2,answer3,answer4,correct;
    Button Add ,Save ;
    List<Questions> questionsList;
    QuizModel quizModel;
    DatabaseReference   databaseReference;
    FirebaseDatabase firebaseDatabase;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__question);
        question = findViewById(R.id.question);
        answer1=findViewById(R.id.answer1);
        answer2=findViewById(R.id.answer2);
        answer3=findViewById(R.id.answer3);
        answer4=findViewById(R.id.answer4);
        correct=findViewById(R.id.correct);
        Add = findViewById(R.id.add);
        Save = findViewById(R.id.save);
        questionsList = new ArrayList<>();
        quizModel = new QuizModel();
        quizModel.setPushed(true);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("doctor").child("Momen").child("subject").child("Quizs");
        Intent intent = getIntent();
        final String QuizeName = intent.getStringExtra("QuizName");

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionsList.add(new Questions(question.getText().toString(),answer1.getText().toString(),answer2.getText().toString(),answer3.getText().toString(),answer4.getText().toString(),correct.getText().toString(),30));
                question.setText("");
                answer1.setText("");
                answer2.setText("");
                answer3.setText("");
                answer4.setText("");
                correct.setText("");
            }

        });
         Save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 questionsList.add(new Questions(question.getText().toString(),answer1.getText().toString(),answer2.getText().toString(),answer3.getText().toString(),answer4.getText().toString(),correct.getText().toString(),30));
                 Toast.makeText(Create_Question.this, questionsList.get(0).toString(), Toast.LENGTH_SHORT).show();
                 databaseReference.child(QuizeName).setValue(new QuizModel(true,questionsList,100,30));
                 finish();

             }
         });
           }
}
