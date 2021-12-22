package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.account;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.AppConstants;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.base.BaseFragment;
//import com.kiandashopping.kiandashopping.model.accountdetail.AccountDetailResult;
//import com.kiandashopping.kiandashopping.model.accountdetail.ShippingDetail;
//import com.kiandashopping.kiandashopping.p011ui.account.activity.EditProfile;
//import com.kiandashopping.kiandashopping.p011ui.account.activity.ShippingDetails;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.base.BaseFragment;
import com.innomalist.taxi.shoppingapp.model.accountdetail.AccountDetailResult;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
import com.kiandashopping.kiandashopping.p011ui.dashboard.activity.DashboardActivity;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.account.mvp.AccountContractor;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.account.mvp.AccountPresenter;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogChangePassword;
import com.kiandashopping.kiandashopping.p011ui.myorder.activity.MyOrdersActivity;
//import com.kiandashopping.kiandashopping.p011ui.wishlist.activity.WishListActivity;
//import com.kiandashopping.kiandashopping.util.GlideUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.account.AccountFragment */
public class AccountFragment extends BaseFragment implements AccountContractor.View {
    @BindView(2131362101)
    ImageView ivProfile;
    private AccountPresenter presenter;
    @BindView(2131362275)
    TextView shippingAddressTxt;
    @BindView(2131362372)
    TextView tvEmail;
    @BindView(2131362424)
    TextView tvUserName;

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_account, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AccountPresenter accountPresenter = new AccountPresenter(this);
        this.presenter = accountPresenter;
        accountPresenter.requestAccountDetails();
    }

    public void onResume() {
        super.onResume();
        updateUserDetail(BaseApplication.getAppRepository().getFirstName(), BaseApplication.getAppRepository().getEmail(), BaseApplication.getAppRepository().getAvatar());
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361930})
    public void showChangePassword() {
        DialogChangePassword newInstance = DialogChangePassword.newInstance(getActivity(), ResourceUtils.getString(R.string.change_password), ResourceUtils.getString(R.string.submit));
        newInstance.setClickListener(new DialogChangePassword.MessageListener() {
            public final void onSubmitMessage(String str, String str2) {
                AccountFragment.this.lambda$showChangePassword$0$AccountFragment(str, str2);
            }
        });
        newInstance.show(getChildFragmentManager(), newInstance.getTag());
    }

    public /* synthetic */ void lambda$showChangePassword$0$AccountFragment(String str, String str2) {
        this.presenter.changePassword(str, str2);
    }

    public void showAccountDetails(AccountDetailResult accountDetailResult) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (accountDetailResult.getUserDetails().size() > 0) {
            if (accountDetailResult.getShippingDetails().size() > 0) {
                ShippingDetail shippingDetail = accountDetailResult.getShippingDetails().get(0);
                StringBuilder sb = new StringBuilder();
                String str6 = "";
                if (shippingDetail.getShipAddress1().length() > 0) {
                    str = shippingDetail.getShipAddress1() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str = str6;
                }
                sb.append(str);
                if (shippingDetail.getShipAddress2().length() > 0) {
                    str2 = shippingDetail.getShipAddress2() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str2 = str6;
                }
                sb.append(str2);
                if (shippingDetail.getShipCityName().length() > 0) {
                    str3 = shippingDetail.getShipCityName() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str3 = str6;
                }
                sb.append(str3);
                if (shippingDetail.getShipState().length() > 0) {
                    str4 = shippingDetail.getShipState() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str4 = str6;
                }
                sb.append(str4);
                if (shippingDetail.getShipCountryName().length() > 0) {
                    str5 = shippingDetail.getShipCountryName() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str5 = str6;
                }
                sb.append(str5);
                if (shippingDetail.getShipPostalcode().length() > 0) {
                    str6 = shippingDetail.getShipPostalcode();
                }
                sb.append(str6);
                this.appRepository.setShippingAddress(sb.toString());
            }
            updateUserDetail(accountDetailResult.getUserDetails().get(0).getCusName(), accountDetailResult.getUserDetails().get(0).getCusEmail(), accountDetailResult.getUserDetails().get(0).getCusImage());
        }
    }

    private void updateUserDetail(String str, String str2, String str3) {
        this.tvUserName.setText(str);
        this.tvEmail.setText(str2);
        GlideUtils.showRoundImage(getActivity(), this.ivProfile, R.drawable.user_placeholder, str3);
        this.shippingAddressTxt.setText(this.appRepository.getShippingAddress());
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362022})
    public void setEditProfile() {
        changeActivity(EditProfile.class);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362274})
    public void setShippingAddress() {
        changeActivity(ShippingDetails.class);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362155})
    public void setMyOrder() {
        changeActivity(MyOrdersActivity.class);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362156})
    public void setWishList() {
        changeActivity(WishListActivity.class);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362154})
    public void setMyCart() {
        try {
            ((DashboardActivity) getActivity()).openPage(2);
        } catch (Exception e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
        }
    }
}
