package com.kiandashopping.kiandashopping.p011ui.payment.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.accountdetail.ShippingDetail;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.payment.RequestCOD;
import com.kiandashopping.kiandashopping.model.payment.RequestProxyPay;
import com.kiandashopping.kiandashopping.model.payment.ResultPaymentDetails;
import com.kiandashopping.kiandashopping.p011ui.payment.mvp.PaymentContractor;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.payment.mvp.PaymentPresenter */
public class PaymentPresenter extends BasePresenter implements PaymentContractor.Presenter {
    private Disposable disposable;
    private PaymentContractor.View mView;
    private PaymentModel model = new PaymentModel(this);

    public PaymentPresenter(PaymentContractor.View view) {
        this.mView = view;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void onRequestPaymentDetail() {
        this.mView.showLoadingView();
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.onRequestPaymentDetail(new LangRequest(this.appRepository.getLanguage(), this.appRepository.getUserId()));
    }

    public void onRequestCOD(ShippingDetail shippingDetail) {
        this.mView.showLoadingView();
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.onRequestCOD(new RequestCOD(shippingDetail, this.appRepository.getUserId(), this.appRepository.getLanguage()));
    }

    public void onRequestProxyPay(ShippingDetail shippingDetail, String str) {
        this.mView.showLoadingView();
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.onRequestProxyPay(new RequestProxyPay(shippingDetail, this.appRepository.getUserId(), this.appRepository.getLanguage()), str);
    }

    public void onPaymentDetailsError(String str) {
        this.mView.hideLoadingView();
        this.mView.showError(str);
    }

    public void onPaymentDetails(ResultPaymentDetails resultPaymentDetails) {
        this.mView.hideLoadingView();
        this.mView.onPaymentDetails(resultPaymentDetails);
    }

    public void onPaymentSuccessError(String str) {
        this.mView.hideLoadingView();
        this.mView.showPaymentError(str);
    }

    public void onPaymentSuccess(String str, String str2) {
        this.mView.hideLoadingView();
        this.mView.showPaymentSuccess(str, str2);
    }

    public void onPaymentSuccess(String str, String str2, String str3, String str4, String str5) {
        this.mView.hideLoadingView();
        this.mView.showPaymentSuccess(str, str2, str3, str4, str5);
    }
}
