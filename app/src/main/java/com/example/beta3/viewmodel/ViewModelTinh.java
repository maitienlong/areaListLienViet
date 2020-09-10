package com.example.beta3.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.beta3.AdapterRecycleViewTinh;
import com.example.beta3.Request.Base64Request;
import com.example.beta3.Response.Base64Response;
import com.example.beta3.Services.MyRetrofit;
import com.example.beta3.Services.RequestApiUtils;
import com.example.beta3.Services.RetrofitServices;
import com.example.beta3.databinding.CusTinhBinding;
import com.example.beta3.models.Example;
import com.example.beta3.models.ListArea;
import com.example.beta3.views.MainActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewModelTinh extends Observable {
    private Context context;
    private ArrayList<ListArea> areaArrayList;
    private AdapterRecycleViewTinh adapterRecycleViewTinh;
    private CusTinhBinding cusTinhBinding;

    public ViewModelTinh(Context context, CusTinhBinding cusTinhBinding) {
        this.context = context;
        this.cusTinhBinding = cusTinhBinding;
        GetData();
    }

    private void GetData() {
        Base64Request base64Request = RequestApiUtils.createRequest("eyJhcmVhVHlwZSI6IkQiLCJwYXJlbnRDb2RlIjoiSE5PIn0=", (Activity) context);
        Retrofit retrofit = MyRetrofit.getInstance("https://lifecardtest.viviet.vn");
        RetrofitServices retrofitServices = retrofit.create(RetrofitServices.class);
        retrofitServices.getArea(base64Request).enqueue(new Callback<Base64Response>() {
            @Override
            public void onResponse(Call<Base64Response> call, Response<Base64Response> response) {
                Log.e("DATACONFIG", response.body().getBody());
                String endcode = response.body().getBody();
                String json = new String(Base64.decode(endcode, 1));
                Log.e("DATACONFIG", json);

                Gson gson = new Gson();

                Example example = gson.fromJson(json, Example.class);
                List<ListArea> listAreaList = example.getListArea();

                areaArrayList = new ArrayList<>();
                areaArrayList.addAll(listAreaList);
                ListView(areaArrayList);

            }

            @Override
            public void onFailure(Call<Base64Response> call, Throwable t) {
                Log.e("DATACONFIG", t.getMessage());
            }
        });
    }

    private void ListView(ArrayList arrayList) {
        cusTinhBinding.listTinh.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        cusTinhBinding.listTinh.setLayoutManager(staggeredGridLayoutManager);
        adapterRecycleViewTinh = new AdapterRecycleViewTinh(context,arrayList);
        cusTinhBinding.listTinh.setAdapter(adapterRecycleViewTinh);


    }


}
