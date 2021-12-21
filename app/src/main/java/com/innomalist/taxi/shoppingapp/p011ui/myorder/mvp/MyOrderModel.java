package com.kiandashopping.kiandashopping.p011ui.myorder.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.myorder.OrderHistoryResult;
import com.kiandashopping.kiandashopping.p011ui.myorder.mvp.MyOrderContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.myorder.mvp.MyOrderModel */
public class MyOrderModel extends BaseModel implements MyOrderContractor.Model {
    /* access modifiers changed from: private */
    public MyOrderContractor.Presenter presenter;

    MyOrderModel(MyOrderPresenter myOrderPresenter) {
        this.presenter = myOrderPresenter;
    }

    public Disposable requestMyOrder(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestMyOrders(langRequest), new DisposableSingleObserver<BaseResponse<OrderHistoryResult>>() {
            public void onSuccess(BaseResponse<OrderHistoryResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    MyOrderModel.this.presenter.onResult(baseResponse.getData().getOrderList());
                } else {
                    MyOrderModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                MyOrderModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
