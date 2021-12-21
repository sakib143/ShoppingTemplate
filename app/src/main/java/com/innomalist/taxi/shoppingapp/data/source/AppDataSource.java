package com.innomalist.taxi.shoppingapp.data.source;

public interface AppDataSource {
    void delete();

    String getAvatar();

    Integer getCartCount();

    String getCurrencyCode();

    String getEmail();

    String getFCMToken();

    String getFirstName();

    String getLanguage();

    String getLastName();

    String getOAuthKey();

    String getShippingAddress();

    String getUserId();

    boolean isLoggedIn();

    boolean isShowIntro();

    void saveIsLoggedIn(boolean z);

    void saveIsShowIntro(boolean z);

    void setAvatar(String str);

    void setCartCount(int i);

    void setCurrencyCode(String str);

    void setEmail(String str);

    void setFCMToken(String str);

    void setFirstName(String str);

    void setLanguage(String str);

    void setLastName(String str);

    void setOAuthKey(String str);

    void setShippingAddress(String str);

    void setUserId(String str);
}
