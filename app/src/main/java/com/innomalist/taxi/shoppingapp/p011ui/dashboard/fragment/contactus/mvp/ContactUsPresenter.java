package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus.mvp;

import android.util.Patterns;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.accountdetail.ContactUsResult;
import com.kiandashopping.kiandashopping.model.accountdetail.RequestSubmitForm;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus.mvp.ContactUsContractor;
import com.kiandashopping.kiandashopping.util.NetworkUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.contactus.mvp.ContactUsPresenter */
public class ContactUsPresenter extends BasePresenter implements ContactUsContractor.Presenter {
    private ContactUsContractor.Model model = new ContactUsModel(this);
    private ContactUsContractor.View view;

    public ContactUsPresenter(ContactUsContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestContactUs() {
        this.view.showLoadingView();
        this.model.requestContactUs(new LangRequest(this.appRepository.getLanguage()));
    }

    public void postRequest(String str, String str2, String str3, String str4) {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (str.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_name));
        } else if (str2.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_email));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str2).matches()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_valid_email));
        } else if (str4.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.warning_empty_message));
        } else {
            this.view.showLoadingView();
            this.model.requestSubmit(new RequestSubmitForm(this.appRepository.getLanguage(), str, str2, str3, str4));
        }
    }

    public void onResult(ContactUsResult contactUsResult) {
        this.view.hideLoadingView();
        this.view.showResult(contactUsResult);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showToast(str);
    }

    public void onResult(String str) {
        this.view.hideLoadingView();
        this.view.showToast(str);
        this.view.onResult(str);
    }
}
