package com.kiandashopping.kiandashopping.p011ui.ordertracking.activity;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.activity.OrdersTrackingActivity_ViewBinding */
public class OrdersTrackingActivity_ViewBinding implements Unbinder {
    private OrdersTrackingActivity target;

    public OrdersTrackingActivity_ViewBinding(OrdersTrackingActivity ordersTrackingActivity) {
        this(ordersTrackingActivity, ordersTrackingActivity.getWindow().getDecorView());
    }

    public OrdersTrackingActivity_ViewBinding(OrdersTrackingActivity ordersTrackingActivity, View view) {
        this.target = ordersTrackingActivity;
        ordersTrackingActivity.f255rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        OrdersTrackingActivity ordersTrackingActivity = this.target;
        if (ordersTrackingActivity != null) {
            this.target = null;
            ordersTrackingActivity.f255rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
