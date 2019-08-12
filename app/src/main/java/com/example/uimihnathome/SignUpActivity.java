package com.example.uimihnathome;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.model.User;
import com.example.network.ApiService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    EditText edt_dkyTK, edt_dkyMK;
    Button btn_DK;

    String tenKh = "", diachi = "", email, password;
    int phone = 0;

    ArrayList<User> arrUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        getAllList();

        addControls();
        addEvents();
    }

    private void addEvents() {
        btn_DK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String test;
//                int kt =0;
//                for(User user : arrUser){
//                    test = user.getEmail();
//                    if(test==edt_dkyTK.getText().toString()){
//                        kt++;
//                    }
//                }
//                if(kt==0){
//                    XuLyDK();
//                }else{
//                    Toast.makeText(SignUpActivity.this, "Tai khoan da dang ky", Toast.LENGTH_SHORT).show();
//                }

                XuLyDK();

            }
        });
    }

    private void XuLyDK() {
        ApiService.getInstance().CreateAcc(tenKh, edt_dkyMK.getText().toString(), phone, diachi, edt_dkyMK.getText().toString(),
                new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                    }
                });
    }

    private void getAllList(){
        ApiService.getInstance().getListUser(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    ArrayList<User> list = (ArrayList<User>) response.body();
                    arrUser.addAll(list);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    private void addControls() {
        edt_dkyTK = findViewById(R.id.edt_dkyTK);
        edt_dkyMK = findViewById(R.id.edt_dkyMK);
        btn_DK = findViewById(R.id.btnDK);
    }

}
