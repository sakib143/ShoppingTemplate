package com.innomalist.taxi.shoppingapp.p011ui.account.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.innomalist.taxi.shoppingapp.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.account.activity.EditProfile_ViewBinding */
public class EditProfile_ViewBinding implements Unbinder {
    private EditProfile target;
    private View view7f0a0079;
    private View view7f0a00af;

    public EditProfile_ViewBinding(EditProfile editProfile) {
        this(editProfile, editProfile.getWindow().getDecorView());
    }

    public EditProfile_ViewBinding(final EditProfile editProfile, View view) {
        this.target = editProfile;
        editProfile.ivAvatar = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivAvatar, "field 'ivAvatar'", ImageView.class);
        editProfile.etUserName = (EditText) Utils.findRequiredViewAsType(view, R.id.etUserName, "field 'etUserName'", EditText.class);
        editProfile.etEmail = (EditText) Utils.findRequiredViewAsType(view, R.id.etEmail, "field 'etEmail'", EditText.class);
        editProfile.etPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.etPhone, "field 'etPhone'", EditText.class);
        editProfile.etCountry = (AppCompatAutoCompleteTextView) Utils.findRequiredViewAsType(view, R.id.etCountry, "field 'etCountry'", AppCompatAutoCompleteTextView.class);
        editProfile.etCity = (AppCompatAutoCompleteTextView) Utils.findRequiredViewAsType(view, R.id.etCity, "field 'etCity'", AppCompatAutoCompleteTextView.class);
        editProfile.nsv = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.nsv, "field 'nsv'", NestedScrollView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.cvAvatar, "method 'onClickAvatar'");
        this.view7f0a00af = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                editProfile.onClickAvatar();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btnUpdateProfile, "method 'onClickUpdateProfile'");
        this.view7f0a0079 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                editProfile.onClickUpdateProfile();
            }
        });
    }

    public void unbind() {
        EditProfile editProfile = this.target;
        if (editProfile != null) {
            this.target = null;
            editProfile.ivAvatar = null;
            editProfile.etUserName = null;
            editProfile.etEmail = null;
            editProfile.etPhone = null;
            editProfile.etCountry = null;
            editProfile.etCity = null;
            editProfile.nsv = null;
            this.view7f0a00af.setOnClickListener((View.OnClickListener) null);
            this.view7f0a00af = null;
            this.view7f0a0079.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0079 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
