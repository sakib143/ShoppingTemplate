package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.nearme.NearByRequest;
import com.kiandashopping.kiandashopping.model.nearme.NearByResult;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.mvp.NearByContractor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.mvp.NearByPresenter */
public class NearByPresenter extends BasePresenter implements NearByContractor.Presenter {
    private NearByContractor.Model model = new NearByModel(this);
    private NearByContractor.View view;

    public NearByPresenter(NearByContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestNearBy(String str, String str2) {
        this.view.showLoadingView();
        this.model.requestNearBy(new NearByRequest(str, str2, this.appRepository.getLanguage()));
    }

    public void onResult(List<NearByResult> list) {
        this.view.hideLoadingView();
        this.view.showResult(list);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showToast(str);
        this.view.showResult(new ArrayList());
    }
}
