package com.kiandashopping.kiandashopping.p011ui.itemdetails.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.apptube.ecommerce.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.AppConstants;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.itemdetails.AddedCartResult;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult;
import com.kiandashopping.kiandashopping.p011ui.allreviews.activity.AllReviews;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.actvity.MyCartActivity;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.activity.ProductDetailActivity;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductInfinitePager;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.mvp.ProductDetailsContractor;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.mvp.ProductDetailsPresenter;
import com.kiandashopping.kiandashopping.p011ui.storedetails.activity.StoreDetailsActivity;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.DateTime;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.activity.ProductDetailActivity */
public class ProductDetailActivity extends BaseActivity implements ProductDetailsContractor.View, ProductDetailAdapter.Listener {
    private static final int ADD_TO_CART = 0;
    private static final String ARG_IS_DEAL = "isDeal";
    private static final String ARG_PRODUCT_ID = "productId";
    private static final int BUY_NOW = 1;
    @BindView(2131361869)
    AppBarLayout appBarLayout;
    @BindView(2131361898)
    Button btnAddCart;
    @BindView(2131361899)
    Button btnBuyNow;
    @BindView(2131361963)
    CollapsingToolbarLayout collapsingToolbar;
    int colorId = 0;
    @BindView(2131362031)
    FloatingActionButton fabFav;
    @BindView(2131362040)
    FrameLayout flBottom;
    boolean isColor = false;
    boolean isSize = false;
    @BindView(2131362106)
    ImageView ivStore;
    private List<Object> objectList;
    ProductDetailsPresenter presenter;
    ProductDetailAdapter productDetailAdapter;
    ProductDetailsResult productDetailsResult;
    int quantity = 1;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f245rv;
    int sizeId = 0;
    private Timer timerObj = new Timer();
    private TimerTask timerTaskObj;

    public int getLayout() {
        return R.layout.activity_product_details;
    }

    public static Intent builtIntent(Activity activity, int i, boolean z) {
        Intent intent = new Intent(activity, ProductDetailActivity.class);
        intent.putExtra(ARG_PRODUCT_ID, i);
        intent.putExtra(ARG_IS_DEAL, z);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.presenter = new ProductDetailsPresenter(this);
        if (AppUtils.getBoolean(getIntent(), ARG_IS_DEAL).booleanValue()) {
            this.presenter.onRequestDealDetails(AppUtils.getInt(getIntent(), ARG_PRODUCT_ID));
        } else {
            this.presenter.onRequestProductDetails(AppUtils.getInt(getIntent(), ARG_PRODUCT_ID));
        }
        setRecyclerView();
        this.appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                ProductDetailActivity.this.lambda$onCreate$0$ProductDetailActivity(appBarLayout, i);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$ProductDetailActivity(AppBarLayout appBarLayout2, int i) {
        float abs = (((float) Math.abs(i)) - 0.0f) / ((float) appBarLayout2.getTotalScrollRange());
        this.title.setAlpha(AppUtils.getAlpha(abs, 0.75f, 1.0f));
        int round = Math.round((1.0f - abs) * 255.0f);
        if (this.toolbar.getNavigationIcon() != null) {
            this.toolbar.getNavigationIcon().setColorFilter(Color.rgb(255, round, round), PorterDuff.Mode.SRC_ATOP);
        }
        if (this.menuItem != null) {
            this.menuItem.getIcon().setColorFilter(Color.rgb(255, round, round), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    private void setRecyclerView() {
        ArrayList arrayList = new ArrayList();
        this.objectList = arrayList;
        ProductDetailAdapter productDetailAdapter2 = new ProductDetailAdapter(this, arrayList, this);
        this.productDetailAdapter = productDetailAdapter2;
        this.f245rv.setAdapter(productDetailAdapter2);
    }

    @OnClick({2131362106})
    public void setIvStore() {
        changeActivity(StoreDetailsActivity.builtIntent(this, this.productDetailsResult.getProductShopName(), this.productDetailsResult.getProductShopId().intValue()));
    }

    public void showResult(ProductDetailsResult productDetailsResult2) {
        this.objectList.clear();
        this.productDetailsResult = productDetailsResult2;
        if (productDetailsResult2.getIsWishlist() == null) {
            AppUtils.hideFabButton(this.fabFav);
        } else if (productDetailsResult2.getIsWishlist().booleanValue()) {
            this.fabFav.setImageResource(R.drawable.ic_fav);
        } else {
            this.fabFav.setImageResource(R.drawable.ic_un_fav);
        }
        new ProductInfinitePager(getWindow().getDecorView(), productDetailsResult2.getProductImage(), getSupportFragmentManager());
        this.title.setText(productDetailsResult2.getProductTitle());
        if (productDetailsResult2.getDealEndDate() != null) {
            this.productDetailAdapter.setOffEnd(new DateTime(productDetailsResult2.getDealEndDate(), DateTime.SERVER_DATE_TIME).getCalendar().getTimeInMillis());
        }
        this.objectList.add(1);
        if (productDetailsResult2.getProductColorDetails().size() > 0) {
            this.isColor = true;
            this.objectList.add(ResourceUtils.getString(R.string.choose_color));
            this.objectList.add(2);
        }
        if (productDetailsResult2.getProductSizeDetails().size() > 0) {
            this.isSize = true;
            this.objectList.add(ResourceUtils.getString(R.string.choose_size));
            this.objectList.add(3);
        }
        if (productDetailsResult2.getCancelPolicy().getPolicyDesc() != null) {
            this.objectList.add(ResourceUtils.getString(R.string.cancellation_policy_details));
            this.objectList.add(4);
        }
        if (productDetailsResult2.getReturnPolicy().getPolicyDesc() != null) {
            this.objectList.add(ResourceUtils.getString(R.string.return_policy_details));
            this.objectList.add(5);
        }
        if (productDetailsResult2.getReplacePolicy().getPolicyDesc() != null) {
            this.objectList.add(ResourceUtils.getString(R.string.replace_policy_details));
            this.objectList.add(6);
        }
        this.objectList.add(7);
        if (productDetailsResult2.getRelatedProducts().size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.related_products));
            this.objectList.add(8);
        }
        this.objectList.add(ResourceUtils.getString(R.string.store_details));
        this.objectList.add(9);
        this.productDetailAdapter.setListData(productDetailsResult2);
        this.productDetailAdapter.notifyDataSetChanged();
    }

    public void onResume() {
        super.onResume();
        Timer timer = this.timerObj;
        TimerTask newTimerTask = newTimerTask();
        this.timerTaskObj = newTimerTask;
        timer.schedule(newTimerTask, 0, 1000);
    }

    public void onPause() {
        super.onPause();
        this.timerTaskObj.cancel();
    }

    private TimerTask newTimerTask() {
        return new TimerTask() {
            public void run() {
                ProductDetailActivity.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        ProductDetailActivity.C15401.this.lambda$run$0$ProductDetailActivity$1();
                    }
                });
            }

            public /* synthetic */ void lambda$run$0$ProductDetailActivity$1() {
                if (ProductDetailActivity.this.productDetailsResult != null && ProductDetailActivity.this.productDetailsResult.getDealEndDate() != null) {
                    int childCount = ProductDetailActivity.this.f245rv.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        RecyclerView.ViewHolder childViewHolder = ProductDetailActivity.this.f245rv.getChildViewHolder(ProductDetailActivity.this.f245rv.getChildAt(i));
                        if (childViewHolder instanceof ProductDetailAdapter.ItemInfoHolder) {
                            ((ProductDetailAdapter.ItemInfoHolder) childViewHolder).updateRemainingTime();
                        }
                    }
                }
            }
        };
    }

    public void showResultError(String str) {
        showToast(str);
    }

    public void showWishListResult(BaseResponse baseResponse) {
        if (baseResponse.getMessage().equals(AppConstants.API_WISHLIST_ADDED_SUCCESSFULLY)) {
            this.fabFav.setImageResource(R.drawable.ic_fav);
        } else if (baseResponse.getMessage().equals(AppConstants.API_WISHLIST_DELETED_SUCCESSFULLY)) {
            this.fabFav.setImageResource(R.drawable.ic_un_fav);
        }
        showToast(baseResponse.getDescription());
    }

    public void showAddCartResult(BaseResponse<AddedCartResult> baseResponse) {
        this.appRepository.setCartCount(baseResponse.getData().getCartCount().intValue());
        showToast(baseResponse.getDescription());
        setBadgeIcon();
    }

    public void showBuyNowResult(BaseResponse<AddedCartResult> baseResponse) {
        this.appRepository.setCartCount(baseResponse.getData().getCartCount().intValue());
        setBadgeIcon();
        changeActivity(MyCartActivity.class);
    }

    public void onClickColor(int i, int i2) {
        this.colorId = i;
        this.productDetailAdapter.setColorPosition(i2);
        this.productDetailAdapter.notifyDataSetChanged();
    }

    public void onClickSize(int i, int i2) {
        this.sizeId = i;
        this.productDetailAdapter.setSizePosition(i2);
        this.productDetailAdapter.notifyDataSetChanged();
    }

    public void onClickQuantity(int i) {
        this.quantity = i;
        this.productDetailAdapter.setQuantity(i);
        this.productDetailAdapter.notifyDataSetChanged();
    }

    public void onClickPolicyDetails(String str, String str2) {
        showSuccess(str, str2, false);
    }

    public void onClickSendReview(float f, String str, String str2) {
        if (AppUtils.getBoolean(getIntent(), ARG_IS_DEAL).booleanValue()) {
            this.presenter.onAddReview(AppUtils.getInt(getIntent(), ARG_PRODUCT_ID), f, str, str2, true);
        } else {
            this.presenter.onAddReview(AppUtils.getInt(getIntent(), ARG_PRODUCT_ID), f, str, str2, false);
        }
    }

    public void onClickProduct(int i) {
        finish();
        changeActivity(builtIntent(this, i, false));
    }

    public void onCallStore(final String str) {
        Dexter.withActivity(this).withPermission("android.permission.CALL_PHONE").withListener(new PermissionListener() {
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + str));
                ProductDetailActivity.this.startActivity(intent);
            }

            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                if (permissionDeniedResponse.isPermanentlyDenied()) {
                    ProductDetailActivity.this.onCallStore(str);
                }
            }

            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    public void onNavigation(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + str + AppConstants.COMMA + str2));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void onWeb(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void onMoreReview() {
        if (AppUtils.getBoolean(getIntent(), ARG_IS_DEAL).booleanValue()) {
            changeActivity(AllReviews.builtIntent(this, AllReviews.TYPE_DEAL, AppUtils.getInt(getIntent(), ARG_PRODUCT_ID)));
        } else {
            changeActivity(AllReviews.builtIntent(this, AllReviews.TYPE_PRODUCT, AppUtils.getInt(getIntent(), ARG_PRODUCT_ID)));
        }
    }

    public void onTabSelected(int i) {
        this.productDetailAdapter.setTabPosition(i);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362031})
    public void setFavClick() {
        this.presenter.onAddWish(AppUtils.getInt(getIntent(), ARG_PRODUCT_ID));
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361898})
    public void setAddToCart() {
        if (AppUtils.getBoolean(getIntent(), ARG_IS_DEAL).booleanValue()) {
            this.presenter.onAddDealToCart(AppUtils.getInt(getIntent(), ARG_PRODUCT_ID), this.quantity, 0);
        } else {
            this.presenter.onAddToCart(AppUtils.getInt(getIntent(), ARG_PRODUCT_ID), this.productDetailsResult, this.colorId, this.isColor, this.sizeId, this.isSize, this.quantity, 0);
        }
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361899})
    public void setBuyNow() {
        if (AppUtils.getBoolean(getIntent(), ARG_IS_DEAL).booleanValue()) {
            this.presenter.onAddDealToCart(AppUtils.getInt(getIntent(), ARG_PRODUCT_ID), this.quantity, 1);
        } else {
            this.presenter.onAddToCart(AppUtils.getInt(getIntent(), ARG_PRODUCT_ID), this.productDetailsResult, this.colorId, this.isColor, this.sizeId, this.isSize, this.quantity, 1);
        }
    }
}
