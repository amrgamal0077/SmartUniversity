package com.example.momen.smart_university.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.Questions;
import com.example.momen.smart_university.firebase.Doctor.QuizModel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Answer_question extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference referenceQuestion;
    private DatabaseReference referenceAttend;
    private ChildEventListener listener;
    private ChildEventListener listenerQuiz;
    private List<String> attendances;
    private List<Questions> questionsList;
    private List<QuizModel> quizModelList;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioGroup radioGroup;
    private TextView tv_question;
    private Button next;
    private int count;
    private boolean checkItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_question);
        setTitle("Task");
        //attach with design
        radioButton=findViewById(R.id.radioButton);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton3);
        radioButton4=findViewById(R.id.radioButton4);
        radioGroup = findViewById(R.id.rg);
        tv_question=findViewById(R.id.question);
        next=findViewById(R.id.next);
        count=0;
        //firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        referenceQuestion = firebaseDatabase.getReference().child("doctor").child("Momen").child("subject").child("Quizs");
        referenceAttend =firebaseDatabase.getReference().child("Attendances");
        attendances = new ArrayList<>();
        questionsList = new ArrayList<>();
        quizModelList = new ArrayList<>();

        final List<Questions> questions = new ArrayList<>();

       listener = new ChildEventListener() {
           @Override
           public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                 String attend = dataSnapshot.getValue(String.class);
                 attendances.add(attend);

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
       };
       referenceAttend.addChildEventListener(listener);

       listenerQuiz = new ChildEventListener() {
           @Override
           public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               QuizModel quizModel = dataSnapshot.getValue(QuizModel.class);

               if(quizModel.getPushed()){
                   quizModelList.add(quizModel);
                   QuizModel model = quizModelList.get(getIndex(StudentName.name)%quizModelList.size());
                   questionsList = model.getQuestions();
                   populateUI();
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
       };
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        referenceQuestion.addChildEventListener(listenerQuiz);

       //QuizModel quizModel =  quizModelList.get(getIndex(StudentName.name)%(quizModelList.size()-1));
       //questionsList = quizModel.getQuestions();
        //Toast.makeText(this, String.valueOf(questionsList.size()), Toast.LENGTH_SHORT).show();





       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               checked();

               if(checkItem)
                   Toast.makeText(Answer_question.this, "good", Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText(Answer_question.this, "false", Toast.LENGTH_SHORT).show();
               if (count==questionsList.size()-2||questionsList.size()==1)
               {
                   next.setText("Finish");
               }

               if (count==questionsList.size()-1)
                   finish();
               else
              {
               count++;
               reset();
               populateUI();
               //Toast.makeText(Answer_question.this, String.valueOf(count)+" "+String.valueOf(questionsList.size()-1), Toast.LENGTH_SHORT).show();

              }
           }
       });

    }

    public int getIndex(String name)
    {
        for(int i=0; i<attendances.size(); i++){
            if(name.equals(attendances.get(i)))
                return i;
        }
        return -1;
    }

    public void reset(){
        checkItem=false;
        radioButton.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
        radioButton4.setChecked(false);
    }

    public void checked( ) {
        if (radioButton.isChecked())
        {

            if (radioButton.getText().toString().equals(questionsList.get(count).correctAnswer))
                checkItem=true;
        }
        else if (radioButton2.isChecked()){
            if (radioButton2.getText().toString().equals(questionsList.get(count).correctAnswer))
                checkItem=true;

        }
        else if (radioButton3.isChecked()){
            if (radioButton3.getText().toString().equals(questionsList.get(count).correctAnswer))
                checkItem=true;

        }
        else if (radioButton4.isChecked()){
            if (radioButton4.getText().toString().equals(questionsList.get(count).correctAnswer))
                checkItem=true;

        }


    }
    public void populateUI (){
        tv_question.setText(questionsList.get(count).getQuestion());
        radioButton.setText(questionsList.get(count).getAnswer1());
        radioButton2.setText(questionsList.get(count).getAnswer2());
        radioButton3.setText(questionsList.get(count).getAnswer3());
        radioButton4.setText(questionsList.get(count).getAnswer4());
        if(questionsList.size()==1)
        {
            next.setText("Finish");
        }


    }
}

