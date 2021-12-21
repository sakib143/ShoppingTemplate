package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.accountdetail.ContactUsResult;
import com.kiandashopping.kiandashopping.model.accountdetail.RequestSubmitForm;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.contactus.mvp.ContactUsContractor */
public interface ContactUsContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.contactus.mvp.ContactUsContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestContactUs(LangRequest langRequest);

        Disposable requestSubmit(RequestSubmitForm requestSubmitForm);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.contactus.mvp.ContactUsContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onResult(ContactUsResult contactUsResult);

        void onResult(String str);

        void onResultError(String str);

        void postRequest(String str, String str2, String str3, String str4);

        void requestContactUs();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.contactus.mvp.ContactUsContractor$View */
    public interface View extends ViewInterface {
        void onResult(String str);

        void showResult(ContactUsResult contactUsResult);
    }
}
