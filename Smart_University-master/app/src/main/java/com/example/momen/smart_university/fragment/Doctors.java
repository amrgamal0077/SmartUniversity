package com.example.momen.smart_university.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.momen.smart_university.Activites.AddDoctor;
import com.example.momen.smart_university.Adapter.DoctorListAdapter;
import com.example.momen.smart_university.Adapter.StudentListAdapter;
import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.Doctor;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class Doctors extends Fragment implements StudentListAdapter.StudentClickListener {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecyclerView recyclerViewDoctor;
    List<Doctor> doctors;
    public Doctors() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctors, container, false);

        doctors = new ArrayList<>();
        recyclerViewDoctor = view.findViewById(R.id.admin_doctor_recycler);
        recyclerViewDoctor.setLayoutManager(new LinearLayoutManager(this.getContext()));
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Doctors");
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddDoctor.class);
                startActivity(intent);
            }
        });
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Doctor doctor = dataSnapshot.getValue(Doctor.class);
                doctors.add(doctor);
                DoctorListAdapter doctorListAdapter = new DoctorListAdapter(doctors, getContext(),Doctors.this);
                recyclerViewDoctor.setAdapter(doctorListAdapter);

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


        return view;
    }

    @Override
    public void onListItemClick(int position) {

    }
}