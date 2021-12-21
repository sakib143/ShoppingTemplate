package com.kiandashopping.kiandashopping.p011ui.deallist.activity;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.deallist.activity.DealListActivity_ViewBinding */
public class DealListActivity_ViewBinding implements Unbinder {
    private DealListActivity target;

    public DealListActivity_ViewBinding(DealListActivity dealListActivity) {
        this(dealListActivity, dealListActivity.getWindow().getDecorView());
    }

    public DealListActivity_ViewBinding(DealListActivity dealListActivity, View view) {
        this.target = dealListActivity;
        dealListActivity.f243rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        DealListActivity dealListActivity = this.target;
        if (dealListActivity != null) {
            this.target = null;
            dealListActivity.f243rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
