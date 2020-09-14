package com.example.beta3.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.beta3.R;
import com.example.beta3.databinding.ActivityWardBinding;
import com.example.beta3.viewmodel.ViewModelDistrict;
import com.example.beta3.viewmodel.ViewModelWard;

public class WardActivity extends AppCompatActivity {
    ActivityWardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_ward);
        Intent intent = getIntent();
        String body = intent.getStringExtra("body");
        Log.e("DistrictActivity", body);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ward);
        ViewModelWard viewModelDistrict = new ViewModelWard(this,binding,body);
        binding.setWardActivity(viewModelDistrict);
    }
}