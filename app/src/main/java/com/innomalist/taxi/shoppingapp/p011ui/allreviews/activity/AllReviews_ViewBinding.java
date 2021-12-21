package com.kiandashopping.kiandashopping.p011ui.allreviews.activity;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.activity.AllReviews_ViewBinding */
public class AllReviews_ViewBinding implements Unbinder {
    private AllReviews target;

    public AllReviews_ViewBinding(AllReviews allReviews) {
        this(allReviews, allReviews.getWindow().getDecorView());
    }

    public AllReviews_ViewBinding(AllReviews allReviews, View view) {
        this.target = allReviews;
        allReviews.f223rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        AllReviews allReviews = this.target;
        if (allReviews != null) {
            this.target = null;
            allReviews.f223rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
