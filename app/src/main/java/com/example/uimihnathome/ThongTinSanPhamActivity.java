package com.example.uimihnathome;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.impl.ButtonClickListener;
import com.example.model.SanPham;
import com.example.uimihnathome.Dialog.DialogBottomSheetBuy;
import com.squareup.picasso.Picasso;

public class ThongTinSanPhamActivity extends AppCompatActivity {

    TextView txt_buy_bottom, txt_add_bottom, txt_nametheme;
    ImageView img_back, img_like;
    ImageView img_hinhSP;

    ImageView img_subtract, img_plus;
    TextView txt_number;

    SanPham sp = new SanPham();


    Button btn_review;

    TextView txt_tenSP, txt_giaSP, txt_slSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_san_pham);
        Intent intentSP = getIntent();
        sp = (SanPham) intentSP.getSerializableExtra("SANPHAM");



        addControls();
        addEvents();
    }

    private void addEvents() {
//        txt_buy_bottom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ButtonClickListener buttonClickListener = new ButtonClickListener() {
//                    @Override
//                    public void Click(int sl) {
//
//                    }
//                };
//                DialogBottomSheetBuy bottom = new DialogBottomSheetBuy(buttonClickListener,sp);
//                bottom.show(getSupportFragmentManager(),"Bottom Sheet");
//            }
//        });
        img_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp.getSlSP() > 0) {
                    img_subtract.setBackgroundColor(ContextCompat.getColor(ThongTinSanPhamActivity.this, R.color.color_white));
                    sp.setSlSP(Integer.parseInt(txt_number.getText().toString()) - 1);
                } else {
                    img_subtract.setBackgroundColor(ContextCompat.getColor(ThongTinSanPhamActivity.this, R.color.grey_enable_false));
                }
                txt_number.setText(sp.getSlSP() + "");
            }
        });

        img_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp.getSlSP() < 100) {
                    img_subtract.setBackgroundColor(ContextCompat.getColor(ThongTinSanPhamActivity.this, R.color.color_white));
                    sp.setSlSP(Integer.parseInt(txt_number.getText().toString()) + 1);
                } else {
                    img_plus.setBackgroundColor(ContextCompat.getColor(ThongTinSanPhamActivity.this, R.color.grey_enable_false));
                }
                txt_number.setText(sp.getSlSP() + "");
            }
        });


        txt_add_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThongTinSanPhamActivity.this, ChiTietGioHangActivity.class);
                sp.setSlSP(Integer.parseInt(txt_number.getText().toString()));
                if (sp.getSlSP() == 0) {
                    Toast.makeText(ThongTinSanPhamActivity.this, "Hãy chọn số lượng mua hàng", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("SANPHAM", sp);
                    startActivity(intent);
                }
            }
        });



        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        ButtonClickListener buttonClickListener = new ButtonClickListener() {
//            @Override
//            public void Click() {
//                Intent intent = new Intent(ThongTinSanPhamActivity.this, ChiTietGioHangActivity.class);
//                startActivity(intent);
//            }
//        };

        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham spTruyen = sp;
                Intent intent = new Intent(ThongTinSanPhamActivity.this, VideoReviewActivity.class);
                intent.putExtra("SPTruyen", spTruyen);
                startActivity(intent);
            }
        });

//       xuLyNutLike();
    }

//    private void xuLyNutLike() {
//        if(sp.isLikeSP()){
//            img_like.setImageResource(R.drawable.icon_heart_red);
//        }else {
//            img_like.setImageResource(R.drawable.ic_heart1);
//        }
//
//        img_like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(sp.isLikeSP()){
//                    sp.setLikeSP(false);
//                    img_like.setImageResource(R.drawable.ic_heart1);
//                    Toast.makeText(ThongTinSanPhamActivity.this, "Da xoa san pham vao danh sach yeu thich", Toast.LENGTH_SHORT).show();
//                }else {
//                    sp.setLikeSP(true);
//                    img_like.setImageResource(R.drawable.icon_heart_red);
//                    Toast.makeText(ThongTinSanPhamActivity.this, "Da them san pham khoi danh sach yeu thich", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }

    private void addControls() {

        txt_add_bottom = findViewById(R.id.txt_add_bottom);
        img_back = findViewById(R.id.img_back);
//        img_like = findViewById(R.id.img_like);

        txt_nametheme = findViewById(R.id.txt_nametheme);
        txt_tenSP = findViewById(R.id.txt_tenSP);
        txt_giaSP = findViewById(R.id.txt_giaSP);
        img_hinhSP = findViewById(R.id.img_hinhSP);
        txt_slSP = findViewById(R.id.txt_slSP);

        img_subtract = findViewById(R.id.img_subtract);
        img_plus = findViewById(R.id.img_plus);
        txt_number = findViewById(R.id.txt_number);

        txt_nametheme.setText(sp.getTenSP());
        txt_tenSP.setText(sp.getTenSP());
        txt_giaSP.setText(sp.getDonGia()+"");
        Picasso.with(ThongTinSanPhamActivity.this).load(sp.getHinhSP()).into(img_hinhSP);
//        img_hinhSP.setImageResource(sp.getHinhSP());
        txt_slSP.setText(sp.getSoLuongTon()+"");

        btn_review = findViewById(R.id.btn_review);
    }
}
