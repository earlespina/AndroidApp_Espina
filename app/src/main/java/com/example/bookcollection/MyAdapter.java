package com.example.bookcollection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id, title, genre , date;

    public MyAdapter(Context context, ArrayList id, ArrayList title, ArrayList genre, ArrayList date) {
        this.context = context;
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.date = date;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.bookentry,parent,false);
        return new MyViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.title.setText(String.valueOf(title.get(position)));
        holder.genre.setText(String.valueOf(genre.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, title,genre,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tId);
            title = itemView.findViewById(R.id.tTitle);
            genre = itemView.findViewById(R.id.tGenre);
            date = itemView.findViewById(R.id.tDate);

        }
    }

}
