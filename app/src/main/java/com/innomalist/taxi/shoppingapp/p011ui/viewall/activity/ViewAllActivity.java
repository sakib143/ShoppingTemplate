package com.innomalist.taxi.shoppingapp.p011ui.viewall.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
//import com.kiandashopping.kiandashopping.model.viewall.AllItemRequest;
//import com.kiandashopping.kiandashopping.model.viewall.ProductList;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.model.viewall.AllItemRequest;
import com.innomalist.taxi.shoppingapp.model.viewall.ProductList;
import com.innomalist.taxi.shoppingapp.p011ui.dialog.DialogFilter;
import com.innomalist.taxi.shoppingapp.p011ui.viewall.adapter.ViewAllAdapter;
import com.innomalist.taxi.shoppingapp.p011ui.viewall.mvp.ViewAllContractor;
import com.innomalist.taxi.shoppingapp.p011ui.viewall.mvp.ViewAllPresenter;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.ItemOffsetDecoration;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
//import com.kiandashopping.kiandashopping.p011ui.dialog.DialogFilter;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogSortBy;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.activity.ProductDetailActivity;
//import com.kiandashopping.kiandashopping.p011ui.viewall.adapter.ViewAllAdapter;
//import com.kiandashopping.kiandashopping.p011ui.viewall.mvp.ViewAllContractor;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.ItemOffsetDecoration;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.viewall.activity.ViewAllActivity */
public class ViewAllActivity extends BaseActivity implements ViewAllContractor.View, ViewAllAdapter.Listener {
    private static final String ARG_CATEGORY_ID = "categoryId";
    private static final String ARG_SEARCH_TEXT = "searchText";
    private static final String ARG_SEC_CATEGORY_ID = "secCategoryId";
    private static final String ARG_SUB_CATEGORY_ID = "subcategoryId";
    private static final String ARG_SUB_SEC_CATEGORY_ID = "subSecCategoryId";
    private static final String ARG_VIEW_TYPE = "viewType";
    AllItemRequest allItemRequest = new AllItemRequest();
    String categoryId = "";
    String discount = "";
    @BindView(2131362137)
    LinearLayout llTopFilter;
    String price = "";
    List<ProductList> productLists;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f261rv;
    String searchText = "";
    String secCategoryId = "";
    String sortBy = "";
    String subSecCategoryId = "";
    String subcategoryId = "";
    ViewAllAdapter viewAllAdapter;
    ViewAllPresenter viewAllPresenter;

    public int getLayout() {
        return R.layout.activity_view_all;
    }

    public static Intent builtIntent(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        Intent intent = new Intent(activity, ViewAllActivity.class);
        intent.putExtra(ARG_VIEW_TYPE, str);
        intent.putExtra(ARG_CATEGORY_ID, str2);
        intent.putExtra(ARG_SUB_CATEGORY_ID, str3);
        intent.putExtra(ARG_SEC_CATEGORY_ID, str4);
        intent.putExtra(ARG_SUB_SEC_CATEGORY_ID, str5);
        intent.putExtra(ARG_SEARCH_TEXT, str6);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        String string = AppUtils.getString(getIntent(), ARG_VIEW_TYPE);
        setCategory(string);
        this.title.setText(string);
        this.viewAllPresenter = new ViewAllPresenter(this);
        this.allItemRequest.setDiscount(this.discount);
        this.allItemRequest.setPageNo("1");
        this.allItemRequest.setAvailability("1");
        this.allItemRequest.setPriceMin("");
        this.allItemRequest.setPriceMax("");
        this.allItemRequest.setTitle(this.searchText);
        this.allItemRequest.setMainCategoryId(this.categoryId);
        this.allItemRequest.setSortOrderBy(this.sortBy);
        this.allItemRequest.setSubCategoryId(this.subcategoryId);
        this.allItemRequest.setSecCategoryId(this.secCategoryId);
        this.allItemRequest.setSubSecCategoryId(this.subSecCategoryId);
        setRecyclerView();
    }

    private void setCategory(String str) {
        if (str.equals(ResourceUtils.getString(R.string.best_offer))) {
            this.discount = "";
            this.sortBy = "4";
        } else if (str.equals(ResourceUtils.getString(R.string.up_50_percent))) {
            this.discount = "7";
            this.sortBy = "4";
        } else if (str.equals(ResourceUtils.getString(R.string.most_popular))) {
            this.discount = "";
            this.sortBy = "1";
        } else {
            this.discount = "";
            this.sortBy = "";
        }
        this.searchText = AppUtils.getString(getIntent(), ARG_SEARCH_TEXT);
        this.categoryId = AppUtils.getString(getIntent(), ARG_CATEGORY_ID);
        this.subcategoryId = AppUtils.getString(getIntent(), ARG_SUB_CATEGORY_ID);
        this.secCategoryId = AppUtils.getString(getIntent(), ARG_SEC_CATEGORY_ID);
        this.subSecCategoryId = AppUtils.getString(getIntent(), ARG_SUB_SEC_CATEGORY_ID);
    }

    private void setRecyclerView() {
        findViewById(R.id.cardView).setVisibility(0);
        this.f261rv.setLayoutManager(new GridLayoutManager((Context) this, 2, 1, false));
        this.f261rv.addItemDecoration(new ItemOffsetDecoration(1));
        ArrayList arrayList = new ArrayList();
        this.productLists = arrayList;
        ViewAllAdapter viewAllAdapter2 = new ViewAllAdapter(arrayList, this);
        this.viewAllAdapter = viewAllAdapter2;
        this.f261rv.setAdapter(viewAllAdapter2);
    }

    public PresenterInterface getPresenterInterface() {
        return this.viewAllPresenter;
    }

    public void showAllItemResult(List<ProductList> list) {
        this.productLists.addAll(list);
        this.viewAllAdapter.onLoadFinished(list.size());
        this.llTopFilter.setVisibility(this.productLists.size() > 0 ? 0 : 8);
    }

    public void onClickItem(ProductList productList) {
        changeActivity(ProductDetailActivity.builtIntent(this, productList.getProductId().intValue(), false));
    }

    public void onClickLoad(int i) {
        this.allItemRequest.setPageNo(this.viewAllAdapter.getPageNumber());
        this.viewAllPresenter.requestAllItem(this.allItemRequest);
    }

    @OnClick({2131362135})
    public void setSortBy() {
        DialogSortBy.newInstance(this).show(new DialogSortBy.SortByListener() {
            public void onClick(String str) {
                ViewAllActivity.this.sortBy = str;
                ViewAllActivity.this.allItemRequest.setSortOrderBy(str);
                ViewAllActivity.this.productLists.clear();
                ViewAllActivity.this.viewAllAdapter.reLoad();
            }
        }, this.sortBy);
    }

    @OnClick({2131362130})
    public void setFilter() {
        DialogFilter.newInstance(this).show(new DialogFilter.FilterListener() {
            public void onClick(String str, String str2) {
                ViewAllActivity.this.price = str;
                ViewAllActivity.this.discount = str2;
                ViewAllActivity.this.allItemRequest.setPriceMin(AppUtils.getPriceRangeMin(ViewAllActivity.this.price));
                ViewAllActivity.this.allItemRequest.setPriceMax(AppUtils.getPriceRangeMax(ViewAllActivity.this.price));
                if (str2.equals("14")) {
                    ViewAllActivity.this.allItemRequest.setDiscount("");
                } else {
                    ViewAllActivity.this.allItemRequest.setDiscount(AppUtils.getDiscount(ViewAllActivity.this.discount));
                }
                ViewAllActivity.this.productLists.clear();
                ViewAllActivity.this.viewAllAdapter.reLoad();
            }
        }, this.price, this.discount);
    }
}
