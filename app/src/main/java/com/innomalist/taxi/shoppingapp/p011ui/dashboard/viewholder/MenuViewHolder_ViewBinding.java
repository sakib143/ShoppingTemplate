package com.kiandashopping.kiandashopping.p011ui.dashboard.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.viewholder.MenuViewHolder_ViewBinding */
public class MenuViewHolder_ViewBinding implements Unbinder {
    private MenuViewHolder target;

    public MenuViewHolder_ViewBinding(MenuViewHolder menuViewHolder, View view) {
        this.target = menuViewHolder;
        menuViewHolder.viewDivider = Utils.findRequiredView(view, R.id.viewDivider, "field 'viewDivider'");
        menuViewHolder.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivIcon, "field 'ivIcon'", ImageView.class);
        menuViewHolder.tvHeader = (TextView) Utils.findRequiredViewAsType(view, R.id.tvHeader, "field 'tvHeader'", TextView.class);
        menuViewHolder.llSelector = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_selector, "field 'llSelector'", LinearLayout.class);
    }

    public void unbind() {
        MenuViewHolder menuViewHolder = this.target;
        if (menuViewHolder != null) {
            this.target = null;
            menuViewHolder.viewDivider = null;
            menuViewHolder.ivIcon = null;
            menuViewHolder.tvHeader = null;
            menuViewHolder.llSelector = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
