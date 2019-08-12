package com.example.uimihnathome.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import com.example.adapter.SanPhamAllAdapter;
import com.example.impl.ItemClickListener;
import com.example.model.NhanHieu;
import com.example.model.SanPham;
import com.example.network.ApiService;
import com.example.uimihnathome.R;
import com.example.uimihnathome.ThongTinSanPhamActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    View view;
    Toolbar toolbar;
    ViewFlipper viewFlipper;

    RecyclerView rcl_spAll;
    ArrayList<SanPham> arrSP;
    SanPhamAllAdapter sanPhamAllAdapter;
//    NhanHieuAdapter brandAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        addControls();
        addEvents();

        return view;
    }

    private void addEvents() {
        ActionBar();
        ActionViewFlipper();
    }

    private void addControls() {
        toolbar = view.findViewById(R.id.toolbar);
        viewFlipper = view.findViewById(R.id.viewflipper);

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getContext(), ThongTinSanPhamActivity.class);
                intent.putExtra("SANPHAM", arrSP.get(position));
                startActivity(intent);
            }
        };

        rcl_spAll = view.findViewById(R.id.rcl_spAll);
        arrSP = new ArrayList<>();
        laydanhsachSP();
        sanPhamAllAdapter = new SanPhamAllAdapter(getContext(), arrSP, itemClickListener);
        rcl_spAll.setHasFixedSize(true);
//        rcl_spAll.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        rcl_spAll.setLayoutManager(new GridLayoutManager(getContext(),2));
        rcl_spAll.setAdapter(sanPhamAllAdapter);
    }


    private void laydanhsachSP(){
        ApiService.getInstance().getSanPham(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if(response.isSuccessful()){
                    List<SanPham> list = response.body();
                    arrSP.addAll(list);
                    sanPhamAllAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {

            }
        });
    }

    private void ActionBar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setTitle("");
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void ActionViewFlipper() {
        ArrayList<Integer> arrQC = new ArrayList<>();
        arrQC.add(R.drawable.banner1);
        arrQC.add(R.drawable.banner2);
        arrQC.add(R.drawable.banner3);
        arrQC.add(R.drawable.banner4);
        arrQC.add(R.drawable.banner5);
        arrQC.add(R.drawable.banner6);

        for (int i = 0; i < arrQC.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(arrQC.get(i));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);

        Animation animation_slide_in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_right);

        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mn_giohang) {
            Toast.makeText(getActivity(), "Gio hang", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getContext(), ChiTietGioHangActivity.class);
//            startActivity(intent);

        }

        if (id == R.id.mn_chat) {
            Toast.makeText(getActivity(), "Chat", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
