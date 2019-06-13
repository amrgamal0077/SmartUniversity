package com.example.momen.smart_university.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.momen.smart_university.Activites.StudentName;
import com.example.momen.smart_university.GetTableDocFactory;
import com.example.momen.smart_university.GetTableModel;
import com.example.momen.smart_university.GetTableModelStu;
import com.example.momen.smart_university.GetTableStudentFactory;
import com.example.momen.smart_university.R;
import com.example.momen.smart_university.Adapter.table_adapter;
import com.example.momen.smart_university.database.DatabaseRoom;
import com.example.momen.smart_university.database.TableEntry;
import com.example.momen.smart_university.firebase.Doctor.DoctorName;
import com.example.momen.smart_university.firebase.Student.*;
import com.example.momen.smart_university.firebase.Student.Students;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sun extends Fragment {


    public static Sun getType(String docOrStu) {

        Sun result = new Sun();
        Bundle bundle = new Bundle();
        bundle.putString("type", docOrStu);
        result.setArguments(bundle);
        return result;
    }
    List <String> list;
    List <TableEntry> sunday;
    DatabaseRoom db;
    private String type;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        type = bundle.getString("type");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_sun, container, false);
        db = DatabaseRoom.getsInstance(getContext());
        list=new ArrayList<>();
        sunday = new ArrayList<>();
        RecyclerView recyclerView=view.findViewById(R.id.Recycler_table);
        final table_adapter table_adapter = new table_adapter(sunday);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(table_adapter);

        if (type.equals("stu")){
            FirebaseDatabase.getInstance().getReference().child("Students").child(StudentName.year).child(StudentName.name).child("subjects")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot tableSnapshot : dataSnapshot.getChildren()){
                                Subjects subs = tableSnapshot.getValue(Subjects.class);
                                if (subs != null){
                                    list.add(subs.getLecture().getname());
                                }
                            }

                            GetTableStudentFactory studentFactory = new GetTableStudentFactory(db,list);
                            GetTableModelStu modelStu = ViewModelProviders.of(getActivity(),studentFactory).get(GetTableModelStu.class);
                            //Toast.makeText(getContext(), "List = "+String.valueOf(list.size()), Toast.LENGTH_SHORT).show();
                            modelStu.getTableStudent().observe(getActivity(), new Observer<List<TableEntry>>() {
                                @Override
                                public void onChanged(@Nullable List<TableEntry> tableEntries) {
                                    for (int i=0;i<tableEntries.size();i++){
                                        if (tableEntries.get(i).getDay().equals("Sun")){
                                            sunday.add(tableEntries.get(i));
                                        }
                                    }
                                    table_adapter.notifyDataSetChanged();
                                }
                            });


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }else if (type.equals("doc")){
            GetTableDocFactory docFactory = new GetTableDocFactory(db, DoctorName.doctorName);
            GetTableModel tableModel = ViewModelProviders.of(getActivity(),docFactory).get(GetTableModel.class);
            tableModel.getTableDoc().observe(getActivity(), new Observer<List<TableEntry>>() {
                @Override
                public void onChanged(@Nullable List<TableEntry> tableEntries) {
                    for (int i=0;i<tableEntries.size();i++){
                        if (tableEntries.get(i).getDay().equals("Sun")){
                            sunday.add(tableEntries.get(i));
                        }
                    }
                    table_adapter.notifyDataSetChanged();
                }
            });
        }



        return view;
    }

}
