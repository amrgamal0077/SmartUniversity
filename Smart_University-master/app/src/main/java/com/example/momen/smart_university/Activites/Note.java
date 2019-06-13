package com.example.momen.smart_university.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.Request.Data;
import com.example.momen.smart_university.Request.RequestUniversity;
import com.example.momen.smart_university.Response.ResponseUniversity;
import com.example.momen.smart_university.api.UniversityRetofit;
import com.example.momen.smart_university.api.UniversityService;
import com.example.momen.smart_university.firebase.Doctor.DoctorName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Note extends AppCompatActivity {

    EditText note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setTitle("My Notes");

        note = findViewById(R.id.note);

        Spinner subject =findViewById(R.id.spinner_subjects);
        ArrayAdapter<CharSequence>arrayAdapter=ArrayAdapter.createFromResource(this,R.array.subjects,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject.setAdapter(arrayAdapter);
        final Spinner spinner_year=findViewById(R.id.spinner_year);
        Spinner spinner_spec=findViewById(R.id.spinner_spec);
        ArrayAdapter<CharSequence> arrayAdapter1= ArrayAdapter.createFromResource(this,R.array.year,android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_year.setAdapter(arrayAdapter1);
        ArrayAdapter<CharSequence> arrayAdapter_spec= ArrayAdapter.createFromResource(this,R.array.specialize,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_spec.setAdapter(arrayAdapter_spec);
        Button send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String topic = spinner_year.getSelectedItem().toString();

                String note_text = note.getText().toString();

                if (topic.equals("Select year")|| TextUtils.isEmpty(note_text)){
                    Toast.makeText(Note.this," please entre the note or select the year", Toast.LENGTH_SHORT).show();
                    return;
                }

                UniversityService universityService = UniversityRetofit.getRetrofit().create(UniversityService.class);
                Call<ResponseUniversity> call = universityService.sendData(new RequestUniversity("/topics/"+topic,
                        new Data(DoctorName.doctorName,note_text)));
                call.enqueue(new Callback<ResponseUniversity>() {
                    @Override
                    public void onResponse(Call<ResponseUniversity> call, Response<ResponseUniversity> response) {
                        ResponseUniversity responseUniversity = response.body();
                        //Toast.makeText(MainActivity.this, String.valueOf(responseSquawk.toString()), Toast.LENGTH_SHORT).show();
                        if (responseUniversity == null){
                            Toast.makeText(Note.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                            Log.d("bb", response.errorBody().toString());
                            return;
                        }

                        else
                            Toast.makeText(Note.this, "message sent", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseUniversity> call, Throwable t) {

                        Toast.makeText(Note.this, call.toString(), Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });

    }
}
