package com.kiandashopping.kiandashopping.p011ui.viewall.activity;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.viewall.activity.ViewAllActivity_ViewBinding */
public class ViewAllActivity_ViewBinding implements Unbinder {
    private ViewAllActivity target;
    private View view7f0a0152;
    private View view7f0a0157;

    public ViewAllActivity_ViewBinding(ViewAllActivity viewAllActivity) {
        this(viewAllActivity, viewAllActivity.getWindow().getDecorView());
    }

    public ViewAllActivity_ViewBinding(final ViewAllActivity viewAllActivity, View view) {
        this.target = viewAllActivity;
        viewAllActivity.f261rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        viewAllActivity.llTopFilter = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llTopFilter, "field 'llTopFilter'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.llSortBy, "method 'setSortBy'");
        this.view7f0a0157 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                viewAllActivity.setSortBy();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.llFilter, "method 'setFilter'");
        this.view7f0a0152 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                viewAllActivity.setFilter();
            }
        });
    }

    public void unbind() {
        ViewAllActivity viewAllActivity = this.target;
        if (viewAllActivity != null) {
            this.target = null;
            viewAllActivity.f261rv = null;
            viewAllActivity.llTopFilter = null;
            this.view7f0a0157.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0157 = null;
            this.view7f0a0152.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0152 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
