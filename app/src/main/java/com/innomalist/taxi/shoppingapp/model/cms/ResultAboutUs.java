package com.innomalist.taxi.shoppingapp.model.cms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultAboutUs {
    @SerializedName("content")
    @Expose
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
