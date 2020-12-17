package com.example.stayarta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tv_title2 = findViewById(R.id.tv_title2);
        TextView tv_nomor = findViewById(R.id.tv_nomor);
        TextView tv_alamat = findViewById(R.id.tv_alamat);
        ImageView iv_hotel2 = findViewById(R.id.iv_hotel2);

        tv_title2.setText(getIntent().getStringExtra("nama"));
        tv_nomor.setText("Nomor Telepon: "+getIntent().getStringExtra("nomor"));
        tv_alamat.setText("Alamat: "+getIntent().getStringExtra("alamat"));
        Glide.with(getApplicationContext())
                .load(getIntent()
                        .getStringExtra("gambar")).error(R.mipmap.logo).into(iv_hotel2);
    }
}