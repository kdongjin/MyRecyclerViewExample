package com.example.myrecyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private final List<CardItem> mDataList;
    private Context context;

    public MyRecyclerAdapter(Context context, List<CardItem> mDataList) {
        this.context = context;
        this.mDataList = mDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardItem item = mDataList.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvContents.setText(item.getContents() );

        holder.itemView.setOnClickListener(v->{
            Toast.makeText(context, "전체"+position, Toast.LENGTH_SHORT).show();
        });
        holder.tvTitle.setOnClickListener(v ->{
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvContents;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContents = itemView.findViewById(R.id.tvContents);

        }
    }
}
