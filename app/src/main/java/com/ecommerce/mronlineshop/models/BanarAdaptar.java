package com.ecommerce.mronlineshop.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ecommerce.mronlineshop.R;

import java.util.List;

public class BanarAdaptar extends RecyclerView.Adapter<BanarAdaptar.PlateViewHolder> {

    private Context context;
    private List<Banar_Model> list;

    public BanarAdaptar(Context context, List<Banar_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override


    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_banar,parent,false);
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {
        Banar_Model platModel=list.get(position);
        Glide.with(context).load(platModel.getBanar_img()).placeholder(R.drawable.logo).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.banar_img);
        }
    }
}