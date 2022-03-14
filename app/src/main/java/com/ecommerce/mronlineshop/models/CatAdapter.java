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

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.PlateViewHolder> {

    private Context context;
    private List<CatagoryModel> list;

    public CatAdapter(Context context, List<CatagoryModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override


    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_catagory,parent,false);
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {
       CatagoryModel platModel=list.get(position);
       holder.textView.setText(platModel.getCat_title());
        Glide.with(context).load(platModel.getCat_img()).placeholder(R.drawable.logo).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView textView;
        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageView4);
            textView=(TextView)itemView.findViewById(R.id.textView3);
        }
    }
}