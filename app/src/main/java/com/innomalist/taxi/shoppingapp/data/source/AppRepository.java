package com.innomalist.taxi.shoppingapp.data.source;

public class AppRepository implements AppDataSource {
    private AppDataSource mSharedPrefercenseDataSource;

    public void delete() {
        this.mSharedPrefercenseDataSource.delete();
    }

    public AppRepository(AppDataSource appDataSource) {
        this.mSharedPrefercenseDataSource = appDataSource;
    }

    public void saveIsLoggedIn(boolean z) {
        this.mSharedPrefercenseDataSource.saveIsLoggedIn(z);
    }

    public boolean isLoggedIn() {
        return this.mSharedPrefercenseDataSource.isLoggedIn();
    }

    public void setUserId(String str) {
        this.mSharedPrefercenseDataSource.setUserId(str);
    }

    public String getUserId() {
        return this.mSharedPrefercenseDataSource.getUserId();
    }

    public void setOAuthKey(String str) {
        this.mSharedPrefercenseDataSource.setOAuthKey(str);
    }

    public String getOAuthKey() {
        return this.mSharedPrefercenseDataSource.getOAuthKey();
    }

    public void saveIsShowIntro(boolean z) {
        this.mSharedPrefercenseDataSource.saveIsShowIntro(z);
    }

    public boolean isShowIntro() {
        return this.mSharedPrefercenseDataSource.isShowIntro();
    }

    public void setFCMToken(String str) {
        this.mSharedPrefercenseDataSource.setFCMToken(str);
    }

    public String getFCMToken() {
        return this.mSharedPrefercenseDataSource.getFCMToken();
    }

    public void setFirstName(String str) {
        this.mSharedPrefercenseDataSource.setFirstName(str);
    }

    public void setLastName(String str) {
        this.mSharedPrefercenseDataSource.setLastName(str);
    }

    public void setEmail(String str) {
        this.mSharedPrefercenseDataSource.setEmail(str);
    }

    public String getFirstName() {
        return this.mSharedPrefercenseDataSource.getFirstName();
    }

    public String getLastName() {
        return this.mSharedPrefercenseDataSource.getLastName();
    }

    public String getEmail() {
        return this.mSharedPrefercenseDataSource.getEmail();
    }

    public void setLanguage(String str) {
        this.mSharedPrefercenseDataSource.setLanguage(str);
    }

    public void setAvatar(String str) {
        this.mSharedPrefercenseDataSource.setAvatar(str);
    }

    public void setCurrencyCode(String str) {
        this.mSharedPrefercenseDataSource.setCurrencyCode(str);
    }

    public void setShippingAddress(String str) {
        this.mSharedPrefercenseDataSource.setShippingAddress(str);
    }

    public void setCartCount(int i) {
        this.mSharedPrefercenseDataSource.setCartCount(i);
    }

    public String getAvatar() {
        return this.mSharedPrefercenseDataSource.getAvatar();
    }

    public String getCurrencyCode() {
        return this.mSharedPrefercenseDataSource.getCurrencyCode();
    }

    public Integer getCartCount() {
        return this.mSharedPrefercenseDataSource.getCartCount();
    }

    public String getShippingAddress() {
        return this.mSharedPrefercenseDataSource.getShippingAddress();
    }

    public String getLanguage() {
        return this.mSharedPrefercenseDataSource.getLanguage();
    }
}
