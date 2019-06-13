package com.example.momen.smart_university.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.momen.smart_university.R;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.recyclerVH>
{
    List<String> Quizname;
    Context context;

    public QuizAdapter(List<String> name, Context context) {
        this.Quizname = name;
        this.context = context;
    }
    @NonNull
    @Override
    public QuizAdapter.recyclerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.quiz_item, viewGroup, false);
        return new QuizAdapter.recyclerVH(view);        }

    @Override
    public void onBindViewHolder(@NonNull QuizAdapter.recyclerVH holder,final int position) {
        TextView QuizName=holder.itemView.findViewById(R.id.quizname) ;
        QuizName.setText(Quizname.get(position));
    }

    @Override
    public int getItemCount() {
        return Quizname.size();
    }

    class recyclerVH extends RecyclerView.ViewHolder {
        public recyclerVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}

