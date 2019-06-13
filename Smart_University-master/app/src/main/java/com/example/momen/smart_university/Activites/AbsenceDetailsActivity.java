package com.example.momen.smart_university.Activites;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.momen.smart_university.Adapter.AbsenceAdapter;
import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Student.Subjects;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AbsenceDetailsActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    int attendance_num,absence_num;

    DatabaseReference databaseReference;
    List<Subjects>subjects= new ArrayList<>();
    List<String>subject_name=new ArrayList<>();
    AbsenceAdapter attendance_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absence_details);
        //recyclerview
        final Spinner spinner =findViewById(R.id.spinner);

        final RecyclerView recyclerView=findViewById(R.id.attendance_recycler);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Students").child(StudentName.year).child(StudentName.name).child("subjects");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Subjects subjects1=snapshot.getValue(Subjects.class);
                    if(subjects1!=null)
                    {
                        Toast.makeText(AbsenceDetailsActivity.this, subjects1.getLecture().getname(), Toast.LENGTH_SHORT).show();
                        subjects.add(subjects1);
                        subject_name.add(subjects1.getLecture().getname());
                    }
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,subject_name);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(AbsenceDetailsActivity.this,subjects.get(position).getLecture().getname(), Toast.LENGTH_SHORT).show();
                        if (subjects.get(position).getLecture().attendances==null)
                        {
                            attendance_adapter=new AbsenceAdapter(new ArrayList<String>(),getApplicationContext());
                            recyclerView.setHasFixedSize(true);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            recyclerView.setAdapter(attendance_adapter);

                            attendance_num=0;
                            absence_num=0;
                        }

                   //piechart

                        else {
                            attendance_adapter = new AbsenceAdapter(subjects.get(position).getLecture().attendances, getApplicationContext());
                            recyclerView.setHasFixedSize(true);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            recyclerView.setAdapter(attendance_adapter);

                            attendance_num=subjects.get(position).getLecture().attendances.size();
                            absence_num=subjects.get(position).getLecture().getNum_lecture()-subjects.get(0).getLecture().attendances.size();
                        }
                        PieChart pieChart = (PieChart) findViewById(R.id.chart);
                        pieChart.setHoleRadius(33f);
                        pieChart.setRotationEnabled(true);
                        pieChart.setTransparentCircleAlpha(0);
                        pieChart.setCenterText("Attendance");
                        pieChart.setCenterTextSize(12);
                        ArrayList<PieEntry> pieEntries = new ArrayList<>();
                        pieEntries.add(new PieEntry(attendance_num));
                        pieEntries.add(new PieEntry(absence_num));
                        String[] str = new String[]{"Attendance", "Absent"};
                        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Attendance");
                        ArrayList<Integer> colors = new ArrayList<>();
                        colors.add(Color.rgb(121, 134, 203));
                        colors.add(Color.rgb(77, 182, 172));
                        pieDataSet.setColors(colors);
                        pieDataSet.setSliceSpace(2);
                        pieDataSet.setSelectionShift(5f);
                        PieData pieData = new PieData(pieDataSet);
                        pieChart.setData(pieData);
                        Legend legend = pieChart.getLegend();
                        legend.setEnabled(true);
                        List<LegendEntry> entries = new ArrayList<>();

                        for (int i = 0; i < colors.size(); i++) {
                            LegendEntry entry = new LegendEntry();
                            entries.add(entry);
                        }
                        legend.setCustom(entries);
                        pieChart.getDescription().setEnabled(false);


                        pieChart.invalidate();


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
