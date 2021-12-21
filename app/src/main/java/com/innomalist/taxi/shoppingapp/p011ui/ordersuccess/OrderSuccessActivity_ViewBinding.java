package com.kiandashopping.kiandashopping.p011ui.ordersuccess;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordersuccess.OrderSuccessActivity_ViewBinding */
public class OrderSuccessActivity_ViewBinding implements Unbinder {
    private OrderSuccessActivity target;
    private View view7f0a00ee;

    public OrderSuccessActivity_ViewBinding(OrderSuccessActivity orderSuccessActivity) {
        this(orderSuccessActivity, orderSuccessActivity.getWindow().getDecorView());
    }

    public OrderSuccessActivity_ViewBinding(final OrderSuccessActivity orderSuccessActivity, View view) {
        this.target = orderSuccessActivity;
        orderSuccessActivity.avEmpty = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avEmpty, "field 'avEmpty'", LottieAnimationView.class);
        orderSuccessActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        orderSuccessActivity.tvDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDesc, "field 'tvDesc'", TextView.class);
        orderSuccessActivity.tvAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.tvAmount, "field 'tvAmount'", TextView.class);
        orderSuccessActivity.tvEntity = (TextView) Utils.findRequiredViewAsType(view, R.id.tvEntity, "field 'tvEntity'", TextView.class);
        orderSuccessActivity.tvReference = (TextView) Utils.findRequiredViewAsType(view, R.id.tvReference, "field 'tvReference'", TextView.class);
        orderSuccessActivity.tvValue = (TextView) Utils.findRequiredViewAsType(view, R.id.tvValue, "field 'tvValue'", TextView.class);
        orderSuccessActivity.tvValidity = (TextView) Utils.findRequiredViewAsType(view, R.id.tvValidity, "field 'tvValidity'", TextView.class);
        orderSuccessActivity.llProxyPay = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llProxyPay, "field 'llProxyPay'", LinearLayout.class);
        orderSuccessActivity.llAmountDetails = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llAmountDetails, "field 'llAmountDetails'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.fabDone, "method 'setDone'");
        this.view7f0a00ee = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                orderSuccessActivity.setDone();
            }
        });
    }

    public void unbind() {
        OrderSuccessActivity orderSuccessActivity = this.target;
        if (orderSuccessActivity != null) {
            this.target = null;
            orderSuccessActivity.avEmpty = null;
            orderSuccessActivity.tvTitle = null;
            orderSuccessActivity.tvDesc = null;
            orderSuccessActivity.tvAmount = null;
            orderSuccessActivity.tvEntity = null;
            orderSuccessActivity.tvReference = null;
            orderSuccessActivity.tvValue = null;
            orderSuccessActivity.tvValidity = null;
            orderSuccessActivity.llProxyPay = null;
            orderSuccessActivity.llAmountDetails = null;
            this.view7f0a00ee.setOnClickListener((View.OnClickListener) null);
            this.view7f0a00ee = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
