package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.nearme.NearByRequest;
import com.kiandashopping.kiandashopping.model.nearme.NearByResult;
import java.util.List;
import p013io.reactivex.disposables.Disposable;

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
