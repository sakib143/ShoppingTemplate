package com.kiandashopping.kiandashopping.p011ui.itemdetails.activity;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.activity.ProductDetailActivity_ViewBinding */
public class ProductDetailActivity_ViewBinding implements Unbinder {
    private ProductDetailActivity target;
    private View view7f0a006a;
    private View view7f0a006b;
    private View view7f0a00ef;
    private View view7f0a013a;

    public ProductDetailActivity_ViewBinding(ProductDetailActivity productDetailActivity) {
        this(productDetailActivity, productDetailActivity.getWindow().getDecorView());
    }

    public ProductDetailActivity_ViewBinding(final ProductDetailActivity productDetailActivity, View view) {
        this.target = productDetailActivity;
        productDetailActivity.f245rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        productDetailActivity.appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.appBarLayout, "field 'appBarLayout'", AppBarLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.fabFav, "field 'fabFav' and method 'setFavClick'");
        productDetailActivity.fabFav = (FloatingActionButton) Utils.castView(findRequiredView, R.id.fabFav, "field 'fabFav'", FloatingActionButton.class);
        this.view7f0a00ef = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                productDetailActivity.setFavClick();
            }
        });
        productDetailActivity.flBottom = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flBottom, "field 'flBottom'", FrameLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btnAddCart, "field 'btnAddCart' and method 'setAddToCart'");
        productDetailActivity.btnAddCart = (Button) Utils.castView(findRequiredView2, R.id.btnAddCart, "field 'btnAddCart'", Button.class);
        this.view7f0a006a = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                productDetailActivity.setAddToCart();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ivStore, "field 'ivStore' and method 'setIvStore'");
        productDetailActivity.ivStore = (ImageView) Utils.castView(findRequiredView3, R.id.ivStore, "field 'ivStore'", ImageView.class);
        this.view7f0a013a = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                productDetailActivity.setIvStore();
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.btnBuyNow, "field 'btnBuyNow' and method 'setBuyNow'");
        productDetailActivity.btnBuyNow = (Button) Utils.castView(findRequiredView4, R.id.btnBuyNow, "field 'btnBuyNow'", Button.class);
        this.view7f0a006b = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                productDetailActivity.setBuyNow();
            }
        });
        productDetailActivity.collapsingToolbar = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.ctl, "field 'collapsingToolbar'", CollapsingToolbarLayout.class);
    }

    public void unbind() {
        ProductDetailActivity productDetailActivity = this.target;
        if (productDetailActivity != null) {
            this.target = null;
            productDetailActivity.f245rv = null;
            productDetailActivity.appBarLayout = null;
            productDetailActivity.fabFav = null;
            productDetailActivity.flBottom = null;
            productDetailActivity.btnAddCart = null;
            productDetailActivity.ivStore = null;
            productDetailActivity.btnBuyNow = null;
            productDetailActivity.collapsingToolbar = null;
            this.view7f0a00ef.setOnClickListener((View.OnClickListener) null);
            this.view7f0a00ef = null;
            this.view7f0a006a.setOnClickListener((View.OnClickListener) null);
            this.view7f0a006a = null;
            this.view7f0a013a.setOnClickListener((View.OnClickListener) null);
            this.view7f0a013a = null;
            this.view7f0a006b.setOnClickListener((View.OnClickListener) null);
            this.view7f0a006b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
