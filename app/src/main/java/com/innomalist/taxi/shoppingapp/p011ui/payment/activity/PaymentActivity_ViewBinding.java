package com.kiandashopping.kiandashopping.p011ui.payment.activity;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.payment.activity.PaymentActivity_ViewBinding */
public class PaymentActivity_ViewBinding implements Unbinder {
    private PaymentActivity target;

    public PaymentActivity_ViewBinding(PaymentActivity paymentActivity) {
        this(paymentActivity, paymentActivity.getWindow().getDecorView());
    }

    public PaymentActivity_ViewBinding(PaymentActivity paymentActivity, View view) {
        this.target = paymentActivity;
        paymentActivity.f256rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        PaymentActivity paymentActivity = this.target;
        if (paymentActivity != null) {
            this.target = null;
            paymentActivity.f256rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
