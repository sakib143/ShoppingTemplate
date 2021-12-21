package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.contactus.ContactUsFragment_ViewBinding */
public class ContactUsFragment_ViewBinding implements Unbinder {
    private ContactUsFragment target;
    private View view7f0a0074;
    private View view7f0a0112;
    private View view7f0a0113;
    private View view7f0a0114;
    private View view7f0a0118;
    private View view7f0a0232;
    private View view7f0a0233;
    private View view7f0a0244;
    private View view7f0a027b;

    public ContactUsFragment_ViewBinding(final ContactUsFragment contactUsFragment, View view) {
        this.target = contactUsFragment;
        contactUsFragment.etName = (EditText) Utils.findRequiredViewAsType(view, R.id.etName, "field 'etName'", EditText.class);
        contactUsFragment.etMailId = (EditText) Utils.findRequiredViewAsType(view, R.id.etMailId, "field 'etMailId'", EditText.class);
        contactUsFragment.etMobileNumber = (EditText) Utils.findRequiredViewAsType(view, R.id.etMobileNumber, "field 'etMobileNumber'", EditText.class);
        contactUsFragment.etMessage = (EditText) Utils.findRequiredViewAsType(view, R.id.etMessage, "field 'etMessage'", EditText.class);
        contactUsFragment.llInfo = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llInfo, "field 'llInfo'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tvCall1, "field 'tvCall1' and method 'onCallStore1'");
        contactUsFragment.tvCall1 = (TextView) Utils.castView(findRequiredView, R.id.tvCall1, "field 'tvCall1'", TextView.class);
        this.view7f0a0232 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactUsFragment.onCallStore1();
            }
        });
        contactUsFragment.rlCall1 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlCall1, "field 'rlCall1'", RelativeLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tvCall2, "field 'tvCall2' and method 'onCallStore2'");
        contactUsFragment.tvCall2 = (TextView) Utils.castView(findRequiredView2, R.id.tvCall2, "field 'tvCall2'", TextView.class);
        this.view7f0a0233 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactUsFragment.onCallStore2();
            }
        });
        contactUsFragment.rlCall2 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlCall2, "field 'rlCall2'", RelativeLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tvEmail, "field 'tvEmail' and method 'onMail'");
        contactUsFragment.tvEmail = (TextView) Utils.castView(findRequiredView3, R.id.tvEmail, "field 'tvEmail'", TextView.class);
        this.view7f0a0244 = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactUsFragment.onMail();
            }
        });
        contactUsFragment.rlMail = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlMail, "field 'rlMail'", RelativeLayout.class);
        contactUsFragment.tvSkype = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSkype, "field 'tvSkype'", TextView.class);
        contactUsFragment.rlSkype = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlSkype, "field 'rlSkype'", RelativeLayout.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tvWeb, "field 'tvWeb' and method 'onWeb'");
        contactUsFragment.tvWeb = (TextView) Utils.castView(findRequiredView4, R.id.tvWeb, "field 'tvWeb'", TextView.class);
        this.view7f0a027b = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactUsFragment.onWeb();
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.icStoreCall1, "method 'onCallStore1'");
        this.view7f0a0112 = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactUsFragment.onCallStore1();
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.icStoreCall2, "method 'onCallStore2'");
        this.view7f0a0113 = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactUsFragment.onCallStore2();
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.icStoreMail, "method 'onMail'");
        this.view7f0a0114 = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactUsFragment.onMail();
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.icStoreWeb, "method 'onWeb'");
        this.view7f0a0118 = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactUsFragment.onWeb();
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.btnSend, "method 'onSend'");
        this.view7f0a0074 = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactUsFragment.onSend();
            }
        });
    }

    public void unbind() {
        ContactUsFragment contactUsFragment = this.target;
        if (contactUsFragment != null) {
            this.target = null;
            contactUsFragment.etName = null;
            contactUsFragment.etMailId = null;
            contactUsFragment.etMobileNumber = null;
            contactUsFragment.etMessage = null;
            contactUsFragment.llInfo = null;
            contactUsFragment.tvCall1 = null;
            contactUsFragment.rlCall1 = null;
            contactUsFragment.tvCall2 = null;
            contactUsFragment.rlCall2 = null;
            contactUsFragment.tvEmail = null;
            contactUsFragment.rlMail = null;
            contactUsFragment.tvSkype = null;
            contactUsFragment.rlSkype = null;
            contactUsFragment.tvWeb = null;
            this.view7f0a0232.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0232 = null;
            this.view7f0a0233.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0233 = null;
            this.view7f0a0244.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0244 = null;
            this.view7f0a027b.setOnClickListener((View.OnClickListener) null);
            this.view7f0a027b = null;
            this.view7f0a0112.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0112 = null;
            this.view7f0a0113.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0113 = null;
            this.view7f0a0114.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0114 = null;
            this.view7f0a0118.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0118 = null;
            this.view7f0a0074.setOnClickListener((View.OnClickListener) null);
            this.view7f0a0074 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
