package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.account.AccountFragment_ViewBinding */
public class AccountFragment_ViewBinding implements Unbinder {
    private AccountFragment target;
    private View view7f0a008a;
    private View view7f0a00e6;
    private View view7f0a016a;
    private View view7f0a016b;
    private View view7f0a016c;
    private View view7f0a01e2;

    public AccountFragment_ViewBinding(final AccountFragment accountFragment, View view) {
        this.target = accountFragment;
        accountFragment.ivProfile = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivProfile, "field 'ivProfile'", ImageView.class);
        accountFragment.tvUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tvUserName, "field 'tvUserName'", TextView.class);
        accountFragment.tvEmail = (TextView) Utils.findRequiredViewAsType(view, R.id.tvEmail, "field 'tvEmail'", TextView.class);
        accountFragment.shippingAddressTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.shippingAddressTxt, "field 'shippingAddressTxt'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.changePassword, "method 'showChangePassword'");
        this.view7f0a008a = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                accountFragment.showChangePassword();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.etProfile, "method 'setEditProfile'");
        this.view7f0a00e6 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                accountFragment.setEditProfile();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.shippingAddress, "method 'setShippingAddress'");
        this.view7f0a01e2 = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                accountFragment.setShippingAddress();
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.myOrder, "method 'setMyOrder'");
        this.view7f0a016b = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                accountFragment.setMyOrder();
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.myWishList, "method 'setWishList'");
        this.view7f0a016c = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                accountFragment.setWishList();
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.myCart, "method 'setMyCart'");
        this.view7f0a016a = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                accountFragment.setMyCart();
            }
        });
    }

    public void unbind() {
        AccountFragment accountFragment = this.target;
        if (accountFragment != null) {
            this.target = null;
            accountFragment.ivProfile = null;
            accountFragment.tvUserName = null;
            accountFragment.tvEmail = null;
            accountFragment.shippingAddressTxt = null;
            this.view7f0a008a.setOnClickListener((View.OnClickListener) null);
            this.view7f0a008a = null;
            this.view7f0a00e6.setOnClickListener((View.OnClickListener) null);
            this.view7f0a00e6 = null;
            this.view7f0a01e2.setOnClickListener((View.OnClickListener) null);
            this.view7f0a01e2 = null;
            this.view7f0a016b.setOnClickListener((View.OnClickListener) null);
            this.view7f0a016b = null;
            this.view7f0a016c.setOnClickListener((View.OnClickListener) null);
            this.view7f0a016c = null;
            this.view7f0a016a.setOnClickListener((View.OnClickListener) null);
            this.view7f0a016a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
