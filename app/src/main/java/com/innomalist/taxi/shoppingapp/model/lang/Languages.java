package com.innomalist.taxi.shoppingapp.model.lang;

public class Languages {
    boolean isActive;
    String language;
    String languageCode;

    public Languages(String str, String str2, boolean z) {
        this.language = str;
        this.languageCode = str2;
        this.isActive = z;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String str) {
        this.languageCode = str;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }
}
