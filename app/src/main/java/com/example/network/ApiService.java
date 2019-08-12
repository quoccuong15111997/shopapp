package com.example.network;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.model.DanhMuc;
import com.example.model.SanPham;
import com.example.model.User;

import java.util.EnumMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static ApiService apiService;

    private Retrofit retrofit;

    private ApiService(String baseUrl) {
        initClient(baseUrl);
    }

    private void initClient(@NonNull String baseUrl) {
        if (TextUtils.isEmpty(baseUrl)) {
            return;
        }
        if (!baseUrl.endsWith("/")) {
            baseUrl = baseUrl + "/";
        }
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
    }

    public static void init(@NonNull String baseUrl) {
        if (apiService == null) {
            apiService = new ApiService(baseUrl);
        }
    }

    public static ApiService getInstance() {
        return apiService;
    }

    public void getDanhMuc(Callback<List<DanhMuc>> callback) {
        if (retrofit != null) {
            Call<List<DanhMuc>> getDanhMucApi = retrofit.create(RestApi.class).getDanhMuc();
            getDanhMucApi.enqueue(callback);
        }
    }

    public void getSanPham(Callback<List<SanPham>> callback){
        if(retrofit != null){
            Call<List<SanPham>> getSanPhamApi = retrofit.create(RestApi.class).getSanPham();
            getSanPhamApi.enqueue(callback);
        }
    }


    public void getListSanPham(int id, Callback<List<SanPham>> callback) {
        if (retrofit != null) {
            Call<List<SanPham>> getListSanPhamApi = retrofit.create(RestApi.class).getListSanPham(id);
            getListSanPhamApi.enqueue(callback);
        }
    }


    public void CreateAcc(String tenKH, String email,
                          int phone, String diachi,
                          String password, Callback<Boolean> callback) {
        if (retrofit != null) {
            Call<Boolean> getCreat = retrofit.create(RestApi.class).getCreatAccount(tenKH, email, phone, diachi, password);
            getCreat.enqueue(callback);
        }
    }

    public void getListUser(Callback<List<User>> callback){
        if(retrofit != null){
            Call<List<User>> getListUserApi = retrofit.create(RestApi.class).getListUser();
            getListUserApi.enqueue(callback);
        }
    }

    public void getUserTheoEmail(String email, Callback<User> callback){
        if(retrofit !=null){
            Call<User> getUserApi = retrofit.create(RestApi.class).getKhachHangTheoEmail(email);
            getUserApi.enqueue(callback);
        }
    }


}
