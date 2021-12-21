package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.apptube.ecommerce.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.kiandashopping.kiandashopping.BuildConfig;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.AppConstants;
import com.kiandashopping.kiandashopping.base.BaseFragment;
import com.kiandashopping.kiandashopping.model.accountdetail.ContactUsResult;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus.mvp.ContactUsContractor;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus.mvp.ContactUsPresenter;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.contactus.ContactUsFragment */
public class ContactUsFragment extends BaseFragment implements ContactUsContractor.View {
    private ContactUsPresenter contactUsPresenter;
    @BindView(2131362012)
    EditText etMailId;
    @BindView(2131362013)
    EditText etMessage;
    @BindView(2131362014)
    EditText etMobileNumber;
    @BindView(2131362015)
    EditText etName;
    @BindView(2131362131)
    LinearLayout llInfo;
    @BindView(2131362241)
    RelativeLayout rlCall1;
    @BindView(2131362242)
    RelativeLayout rlCall2;
    @BindView(2131362243)
    RelativeLayout rlMail;
    @BindView(2131362245)
    RelativeLayout rlSkype;
    @BindView(2131362354)
    TextView tvCall1;
    @BindView(2131362355)
    TextView tvCall2;
    @BindView(2131362372)
    TextView tvEmail;
    @BindView(2131362411)
    TextView tvSkype;
    @BindView(2131362427)
    TextView tvWeb;

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_contact_us, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ContactUsPresenter contactUsPresenter2 = new ContactUsPresenter(this);
        this.contactUsPresenter = contactUsPresenter2;
        contactUsPresenter2.requestContactUs();
    }

    public PresenterInterface getPresenterInterface() {
        return this.contactUsPresenter;
    }

    public void showResult(ContactUsResult contactUsResult) {
        this.tvCall1.setText(contactUsResult.getPhone1());
        int i = 8;
        this.rlCall1.setVisibility(contactUsResult.getPhone1().equals("") ? 8 : 0);
        this.tvCall2.setText(contactUsResult.getPhone2());
        this.rlCall2.setVisibility(contactUsResult.getPhone2().equals("") ? 8 : 0);
        this.tvEmail.setText(contactUsResult.getContactMail());
        this.rlMail.setVisibility(contactUsResult.getContactMail().equals("") ? 8 : 0);
        this.tvSkype.setText(contactUsResult.getSkypeMail());
        RelativeLayout relativeLayout = this.rlSkype;
        if (!contactUsResult.getSkypeMail().equals("")) {
            i = 0;
        }
        relativeLayout.setVisibility(i);
        this.tvWeb.setText(BuildConfig.SERVER_URL);
        this.llInfo.setVisibility(0);
        this.etName.setText(this.appRepository.getFirstName());
        this.etMailId.setText(this.appRepository.getEmail());
    }

    public void onResult(String str) {
        this.etMessage.setText("");
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362066, 2131362354})
    public void onCallStore1() {
        Dexter.withActivity(getActivity()).withPermission("android.permission.CALL_PHONE").withListener(new PermissionListener() {
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + ContactUsFragment.this.tvCall1.getText().toString()));
                ContactUsFragment.this.startActivity(intent);
            }

            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                if (permissionDeniedResponse.isPermanentlyDenied()) {
                    ContactUsFragment.this.onCallStore1();
                }
            }

            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362067, 2131362355})
    public void onCallStore2() {
        Dexter.withActivity(getActivity()).withPermission("android.permission.CALL_PHONE").withListener(new PermissionListener() {
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + ContactUsFragment.this.tvCall2.getText().toString()));
                ContactUsFragment.this.startActivity(intent);
            }

            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                if (permissionDeniedResponse.isPermanentlyDenied()) {
                    ContactUsFragment.this.onCallStore2();
                }
            }

            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362068, 2131362372})
    public void onMail() {
        try {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra("android.intent.extra.EMAIL", new String[]{this.tvEmail.getText().toString()});
            intent.putExtra("android.intent.extra.SUBJECT", "");
            startActivity(Intent.createChooser(intent, "Email via..."));
        } catch (Exception e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
        }
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362072, 2131362427})
    public void onWeb() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.tvWeb.getText().toString())));
        } catch (Exception e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
        }
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361908})
    public void onSend() {
        this.contactUsPresenter.postRequest(this.etName.getText().toString().trim(), this.etMailId.getText().toString().trim(), this.etMobileNumber.getText().toString().trim(), this.etMessage.getText().toString().trim());
    }
}
