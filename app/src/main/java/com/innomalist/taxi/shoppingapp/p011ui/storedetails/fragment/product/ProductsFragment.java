package com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.product;

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
import com.kiandashopping.kiandashopping.model.storelist.ProductListByShop;
import com.kiandashopping.kiandashopping.model.storelist.StoreDetailsResult;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.activity.ProductDetailActivity;
import com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.product.adapter.ProductAdapter;
import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsContractor;
import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsPresenter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.product.ProductsFragment */
public class ProductsFragment extends BaseFragment implements StoreDetailsContractor.View, ProductAdapter.Listener {
    private static final String ARG_PRODUCT_LIST = "product_LIST";
    private static final String ARG_STORE_ID = "storeId";
    private List<ProductListByShop> objectList = new ArrayList();
    private ProductAdapter productAdapter;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f258rv;
    private StoreDetailsPresenter storeDetailsPresenter;

    public static Fragment builtFragment(int i, ArrayList<ProductListByShop> arrayList) {
        ProductsFragment productsFragment = new ProductsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_STORE_ID, i);
        bundle.putParcelableArrayList(ARG_PRODUCT_LIST, arrayList);
        productsFragment.setArguments(bundle);
        return productsFragment;
    }

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f258rv.setVisibility(8);
        this.f258rv.setLayoutManager(new GridLayoutManager((Context) getActivity(), 2, 1, false));
        this.storeDetailsPresenter = new StoreDetailsPresenter(this);
        ArrayList arrayList = new ArrayList();
        this.objectList = arrayList;
        ProductAdapter productAdapter2 = new ProductAdapter(arrayList, this);
        this.productAdapter = productAdapter2;
        this.f258rv.setAdapter(productAdapter2);
        show(AppUtils.getProductDetails(getArguments(), ARG_PRODUCT_LIST));
    }

    public PresenterInterface getPresenterInterface() {
        return this.storeDetailsPresenter;
    }

    public void showResult(StoreDetailsResult storeDetailsResult) {
        show(storeDetailsResult.getProductListByShop());
    }

    private void show(List<ProductListByShop> list) {
        this.f258rv.setVisibility(0);
        this.objectList.addAll(list);
        this.productAdapter.onLoadFinished(list.size());
    }

    public void showResultError(String str) {
        showToast(str);
        show(new ArrayList());
    }

    public void onClickItem(ProductListByShop productListByShop) {
        changeActivity(ProductDetailActivity.builtIntent(getActivity(), productListByShop.getProductId().intValue(), false));
    }
}
