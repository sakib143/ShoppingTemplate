package com.kiandashopping.kiandashopping.p011ui.payment.mvp;

import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.accountdetail.ShippingDetail;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.payment.RequestCOD;
import com.kiandashopping.kiandashopping.model.payment.RequestProxyPay;
import com.kiandashopping.kiandashopping.model.payment.ResultPaymentDetails;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.payment.mvp.PaymentContractor */
public interface PaymentContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.payment.mvp.PaymentContractor$Model */
    public interface Model {
        Disposable onRequestCOD(RequestCOD requestCOD);

        Disposable onRequestPaymentDetail(LangRequest langRequest);

        Disposable onRequestProxyPay(RequestProxyPay requestProxyPay, String str);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.payment.mvp.PaymentContractor$Presenter */
    public interface Presenter {
        void onPaymentDetails(ResultPaymentDetails resultPaymentDetails);

        void onPaymentDetailsError(String str);

        void onPaymentSuccess(String str, String str2);

        void onPaymentSuccess(String str, String str2, String str3, String str4, String str5);

        void onPaymentSuccessError(String str);

        void onRequestCOD(ShippingDetail shippingDetail);

        void onRequestPaymentDetail();

        void onRequestProxyPay(ShippingDetail shippingDetail, String str);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.payment.mvp.PaymentContractor$View */
    public interface View extends ViewInterface {
        void onPaymentDetails(ResultPaymentDetails resultPaymentDetails);

        void showPaymentError(String str);

        void showPaymentSuccess(String str, String str2);

        void showPaymentSuccess(String str, String str2, String str3, String str4, String str5);
    }
}
