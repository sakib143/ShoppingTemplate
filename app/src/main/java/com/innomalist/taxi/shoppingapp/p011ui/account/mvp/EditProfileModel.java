package com.innomalist.taxi.shoppingapp.p011ui.account.mvp;

//import com.kiandashopping.kiandashopping.base.BaseModel;
//import com.kiandashopping.kiandashopping.util.AppUtils;
import com.innomalist.taxi.shoppingapp.base.BaseModel;
import com.innomalist.taxi.shoppingapp.data.rest.ApiInterface;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.accountdetail.AccountDetailResult;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.country.CountryDetail;
import com.innomalist.taxi.shoppingapp.model.register.UserDetail;
import com.innomalist.taxi.shoppingapp.util.AppUtils;

import java.io.File;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* renamed from: com.kiandashopping.kiandashopping.ui.account.mvp.EditProfileModel */
public class EditProfileModel extends BaseModel implements EditProfileContractor.Model {
    private static final String CUS_IMAGE = "profileImage";
    private static MediaType mediaType = MediaType.parse("text/plain");
    /* access modifiers changed from: private */
    public EditProfileContractor.Presenter presenter;

    EditProfileModel(EditProfilePresenter editProfilePresenter) {
        this.presenter = editProfilePresenter;
    }

    public Disposable requestCountry(final LangRequest langRequest) {
        return addRequest(this.apiInterface.requestCountry(langRequest), new DisposableSingleObserver<BaseResponse<List<CountryDetail>>>() {
            public void onSuccess(BaseResponse<List<CountryDetail>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    EditProfileModel.this.requestAccountDetails(baseResponse.getData(), langRequest);
                } else {
                    EditProfileModel.this.presenter.resultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                EditProfileModel.this.presenter.resultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable requestAccountDetails(final List<CountryDetail> list, LangRequest langRequest) {
        return addRequest(this.apiInterface.requestAccountDetails(langRequest), new DisposableSingleObserver<BaseResponse<AccountDetailResult>>() {
            public void onSuccess(BaseResponse<AccountDetailResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    EditProfileModel.this.presenter.result(list, baseResponse.getData());
                } else {
                    EditProfileModel.this.presenter.resultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                EditProfileModel.this.presenter.resultError(AppUtils.getError(th));
            }
        });
    }

    public Disposable updateProfile(File file, String str, String str2, String str3, String str4, String str5, String str6, String str7, ShippingDetail shippingDetail) {
        MultipartBody.Part part;
        File file2 = file;
        if (file2 != null) {
            part = MultipartBody.Part.createFormData(CUS_IMAGE, file.getName(), RequestBody.create(MediaType.parse("image/*"), file2));
        } else {
            part = null;
        }
        return addRequest(this.apiInterface.updateAccount(createPart(str), createPart(str3), createPart(str4), createPart(str5), createPart(str6), createPart(str7), createPart(""), createPart(""), createPart(shippingDetail.getShipName()), createPart(shippingDetail.getShipEmail()), createPart(shippingDetail.getShipPhone()), createPart(shippingDetail.getShipAddress1()), createPart(shippingDetail.getShipAddress2()), createPart(shippingDetail.getShipCountryId()), createPart(shippingDetail.getShipCityId()), createPart(shippingDetail.getShipState()), createPart(shippingDetail.getShipPostalcode()), createPart(str2), part), new DisposableSingleObserver<BaseResponse<AccountDetailResult>>() {
            public void onSuccess(BaseResponse<AccountDetailResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    EditProfileModel.this.presenter.updateSuccess(baseResponse);
                } else {
                    EditProfileModel.this.presenter.updateError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                EditProfileModel.this.presenter.updateError(AppUtils.getError(th));
            }
        });
    }

    public Disposable updateShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UserDetail userDetail) {
        ApiInterface apiInterface = this.apiInterface;
        return addRequest(apiInterface.updateAccount(createPart(str), createPart(userDetail.getCusName()), createPart(userDetail.getCusEmail()), createPart(userDetail.getCusPhone()), createPart(""), createPart(""), createPart(userDetail.getCountryId()), createPart(userDetail.getCityId()), createPart(str3), createPart(str4), createPart(str5), createPart(str6), createPart(str7), createPart(str8), createPart(str9), createPart(str10), createPart(str11), createPart(str2), (MultipartBody.Part) null), new DisposableSingleObserver<BaseResponse<AccountDetailResult>>() {
            public void onSuccess(BaseResponse<AccountDetailResult> baseResponse) {
                if (baseResponse.isSuccess()) {
                    EditProfileModel.this.presenter.updateSuccess(baseResponse);
                } else {
                    EditProfileModel.this.presenter.updateError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                EditProfileModel.this.presenter.updateError(AppUtils.getError(th));
            }
        });
    }

    private RequestBody createPart(String str) {
        return RequestBody.create(mediaType, str);
    }
}
