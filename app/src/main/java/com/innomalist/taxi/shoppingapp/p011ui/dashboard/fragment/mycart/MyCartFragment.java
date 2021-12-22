package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.mycart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.airbnb.lottie.LottieAnimationView;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
//import com.kiandashopping.kiandashopping.base.BaseFragment;
//import com.kiandashopping.kiandashopping.model.mycart.CartDetail;
//import com.kiandashopping.kiandashopping.model.mycart.MyCartResult;
//import com.kiandashopping.kiandashopping.p011ui.confirmshipping.activity.ConfirmShippingDetails;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.base.BaseFragment;
import com.innomalist.taxi.shoppingapp.model.mycart.CartDetail;
import com.innomalist.taxi.shoppingapp.model.mycart.MyCartResult;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.adapter.CartAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.mvp.MyCartContractor;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.mvp.MyCartPresenter;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.MyCartFragment */
public class MyCartFragment extends BaseFragment implements MyCartContractor.View, CartAdapter.Listener {
    private static final String ARG_IS_HOME = "isHome";
    private static final int IS_PRODUCT = 1;
    @BindView(2131361879)
    LottieAnimationView avEmpty;
    private CartAdapter cartAdapter;
    private List<CartDetail> cartDetails;
    @BindView(2131362127)
    LinearLayout llCartEmpty;
    private List<Object> objectList;
    private MyCartPresenter presenter;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f239rv;

    public static Fragment newInstance(boolean z) {
        MyCartFragment myCartFragment = new MyCartFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ARG_IS_HOME, z);
        myCartFragment.setArguments(bundle);
        return myCartFragment;
    }

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(AppUtils.getBoolean(getArguments(), ARG_IS_HOME).booleanValue() ? R.layout.fragment_mycart : R.layout.fragment_mycart_nomargin, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.presenter = new MyCartPresenter(this);
        setRecyclerView();
        this.presenter.requestCart();
        ((BaseActivity) Objects.requireNonNull(getActivity())).hideMenuInFragment();
    }

    private void setRecyclerView() {
        ArrayList arrayList = new ArrayList();
        this.objectList = arrayList;
        CartAdapter cartAdapter2 = new CartAdapter(arrayList, this);
        this.cartAdapter = cartAdapter2;
        this.f239rv.setAdapter(cartAdapter2);
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    public void showResponse(MyCartResult myCartResult) {
        this.objectList.clear();
        List<CartDetail> cartDetails2 = myCartResult.getCartDetails();
        this.cartDetails = cartDetails2;
        if (cartDetails2.size() > 0) {
            this.objectList.clear();
            this.objectList.add(1);
            this.objectList.add(2);
            this.cartAdapter.setResultCartDetails(myCartResult);
            this.cartAdapter.setCartDetails(this.cartDetails);
            this.cartAdapter.onLoadFinished(this.objectList.size());
            this.cartAdapter.notifyDataSetChanged();
            this.appRepository.setCartCount(myCartResult.getCartCount().intValue());
            ((BaseActivity) Objects.requireNonNull(getActivity())).setBadgeIcon();
        } else {
            noRecordView();
        }
        ((BaseActivity) Objects.requireNonNull(getActivity())).hideMenuInFragment();
    }

    public void updateCartSuccess(MyCartResult myCartResult, int i, int i2) {
        this.cartDetails.get(i2).setCartQuantity(Integer.valueOf(i));
        this.cartAdapter.setCartDetails(this.cartDetails);
        this.cartAdapter.notifyDataSetChanged();
    }

    public void deleteCartSuccess(MyCartResult myCartResult, int i) {
        this.cartAdapter.removeAt(i);
        this.appRepository.setCartCount(this.appRepository.getCartCount().intValue() - 1);
        if (myCartResult.getCartDetails() == null) {
            this.appRepository.setCartCount(0);
            noRecordView();
        }
        ((BaseActivity) Objects.requireNonNull(getActivity())).setBadgeIcon();
    }

    public void noRecordView() {
        this.f239rv.setVisibility(8);
        this.llCartEmpty.setVisibility(0);
        this.avEmpty.setVisibility(0);
        this.avEmpty.setAnimation((int) R.raw.cart_empty);
        this.avEmpty.playAnimation();
        this.appRepository.setCartCount(0);
        ((BaseActivity) Objects.requireNonNull(getActivity())).setBadgeIcon();
        ((BaseActivity) Objects.requireNonNull(getActivity())).hideMenuInFragment();
    }

    public void showUpdateError(String str) {
        showError(str);
        this.cartAdapter.notifyDataSetChanged();
    }

    public void clickMinusBtn(CartDetail cartDetail, int i, int i2) {
        if (cartDetail.getCartType().intValue() == 1) {
            this.presenter.updateCartProduct(cartDetail.getCartId().intValue(), cartDetail.getCartProductId().intValue(), i2, i);
        } else {
            this.presenter.updateCartDeal(cartDetail.getCartId().intValue(), cartDetail.getCartProductId().intValue(), i2, i);
        }
    }

    public void clickPlusBtn(CartDetail cartDetail, int i, int i2) {
        if (cartDetail.getCartType().intValue() == 1) {
            this.presenter.updateCartProduct(cartDetail.getCartId().intValue(), cartDetail.getCartProductId().intValue(), i2, i);
        } else {
            this.presenter.updateCartDeal(cartDetail.getCartId().intValue(), cartDetail.getCartProductId().intValue(), i2, i);
        }
    }

    public void outOfQuantity() {
        showError(ResourceUtils.getString(R.string.maximum_quantity));
    }

    public void onRemoveCart(CartDetail cartDetail, int i) {
        this.presenter.deleteCart(cartDetail.getCartType().intValue(), cartDetail.getCartId().intValue(), i);
    }

    public void onSubmit() {
        changeActivity(ConfirmShippingDetails.class);
    }
}
