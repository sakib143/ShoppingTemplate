package com.innomalist.taxi.shoppingapp.p011ui.account.mvp;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.ViewInterface;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.accountdetail.AccountDetailResult;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.model.accountdetail.UserDetail;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.country.CountryDetail;
import java.io.File;
import java.util.List;

import io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.account.mvp.EditProfileContractor */
public interface EditProfileContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.account.mvp.EditProfileContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestAccountDetails(List<CountryDetail> list, LangRequest langRequest);

        Disposable requestCountry(LangRequest langRequest);

        Disposable updateProfile(File file, String str, String str2, String str3, String str4, String str5, String str6, String str7, ShippingDetail shippingDetail);

        Disposable updateShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UserDetail userDetail);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.account.mvp.EditProfileContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void requestCountry();

        void result(List<CountryDetail> list, AccountDetailResult accountDetailResult);

        void resultError(String str);

        void updateError(String str);

        void updateProfile(File file, String str, String str2, String str3, String str4, String str5, ShippingDetail shippingDetail);

        void updateShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, UserDetail userDetail);

        void updateSuccess(BaseResponse<AccountDetailResult> baseResponse);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.account.mvp.EditProfileContractor$View */
    public interface View extends ViewInterface {
        void showResult(List<CountryDetail> list, AccountDetailResult accountDetailResult);

        void showUpdateSuccess(String str);
    }
}
