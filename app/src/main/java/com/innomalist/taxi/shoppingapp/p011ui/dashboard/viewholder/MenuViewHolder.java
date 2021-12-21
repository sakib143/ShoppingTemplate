package com.kiandashopping.kiandashopping.p011ui.dashboard.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseViewHolder;
import com.kiandashopping.kiandashopping.model.dashboard.NavigationMenu;
import com.kiandashopping.kiandashopping.p011ui.dashboard.adapter.NavigationAdapter;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.viewholder.MenuViewHolder */
public class MenuViewHolder extends BaseViewHolder {
    public static int selectedPosition = -1;
    @BindView(2131362096)
    ImageView ivIcon;
    private NavigationAdapter.Listener listener;
    @BindView(2131362139)
    LinearLayout llSelector;
    private NavigationMenu navigationMenu;
    @BindView(2131362377)
    TextView tvHeader;
    @BindView(2131362436)
    View viewDivider;

    public void setListener(NavigationAdapter.Listener listener2) {
        this.listener = listener2;
    }

    public MenuViewHolder(View view) {
        super(view);
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MenuViewHolder.this.lambda$new$0$MenuViewHolder(view);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$MenuViewHolder(View view) {
        this.listener.onClick(this.navigationMenu);
    }

    public void onBind(int i, Object obj) {
        this.navigationMenu = (NavigationMenu) obj;
        this.viewDivider.setVisibility(8);
        this.tvHeader.setText(this.navigationMenu.getMenuName());
        this.ivIcon.setImageResource(this.navigationMenu.getResourceId());
        if (selectedPosition == i) {
            this.llSelector.setBackgroundColor(ResourceUtils.getColor((int) R.color.order_canceled));
            this.tvHeader.setTextColor(ResourceUtils.getColor((int) R.color.colorAccent));
            this.ivIcon.setColorFilter(ResourceUtils.getColor((int) R.color.colorAccent));
            return;
        }
        this.llSelector.setBackgroundColor(ResourceUtils.getColor((int) R.color.white));
        this.tvHeader.setTextColor(ResourceUtils.getColor(17170444));
        this.ivIcon.setColorFilter(ResourceUtils.getColor((int) R.color.nav_icon_color));
    }
}
