package com.example.momen.smart_university.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.momen.smart_university.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click(View view){
        Intent intent = new Intent(MainActivity.this,Login.class);
        startActivity(intent);
    }

    public void doc(View view) {
        Intent intent = new Intent(MainActivity.this,LoginDoctorActivity.class);
        startActivity(intent);
    }

    public void admin(View view) {
        Intent intent = new Intent(MainActivity.this,AdminActivity.class);
        startActivity(intent);
    }
}
