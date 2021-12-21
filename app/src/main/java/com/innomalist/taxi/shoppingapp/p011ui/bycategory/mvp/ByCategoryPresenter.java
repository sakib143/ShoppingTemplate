package com.innomalist.taxi.shoppingapp.p011ui.bycategory.mvp;


import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.base.BasePresenter;
import com.innomalist.taxi.shoppingapp.model.bycategory.ByCategoryRequest;
import com.innomalist.taxi.shoppingapp.model.bycategory.ByCategoryResult;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.mvp.ByCategoryPresenter */
public class ByCategoryPresenter extends BasePresenter implements ByCategoryContractor.Presenter {
    private ByCategoryContractor.Model model = new ByCategoryModel(this);
    private ByCategoryContractor.View view;

    public ByCategoryPresenter(ByCategoryContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestByCategory(String str, String str2) {
        this.view.showLoadingView();
        this.model.requestByCategory(new ByCategoryRequest(str, str2, this.appRepository.getUserId(), this.appRepository.getLanguage()));
    }

    public void onResult(ByCategoryResult byCategoryResult) {
        this.view.hideLoadingView();
        this.view.showResult(byCategoryResult);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showResultError(str);
    }
}
