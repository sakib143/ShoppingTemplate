package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.aboutus.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.cms.RequestAboutUs;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.aboutus.mvp.AboutUsContractor;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.aboutus.mvp.AboutUsPresenter */
public class AboutUsPresenter extends BasePresenter implements AboutUsContractor.Presenter {
    private AboutUsContractor.Model model = new AboutUsModel(this);
    private AboutUsContractor.View view;

    public AboutUsPresenter(AboutUsContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestAboutUs(String str) {
        this.view.showLoadingView();
        this.model.requestAboutUs(new RequestAboutUs(str, this.appRepository.getLanguage()));
    }

    public void onResult(String str) {
        this.view.hideLoadingView();
        this.view.showResult(str);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showToast(str);
    }
}
