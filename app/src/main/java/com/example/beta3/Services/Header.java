package com.example.beta3.Services;

import com.example.beta3.Request.Location;
import com.example.beta3.Request.RequestHeader;

public class Header {
    public static RequestHeader requestHeader = new RequestHeader();
    public static Location location = new Location();
    public static String clientRequestId;

    static void setHeader() {

        if (requestHeader == null) {
            requestHeader = new RequestHeader();
        }
        requestHeader.setChannelCode("VIVIET_APP");
        requestHeader.setClientAddress("127.0.0.1");
        requestHeader.setClientRequestId(clientRequestId);

        requestHeader.setClientSessionId("");
        requestHeader.setDeviceId("abc-123-def-456");
        requestHeader.setExchangeIV("");
        requestHeader.setSystemCode("VIVIET");
        requestHeader.setLanguage("vi");
        requestHeader.setLocation(location);
        requestHeader.setPlatform("android");
        requestHeader.setPlatformVersion("");
        requestHeader.setSdkId("123");
        requestHeader.setSecretKey("");
        requestHeader.setSignature("");

    }


    public static void setClientRequestId(String clientRequestId) {
        Header.clientRequestId = clientRequestId;
        location.setLatitude("0");
        location.setLongitude("0");
        setHeader();

    }

    public static RequestHeader getHeader() {
        return requestHeader;
    }

}
