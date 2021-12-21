package com.innomalist.taxi.shoppingapp.p011ui.allcategory.mvp;


import com.innomalist.taxi.shoppingapp.base.BasePresenter;

import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.allcategory.mvp.AllCategoryPresenter */
public class AllCategoryPresenter extends BasePresenter implements AllCategoryContractor.Presenter {
    private AllCategoryModel model = new AllCategoryModel(this);
    private AllCategoryContractor.View view;

    public AllCategoryPresenter(AllCategoryContractor.View view2) {
        this.view = view2;
    }

    public void requestCategory() {
        this.view.showLoadingView();
        this.model.requestCategory(new LangRequest(this.appRepository.getLanguage()));
    }

    public void onResultCategory(List<CategoriesList> list) {
        this.view.hideLoadingView();
        this.view.showDashBoardActivity(list);
    }

    public void onError(String str) {
        this.view.hideLoadingView();
        this.view.showError(str, true);
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }
}
