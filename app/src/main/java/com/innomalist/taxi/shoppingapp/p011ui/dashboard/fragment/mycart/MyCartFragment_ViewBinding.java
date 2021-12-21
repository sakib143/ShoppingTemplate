package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.MyCartFragment_ViewBinding */
public class MyCartFragment_ViewBinding implements Unbinder {
    private MyCartFragment target;

    public MyCartFragment_ViewBinding(MyCartFragment myCartFragment, View view) {
        this.target = myCartFragment;
        myCartFragment.f239rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        myCartFragment.avEmpty = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.avEmpty, "field 'avEmpty'", LottieAnimationView.class);
        myCartFragment.llCartEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llCartEmpty, "field 'llCartEmpty'", LinearLayout.class);
    }

    public void unbind() {
        MyCartFragment myCartFragment = this.target;
        if (myCartFragment != null) {
            this.target = null;
            myCartFragment.f239rv = null;
            myCartFragment.avEmpty = null;
            myCartFragment.llCartEmpty = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
