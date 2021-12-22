package com.innomalist.taxi.shoppingapp.p011ui.dashboard.viewholder;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.innomalist.taxi.shoppingapp.R;
//import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.viewholder.BottomTabs */
public class BottomTabs {
    @BindView(2131361878)
    protected LottieAnimationView avAccount;
    @BindView(2131361880)
    protected LottieAnimationView avHome;
    @BindView(2131361881)
    protected LottieAnimationView avMyCart;
    @BindView(2131361882)
    protected LottieAnimationView avNearMe;
    @BindView(2131361883)
    protected LottieAnimationView avStore;
    private LottieAnimationView previousLottie;
    private TabListener tabListener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.viewholder.BottomTabs$TabListener */
    public interface TabListener {
        void onTabSelected(int i);
    }

    public BottomTabs(LinearLayout linearLayout, TabListener tabListener2) {
        this.tabListener = tabListener2;
        ButterKnife.bind((Object) this, (View) linearLayout);
        this.avStore.setImageResource(R.drawable.ic_bottom_nav_store);
        this.avMyCart.setImageResource(R.drawable.ic_bottom_nav_cart);
        this.avHome.setImageResource(R.drawable.ic_bottom_nav_home);
        this.avNearMe.setImageResource(R.drawable.ic_bottom_nav_nearme);
        this.avAccount.setImageResource(R.drawable.ic_bottom_tab_account);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362046})
    public void onStoreClick(View view) {
        this.tabListener.onTabSelected(view.getId());
        startAnimation(this.avStore);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362043})
    public void onCartClick(View view) {
        this.tabListener.onTabSelected(view.getId());
        startAnimation(this.avMyCart);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362042})
    public void onHomeClick(View view) {
        this.tabListener.onTabSelected(view.getId());
        startAnimation(this.avHome);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362044})
    public void onNearMeClick(View view) {
        this.tabListener.onTabSelected(view.getId());
        startAnimation(this.avNearMe);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362039})
    public void onAccountClick(View view) {
        this.tabListener.onTabSelected(view.getId());
        startAnimation(this.avAccount);
    }

    public void startAnimation(final LottieAnimationView lottieAnimationView) {
        LottieAnimationView lottieAnimationView2 = this.previousLottie;
        if (lottieAnimationView2 != null) {
            switch (lottieAnimationView2.getId()) {
                case R.id.avAccount:
                    this.previousLottie.setImageResource(R.drawable.ic_bottom_tab_account);
                    break;
                case R.id.avHome:
                    this.previousLottie.setImageResource(R.drawable.ic_bottom_nav_home);
                    break;
                case R.id.avMyCart:
                    this.previousLottie.setImageResource(R.drawable.ic_bottom_nav_cart);
                    break;
                case R.id.avNearMe:
                    this.previousLottie.setImageResource(R.drawable.ic_bottom_nav_nearme);
                    break;
                case R.id.avStore:
                    this.previousLottie.setImageResource(R.drawable.ic_bottom_nav_store);
                    break;
            }
            this.previousLottie.cancelAnimation();
            this.previousLottie.invalidate();
        }
        switch (lottieAnimationView.getId()) {
            case R.id.avAccount:
                lottieAnimationView.setAnimation((int) R.raw.account);
                break;
            case R.id.avHome:
                lottieAnimationView.setAnimation((int) R.raw.home);
                break;
            case R.id.avMyCart:
                lottieAnimationView.setAnimation((int) R.raw.cart);
                break;
            case R.id.avNearMe:
                lottieAnimationView.setAnimation((int) R.raw.location);
                break;
            case R.id.avStore:
                lottieAnimationView.setAnimation((int) R.raw.store);
                break;
        }
        lottieAnimationView.addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new SimpleLottieValueCallback<ColorFilter>() {
            public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
                return new PorterDuffColorFilter(ContextCompat.getColor(lottieAnimationView.getContext(), R.color._colorPrimary), PorterDuff.Mode.SRC_ATOP);
            }
        });
        lottieAnimationView.playAnimation();
        this.previousLottie = lottieAnimationView;
    }
}
