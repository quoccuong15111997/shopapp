package com.example.network;

import com.example.model.DanhMuc;
import com.example.model.SanPham;
import com.example.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {
    @GET("danhmuc/{1}")
    Call<List<DanhMuc>> getDanhMuc();

    @GET("sanpham")
    Call<List<SanPham>> getSanPham();

    //@FormUrlEncoded
    @GET("sanpham")
    Call<List<SanPham>> getListSanPham(@Query("madm") int id);

    @POST("khachhang")
    Call<Boolean> getCreatAccount(@Query("tenkh") String tenKH, @Query("email") String email,
                                  @Query("phone") int phone, @Query("diachi") String diachi,
                                  @Query("password") String password);

    @GET("khachhang")
    Call<List<User>> getListUser();

    @GET("khachhang")
    Call<User> getKhachHangTheoEmail(@Query("email") String email);
}
