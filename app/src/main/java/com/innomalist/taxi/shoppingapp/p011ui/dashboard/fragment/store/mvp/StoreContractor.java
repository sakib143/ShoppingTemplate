package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.store.mvp;

//import com.kiandashopping.kiandashopping.ModelInterface;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.ViewInterface;
//import com.kiandashopping.kiandashopping.model.category.LangRequest;
//import com.kiandashopping.kiandashopping.model.storelist.StoreResult;
import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.ViewInterface;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreResult;

import java.util.List;

import io.reactivex.disposables.Disposable;
//import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.mvp.StoreContractor */
public interface StoreContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.mvp.StoreContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestStore(LangRequest langRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.mvp.StoreContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onResult(List<StoreResult> list);

        void onResultError(String str);

        void requestStore(LangRequest langRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.mvp.StoreContractor$View */
    public interface View extends ViewInterface {
        void showResult(List<StoreResult> list);
    }
}
