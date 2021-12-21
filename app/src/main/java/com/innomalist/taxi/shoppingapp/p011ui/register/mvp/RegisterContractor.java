package com.kiandashopping.kiandashopping.p011ui.register.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.country.CountryDetail;
import com.kiandashopping.kiandashopping.model.register.RegisterResult;
import com.kiandashopping.kiandashopping.model.register.RequestRegister;
import java.util.List;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.register.mvp.RegisterContractor */
public interface RegisterContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.register.mvp.RegisterContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestCountry(LangRequest langRequest);

        Disposable requestRegister(RequestRegister requestRegister);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.register.mvp.RegisterContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void registerError(String str);

        void requestCountry();

        void requestRegister(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z);

        void resultCountryList(List<CountryDetail> list);

        void resultError(String str);

        void resultOTP(RequestRegister requestRegister);

        void resultSuccess(RegisterResult registerResult);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.register.mvp.RegisterContractor$View */
    public interface View extends ViewInterface {
        void showCountryList(List<CountryDetail> list);

        void showResultOtp(RequestRegister requestRegister);

        void showResultSuccess();
    }
}
