package com.kiandashopping.kiandashopping.p011ui.ordertracking.mvp;

import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.myorder.OrderList;
import com.kiandashopping.kiandashopping.model.myorder.RequestOrderTracking;
import com.kiandashopping.kiandashopping.model.tracking.DHLOrderDetails;
import com.kiandashopping.kiandashopping.model.tracking.OrderDetails;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.mvp.OrderTrackingContractor */
public interface OrderTrackingContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.mvp.OrderTrackingContractor$Model */
    public interface Model {
        Disposable requestDHLOrderDetail(RequestOrderTracking requestOrderTracking);

        Disposable requestOrderDetail(RequestOrderTracking requestOrderTracking);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.mvp.OrderTrackingContractor$Presenter */
    public interface Presenter {
        void onOrderDetailError(String str);

        void onOrderDetails(OrderList orderList);

        void onOrderDetails(DHLOrderDetails dHLOrderDetails);

        void requestDHLOrderDetail(String str, boolean z);

        void requestOrderDetail(String str, boolean z);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.mvp.OrderTrackingContractor$View */
    public interface View extends ViewInterface {
        void showOrderDetails(OrderList orderList);

        void showOrderDetails(OrderDetails orderDetails);
    }
}
