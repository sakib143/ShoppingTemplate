package com.kiandashopping.kiandashopping.p011ui.confirmshipping.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.accountdetail.AccountDetailResult;
import com.kiandashopping.kiandashopping.model.accountdetail.ShippingDetail;
import com.kiandashopping.kiandashopping.model.accountdetail.UserDetail;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.country.CountryDetail;
import java.util.List;
import p013io.reactivex.disposables.Disposable;

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
