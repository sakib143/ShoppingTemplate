package com.innomalist.taxi.shoppingapp.p011ui.confirmshipping.mvp;

import com.innomalist.taxi.shoppingapp.base.BaseModel;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.country.CountryDetail;

import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.confirmshipping.mvp.ConfirmShippingModel */
public class ConfirmShippingModel extends BaseModel implements ConfirmShippingContractor.Model {
    private static final String CUS_IMAGE = "profileImage";
    private static MediaType mediaType = MediaType.parse("text/plain");
    /* access modifiers changed from: private */
    public ConfirmShippingContractor.Presenter presenter;

    ConfirmShippingModel(ConfirmShippingPresenter confirmShippingPresenter) {
        this.presenter = confirmShippingPresenter;
    }

    public Disposable requestCountry(final LangRequest langRequest) {
        return addRequest(this.apiInterface.requestCountry(langRequest), new DisposableSingleObserver<BaseResponse<List<CountryDetail>>>() {
            public void onSuccess(BaseResponse<List<CountryDetail>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    Disposable unused = ConfirmShippingModel.this.requestAccountDetails(langRequest, baseResponse.getData());
                } else {
                    ConfirmShippingModel.this.presenter.resultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ConfirmShippingModel.this.presenter.resultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable updateShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UserDetail userDetail) {
        ApiInterface apiInterface = this.apiInterface;
        return addRequest(apiInterface.updateAccount(createPart(str), createPart(userDetail.getCusName()), createPart(userDetail.getCusEmail()), createPart(userDetail.getCusPhone()), createPart(""), createPart(""), createPart(userDetail.getCountryId()), createPart(userDetail.getCityId()), createPart(str3), createPart(str4), createPart(str5), createPart(str6), createPart(str7), createPart(str8), createPart(str9), createPart(str10), createPart(str11), createPart(str2), (MultipartBody.Part) null), new DisposableSingleObserver<BaseResponse<AccountDetailResult>>() {
            public void onSuccess(BaseResponse<AccountDetailResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    ConfirmShippingModel.this.presenter.updateSuccess(baseResponse);
                } else {
                    ConfirmShippingModel.this.presenter.updateError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ConfirmShippingModel.this.presenter.updateError(AppUtils.getError(th));
            }
        });
    }

    /* access modifiers changed from: private */
    public Disposable requestAccountDetails(LangRequest langRequest, final List<CountryDetail> list) {
        return addRequest(this.apiInterface.requestAccountDetails(langRequest), new DisposableSingleObserver<BaseResponse<AccountDetailResult>>() {
            public void onSuccess(BaseResponse<AccountDetailResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    ConfirmShippingModel.this.presenter.onAccountDetails(baseResponse.getData(), list);
                } else {
                    ConfirmShippingModel.this.presenter.resultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ConfirmShippingModel.this.presenter.resultError(AppUtils.getError(th));
            }
        });
    }

    private RequestBody createPart(String str) {
        return RequestBody.create(mediaType, str);
    }
}
