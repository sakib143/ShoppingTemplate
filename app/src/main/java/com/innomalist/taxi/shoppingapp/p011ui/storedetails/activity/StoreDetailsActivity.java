package com.kiandashopping.kiandashopping.p011ui.storedetails.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.google.android.material.tabs.TabLayout;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.model.storelist.StoreDetailsResult;
import com.kiandashopping.kiandashopping.p011ui.storedetails.adapter.StoreViewPageAdapter;
import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsContractor;
import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsPresenter;
import com.kiandashopping.kiandashopping.util.AppUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.activity.StoreDetailsActivity */
public class StoreDetailsActivity extends BaseActivity implements StoreDetailsContractor.View {
    private static final String ARG_SHOP_ID = "shopId";
    private static final String ARG_SHOP_NAME = "shopName";
    StoreDetailsPresenter storeDetailsPresenter;
    @BindView(2131362312)
    TabLayout tabLayout;
    @BindView(2131362175)
    ViewPager viewPager;

    public int getLayout() {
        return R.layout.activity_store_details;
    }

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    public static Intent builtIntent(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, StoreDetailsActivity.class);
        intent.putExtra(ARG_SHOP_ID, i);
        intent.putExtra(ARG_SHOP_NAME, str);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.storeDetailsPresenter = new StoreDetailsPresenter(this);
        setupToolBar();
        this.title.setText(AppUtils.getString(getIntent(), ARG_SHOP_NAME));
        this.storeDetailsPresenter.requestStoreDetails(AppUtils.getInt(getIntent(), ARG_SHOP_ID));
    }

    public void showResult(StoreDetailsResult storeDetailsResult) {
        this.viewPager.setAdapter(new StoreViewPageAdapter(getSupportFragmentManager(), storeDetailsResult, AppUtils.getInt(getIntent(), ARG_SHOP_ID)));
        this.tabLayout.setupWithViewPager(this.viewPager);
    }

    public void showResultError(String str) {
        showConnectionError(str);
    }
}
