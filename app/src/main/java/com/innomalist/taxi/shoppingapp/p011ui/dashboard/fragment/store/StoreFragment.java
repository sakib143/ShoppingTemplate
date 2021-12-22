package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.BaseFragment;
//import com.kiandashopping.kiandashopping.model.category.LangRequest;
//import com.kiandashopping.kiandashopping.model.storelist.StoreResult;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseFragment;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreResult;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.store.adapter.StoreAdapter;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.store.adapter.StoreAdapter;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.store.mvp.StoreContractor;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.store.mvp.StorePresenter;
import com.innomalist.taxi.shoppingapp.p011ui.storedetails.activity.StoreDetailsActivity;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.store.mvp.StoreContractor;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.store.mvp.StorePresenter;
//import com.kiandashopping.kiandashopping.p011ui.storedetails.activity.StoreDetailsActivity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.StoreFragment */
public class StoreFragment extends BaseFragment implements StoreContractor.View, StoreAdapter.Listener {
    private LangRequest langRequest;
    private StorePresenter presenter;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f242rv;
    private StoreAdapter storeAdapter;
    private List<StoreResult> storeResultList;

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.presenter = new StorePresenter(this);
        LangRequest langRequest2 = new LangRequest();
        this.langRequest = langRequest2;
        langRequest2.setLang(this.appRepository.getLanguage());
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList arrayList = new ArrayList();
        this.storeResultList = arrayList;
        StoreAdapter storeAdapter2 = new StoreAdapter(arrayList, this);
        this.storeAdapter = storeAdapter2;
        this.f242rv.setAdapter(storeAdapter2);
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    public void onClickLoad(int i) {
        this.langRequest.setPageNo(this.storeAdapter.getPageNumber());
        this.presenter.requestStore(this.langRequest);
    }

    public void showResult(List<StoreResult> list) {
        this.storeResultList.addAll(list);
        this.storeAdapter.onLoadFinished(list.size());
    }

    public void onClickItem(StoreResult storeResult) {
        changeActivity(StoreDetailsActivity.builtIntent(getActivity(), storeResult.getStoreName(), storeResult.getStoreId().intValue()));
    }
}
