package com.kiandashopping.kiandashopping.p011ui.myorder.activity;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.myorder.activity.MyOrdersActivity_ViewBinding */
public class MyOrdersActivity_ViewBinding implements Unbinder {
    private MyOrdersActivity target;

    public MyOrdersActivity_ViewBinding(MyOrdersActivity myOrdersActivity) {
        this(myOrdersActivity, myOrdersActivity.getWindow().getDecorView());
    }

    public MyOrdersActivity_ViewBinding(MyOrdersActivity myOrdersActivity, View view) {
        this.target = myOrdersActivity;
        myOrdersActivity.f253rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        myOrdersActivity.avEmpty = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avEmpty, "field 'avEmpty'", LottieAnimationView.class);
        myOrdersActivity.llListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llListEmpty, "field 'llListEmpty'", LinearLayout.class);
    }

    public void unbind() {
        MyOrdersActivity myOrdersActivity = this.target;
        if (myOrdersActivity != null) {
            this.target = null;
            myOrdersActivity.f253rv = null;
            myOrdersActivity.avEmpty = null;
            myOrdersActivity.llListEmpty = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
