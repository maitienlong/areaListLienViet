package com.example.beta3.Services;
import com.example.beta3.Request.Base64Request;
import com.example.beta3.Response.Base64Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitServices {
    @POST("/lifecard-app/area/req")
    Call<Base64Response> getArea(@Body Base64Request requestBase64);
}
