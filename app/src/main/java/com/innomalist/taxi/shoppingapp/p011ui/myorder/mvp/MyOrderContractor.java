package com.kiandashopping.kiandashopping.p011ui.myorder.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.myorder.OrderList;
import java.util.List;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.myorder.mvp.MyOrderContractor */
public interface MyOrderContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.myorder.mvp.MyOrderContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestMyOrder(LangRequest langRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.myorder.mvp.MyOrderContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onResult(List<OrderList> list);

        void onResultError(String str);

        void requestMyOrder(LangRequest langRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.myorder.mvp.MyOrderContractor$View */
    public interface View extends ViewInterface {
        void showResult(List<OrderList> list);
    }
}
