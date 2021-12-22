package com.innomalist.taxi.shoppingapp.p011ui.allcategory.mvp;

import com.innomalist.taxi.shoppingapp.base.BaseModel;
import com.innomalist.taxi.shoppingapp.model.BaseResponse;
import com.innomalist.taxi.shoppingapp.model.category.CategoriesList;
import com.innomalist.taxi.shoppingapp.model.category.LangRequest;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.allcategory.mvp.AllCategoryModel */
public class AllCategoryModel extends BaseModel implements AllCategoryContractor.Model {
    /* access modifiers changed from: private */
    public AllCategoryPresenter presenter;

    AllCategoryModel(AllCategoryPresenter allCategoryPresenter) {
        this.presenter = allCategoryPresenter;
    }

    public Disposable requestCategory(LangRequest langRequest) {
        return addRequest(this.apiInterface.requestCategory(langRequest), new DisposableSingleObserver<BaseResponse<List<CategoriesList>>>() {
            public void onSuccess(BaseResponse<List<CategoriesList>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    AllCategoryModel.this.presenter.onResultCategory(baseResponse.getData());
                } else {
                    AllCategoryModel.this.presenter.onError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                AllCategoryModel.this.presenter.onError(AppUtils.getError(th));
            }
        });
    }
}
