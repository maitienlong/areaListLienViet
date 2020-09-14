package com.example.beta3.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.beta3.Adapter.AdapterRecycleViewTinh;
import com.example.beta3.Request.Base64Request;
import com.example.beta3.Response.Base64Response;
import com.example.beta3.Services.MyRetrofit;
import com.example.beta3.Services.RequestApiUtils;
import com.example.beta3.Services.RetrofitServices;
import com.example.beta3.databinding.ActivityDistrictBinding;
import com.example.beta3.databinding.CusHuyenBinding;
import com.example.beta3.models.Example;
import com.example.beta3.models.ListArea;
import com.example.beta3.views.DistrictActivity;
import com.example.beta3.views.WardActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewModelDistrict extends ViewModel {


    private Context context;
    private ArrayList<ListArea> areaArrayList;
    private AdapterRecycleViewTinh adapterRecycleViewTinh;
    private ActivityDistrictBinding binding;

    public ViewModelDistrict(Context context, ActivityDistrictBinding binding, String body) {
        this.context = context;
        this.binding = binding;
        String json = "{\"areaType\":\"D\",\"parentCode\":\"" + body + "\"}";
        String base64 = new String(Base64.encode(json.getBytes(), 1));
        GetData(base64);


    }


    private void ListView(ArrayList<ListArea> arrayList) {
        binding.listDistric.setHasFixedSize(true);

        LinearLayoutManager linearLayout = new LinearLayoutManager(context);
        binding.listDistric.setLayoutManager(linearLayout);
        adapterRecycleViewTinh = new AdapterRecycleViewTinh(context, arrayList);
        binding.listDistric.setAdapter(adapterRecycleViewTinh);
        AdapterRecycleViewTinh.ItemClickSupport.addTo(binding.listDistric).setOnItemClickListener(new AdapterRecycleViewTinh.ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent((Activity) context, WardActivity.class);
                intent.putExtra("body",arrayList.get(position).getAreaCode());
                context.startActivity(intent);
            }
        });
    }

    public void search(String s) {
        ArrayList<ListArea> fiterList = new ArrayList<>();
        for (ListArea item : areaArrayList) {
            if (item.getAreaName().toLowerCase().contains(s.toLowerCase())) {
                fiterList.add(item);
            }
        }
        adapterRecycleViewTinh.filterList(fiterList);
    }

    public TextWatcher searchData() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search(s.toString());
            }
        };
    }

    private void GetData(String body) {
        Base64Request base64Request = RequestApiUtils.createRequest(body.toString().trim(), (Activity) context);
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
                ConvertData(listAreaList);

            }

            @Override
            public void onFailure(Call<Base64Response> call, Throwable t) {
                Log.e("DATACONFIG", t.getMessage());
            }
        });
    }

    private void ConvertData(List<ListArea> listAreas) {
        areaArrayList = new ArrayList<>();
        areaArrayList.addAll(listAreas);
        ListView(areaArrayList);

    }


}
