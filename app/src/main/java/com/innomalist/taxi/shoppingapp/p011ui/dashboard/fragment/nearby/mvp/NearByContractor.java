package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.nearby.mvp;

//import com.kiandashopping.kiandashopping.ModelInterface;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.ViewInterface;
//import com.kiandashopping.kiandashopping.model.nearme.NearByRequest;
//import com.kiandashopping.kiandashopping.model.nearme.NearByResult;
import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.ViewInterface;
import com.innomalist.taxi.shoppingapp.model.nearme.NearByRequest;
import com.innomalist.taxi.shoppingapp.model.nearme.NearByResult;

import java.util.List;

import io.reactivex.disposables.Disposable;
//import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.mvp.NearByContractor */
public interface NearByContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.mvp.NearByContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestNearBy(NearByRequest nearByRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.mvp.NearByContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onResult(List<NearByResult> list);

        void onResultError(String str);

        void requestNearBy(String str, String str2);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.mvp.NearByContractor$View */
    public interface View extends ViewInterface {
        void showResult(List<NearByResult> list);
    }
}
