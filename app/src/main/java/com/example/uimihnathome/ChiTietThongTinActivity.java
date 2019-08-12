package com.example.uimihnathome;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChiTietThongTinActivity extends AppCompatActivity {
    ImageView iv_backTaiKhoan, img_fix;

    TextView txt_mail, txt_phone, txt_sex, txt_position;
    EditText edt_mail, edt_phone, edt_sex, edt_position;

    Button btn_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_thong_tin);


        addControls();
        addEvents();
    }


    private void addEvents() {
        iv_backTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        img_fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_mail.setVisibility(View.GONE);
                txt_phone.setVisibility(View.GONE);
                txt_sex.setVisibility(View.GONE);
                txt_position.setVisibility(View.GONE);

                edt_mail.setVisibility(View.VISIBLE);
                edt_phone.setVisibility(View.VISIBLE);
                edt_sex.setVisibility(View.VISIBLE);
                edt_position.setVisibility(View.VISIBLE);

                Toast.makeText(ChiTietThongTinActivity.this, "Bạn có thể chỉnh sửa thông tin", Toast.LENGTH_SHORT).show();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = edt_mail.getText().toString();
                String phone = edt_phone.getText().toString();
                String sex = edt_sex.getText().toString();
                String position = edt_position.getText().toString();

                txt_mail.setVisibility(View.VISIBLE);
                txt_phone.setVisibility(View.VISIBLE);
                txt_sex.setVisibility(View.VISIBLE);
                txt_position.setVisibility(View.VISIBLE);

                edt_mail.setVisibility(View.GONE);
                edt_phone.setVisibility(View.GONE);
                edt_sex.setVisibility(View.GONE);
                edt_position.setVisibility(View.GONE);

                txt_mail.setText(mail);
                txt_phone.setText(phone);
                txt_sex.setText(sex);
                txt_position.setText(position);

                Toast.makeText(ChiTietThongTinActivity.this, "Bạn đã lưu thông tin", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void addControls() {
        iv_backTaiKhoan = findViewById(R.id.iv_backTaiKhoan);
        img_fix = findViewById(R.id.img_fix);

        txt_mail = findViewById(R.id.txt_mail);
        txt_phone = findViewById(R.id.txt_phone);
        txt_sex = findViewById(R.id.txt_sex);
        txt_position = findViewById(R.id.txt_position);

        edt_mail = findViewById(R.id.edt_mail);
        edt_phone = findViewById(R.id.edt_phone);
        edt_sex = findViewById(R.id.edt_sex);
        edt_position = findViewById(R.id.edt_position);

        btn_save = findViewById(R.id.btn_save);

    }
}
