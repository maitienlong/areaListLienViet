package com.example.beta3.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.example.beta3.R;
import com.example.beta3.Request.Base64Request;
import com.example.beta3.Services.RequestApiUtils;
import com.example.beta3.Response.Base64Response;
import com.example.beta3.Services.MyRetrofit;
import com.example.beta3.Services.RetrofitServices;
import com.example.beta3.databinding.ActivityProviceBinding;
import com.example.beta3.databinding.CusTinhBinding;
import com.example.beta3.models.Example;
import com.example.beta3.models.ListArea;
import com.example.beta3.viewmodel.ViewModelProvince;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProvinceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_provice);
        ActivityProviceBinding activityProviceBinding = DataBindingUtil.setContentView(this,R.layout.activity_provice);
        activityProviceBinding.setProvinceActivity(new ViewModelProvince(this,activityProviceBinding));

    }
}