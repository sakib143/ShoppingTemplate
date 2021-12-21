package com.innomalist.taxi.shoppingapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {
    public static final int SUCCESS = 200;
    public static final int SUCCESS1 = 201;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    private T data;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("message")
    @Expose
    private String message;

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public Integer getStatus() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public boolean isSuccess() {
        return this.code.intValue() == 200 || this.code.intValue() == 201;
    }
}
