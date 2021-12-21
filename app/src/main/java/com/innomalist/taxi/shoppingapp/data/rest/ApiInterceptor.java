package com.innomalist.taxi.shoppingapp.data.rest;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class ApiInterceptor implements Interceptor {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().build());
    }
}
