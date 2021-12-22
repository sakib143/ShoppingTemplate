package com.innomalist.taxi.shoppingapp.p011ui.storedetails.mvp;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.ViewInterface;
import com.innomalist.taxi.shoppingapp.model.storelist.RequestAddStoreReview;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreDetailRequest;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreDetailsResult;
//import com.kiandashopping.kiandashopping.ModelInterface;

import io.reactivex.disposables.Disposable;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.ViewInterface;
//import com.kiandashopping.kiandashopping.model.storelist.RequestAddStoreReview;
//import com.kiandashopping.kiandashopping.model.storelist.StoreDetailRequest;
//import com.kiandashopping.kiandashopping.model.storelist.StoreDetailsResult;
//import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.mvp.StoreDetailsContractor */
public interface StoreDetailsContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.mvp.StoreDetailsContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestAddReview(RequestAddStoreReview requestAddStoreReview);

        Disposable requestStoreDetails(StoreDetailRequest storeDetailRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.mvp.StoreDetailsContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onAddReview(int i, float f, String str, String str2);

        void onResult(StoreDetailsResult storeDetailsResult);

        void onResultError(String str);

        void requestStoreDetails(int i);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.mvp.StoreDetailsContractor$View */
    public interface View extends ViewInterface {
        void showResult(StoreDetailsResult storeDetailsResult);

        void showResultError(String str);
    }
}
