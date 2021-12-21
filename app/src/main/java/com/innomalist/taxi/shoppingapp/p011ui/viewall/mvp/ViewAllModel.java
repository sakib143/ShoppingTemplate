package com.kiandashopping.kiandashopping.p011ui.viewall.mvp;

import com.kiandashopping.kiandashopping.base.BaseModel;
import com.kiandashopping.kiandashopping.model.BaseResponse;
import com.kiandashopping.kiandashopping.model.viewall.AllItemRequest;
import com.kiandashopping.kiandashopping.model.viewall.ProductList;
import com.kiandashopping.kiandashopping.p011ui.viewall.mvp.ViewAllContractor;
import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.List;
import p013io.reactivex.disposables.Disposable;
import p013io.reactivex.observers.DisposableSingleObserver;

/* renamed from: com.kiandashopping.kiandashopping.ui.viewall.mvp.ViewAllModel */
public class ViewAllModel extends BaseModel implements ViewAllContractor.Model {
    /* access modifiers changed from: private */
    public ViewAllContractor.Presenter presenter;

    ViewAllModel(ViewAllPresenter viewAllPresenter) {
        this.presenter = viewAllPresenter;
    }

    public Disposable requestDashboard(AllItemRequest allItemRequest) {
        return addRequest(this.apiInterface.requestAllItems(allItemRequest), new DisposableSingleObserver<BaseResponse<List<ProductList>>>() {
            public void onSuccess(BaseResponse<List<ProductList>> baseResponse) {
                if (baseResponse.isSuccess()) {
                    ViewAllModel.this.presenter.onAllItemResult(baseResponse.getData());
                } else {
                    ViewAllModel.this.presenter.onAllItemResultError(baseResponse.getDescription());
                }
            }

            public void onError(Throwable th) {
                ViewAllModel.this.presenter.onAllItemResultError(AppUtils.getError(th));
            }
        });
    }
}
