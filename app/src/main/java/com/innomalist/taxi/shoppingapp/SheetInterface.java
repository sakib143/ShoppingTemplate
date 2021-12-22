package com.innomalist.taxi.shoppingapp;

public interface SheetInterface extends ViewInterface {
    int getLayout();

    boolean isShowing();

    void setCustomLayout(int i);

    void show();
}
