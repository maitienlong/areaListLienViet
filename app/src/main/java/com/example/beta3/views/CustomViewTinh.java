package com.example.beta3.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.databinding.DataBindingUtil;

import com.example.beta3.R;
import com.example.beta3.databinding.CusTinhBinding;
import com.example.beta3.viewmodel.ViewModelTinh;

public class CustomViewTinh extends RelativeLayout {
    public CustomViewTinh(Context context) {
        super(context);
        CusTinhBinding cusTinhBinding = DataBindingUtil.setContentView((Activity) context, R.layout.cus_tinh);
        cusTinhBinding.setCustomViewTinh(new ViewModelTinh((Activity) context,cusTinhBinding));
        cusTinhBinding.executePendingBindings();
        Log.e("DEMOOO", "1");
    }

    public CustomViewTinh(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewTinh(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomViewTinh(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
