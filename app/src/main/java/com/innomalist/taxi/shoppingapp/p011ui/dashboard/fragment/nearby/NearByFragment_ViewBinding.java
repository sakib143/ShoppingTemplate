package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.NearByFragment_ViewBinding */
public class NearByFragment_ViewBinding implements Unbinder {
    private NearByFragment target;
    private View view7f0a00e7;
    private TextWatcher view7f0a00e7TextWatcher;

    public NearByFragment_ViewBinding(final NearByFragment nearByFragment, View view) {
        this.target = nearByFragment;
        nearByFragment.rvSearch = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rvSearch, "field 'rvSearch'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.etSearch, "field 'etSearch' and method 'onTextChanged'");
        nearByFragment.etSearch = (EditText) Utils.castView(findRequiredView, R.id.etSearch, "field 'etSearch'", EditText.class);
        this.view7f0a00e7 = findRequiredView;
        C15211 r0 = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                nearByFragment.onTextChanged(charSequence);
            }
        };
        this.view7f0a00e7TextWatcher = r0;
        ((TextView) findRequiredView).addTextChangedListener(r0);
    }

    public void unbind() {
        NearByFragment nearByFragment = this.target;
        if (nearByFragment != null) {
            this.target = null;
            nearByFragment.rvSearch = null;
            nearByFragment.etSearch = null;
            ((TextView) this.view7f0a00e7).removeTextChangedListener(this.view7f0a00e7TextWatcher);
            this.view7f0a00e7TextWatcher = null;
            this.view7f0a00e7 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
