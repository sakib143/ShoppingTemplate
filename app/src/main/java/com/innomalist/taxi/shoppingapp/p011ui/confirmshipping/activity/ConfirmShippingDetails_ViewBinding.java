package com.innomalist.taxi.shoppingapp.p011ui.confirmshipping.activity;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.innomalist.taxi.shoppingapp.R;


/* renamed from: com.kiandashopping.kiandashopping.ui.confirmshipping.activity.ConfirmShippingDetails_ViewBinding */
public class ConfirmShippingDetails_ViewBinding implements Unbinder {
    private ConfirmShippingDetails target;
    private View view7f0a0078;
    private View view7f0a01cf;

    public ConfirmShippingDetails_ViewBinding(ConfirmShippingDetails confirmShippingDetails) {
        this(confirmShippingDetails, confirmShippingDetails.getWindow().getDecorView());
    }

    public ConfirmShippingDetails_ViewBinding(final ConfirmShippingDetails confirmShippingDetails, View view) {
        this.target = confirmShippingDetails;
        confirmShippingDetails.etUserName = (EditText) Utils.findRequiredViewAsType(view, R.id.etUserName, "field 'etUserName'", EditText.class);
        confirmShippingDetails.etEmail = (EditText) Utils.findRequiredViewAsType(view, R.id.etEmail, "field 'etEmail'", EditText.class);
        confirmShippingDetails.etPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.etPhone, "field 'etPhone'", EditText.class);
        confirmShippingDetails.etBuildingName = (EditText) Utils.findRequiredViewAsType(view, R.id.etBuildingName, "field 'etBuildingName'", EditText.class);
        confirmShippingDetails.etLocality = (EditText) Utils.findRequiredViewAsType(view, R.id.etLocality, "field 'etLocality'", EditText.class);
        confirmShippingDetails.etCountry = (AppCompatAutoCompleteTextView) Utils.findRequiredViewAsType(view, R.id.etCountry, "field 'etCountry'", AppCompatAutoCompleteTextView.class);
        confirmShippingDetails.etCity = (AppCompatAutoCompleteTextView) Utils.findRequiredViewAsType(view, R.id.etCity, "field 'etCity'", AppCompatAutoCompleteTextView.class);
        confirmShippingDetails.etState = (EditText) Utils.findRequiredViewAsType(view, R.id.etState, "field 'etState'", EditText.class);
        confirmShippingDetails.etPinCode = (EditText) Utils.findRequiredViewAsType(view, R.id.etPinCode, "field 'etPinCode'", EditText.class);
        confirmShippingDetails.nsv = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.nsv, "field 'nsv'", NestedScrollView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.scShipping, "field 'scShipping', method 'setScShipping', and method 'setScShipping'");
        confirmShippingDetails.scShipping = (SwitchCompat) Utils.castView(findRequiredView, R.id.scShipping, "field 'scShipping'", SwitchCompat.class);
        this.view7f0a01cf = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                confirmShippingDetails.setScShipping();
            }
        });
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                confirmShippingDetails.setScShipping();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btnUpdate, "method 'onClickUpdate'");
        this.view7f0a0078 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                confirmShippingDetails.onClickUpdate();
            }
        });
    }

    public void unbind() {
        ConfirmShippingDetails confirmShippingDetails = this.target;
        if (confirmShippingDetails != null) {
            this.target = null;
            confirmShippingDetails.etUserName = null;
            confirmShippingDetails.etEmail = null;
            confirmShippingDetails.etPhone = null;
            confirmShippingDetails.etBuildingName = null;
            confirmShippingDetails.etLocality = null;
            confirmShippingDetails.etCountry = null;
            confirmShippingDetails.etCity = null;
            confirmShippingDetails.etState = null;
            confirmShippingDetails.etPinCode = null;
            confirmShippingDetails.nsv = null;
            confirmShippingDetails.scShipping = null;
            ((CompoundButton) this.view7f0a01cf).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            this.view7f0a01cf.setOnClickListener((View.OnClickListener) null);
            this.view7f0a01cf = null;
            this.view7f0a0078.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0078 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
