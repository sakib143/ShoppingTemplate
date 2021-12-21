package com.innomalist.taxi.shoppingapp.p011ui.bycategory.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.google.android.material.tabs.TabLayout;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.model.bycategory.ByCategoryResult;
import com.innomalist.taxi.shoppingapp.p011ui.bycategory.mvp.ByCategoryContractor;
import com.kiandashopping.kiandashopping.p011ui.bycategory.adapter.ViewPageAdapter;
import com.kiandashopping.kiandashopping.p011ui.bycategory.mvp.ByCategoryPresenter;
import com.kiandashopping.kiandashopping.util.AppUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.activity.ByCategoryActivity */
public class ByCategoryActivity extends BaseActivity implements ByCategoryContractor.View {
    private static final String ARG_CATEGORY_ID = "categoryId";
    private static final String ARG_CATEGORY_NAME = "categoryName";
    private static final String ARG_SUB_CATEGORY_ID = "subCategoryId";
    ByCategoryPresenter byCategoryPresenter;
    @BindView(2131362312)
    TabLayout tabLayout;
    @BindView(2131362175)
    ViewPager viewPager;

    public int getLayout() {
        return R.layout.activity_by_category;
    }

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    public static Intent builtIntent(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, ByCategoryActivity.class);
        intent.putExtra(ARG_CATEGORY_ID, str);
        intent.putExtra(ARG_SUB_CATEGORY_ID, str2);
        intent.putExtra(ARG_CATEGORY_NAME, str3);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.byCategoryPresenter = new ByCategoryPresenter(this);
        setupToolBar();
        this.title.setText(AppUtils.getString(getIntent(), ARG_CATEGORY_NAME));
        this.byCategoryPresenter.requestByCategory(AppUtils.getString(getIntent(), ARG_CATEGORY_ID), AppUtils.getString(getIntent(), ARG_SUB_CATEGORY_ID));
    }

    public void showResult(ByCategoryResult byCategoryResult) {
        if (byCategoryResult.getCategoriesList().size() > 0) {
            this.viewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(), byCategoryResult.getCategoriesList().get(0).getSecMaincategoryList(), AppUtils.getString(getIntent(), ARG_CATEGORY_ID)));
            this.tabLayout.setupWithViewPager(this.viewPager);
        }
    }

    public void showResultError(String str) {
        showConnectionError(str);
    }
}
