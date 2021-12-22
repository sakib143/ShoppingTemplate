package com.innomalist.taxi.shoppingapp.p011ui.wishlist.mvp;

//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.ModelInterface;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.base.BasePresenter;
//import com.kiandashopping.kiandashopping.model.BaseResponse;
//import com.kiandashopping.kiandashopping.model.category.LangRequest;
//import com.kiandashopping.kiandashopping.model.itemdetails.RequestAddWishList;
//import com.kiandashopping.kiandashopping.model.wishlist.MyWishListResult;
//import com.kiandashopping.kiandashopping.p011ui.wishlist.mvp.WishListContractor;
//import com.kiandashopping.kiandashopping.util.NetworkUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.base.BasePresenter;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.model.itemdetails.RequestAddWishList;
import com.innomalist.taxi.shoppingapp.model.wishlist.MyWishListResult;
import com.innomalist.taxi.shoppingapp.util.NetworkUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

import java.util.List;

import io.reactivex.disposables.Disposable;
//import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.mvp.WishListPresenter */
public class WishListPresenter extends BasePresenter implements WishListContractor.Presenter {
    private Disposable disposable;
    private WishListContractor.Model model = new WishListModel(this);
    private int position;
    private WishListContractor.View view;

    public WishListPresenter(WishListContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestWishList(LangRequest langRequest) {
        if (langRequest.getPageNo().equals("1")) {
            this.view.showLoadingView();
        }
        langRequest.setLang(this.appRepository.getLanguage());
        langRequest.setCusId(this.appRepository.getUserId());
        this.model.requestWishList(langRequest);
    }

    public void onAddWish(int i, int i2) {
        this.position = i2;
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
            return;
        }
        this.view.showLoadingView();
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        this.disposable = this.model.requestAddWishList(new RequestAddWishList(this.appRepository.getUserId(), i, this.appRepository.getLanguage()));
    }

    public void onResult(List<MyWishListResult> list) {
        this.view.hideLoadingView();
        this.view.showResult(list);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showResultError();
    }

    public void onWishListError(String str) {
        this.view.hideLoadingView();
        this.view.showWishListError(this.position, str);
    }

    public void onWishListResult(BaseResponse baseResponse) {
        this.view.hideLoadingView();
        this.view.showWishListResult(this.position, baseResponse);
    }
}
