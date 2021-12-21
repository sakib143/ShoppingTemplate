package com.kiandashopping.kiandashopping.p011ui.wishlist.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.RequestAddWishList;
import com.kiandashopping.kiandashopping.model.wishlist.MyWishListResult;
import java.util.List;
import p013io.reactivex.disposables.Disposable;

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
