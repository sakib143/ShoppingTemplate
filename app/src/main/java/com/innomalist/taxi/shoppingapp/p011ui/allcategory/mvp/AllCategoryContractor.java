package com.innomalist.taxi.shoppingapp.p011ui.allcategory.mvp;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.ViewInterface;
import com.innomalist.taxi.shoppingapp.model.category.CategoriesList;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
//import com.kiandashopping.kiandashopping.ViewInterface;
import java.util.List;

import io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.allcategory.mvp.AllCategoryContractor */
public interface AllCategoryContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.allcategory.mvp.AllCategoryContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestCategory(LangRequest langRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.allcategory.mvp.AllCategoryContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onError(String str);

        void onResultCategory(List<CategoriesList> list);

        void requestCategory();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.allcategory.mvp.AllCategoryContractor$View */
    public interface View extends ViewInterface {
        void showDashBoardActivity(List<CategoriesList> list);
    }
}
