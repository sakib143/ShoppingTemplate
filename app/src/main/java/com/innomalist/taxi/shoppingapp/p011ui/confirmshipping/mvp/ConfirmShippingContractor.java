package com.innomalist.taxi.shoppingapp.p011ui.confirmshipping.mvp;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.accountdetail.AccountDetailResult;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.country.CountryDetail;
import com.kiandashopping.kiandashopping.ViewInterface;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.confirmshipping.mvp.ConfirmShippingContractor */
public interface ConfirmShippingContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.confirmshipping.mvp.ConfirmShippingContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestCountry(LangRequest langRequest);

        Disposable updateShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UserDetail userDetail);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.confirmshipping.mvp.ConfirmShippingContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onAccountDetails(AccountDetailResult accountDetailResult, List<CountryDetail> list);

        void requestAccount();

        void resultError(String str);

        void updateError(String str);

        void updateShippingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UserDetail userDetail);

        void updateSuccess(BaseResponse<AccountDetailResult> baseResponse);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.confirmshipping.mvp.ConfirmShippingContractor$View */
    public interface View extends ViewInterface {
        void showAccountDetails(AccountDetailResult accountDetailResult, List<CountryDetail> list);

        void showShippingDetail(ShippingDetail shippingDetail);
    }
}
