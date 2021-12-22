package com.innomalist.taxi.shoppingapp.p011ui.wishlist.mvp;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.itemdetails.RequestAddWishList;
import com.innomalist.taxi.shoppingapp.model.wishlist.MyWishListResult;
import com.kiandashopping.kiandashopping.ViewInterface;
import java.util.List;

import io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.mvp.WishListContractor */
public interface WishListContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.mvp.WishListContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestAddWishList(RequestAddWishList requestAddWishList);

        Disposable requestWishList(LangRequest langRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.mvp.WishListContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onAddWish(int i, int i2);

        void onResult(List<MyWishListResult> list);

        void onResultError(String str);

        void onWishListError(String str);

        void onWishListResult(BaseResponse baseResponse);

        void requestWishList(LangRequest langRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.mvp.WishListContractor$View */
    public interface View extends ViewInterface {
        void showResult(List<MyWishListResult> list);

        void showResultError();

        void showWishListError(int i, String str);

        void showWishListResult(int i, BaseResponse baseResponse);
    }
}
