package com.innomalist.taxi.shoppingapp.p011ui.deallist.mvp;

//import com.kiandashopping.kiandashopping.ModelInterface;
//import com.kiandashopping.kiandashopping.base.BasePresenter;
//import com.kiandashopping.kiandashopping.model.deallist.RequestDealList;
import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.base.BasePresenter;
import com.innomalist.taxi.shoppingapp.model.deallist.RequestDealList;
import com.kiandashopping.kiandashopping.model.deallist.ResultDealList;
//import com.kiandashopping.kiandashopping.p011ui.deallist.mvp.DealListContractor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.deallist.mvp.DealListPresenter */
public class DealListPresenter extends BasePresenter implements DealListContractor.Presenter {
    private DealListContractor.Model model = new DealListModel(this);
    private DealListContractor.View view;

    public DealListPresenter(DealListContractor.View view2) {
        this.view = view2;
    }

    public void requestAllDeals(RequestDealList requestDealList) {
        if (requestDealList.getPageNo().equals("1")) {
            this.view.showLoadingView();
        }
        requestDealList.setLang(this.appRepository.getLanguage());
        this.model.requestAllDeals(requestDealList);
    }

    public void onResult(List<ResultDealList> list) {
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
