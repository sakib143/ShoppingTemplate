package com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.deals;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseFragment;
import com.kiandashopping.kiandashopping.model.storelist.DealListByShop;
import com.kiandashopping.kiandashopping.model.storelist.StoreDetailsResult;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.activity.ProductDetailActivity;
import com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.deals.adapter.DealsAdapter;
import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsContractor;
import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsPresenter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.deals.DealsFragment */
public class DealsFragment extends BaseFragment implements StoreDetailsContractor.View, DealsAdapter.Listener {
    private static final String ARG_DEALS_LIST = "dealListByShops";
    private static final String ARG_STORE_ID = "storeId";
    private DealsAdapter dealsAdapter;
    private List<DealListByShop> objectList = new ArrayList();
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f257rv;
    private StoreDetailsPresenter storeDetailsPresenter;

    public static Fragment builtFragment(int i, ArrayList<DealListByShop> arrayList) {
        DealsFragment dealsFragment = new DealsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_STORE_ID, i);
        bundle.putParcelableArrayList(ARG_DEALS_LIST, arrayList);
        dealsFragment.setArguments(bundle);
        return dealsFragment;
    }

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f257rv.setVisibility(8);
        this.f257rv.setLayoutManager(new GridLayoutManager((Context) getActivity(), 2, 1, false));
        this.storeDetailsPresenter = new StoreDetailsPresenter(this);
        ArrayList arrayList = new ArrayList();
        this.objectList = arrayList;
        DealsAdapter dealsAdapter2 = new DealsAdapter(arrayList, this);
        this.dealsAdapter = dealsAdapter2;
        this.f257rv.setAdapter(dealsAdapter2);
        show(AppUtils.getDealDetails(getArguments(), ARG_DEALS_LIST));
    }

    public PresenterInterface getPresenterInterface() {
        return this.storeDetailsPresenter;
    }

    public void showResult(StoreDetailsResult storeDetailsResult) {
        show(storeDetailsResult.getDealListByShop());
    }

    private void show(List<DealListByShop> list) {
        this.f257rv.setVisibility(0);
        this.objectList.addAll(list);
        this.dealsAdapter.onLoadFinished(list.size());
    }

    public void showResultError(String str) {
        showToast(str);
        show(new ArrayList());
    }

    public void onClickItem(DealListByShop dealListByShop) {
        changeActivity(ProductDetailActivity.builtIntent(getActivity(), dealListByShop.getDealId().intValue(), true));
    }
}
