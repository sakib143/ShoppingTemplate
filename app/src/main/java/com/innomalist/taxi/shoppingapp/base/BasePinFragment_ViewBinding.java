package com.kiandashopping.kiandashopping.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

public class BasePinFragment_ViewBinding implements Unbinder {
    private BasePinFragment target;

    public BasePinFragment_ViewBinding(BasePinFragment basePinFragment, View view) {
        this.target = basePinFragment;
        basePinFragment.flPin = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.flPin, "field 'flPin'", LinearLayout.class);
        basePinFragment.ivPinTop = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivPinTop, "field 'ivPinTop'", ImageView.class);
        basePinFragment.ivPinBottom = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivPinBottom, "field 'ivPinBottom'", ImageView.class);
    }

    public void unbind() {
        BasePinFragment basePinFragment = this.target;
        if (basePinFragment != null) {
            this.target = null;
            basePinFragment.flPin = null;
            basePinFragment.ivPinTop = null;
            basePinFragment.ivPinBottom = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
