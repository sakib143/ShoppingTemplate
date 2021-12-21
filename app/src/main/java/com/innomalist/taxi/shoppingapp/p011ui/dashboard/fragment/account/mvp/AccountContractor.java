package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.account.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.ViewInterface;
import com.kiandashopping.kiandashopping.model.accountdetail.AccountDetailResult;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.dashboard.ChangePasswordRequest;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.account.mvp.AccountContractor */
public interface AccountContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.account.mvp.AccountContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestAccountDetails(LangRequest langRequest);

        Disposable requestChangePassword(ChangePasswordRequest changePasswordRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.account.mvp.AccountContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void changePassword(String str, String str2);

        void changePasswordError(String str);

        void changePasswordSuccess(String str);

        void onAccountDetails(AccountDetailResult accountDetailResult);

        void onAccountDetailsError(String str);

        void requestAccountDetails();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.account.mvp.AccountContractor$View */
    public interface View extends ViewInterface {
        void showAccountDetails(AccountDetailResult accountDetailResult);
    }
}
