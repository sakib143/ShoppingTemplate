package com.innomalist.taxi.shoppingapp.p011ui.storedetails.mvp;

//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.ModelInterface;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.base.BasePresenter;
//import com.kiandashopping.kiandashopping.model.storelist.RequestAddStoreReview;
//import com.kiandashopping.kiandashopping.model.storelist.StoreDetailRequest;
//import com.kiandashopping.kiandashopping.model.storelist.StoreDetailsResult;
//import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsContractor;
//import com.kiandashopping.kiandashopping.util.ConversionUtils;
//import com.kiandashopping.kiandashopping.util.NetworkUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
//import p013io.reactivex.disposables.Disposable;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.base.BasePresenter;
import com.innomalist.taxi.shoppingapp.model.storelist.RequestAddStoreReview;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreDetailRequest;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreDetailsResult;
import com.innomalist.taxi.shoppingapp.util.ConversionUtils;
import com.innomalist.taxi.shoppingapp.util.NetworkUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

import io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.mvp.StoreDetailsPresenter */
public class StoreDetailsPresenter extends BasePresenter implements StoreDetailsContractor.Presenter {
    private Disposable disposable;
    private StoreDetailsContractor.Model model = new StoreDetailsModel(this);
    private StoreDetailsContractor.View view;

    public StoreDetailsPresenter(StoreDetailsContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestStoreDetails(int i) {
        this.view.showLoadingView();
        this.model.requestStoreDetails(new StoreDetailRequest(this.appRepository.getLanguage(), this.appRepository.getUserId(), i));
    }

    public void onAddReview(int i, float f, String str, String str2) {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.getContext())) {
            this.view.showToast(ResourceUtils.getString(R.string.network_error));
        } else if (f == 0.0f) {
            this.view.showToast(ResourceUtils.getString(R.string.choose_rating));
        } else if (str.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.error_summary));
        } else if (str2.isEmpty()) {
            this.view.showToast(ResourceUtils.getString(R.string.error_comments));
        } else {
            this.view.showLoadingView();
            Disposable disposable2 = this.disposable;
            if (disposable2 != null && !disposable2.isDisposed()) {
                this.disposable.dispose();
            }
            this.disposable = this.model.requestAddReview(new RequestAddStoreReview(this.appRepository.getLanguage(), this.appRepository.getUserId(), i, str, str2, ConversionUtils.parseInt(f)));
        }
    }

    public void onResult(StoreDetailsResult storeDetailsResult) {
        this.view.hideLoadingView();
        this.view.showResult(storeDetailsResult);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showResultError(str);
    }
}
