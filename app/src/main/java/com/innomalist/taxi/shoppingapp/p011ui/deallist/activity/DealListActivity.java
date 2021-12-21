package com.kiandashopping.kiandashopping.p011ui.deallist.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.model.deallist.RequestDealList;
import com.kiandashopping.kiandashopping.model.deallist.ResultDealList;
import com.kiandashopping.kiandashopping.p011ui.deallist.adapter.DealListAdapter;
import com.kiandashopping.kiandashopping.p011ui.deallist.mvp.DealListContractor;
import com.kiandashopping.kiandashopping.p011ui.deallist.mvp.DealListPresenter;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.activity.ProductDetailActivity;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.deallist.activity.DealListActivity */
public class DealListActivity extends BaseActivity implements DealListContractor.View, DealListAdapter.Listener {
    DealListAdapter dealListAdapter;
    DealListPresenter dealListPresenter;
    RequestDealList resultDealList = new RequestDealList();
    List<ResultDealList> resultDealLists;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f243rv;

    public int getLayout() {
        return R.layout.activity_view_all_category;
    }

    public static Intent builtIntent(Activity activity) {
        return new Intent(activity, DealListActivity.class);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.title.setText(ResourceUtils.getString(R.string.deals));
        this.dealListPresenter = new DealListPresenter(this);
        this.resultDealList.setPageNo("1");
        this.resultDealList.setTitle("");
        setRecyclerView();
    }

    private void setRecyclerView() {
        this.f243rv.setLayoutManager(new GridLayoutManager((Context) this, 2, 1, false));
        ArrayList arrayList = new ArrayList();
        this.resultDealLists = arrayList;
        DealListAdapter dealListAdapter2 = new DealListAdapter(arrayList, this);
        this.dealListAdapter = dealListAdapter2;
        this.f243rv.setAdapter(dealListAdapter2);
    }

    public PresenterInterface getPresenterInterface() {
        return this.dealListPresenter;
    }

    public void onClickItem(ResultDealList resultDealList2) {
        changeActivity(ProductDetailActivity.builtIntent(this, resultDealList2.getDealId().intValue(), true));
    }

    public void onClickLoad(int i) {
        this.resultDealList.setPageNo(this.dealListAdapter.getPageNumber());
        this.dealListPresenter.requestAllDeals(this.resultDealList);
    }

    public void showResult(List<ResultDealList> list) {
        this.resultDealLists.addAll(list);
        this.dealListAdapter.onLoadFinished(list.size());
    }
}
