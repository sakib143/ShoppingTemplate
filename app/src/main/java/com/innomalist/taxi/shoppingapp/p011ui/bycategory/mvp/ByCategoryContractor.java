package com.innomalist.taxi.shoppingapp.p011ui.bycategory.mvp;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.model.bycategory.ByCategoryRequest;
import com.innomalist.taxi.shoppingapp.model.bycategory.ByCategoryResult;
import com.kiandashopping.kiandashopping.ViewInterface;

import io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.mvp.ByCategoryContractor */
public interface ByCategoryContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.mvp.ByCategoryContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestByCategory(ByCategoryRequest byCategoryRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.mvp.ByCategoryContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onResult(ByCategoryResult byCategoryResult);

        void onResultError(String str);

        void requestByCategory(String str, String str2);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.mvp.ByCategoryContractor$View */
    public interface View extends ViewInterface {
        void showResult(ByCategoryResult byCategoryResult);

        void showResultError(String str);
    }
}
