package com.innomalist.taxi.shoppingapp.p011ui.wishlist.activity;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.innomalist.taxi.shoppingapp.R;

import butterknife.Unbinder;
import butterknife.internal.Utils;
//import com.airbnb.lottie.LottieAnimationView;
//import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.activity.WishListActivity_ViewBinding */
public class WishListActivity_ViewBinding implements Unbinder {
    private WishListActivity target;

    public WishListActivity_ViewBinding(WishListActivity wishListActivity) {
        this(wishListActivity, wishListActivity.getWindow().getDecorView());
    }

    public WishListActivity_ViewBinding(WishListActivity wishListActivity, View view) {
        this.target = wishListActivity;
        wishListActivity.f262rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        wishListActivity.avEmpty = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avEmpty, "field 'avEmpty'", LottieAnimationView.class);
        wishListActivity.llListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llListEmpty, "field 'llListEmpty'", LinearLayout.class);
    }

    public void unbind() {
        WishListActivity wishListActivity = this.target;
        if (wishListActivity != null) {
            this.target = null;
            wishListActivity.f262rv = null;
            wishListActivity.avEmpty = null;
            wishListActivity.llListEmpty = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
