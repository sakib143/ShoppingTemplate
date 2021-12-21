package com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.product;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.product.ProductsFragment_ViewBinding */
public class ProductsFragment_ViewBinding implements Unbinder {
    private ProductsFragment target;

    public ProductsFragment_ViewBinding(ProductsFragment productsFragment, View view) {
        this.target = productsFragment;
        productsFragment.f258rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
    }

    public void unbind() {
        ProductsFragment productsFragment = this.target;
        if (productsFragment != null) {
            this.target = null;
            productsFragment.f258rv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
