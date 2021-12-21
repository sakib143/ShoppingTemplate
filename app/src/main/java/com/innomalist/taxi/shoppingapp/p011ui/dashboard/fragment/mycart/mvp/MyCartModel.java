package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.mvp;

import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.mycart.DeleteCartRequest;
import com.kiandashopping.kiandashopping.model.mycart.MyCartResult;
import com.kiandashopping.kiandashopping.model.mycart.UpdateCartDealRequest;
import com.kiandashopping.kiandashopping.model.mycart.UpdateCartProductRequest;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.mvp.MyCartContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.mvp.MyCartModel */
public class MyCartModel extends BaseModel implements MyCartContractor.Model {
    private static final int IS_PRODUCT = 1;
    /* access modifiers changed from: private */
    public MyCartContractor.Presenter presenter;

    MyCartModel(MyCartPresenter myCartPresenter) {
        this.presenter = myCartPresenter;
    }

    public Disposable requestCart(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestCart(langRequest), new DisposableSingleObserver<BaseResponse<MyCartResult>>() {
            public void onSuccess(BaseResponse<MyCartResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    MyCartModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    MyCartModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                MyCartModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestUpdateCartProduct(UpdateCartProductRequest updateCartProductRequest) {
        return addRequest(this.apiInterface.requestUpdateProdtCart(updateCartProductRequest), new DisposableSingleObserver<BaseResponse<MyCartResult>>() {
            public void onSuccess(BaseResponse<MyCartResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    MyCartModel.this.requestCart(new LangRequest(BaseApplication.getAppRepository().getLanguage(), BaseApplication.getAppRepository().getUserId()));
                } else {
                    MyCartModel.this.presenter.onUpdateError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                MyCartModel.this.presenter.onUpdateError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestUpdateCartDeal(UpdateCartDealRequest updateCartDealRequest) {
        return addRequest(this.apiInterface.requestUpdateDealCart(updateCartDealRequest), new DisposableSingleObserver<BaseResponse<MyCartResult>>() {
            public void onSuccess(BaseResponse<MyCartResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    MyCartModel.this.requestCart(new LangRequest(BaseApplication.getAppRepository().getLanguage(), BaseApplication.getAppRepository().getUserId()));
                } else {
                    MyCartModel.this.presenter.onUpdateError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                MyCartModel.this.presenter.onUpdateError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestDeleteCart(int i, DeleteCartRequest deleteCartRequest) {
        return addRequest(i == 1 ? this.apiInterface.requestRemoveProductCart(deleteCartRequest) : this.apiInterface.requestRemoveDealCart(deleteCartRequest), new DisposableSingleObserver<BaseResponse<MyCartResult>>() {
            public void onSuccess(BaseResponse<MyCartResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    MyCartModel.this.requestCart(new LangRequest(BaseApplication.getAppRepository().getLanguage(), BaseApplication.getAppRepository().getUserId()));
                } else {
                    MyCartModel.this.presenter.onUpdateError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                MyCartModel.this.presenter.onUpdateError(AppUtils.getError(th));
            }
        });
    }
}
