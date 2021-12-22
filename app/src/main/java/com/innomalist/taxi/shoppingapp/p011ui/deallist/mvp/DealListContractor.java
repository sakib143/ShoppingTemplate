package com.innomalist.taxi.shoppingapp.p011ui.deallist.mvp;

//import com.kiandashopping.kiandashopping.ModelInterface;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.ViewInterface;
//import com.kiandashopping.kiandashopping.model.deallist.RequestDealList;
import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.ViewInterface;
import com.innomalist.taxi.shoppingapp.model.deallist.RequestDealList;
import com.kiandashopping.kiandashopping.model.deallist.ResultDealList;
import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;
//import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.deallist.mvp.DealListContractor */
public interface DealListContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.deallist.mvp.DealListContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestAllDeals(RequestDealList requestDealList);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.deallist.mvp.DealListContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onResult(List<ResultDealList> list);

        void onResultError(String str);

        void requestAllDeals(RequestDealList requestDealList);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.deallist.mvp.DealListContractor$View */
    public interface View extends ViewInterface {
        void showResult(List<ResultDealList> list);
    }
}
