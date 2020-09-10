
package com.example.beta3.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Base64Request {

    @SerializedName("restHeader")
    @Expose
    private RequestHeader requestHeader;
    @SerializedName("body")
    @Expose
    private String body;

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
