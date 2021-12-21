package com.innomalist.taxi.shoppingapp.model.viewall;

public class ProductSortBy {

    /* renamed from: id */
    private String f221id;
    private boolean isChecked;
    private String sortBy;

    public ProductSortBy(String str, String str2, boolean z) {
        this.sortBy = str;
        this.f221id = str2;
        this.isChecked = z;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String str) {
        this.sortBy = str;
    }

    public String getId() {
        return this.f221id;
    }

    public void setId(String str) {
        this.f221id = str;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }
}
