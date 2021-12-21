package com.kiandashopping.kiandashopping.base;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

public class BaseDialogFragment_ViewBinding implements Unbinder {
    private BaseDialogFragment target;
    private View view7f0a0071;
    private View view7f0a0072;

    public BaseDialogFragment_ViewBinding(final BaseDialogFragment baseDialogFragment, View view) {
        this.target = baseDialogFragment;
        baseDialogFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        baseDialogFragment.tvMessage = (TextView) Utils.findRequiredViewAsType(view, R.id.tvMessage, "field 'tvMessage'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnPositive, "field 'btnPositive' and method 'onClickPositive'");
        baseDialogFragment.btnPositive = (Button) Utils.castView(findRequiredView, R.id.btnPositive, "field 'btnPositive'", Button.class);
        this.view7f0a0072 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                baseDialogFragment.onClickPositive();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btnNegative, "field 'btnNegative' and method 'onClickNegative'");
        baseDialogFragment.btnNegative = (Button) Utils.castView(findRequiredView2, R.id.btnNegative, "field 'btnNegative'", Button.class);
        this.view7f0a0071 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                baseDialogFragment.onClickNegative();
            }
        });
    }

    public void unbind() {
        BaseDialogFragment baseDialogFragment = this.target;
        if (baseDialogFragment != null) {
            this.target = null;
            baseDialogFragment.tvTitle = null;
            baseDialogFragment.tvMessage = null;
            baseDialogFragment.btnPositive = null;
            baseDialogFragment.btnNegative = null;
            this.view7f0a0072.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0072 = null;
            this.view7f0a0071.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0071 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
