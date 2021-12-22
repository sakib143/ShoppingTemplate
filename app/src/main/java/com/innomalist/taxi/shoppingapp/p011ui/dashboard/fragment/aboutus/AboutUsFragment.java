package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.aboutus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.BaseFragment;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseFragment;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.aboutus.mvp.AboutUsContractor;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.aboutus.mvp.AboutUsPresenter;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.aboutus.mvp.AboutUsContractor;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.aboutus.mvp.AboutUsPresenter;
//import com.kiandashopping.kiandashopping.util.AppUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.aboutus.AboutUsFragment */
public class AboutUsFragment extends BaseFragment implements AboutUsContractor.View {
    private static final String ARG_PAGE = "Page";
    private static final String ENCODING = "UTF-8";
    private static final String MIME_TYPE = "text/html";
    private AboutUsPresenter aboutUsPresenter;
    @BindView(2131362446)

    /* renamed from: wv */
    WebView f230wv;

    public static Fragment newInstance(String str) {
        AboutUsFragment aboutUsFragment = new AboutUsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PAGE, str);
        aboutUsFragment.setArguments(bundle);
        return aboutUsFragment;
    }

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_about_us, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AboutUsPresenter aboutUsPresenter2 = new AboutUsPresenter(this);
        this.aboutUsPresenter = aboutUsPresenter2;
        aboutUsPresenter2.requestAboutUs(AppUtils.getString(getArguments(), ARG_PAGE));
    }

    public PresenterInterface getPresenterInterface() {
        return this.aboutUsPresenter;
    }

    public void showResult(String str) {
        this.f230wv.getSettings().setJavaScriptEnabled(true);
        this.f230wv.getSettings().setCacheMode(2);
        this.f230wv.loadDataWithBaseURL("", str, MIME_TYPE, "UTF-8", "");
    }
}
