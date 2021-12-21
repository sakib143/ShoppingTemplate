package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.mycart.DeleteCartRequest;
import com.kiandashopping.kiandashopping.model.mycart.MyCartResult;
import com.kiandashopping.kiandashopping.model.mycart.UpdateCartDealRequest;
import com.kiandashopping.kiandashopping.model.mycart.UpdateCartProductRequest;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.mvp.MyCartContractor */
public interface MyCartContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.mvp.MyCartContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestCart(LangRequest langRequest);

        Disposable requestDeleteCart(int i, DeleteCartRequest deleteCartRequest);

        Disposable requestUpdateCartDeal(UpdateCartDealRequest updateCartDealRequest);

        Disposable requestUpdateCartProduct(UpdateCartProductRequest updateCartProductRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.mvp.MyCartContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void deleteCart(int i, int i2, int i3);

        void onDeleteSuccess(MyCartResult myCartResult);

        void onResult(MyCartResult myCartResult);

        void onResultError(String str);

        void onUpdateError(String str);

        void onUpdateSuccess(MyCartResult myCartResult);

        void requestCart();

        void updateCartDeal(int i, int i2, int i3, int i4);

        void updateCartProduct(int i, int i2, int i3, int i4);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.mvp.MyCartContractor$View */
    public interface View extends ViewInterface {
        void deleteCartSuccess(MyCartResult myCartResult, int i);

        void noRecordView();

        void showResponse(MyCartResult myCartResult);

        void showUpdateError(String str);

        void updateCartSuccess(MyCartResult myCartResult, int i, int i2);
    }
}
