package com.kiandashopping.kiandashopping.p011ui.itemdetails.fragment;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.fragment.SliderFragment_ViewBinding */
public class SliderFragment_ViewBinding implements Unbinder {
    private SliderFragment target;

    public SliderFragment_ViewBinding(SliderFragment sliderFragment, View view) {
        this.target = sliderFragment;
        sliderFragment.imageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.image, "field 'imageView'", ImageView.class);
    }

    public void unbind() {
        SliderFragment sliderFragment = this.target;
        if (sliderFragment != null) {
            this.target = null;
            sliderFragment.imageView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
