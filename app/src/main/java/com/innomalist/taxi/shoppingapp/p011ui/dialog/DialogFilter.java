package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.model.viewall.ProductFilter;
import com.innomalist.taxi.shoppingapp.p011ui.dialog.adapter.DialogFilterAdapter;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment;
//import com.kiandashopping.kiandashopping.model.viewall.ProductFilter;
//import com.kiandashopping.kiandashopping.p011ui.dialog.adapter.DialogFilterAdapter;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogFilter */
public class DialogFilter extends BaseSheetFragment implements DialogFilterAdapter.FilterByListener {
    private DialogFilterAdapter dialogFilterAdapter;
    private String discount = "";
    private FilterListener filterListener;
    private String price = "";
    private ArrayList<ProductFilter> productFilters;
    @BindView(2131361982)
    RecyclerView recyclerView;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogFilter$FilterListener */
    public interface FilterListener {
        void onClick(String str, String str2);
    }

    public static DialogFilter newInstance(BaseActivity baseActivity) {
        DialogFilter dialogFilter = new DialogFilter();
        dialogFilter.setTitle(ResourceUtils.getString(R.string.filter));
        dialogFilter.setActivity(baseActivity);
        dialogFilter.setCustomLayout(R.layout.dialog_recyclerview);
        dialogFilter.setPositive(ResourceUtils.getString(R.string.btn_submit));
        return dialogFilter;
    }

    public void setFilter(int i, ProductFilter.FilterType filterType) {
        for (int i2 = 0; i2 < this.productFilters.size(); i2++) {
            if (this.productFilters.get(i2).getFilterType() == filterType) {
                if (i2 == i) {
                    this.productFilters.get(i2).setChecked(true);
                } else {
                    this.productFilters.get(i2).setChecked(false);
                }
            }
        }
        if (this.productFilters.get(i).getFilterType() == ProductFilter.FilterType.PRICE) {
            this.price = this.productFilters.get(i).getId();
        } else if (this.productFilters.get(i).getFilterType() == ProductFilter.FilterType.DISCOUNT) {
            this.discount = this.productFilters.get(i).getId();
        }
        this.dialogFilterAdapter.notifyDataSetChanged();
    }

    public void show(FilterListener filterListener2, String str, String str2) {
        this.filterListener = filterListener2;
        this.price = str;
        this.discount = str2;
        show();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList<ProductFilter> filters = AppUtils.getFilters(this.price, this.discount);
        this.productFilters = filters;
        this.dialogFilterAdapter = new DialogFilterAdapter(this, filters);
        this.recyclerView.addItemDecoration(new DividerItemDecoration((Context) Objects.requireNonNull(getActivity()), 1));
        this.recyclerView.setAdapter(this.dialogFilterAdapter);
    }

    public void onClickPositive() {
        this.filterListener.onClick(this.price, this.discount);
        dismiss();
    }
}
