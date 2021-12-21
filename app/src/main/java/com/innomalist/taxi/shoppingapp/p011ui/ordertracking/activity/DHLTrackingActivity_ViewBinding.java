package com.kiandashopping.kiandashopping.p011ui.ordertracking.activity;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.activity.DHLTrackingActivity_ViewBinding */
public class DHLTrackingActivity_ViewBinding implements Unbinder {
    private DHLTrackingActivity target;

    public DHLTrackingActivity_ViewBinding(DHLTrackingActivity dHLTrackingActivity) {
        this(dHLTrackingActivity, dHLTrackingActivity.getWindow().getDecorView());
    }

    public DHLTrackingActivity_ViewBinding(DHLTrackingActivity dHLTrackingActivity, View view) {
        this.target = dHLTrackingActivity;
        dHLTrackingActivity.f254rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        DHLTrackingActivity dHLTrackingActivity = this.target;
        if (dHLTrackingActivity != null) {
            this.target = null;
            dHLTrackingActivity.f254rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
