package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.aboutus;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.aboutus.AboutUsFragment_ViewBinding */
public class AboutUsFragment_ViewBinding implements Unbinder {
    private AboutUsFragment target;

    public AboutUsFragment_ViewBinding(AboutUsFragment aboutUsFragment, View view) {
        this.target = aboutUsFragment;
        aboutUsFragment.f230wv = (WebView) Utils.findRequiredViewAsType(view, R.id.wv, "field 'wv'", WebView.class);
    }

    public void unbind() {
        AboutUsFragment aboutUsFragment = this.target;
        if (aboutUsFragment != null) {
            this.target = null;
            aboutUsFragment.f230wv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
