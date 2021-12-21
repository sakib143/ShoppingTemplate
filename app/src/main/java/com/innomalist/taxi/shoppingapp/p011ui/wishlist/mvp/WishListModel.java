package com.kiandashopping.kiandashopping.p011ui.wishlist.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.itemdetails.RequestAddWishList;
import com.kiandashopping.kiandashopping.model.wishlist.MyWishListResult;
import com.kiandashopping.kiandashopping.p011ui.wishlist.mvp.WishListContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.List;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.mvp.WishListModel */
public class WishListModel extends BaseModel implements WishListContractor.Model {
    /* access modifiers changed from: private */
    public WishListContractor.Presenter presenter;

    WishListModel(WishListPresenter wishListPresenter) {
        this.presenter = wishListPresenter;
    }

    public Disposable requestWishList(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestWishList(langRequest), new DisposableSingleObserver<BaseResponse<List<MyWishListResult>>>() {
            public void onSuccess(BaseResponse<List<MyWishListResult>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    WishListModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    WishListModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                WishListModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestAddWishList(RequestAddWishList requestAddWishList) {
        return addRequest(this.apiInterface.requestAddWishList(requestAddWishList), new DisposableSingleObserver<BaseResponse>() {
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse.isSuccess()) {
                    WishListModel.this.presenter.onWishListResult(baseResponse);
                } else {
                    WishListModel.this.presenter.onWishListError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                WishListModel.this.presenter.onWishListError(AppUtils.getError(th));
            }
        });
    }
}
