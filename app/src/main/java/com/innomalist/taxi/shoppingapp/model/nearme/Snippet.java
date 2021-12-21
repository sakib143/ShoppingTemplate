package com.innomalist.taxi.shoppingapp.model.nearme;

import android.graphics.Bitmap;
import java.io.Serializable;

public class Snippet implements Serializable {
    private Bitmap bitmap;
    private String description;

    /* renamed from: id */
    private int f219id;
    private String image;
    private String name;

    public Snippet(String str, String str2, String str3, int i) {
        this.name = str;
        this.description = str2;
        this.image = str3;
        this.f219id = i;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public int getId() {
        return this.f219id;
    }
}
