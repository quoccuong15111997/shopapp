package com.example.uimihnathome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.GioHangAdapter;
import com.example.impl.CheckClickListener;
import com.example.model.SanPham;

import java.util.ArrayList;

public class ChiTietGioHangActivity extends AppCompatActivity {
    RecyclerView rcl_giohang;
    GioHangAdapter gioHangAdapter;
    ArrayList<SanPham> arrSP;

    TextView txt_giaAll;
    Button btn_buyAll;

    ImageView img_back;
    SanPham sanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_gio_hang);
        Intent intent = getIntent();
        sanPham = (SanPham) intent.getSerializableExtra("SANPHAM");
        String ten=sanPham.getTenSP();

        addControls();
        addEvents();
    }

    private void addEvents() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_buyAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void addControls() {

        rcl_giohang = findViewById(R.id.rcl_giohang);
        arrSP = new ArrayList<>();
        arrSP.add(sanPham);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rcl_giohang.setLayoutManager(manager);
        rcl_giohang.setHasFixedSize(true);
        CheckClickListener checkClickListener = new CheckClickListener() {
            @Override
            public void checkClick(int position) {
            }
        };
        gioHangAdapter = new GioHangAdapter(getApplicationContext(), arrSP, checkClickListener);
        rcl_giohang.setAdapter(gioHangAdapter);


        img_back = findViewById(R.id.img_back);
        txt_giaAll = findViewById(R.id.txt_giaAll);
        btn_buyAll = findViewById(R.id.btn_buyAll);
    }
}
