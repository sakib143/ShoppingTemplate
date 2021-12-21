package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.accountdetail.ContactUsResult;
import com.kiandashopping.kiandashopping.model.accountdetail.RequestSubmitForm;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus.mvp.ContactUsContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.contactus.mvp.ContactUsModel */
public class ContactUsModel extends BaseModel implements ContactUsContractor.Model {
    /* access modifiers changed from: private */
    public ContactUsContractor.Presenter presenter;

    ContactUsModel(ContactUsPresenter contactUsPresenter) {
        this.presenter = contactUsPresenter;
    }

    public Disposable requestContactUs(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestContactUs(langRequest), new DisposableSingleObserver<BaseResponse<ContactUsResult>>() {
            public void onSuccess(BaseResponse<ContactUsResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    ContactUsModel.this.presenter.onResult(baseResponse.getData());
                } else {
                    ContactUsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ContactUsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestSubmit(RequestSubmitForm requestSubmitForm) {
        return addRequest(this.apiInterface.requestFormSubmit(requestSubmitForm), new DisposableSingleObserver<BaseResponse>() {
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse.isSuccess()) {
                    ContactUsModel.this.presenter.onResult(baseResponse.getDescription());
                } else {
                    ContactUsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ContactUsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
