package com.kiandashopping.kiandashopping.p011ui.ordertracking.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.myorder.OrderHistoryResult;
import com.kiandashopping.kiandashopping.model.myorder.RequestOrderTracking;
import com.kiandashopping.kiandashopping.model.tracking.DHLOrderDetails;
import com.kiandashopping.kiandashopping.p011ui.ordertracking.mvp.OrderTrackingContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.mvp.OrderTrackingModel */
public class OrderTrackingModel extends BaseModel implements OrderTrackingContractor.Model {
    /* access modifiers changed from: private */
    public OrderTrackingPresenter presenter;

    OrderTrackingModel(OrderTrackingPresenter orderTrackingPresenter) {
        this.presenter = orderTrackingPresenter;
    }

    public Disposable requestOrderDetail(RequestOrderTracking requestOrderTracking) {
        return addRequest(this.apiInterface.requestOrderDetail(requestOrderTracking), new DisposableSingleObserver<BaseResponse<OrderHistoryResult>>() {
            public void onSuccess(BaseResponse<OrderHistoryResult> baseResponse) {
                if (!baseResponse.isSuccess()) {
                    OrderTrackingModel.this.presenter.onOrderDetailError(baseResponse.getDescription());
                } else if (baseResponse.getData().getOrderList().size() > 0) {
                    OrderTrackingModel.this.presenter.onOrderDetails(baseResponse.getData().getOrderList().get(0));
                } else {
                    OrderTrackingModel.this.presenter.onOrderDetailError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                OrderTrackingModel.this.presenter.onOrderDetailError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestDHLOrderDetail(RequestOrderTracking requestOrderTracking) {
        return addRequest(this.apiInterface.requestDHLOrderDetail(requestOrderTracking), new DisposableSingleObserver<BaseResponse<DHLOrderDetails>>() {
            public void onSuccess(BaseResponse<DHLOrderDetails> baseResponse) {
                if (baseResponse.isSuccess()) {
                    OrderTrackingModel.this.presenter.onOrderDetails(baseResponse.getData());
                } else {
                    OrderTrackingModel.this.presenter.onOrderDetailError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                OrderTrackingModel.this.presenter.onOrderDetailError(AppUtils.getError(th));
            }
        });
    }
}
