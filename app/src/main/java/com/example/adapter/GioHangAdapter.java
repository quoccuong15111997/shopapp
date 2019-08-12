package com.example.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.impl.CheckClickListener;
import com.example.impl.ItemClickListener;
import com.example.model.SanPham;
import com.example.uimihnathome.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.uimihnathome.R.color.color_white;
import static com.example.uimihnathome.R.color.grey_enable_false;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ItemHolder> {
    Context context;
    ArrayList<SanPham> arrSP;
    CheckClickListener checkClickListener;


    SanPham sp =new SanPham();


    public GioHangAdapter(Context context, ArrayList<SanPham> arrSP, CheckClickListener checkClickListener) {
        this.context = context;
        this.arrSP = arrSP;
        this.checkClickListener = checkClickListener;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_giohang, null);
        ItemHolder itemHolder = new ItemHolder(view);


        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder holder, final int position) {
        final SanPham sanPham = arrSP.get(position);

        Picasso.with(context).load(sanPham.getHinhSP()).into(holder.img_hinhSP);
//        holder.img_hinhSP.setImageResource(sanPham.getHinhSP());
        holder.txt_tenSP.setText(sanPham.getTenSP());
        holder.txt_giaSP.setText(sanPham.getDonGia()+"");
        holder.txt_number.setText(sanPham.getSlSP()+"");

    }

    @Override
    public int getItemCount() {
        return arrSP.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView img_hinhSP, img_xoaSP;
        public TextView txt_tenSP,txt_giaSP, txt_number;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            img_hinhSP = itemView.findViewById(R.id.img_hinhSP);
            txt_tenSP = itemView.findViewById(R.id.txt_tenSP);
            txt_giaSP = itemView.findViewById(R.id.txt_giaSP);

            txt_number = itemView.findViewById(R.id.txt_number);

        }
    }
}
