package com.kiandashopping.kiandashopping.p011ui.payment.mvp;

import android.util.Log;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.AppConstants;
import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.data.rest.ApiKeys;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.payment.PaymentResult;
import com.kiandashopping.kiandashopping.model.payment.ProxyPayResult;
import com.kiandashopping.kiandashopping.model.payment.RequestCOD;
import com.kiandashopping.kiandashopping.model.payment.RequestProxyPay;
import com.kiandashopping.kiandashopping.model.payment.ResultPaymentDetails;
import com.kiandashopping.kiandashopping.p011ui.payment.mvp.PaymentContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.DateTime;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.io.IOException;
import java.util.Random;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;
import retrofit2.Response;

/* renamed from: com.kiandashopping.kiandashopping.ui.payment.mvp.PaymentModel */
public class PaymentModel extends BaseModel implements PaymentContractor.Model {
    private static final String API_REFERENCES = "https://api.sandbox.proxypay.co.ao/references/";
    private static final String API_REFERENCE_IDS = "https://api.sandbox.proxypay.co.ao/reference_ids";
    private static final String ENTITY_ID = "99305";
    private static final String INVOICE_PREFIX = "INVOICE_";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    /* access modifiers changed from: private */
    public static final String TAG = PaymentModel.class.getName();
    private static final String TRANSACTION_ID = "KShopping -";
    /* access modifiers changed from: private */
    public static String endDate = "";
    /* access modifiers changed from: private */
    public PaymentPresenter presenter;

    PaymentModel(PaymentPresenter paymentPresenter) {
        this.presenter = paymentPresenter;
    }

    public Disposable onRequestPaymentDetail(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestCheckOutDetails(langRequest), new DisposableSingleObserver<BaseResponse<ResultPaymentDetails>>() {
            public void onSuccess(BaseResponse<ResultPaymentDetails> baseResponse) {
                if (baseResponse.isSuccess()) {
                    PaymentModel.this.presenter.onPaymentDetails(baseResponse.getData());
                } else {
                    PaymentModel.this.presenter.onPaymentDetailsError(baseResponse.getMessage());
                }
            }

            public void onError(Throwable th) {
                PaymentModel.this.presenter.onPaymentDetailsError(AppUtils.getError(th));
            }
        });
    }

    public Disposable onRequestCOD(RequestCOD requestCOD) {
        return addRequest(this.apiInterface.requestCOD(requestCOD), new DisposableSingleObserver<BaseResponse<PaymentResult>>() {
            public void onSuccess(BaseResponse<PaymentResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    PaymentModel.this.presenter.onPaymentSuccess(baseResponse.getDescription(), baseResponse.getData().getTotalOrderAmt());
                } else {
                    PaymentModel.this.presenter.onPaymentSuccessError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                PaymentModel.this.presenter.onPaymentSuccessError(AppUtils.getError(th));
            }
        });
    }

    public Disposable onRequestProxyPay(final RequestProxyPay requestProxyPay, final String str) {
        return addRequest(this.apiInterface.requestReferenceIds(API_REFERENCE_IDS, RequestBody.create((MediaType) null, new byte[0])), new DisposableSingleObserver<Response<ResponseBody>>() {
            public void onSuccess(Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        try {
                            String string = body.string();
                            String access$100 = PaymentModel.TAG;
                            Log.i(access$100, "onSuccess: " + string);
                            PaymentModel.this.onRequestProxyPayReferences(requestProxyPay, str, string);
                        } catch (IOException e) {
                            PaymentModel.this.presenter.onPaymentSuccessError(e.toString());
                        }
                    }
                } else {
                    PaymentModel.this.presenter.onPaymentSuccessError(response.message());
                }
            }

            public void onError(Throwable th) {
                PaymentModel.this.presenter.onPaymentSuccessError(AppUtils.getError(th));
            }
        });
    }

    /* access modifiers changed from: private */
    public void onRequestProxyPayReferences(final RequestProxyPay requestProxyPay, String str, final String str2) {
        addRequest(this.apiInterface.requestReferences(API_REFERENCES + str2, requestReferences(str)), new DisposableSingleObserver<Response<ResponseBody>>() {
            public void onSuccess(Response<ResponseBody> response) {
                if (response.code() == 204) {
                    requestProxyPay.setReferenceId(str2);
                    requestProxyPay.setEntityId(PaymentModel.ENTITY_ID);
                    requestProxyPay.setTransactionId(PaymentModel.generateTransactionId());
                    PaymentModel.this.onRequestProxyPayPayment(requestProxyPay);
                    return;
                }
                PaymentModel.this.presenter.onPaymentSuccessError(ResourceUtils.getString(R.string.proxy_pay_error));
            }

            public void onError(Throwable th) {
                PaymentModel.this.presenter.onPaymentSuccessError(AppUtils.getError(th));
            }
        });
    }

    private static RequestBody requestReferences(String str) {
        JSONObject jSONObject = new JSONObject();
        DateTime dateTime = new DateTime();
        dateTime.getCalendar().add(5, 1);
        endDate = dateTime.getServerDate();
        try {
            jSONObject.put(ApiKeys.AMOUNT, str);
            jSONObject.put(ApiKeys.END_DATETIME, endDate);
            jSONObject.put(ApiKeys.CUSTOM_FIELDS, new JSONObject().put(ApiKeys.INVOICE, generateInvoiceId()));
        } catch (JSONException e) {
            Log.e(AppConstants.EXCEPTION, e.getMessage());
        }
        return RequestBody.create(JSON, jSONObject.toString());
    }

    /* access modifiers changed from: private */
    public void onRequestProxyPayPayment(RequestProxyPay requestProxyPay) {
        addRequest(this.apiInterface.requestProxyPay(requestProxyPay), new DisposableSingleObserver<BaseResponse<ProxyPayResult>>() {
            public void onSuccess(BaseResponse<ProxyPayResult> baseResponse) {
                if (!baseResponse.isSuccess()) {
                    PaymentModel.this.presenter.onPaymentSuccessError(baseResponse.getDescription());
                } else if (baseResponse.getData().getCartDetails().size() > 0) {
                    PaymentModel.this.presenter.onPaymentSuccess(baseResponse.getDescription(), baseResponse.getData().getTotalOrderAmt(), baseResponse.getData().getCartDetails().get(0).getCartEntityId(), baseResponse.getData().getCartDetails().get(0).getCartReferenceId(), PaymentModel.endDate);
                } else {
                    PaymentModel.this.presenter.onPaymentSuccess(baseResponse.getDescription(), baseResponse.getData().getTotalOrderAmt());
                }
            }

            public void onError(Throwable th) {
                PaymentModel.this.presenter.onPaymentSuccessError(AppUtils.getError(th));
            }
        });
    }

    public static String generateInvoiceId() {
        int nextInt = new Random().nextInt(999999);
        return INVOICE_PREFIX + nextInt;
    }

    public static String generateTransactionId() {
        int nextInt = new Random().nextInt(999999);
        return TRANSACTION_ID + nextInt;
    }
}
