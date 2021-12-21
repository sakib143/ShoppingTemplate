package com.kiandashopping.kiandashopping.p011ui.wishlist.activity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.airbnb.lottie.LottieAnimationView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.wishlist.MyWishListResult;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.activity.ProductDetailActivity;
import com.kiandashopping.kiandashopping.p011ui.wishlist.adapter.WishListAdapter;
import com.kiandashopping.kiandashopping.p011ui.wishlist.mvp.WishListContractor;
import com.kiandashopping.kiandashopping.p011ui.wishlist.mvp.WishListPresenter;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.activity.WishListActivity */
public class WishListActivity extends BaseActivity implements WishListContractor.View, WishListAdapter.Listener {
    @BindView(2131361879)
    LottieAnimationView avEmpty;
    LangRequest langRequest = new LangRequest();
    @BindView(2131362132)
    LinearLayout llListEmpty;
    List<MyWishListResult> productLists;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f262rv;
    WishListAdapter viewAllAdapter;
    WishListPresenter wishListPresenter;

    public int getLayout() {
        return R.layout.activity_wish_list;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.title.setText(ResourceUtils.getString(R.string.my_wish_list));
        this.wishListPresenter = new WishListPresenter(this);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList arrayList = new ArrayList();
        this.productLists = arrayList;
        WishListAdapter wishListAdapter = new WishListAdapter(arrayList, this);
        this.viewAllAdapter = wishListAdapter;
        this.f262rv.setAdapter(wishListAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        this.menuItem.setVisible(false);
        return true;
    }

    public PresenterInterface getPresenterInterface() {
        return this.wishListPresenter;
    }

    public void onClickLoad(int i) {
        this.langRequest.setPageNo(this.viewAllAdapter.getPageNumber());
        this.wishListPresenter.requestWishList(this.langRequest);
    }

    public void showResult(List<MyWishListResult> list) {
        this.productLists.addAll(list);
        this.viewAllAdapter.onLoadFinished(list.size());
    }

    public void showResultError() {
        this.f262rv.setVisibility(8);
        this.llListEmpty.setVisibility(0);
        this.avEmpty.setVisibility(0);
        this.avEmpty.setAnimation((int) R.raw.wish_list_empty);
        this.avEmpty.playAnimation();
    }

    public void showWishListResult(int i, BaseResponse baseResponse) {
        showToast(baseResponse.getDescription());
    }

    public void showWishListError(int i, String str) {
        this.viewAllAdapter.notifyDataSetChanged();
        showToast(str);
    }

    public void onAddWishList(int i, int i2) {
        this.wishListPresenter.onAddWish(i, i2);
        this.viewAllAdapter.removeAt(i2);
        if (this.productLists.size() == 0) {
            showResultError();
        }
    }

    public void onClickItem(MyWishListResult myWishListResult) {
        changeActivity(ProductDetailActivity.builtIntent(this, myWishListResult.getProductId().intValue(), false));
    }
}
