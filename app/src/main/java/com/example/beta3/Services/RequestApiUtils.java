package com.example.beta3.Services;

import android.content.Context;

import com.example.beta3.Request.Base64Request;
import com.example.beta3.Request.GetRequest;

public class RequestApiUtils {

    public static Base64Request createRequest(String body, Context context) {
        Base64Request base64Request = new Base64Request();
        base64Request.setBody(body);
        try {
            Header.setClientRequestId(String.valueOf(GetRequest.getClientRequestId(context)));
        } catch (Exception e) {
        }
        base64Request.setRequestHeader(Header.getHeader());


        return base64Request;
    }


}
