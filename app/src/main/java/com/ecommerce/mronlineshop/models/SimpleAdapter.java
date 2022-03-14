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

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.PlateViewHolder> {

    private Context context;
    private List<Simple_product_model> list;

    public SimpleAdapter(Context context, List<Simple_product_model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override


    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_simple_verticle_slider,parent,false);
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {
       Simple_product_model platModel=list.get(position);
        Glide.with(context).load(platModel.getSimple_image()).placeholder(R.drawable.logo).into(holder.img);
        holder.title.setText(platModel.getSimple_title());
        holder.description.setText(platModel.getSimple_description());
        holder.coupon.setText(platModel.getSimple_coupon());
        holder.price.setText(platModel.getSimple_price());
        holder.status.setText(platModel.getSimple_status());
        holder.discount.setText(platModel.getSimple_off());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title,description,coupon,discount,price,status;
        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.simpleimage);
            title=(TextView)itemView.findViewById(R.id.txtsimpletitle);
           description=(TextView)itemView.findViewById(R.id.txtsimpledescription);
            coupon=(TextView)itemView.findViewById(R.id.txtsimplecoupon);
            discount=(TextView)itemView.findViewById(R.id.txtoff);
            price=(TextView)itemView.findViewById(R.id.txtsimple_price);
            status=(TextView)itemView.findViewById(R.id.txtstatus);
        }
    }
}
