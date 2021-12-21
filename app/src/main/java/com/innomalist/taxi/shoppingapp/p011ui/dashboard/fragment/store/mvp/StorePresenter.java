package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.store.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.storelist.StoreResult;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.store.mvp.StoreContractor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.store.mvp.StorePresenter */
public class StorePresenter extends BasePresenter implements StoreContractor.Presenter {
    private StoreContractor.Model model = new StoreModel(this);
    private StoreContractor.View view;

    public StorePresenter(StoreContractor.View view2) {
        this.view = view2;
    }

    public void requestStore(LangRequest langRequest) {
        if (langRequest.getPageNo().equals("1")) {
            this.view.showLoadingView();
        }
        this.model.requestStore(langRequest);
    }

    public void onResult(List<StoreResult> list) {
        this.view.hideLoadingView();
        this.view.showResult(list);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showResult(new ArrayList());
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }
}
