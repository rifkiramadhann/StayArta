package com.example.stayarta.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.stayarta.DetailActivity;
import com.example.stayarta.R;
import com.example.stayarta.model.HotelItem;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    private ArrayList<HotelItem> hotelItems;
    private Context mContext;

    public HotelAdapter(ArrayList<HotelItem> hotelItems, Context mContext) {
        this.hotelItems = hotelItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_title.setText(hotelItems.get(position).getNama());
        Glide.with(mContext)
                .load(hotelItems.get(position).getGambarUrl())
                .error(R.mipmap.logo)
                .into(holder.iv_hotel);
        holder.cv.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("nama", hotelItems.get(position).getNama());
            intent.putExtra("alamat", hotelItems.get(position).getAlamat());
            intent.putExtra("nomor", hotelItems.get(position).getNomorTelp());
            intent.putExtra("gambar", hotelItems.get(position).getGambarUrl());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return hotelItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_hotel;
        private TextView tv_title;
        private CardView cv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            iv_hotel = itemView.findViewById(R.id.iv_hotel);
            cv = itemView.findViewById(R.id.cv);
        }
    }
}