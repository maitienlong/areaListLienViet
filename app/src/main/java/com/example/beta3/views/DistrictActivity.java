package com.example.beta3.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.beta3.R;
import com.example.beta3.databinding.ActivityDistrictBinding;
import com.example.beta3.viewmodel.ViewModelDistrict;

public class DistrictActivity extends AppCompatActivity {
    ActivityDistrictBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_district);
        Intent intent = getIntent();
        String body = intent.getStringExtra("body");
        Log.e("DistrictActivity", body);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_district);
        ViewModelDistrict viewModelDistrict = new ViewModelDistrict(this,binding,body);
        binding.setDistrictActivity(viewModelDistrict);

    }
}