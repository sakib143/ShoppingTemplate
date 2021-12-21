package com.kiandashopping.kiandashopping.p011ui.deallist.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.deallist.RequestDealList;
import com.kiandashopping.kiandashopping.model.deallist.ResultDealList;
import java.util.List;
import p013io.reactivex.disposables.Disposable;

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
