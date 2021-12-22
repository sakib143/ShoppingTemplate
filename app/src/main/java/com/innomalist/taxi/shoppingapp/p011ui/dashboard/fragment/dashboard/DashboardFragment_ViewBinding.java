package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.dashboard;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.DashboardFragment_ViewBinding */
public class DashboardFragment_ViewBinding implements Unbinder {
    private DashboardFragment target;

    public DashboardFragment_ViewBinding(DashboardFragment dashboardFragment, View view) {
        this.target = dashboardFragment;
        dashboardFragment.f231rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        DashboardFragment dashboardFragment = this.target;
        if (dashboardFragment != null) {
            this.target = null;
            dashboardFragment.f231rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
