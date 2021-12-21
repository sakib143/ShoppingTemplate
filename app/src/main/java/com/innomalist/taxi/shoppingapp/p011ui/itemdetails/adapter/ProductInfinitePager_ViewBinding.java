package com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductInfinitePager_ViewBinding */
public class ProductInfinitePager_ViewBinding implements Unbinder {
    private ProductInfinitePager target;

    public ProductInfinitePager_ViewBinding(ProductInfinitePager productInfinitePager, View view) {
        this.target = productInfinitePager;
        productInfinitePager.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vpSlide, "field 'viewPager'", ViewPager.class);
        productInfinitePager.wormDotsIndicator = (WormDotsIndicator) Utils.findRequiredViewAsType(view, R.id.wormDotsIndicator, "field 'wormDotsIndicator'", WormDotsIndicator.class);
    }

    public void unbind() {
        ProductInfinitePager productInfinitePager = this.target;
        if (productInfinitePager != null) {
            this.target = null;
            productInfinitePager.viewPager = null;
            productInfinitePager.wormDotsIndicator = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
