package com.kiandashopping.kiandashopping.p011ui.viewall.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.viewall.AllItemRequest;
import com.kiandashopping.kiandashopping.model.viewall.ProductList;
import java.util.List;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.viewall.mvp.ViewAllContractor */
public interface ViewAllContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.viewall.mvp.ViewAllContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestDashboard(AllItemRequest allItemRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.viewall.mvp.ViewAllContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onAllItemResult(List<ProductList> list);

        void onAllItemResultError(String str);

        void requestAllItem(AllItemRequest allItemRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.viewall.mvp.ViewAllContractor$View */
    public interface View extends ViewInterface {
        void showAllItemResult(List<ProductList> list);
    }
}
