package com.kiandashopping.kiandashopping.p011ui.ordertracking.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.myorder.OrderList;
import com.kiandashopping.kiandashopping.model.myorder.RequestOrderTracking;
import com.kiandashopping.kiandashopping.model.tracking.DHLOrderDetails;
import com.kiandashopping.kiandashopping.p011ui.ordertracking.mvp.OrderTrackingContractor;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.mvp.OrderTrackingPresenter */
public class OrderTrackingPresenter extends BasePresenter implements OrderTrackingContractor.Presenter {
    private Disposable disposable;
    private OrderTrackingContractor.View mView;
    private OrderTrackingModel model = new OrderTrackingModel(this);

    public OrderTrackingPresenter(OrderTrackingContractor.View view) {
        this.mView = view;
    }

    public void requestOrderDetail(String str, boolean z) {
        if (z) {
            this.mView.showLoadingView();
        }
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.requestOrderDetail(new RequestOrderTracking(str, (String) null, this.appRepository.getLanguage(), this.appRepository.getUserId()));
    }

    public void requestDHLOrderDetail(String str, boolean z) {
        if (z) {
            this.mView.showLoadingView();
        }
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.requestDHLOrderDetail(new RequestOrderTracking((String) null, str, this.appRepository.getLanguage(), this.appRepository.getUserId()));
    }

    public void onOrderDetails(OrderList orderList) {
        this.mView.hideLoadingView();
        this.mView.showOrderDetails(orderList);
    }

    public void onOrderDetails(DHLOrderDetails dHLOrderDetails) {
        this.mView.hideLoadingView();
        this.mView.showOrderDetails(dHLOrderDetails.getOrderDetails());
    }

    public void onOrderDetailError(String str) {
        this.mView.hideLoadingView();
        this.mView.showToast(str);
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }
}
