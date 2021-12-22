package com.innomalist.taxi.shoppingapp.p011ui.viewall.mvp;

//import com.kiandashopping.kiandashopping.ModelInterface;
//import com.kiandashopping.kiandashopping.base.BasePresenter;
//import com.kiandashopping.kiandashopping.model.viewall.AllItemRequest;
//import com.kiandashopping.kiandashopping.model.viewall.ProductList;
//import com.kiandashopping.kiandashopping.p011ui.viewall.mvp.ViewAllContractor;
import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.base.BasePresenter;
import com.innomalist.taxi.shoppingapp.model.viewall.AllItemRequest;
import com.innomalist.taxi.shoppingapp.model.viewall.ProductList;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.viewall.mvp.ViewAllPresenter */
public class ViewAllPresenter extends BasePresenter implements ViewAllContractor.Presenter {
    private ViewAllContractor.Model model = new ViewAllModel(this);
    private ViewAllContractor.View view;

    public ViewAllPresenter(ViewAllContractor.View view2) {
        this.view = view2;
    }

    public void requestAllItem(AllItemRequest allItemRequest) {
        if (allItemRequest.getPageNo().equals("1")) {
            this.view.showLoadingView();
        }
        allItemRequest.setLang(this.appRepository.getLanguage());
        allItemRequest.setCusId(this.appRepository.getUserId());
        this.model.requestDashboard(allItemRequest);
    }

    public void onAllItemResult(List<ProductList> list) {
        this.view.hideLoadingView();
        this.view.showAllItemResult(list);
    }

    public void onAllItemResultError(String str) {
        this.view.hideLoadingView();
        this.view.showAllItemResult(new ArrayList());
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }
}
