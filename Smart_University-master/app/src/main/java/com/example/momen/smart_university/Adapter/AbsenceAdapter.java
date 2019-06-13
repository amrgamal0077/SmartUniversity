package com.example.momen.smart_university.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmrGamal on 12/06/2019.
 */

public class AbsenceAdapter  extends RecyclerView.Adapter<AbsenceAdapter.recyclerVH> {

    List <String> date = new ArrayList<>();
    Context context;

    public AbsenceAdapter(List <String> name, Context context) {
        this.date = name;
        this.context = context;
    }

    @NonNull
    @Override
    public AbsenceAdapter.recyclerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_list_item, viewGroup, false);
        return new AbsenceAdapter.recyclerVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AbsenceAdapter.recyclerVH holder, final int position) {
        TextView studentName = holder.itemView.findViewById(R.id.student_name);
        studentName.setText(date.get(position));
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    class recyclerVH extends RecyclerView.ViewHolder {
        public recyclerVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}

