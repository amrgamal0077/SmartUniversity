package com.example.momen.smart_university.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.momen.smart_university.Adapter.QuizAdapter;
import com.example.momen.smart_university.R;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends AppCompatActivity {
    QuizAdapter quizAdapter;
    List <String> quizNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent   = new Intent(Quiz.this,Create_Quiz.class);
                startActivity(intent);
            }
        });
        quizNames=new ArrayList<>();
        quizNames.add("image processimg");
        quizNames.add("multimedia");
        quizNames.add("image processimg");
        quizNames.add("image processimg");
        quizNames.add("image processimg");
        quizNames.add("image processimg");
        quizNames.add("image processimg");
        quizNames.add("image processimg");
        quizNames.add("image ");
        quizAdapter= new QuizAdapter(quizNames,this);
        RecyclerView recyclerView = findViewById(R.id.recycler_quiz);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(quizAdapter);
    }

}
