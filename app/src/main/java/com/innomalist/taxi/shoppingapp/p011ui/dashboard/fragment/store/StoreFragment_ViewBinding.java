package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.store;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.StoreFragment_ViewBinding */
public class StoreFragment_ViewBinding implements Unbinder {
    private StoreFragment target;

    public StoreFragment_ViewBinding(StoreFragment storeFragment, View view) {
        this.target = storeFragment;
        storeFragment.f242rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        StoreFragment storeFragment = this.target;
        if (storeFragment != null) {
            this.target = null;
            storeFragment.f242rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
