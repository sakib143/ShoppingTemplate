package com.innomalist.taxi.shoppingapp.model.viewall;

public class ProductFilter {
    private FilterType filterType;

    /* renamed from: id */
    private String f220id;
    private boolean isChecked;
    private String sortBy;

        public enum FilterType {
        HEADER,
        PRICE,
        DISCOUNT
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String str) {
        this.sortBy = str;
    }

    public String getId() {
        return this.f220id;
    }

    public void setId(String str) {
        this.f220id = str;
    }

    public FilterType getFilterType() {
        return this.filterType;
    }

    public void setFilterType(FilterType filterType2) {
        this.filterType = filterType2;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public ProductFilter(String str, String str2, FilterType filterType2, boolean z) {
        this.sortBy = str;
        this.f220id = str2;
        this.filterType = filterType2;
        this.isChecked = z;
    }
}
