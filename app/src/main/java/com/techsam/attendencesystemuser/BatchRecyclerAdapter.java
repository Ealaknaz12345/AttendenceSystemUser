package com.techsam.attendencesystemuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techsam.attendencesystemuser.models.Batch;

import java.util.ArrayList;

public class BatchRecyclerAdapter extends RecyclerView.Adapter<BatchRecyclerAdapter.ViewHlder> {
    private ArrayList<Batch> list;
    private Context context;

    public BatchRecyclerAdapter(ArrayList<Batch> list,Context context) {
        this.list=list;
        this.context= context;
    }

    @NonNull
    @Override
    public BatchRecyclerAdapter.ViewHlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_batchlist,parent,false);
        return new ViewHlder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BatchRecyclerAdapter.ViewHlder holder, int position) {
        holder.id.setText(list.get(position).getBid());

    }

    @Override
    public int getItemCount() { return  list.size();
    }

    public class ViewHlder extends RecyclerView.ViewHolder {
        TextView id;
        public ViewHlder(@NonNull View itemview ) {
            super(itemview);
            id=itemview.findViewById(R.id.batchnum);
        }
    }
}
