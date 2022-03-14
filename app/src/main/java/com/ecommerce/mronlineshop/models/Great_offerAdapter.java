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

public class Great_offerAdapter extends RecyclerView.Adapter<Great_offerAdapter.Great_offerAdapterViewHolder> {

    Context context;

    public Great_offerAdapter(Context context, List<Great_offer_model> list) {
        this.context = context;
        this.list = list;
    }

    private List<Great_offer_model> list;
    @NonNull
    @Override
    public Great_offerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_great_offer_banner,parent,false);
        return new Great_offerAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Great_offerAdapterViewHolder holder, int position) {
            Great_offer_model gom=list.get(position);
        Glide.with(context).load(gom.getOffer_img()).placeholder(R.drawable.banner_great_offer).into(holder.imageView);
        holder.textView1.setText(gom.getShop_name());
        holder.textView2.setText(gom.getTime());
        holder.textView3.setText(gom.getDiscount());
        holder.textView4.setText(gom.getRating());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Great_offerAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView1,textView2,textView3,textView4;
        public Great_offerAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
           imageView= itemView.findViewById(R.id.txtgreatofferbanar);
           textView1=itemView.findViewById(R.id.textView5);
           textView2=itemView.findViewById(R.id.txtdicount);
           textView3=itemView.findViewById(R.id.txtdicountgfh);
           textView4=itemView.findViewById(R.id.textView4);

        }
    }
}
