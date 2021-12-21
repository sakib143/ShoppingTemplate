package com.innomalist.taxi.shoppingapp.model.storelist;


import com.innomalist.taxi.shoppingapp.model.category.LangRequest;

public class StoreDetailRequest extends LangRequest {
    private int shopId;

    public StoreDetailRequest(String str, String str2, int i) {
        super(str, str2);
        this.shopId = i;
    }
}
