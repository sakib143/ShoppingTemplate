package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.aboutus.mvp;

//import com.kiandashopping.kiandashopping.base.BaseModel;
//import com.kiandashopping.kiandashopping.model.BaseResponse;
//import com.kiandashopping.kiandashopping.model.cms.RequestAboutUs;
//import com.kiandashopping.kiandashopping.model.cms.ResultAboutUs;
import com.innomalist.taxi.shoppingapp.base.BaseModel;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.cms.RequestAboutUs;
import com.innomalist.taxi.shoppingapp.model.cms.ResultAboutUs;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.aboutus.mvp.AboutUsContractor;

import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import p013io.reactivex.disposables.Disposable;
//import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.aboutus.mvp.AboutUsModel */
public class AboutUsModel extends BaseModel implements AboutUsContractor.Model {
    /* access modifiers changed from: private */
    public AboutUsContractor.Presenter presenter;

    AboutUsModel(AboutUsPresenter aboutUsPresenter) {
        this.presenter = aboutUsPresenter;
    }

    public Disposable requestAboutUs(RequestAboutUs requestAboutUs) {
        return addRequest(this.apiInterface.requestAboutUs(requestAboutUs), new DisposableSingleObserver<BaseResponse<ResultAboutUs>>() {
            public void onSuccess(BaseResponse<ResultAboutUs> baseResponse) {
                if (baseResponse.isSuccess()) {
                    AboutUsModel.this.presenter.onResult(baseResponse.getData().getContent());
                } else {
                    AboutUsModel.this.presenter.onResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                AboutUsModel.this.presenter.onResultError(AppUtils.getError(th));
            }
        });
    }
}
