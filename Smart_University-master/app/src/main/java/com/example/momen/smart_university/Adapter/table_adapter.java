package com.example.momen.smart_university.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.database.TableEntry;

import java.util.List;

public class table_adapter extends RecyclerView.Adapter<table_adapter.tableVH> {

    List<TableEntry> list ;
    public table_adapter(List<TableEntry> list)
    {
        this.list=list;
    }
    @NonNull
    @Override
    public tableVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_table_item,parent,false);

            return new tableVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tableVH holder, int position) {
        holder.textView.setText(list.get(position).getSub_name());
        holder.from.setText(String.valueOf(list.get(position).getFrom()));
        holder.to.setText(String.valueOf(list.get(position).getTo()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class tableVH extends RecyclerView.ViewHolder{

        TextView textView,from,to;
        public tableVH(View itemView) {
            super(itemView);
        textView=itemView.findViewById(R.id.lec_table);
        from = itemView.findViewById(R.id.fromTable);
        to = itemView.findViewById(R.id.toTable);
        }

    }
}
