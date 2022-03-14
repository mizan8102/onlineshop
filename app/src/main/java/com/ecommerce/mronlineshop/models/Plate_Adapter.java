package com.ecommerce.mronlineshop.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ecommerce.mronlineshop.R;

import java.util.List;

public class Plate_Adapter extends RecyclerView.Adapter<Plate_Adapter.PlateViewHolder> {

    private Context context;
    private List<PlatModel> list;

    public Plate_Adapter(Context context, List<PlatModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override


    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_view,parent,false);
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {
        PlatModel platModel=list.get(position);
        Glide.with(context).load(platModel.getPlate_img()).placeholder(R.drawable.simple_product_pic).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageView2);
        }
    }
}
