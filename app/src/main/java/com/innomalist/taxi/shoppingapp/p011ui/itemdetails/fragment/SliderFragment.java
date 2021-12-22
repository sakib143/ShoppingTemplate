package com.innomalist.taxi.shoppingapp.p011ui.itemdetails.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.base.BaseFragment;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.GlideUtils;

import butterknife.BindView;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.base.BaseFragment;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.GlideUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.fragment.SliderFragment */
public class SliderFragment extends BaseFragment {
    private static final String ARG_IMAGE_URI = "IMAGE_URI";
    @BindView(2131362082)
    ImageView imageView;

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    public static SliderFragment newInstance(String str) {
        SliderFragment sliderFragment = new SliderFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_IMAGE_URI, str);
        sliderFragment.setArguments(bundle);
        return sliderFragment;
    }

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.item_deals_banner_image, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null) {
            GlideUtils.showImage(BaseApplication.getContext(), this.imageView, (Drawable) AppUtils.getProgressDrawable(), getArguments().getString(ARG_IMAGE_URI));
        }
    }
}
