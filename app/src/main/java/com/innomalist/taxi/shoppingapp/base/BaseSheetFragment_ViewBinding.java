package com.kiandashopping.kiandashopping.base;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

public class BaseSheetFragment_ViewBinding implements Unbinder {
    private BaseSheetFragment target;
    private View view7f0a0071;
    private View view7f0a0072;

    public BaseSheetFragment_ViewBinding(final BaseSheetFragment baseSheetFragment, View view) {
        this.target = baseSheetFragment;
        baseSheetFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        baseSheetFragment.tvMessage = (TextView) Utils.findRequiredViewAsType(view, R.id.tvMessage, "field 'tvMessage'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnPositive, "field 'btnPositive' and method 'onClickPositive'");
        baseSheetFragment.btnPositive = (Button) Utils.castView(findRequiredView, R.id.btnPositive, "field 'btnPositive'", Button.class);
        this.view7f0a0072 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                baseSheetFragment.onClickPositive();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btnNegative, "field 'btnNegative' and method 'onClickNegative'");
        baseSheetFragment.btnNegative = (Button) Utils.castView(findRequiredView2, R.id.btnNegative, "field 'btnNegative'", Button.class);
        this.view7f0a0071 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                baseSheetFragment.onClickNegative();
            }
        });
        baseSheetFragment.clBottomSheet = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.clBottomSheet, "field 'clBottomSheet'", ConstraintLayout.class);
    }

    public void unbind() {
        BaseSheetFragment baseSheetFragment = this.target;
        if (baseSheetFragment != null) {
            this.target = null;
            baseSheetFragment.tvTitle = null;
            baseSheetFragment.tvMessage = null;
            baseSheetFragment.btnPositive = null;
            baseSheetFragment.btnNegative = null;
            baseSheetFragment.clBottomSheet = null;
            this.view7f0a0072.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0072 = null;
            this.view7f0a0071.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0071 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
