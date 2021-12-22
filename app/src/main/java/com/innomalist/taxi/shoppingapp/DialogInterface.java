package com.innomalist.taxi.shoppingapp;

public interface DialogInterface extends ViewInterface {
    int getLayout();

    boolean isShowing();

    void onClickNegative();

    void onClickPositive();

    void setCanceledOnTouchOutside(boolean z);

    void setCustomLayout(int i);

    void setMessage(String str);

    void setNegative(String str);

    void setPositive(String str);

    void setTitle(String str);

    void show();
}
