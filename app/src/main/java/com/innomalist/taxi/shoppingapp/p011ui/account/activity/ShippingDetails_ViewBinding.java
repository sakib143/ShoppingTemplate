package com.innomalist.taxi.shoppingapp.p011ui.account.activity;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.widget.NestedScrollView;

import com.innomalist.taxi.shoppingapp.R;

import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* renamed from: com.kiandashopping.kiandashopping.ui.account.activity.ShippingDetails_ViewBinding */
public class ShippingDetails_ViewBinding implements Unbinder {
    private ShippingDetails target;
    private View view7f0a0078;

    public ShippingDetails_ViewBinding(ShippingDetails shippingDetails) {
        this(shippingDetails, shippingDetails.getWindow().getDecorView());
    }

    public ShippingDetails_ViewBinding(final ShippingDetails shippingDetails, View view) {
        this.target = shippingDetails;
        shippingDetails.etUserName = (EditText) Utils.findRequiredViewAsType(view, R.id.etUserName, "field 'etUserName'", EditText.class);
        shippingDetails.etEmail = (EditText) Utils.findRequiredViewAsType(view, R.id.etEmail, "field 'etEmail'", EditText.class);
        shippingDetails.etPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.etPhone, "field 'etPhone'", EditText.class);
        shippingDetails.etBuildingName = (EditText) Utils.findRequiredViewAsType(view, R.id.etBuildingName, "field 'etBuildingName'", EditText.class);
        shippingDetails.etLocality = (EditText) Utils.findRequiredViewAsType(view, R.id.etLocality, "field 'etLocality'", EditText.class);
        shippingDetails.etCountry = (AppCompatAutoCompleteTextView) Utils.findRequiredViewAsType(view, R.id.etCountry, "field 'etCountry'", AppCompatAutoCompleteTextView.class);
        shippingDetails.etCity = (AppCompatAutoCompleteTextView) Utils.findRequiredViewAsType(view, R.id.etCity, "field 'etCity'", AppCompatAutoCompleteTextView.class);
        shippingDetails.etState = (EditText) Utils.findRequiredViewAsType(view, R.id.etState, "field 'etState'", EditText.class);
        shippingDetails.etPinCode = (EditText) Utils.findRequiredViewAsType(view, R.id.etPinCode, "field 'etPinCode'", EditText.class);
        shippingDetails.nsv = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.nsv, "field 'nsv'", NestedScrollView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnUpdate, "method 'onClickUpdate'");
        this.view7f0a0078 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                shippingDetails.onClickUpdate();
            }
        });
    }

    public void unbind() {
        ShippingDetails shippingDetails = this.target;
        if (shippingDetails != null) {
            this.target = null;
            shippingDetails.etUserName = null;
            shippingDetails.etEmail = null;
            shippingDetails.etPhone = null;
            shippingDetails.etBuildingName = null;
            shippingDetails.etLocality = null;
            shippingDetails.etCountry = null;
            shippingDetails.etCity = null;
            shippingDetails.etState = null;
            shippingDetails.etPinCode = null;
            shippingDetails.nsv = null;
            this.view7f0a0078.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0078 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
