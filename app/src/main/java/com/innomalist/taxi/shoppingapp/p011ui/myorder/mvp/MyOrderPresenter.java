package com.kiandashopping.kiandashopping.p011ui.myorder.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.myorder.OrderList;
import com.kiandashopping.kiandashopping.p011ui.myorder.mvp.MyOrderContractor;
import java.util.ArrayList;
import java.util.List;
import p013io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.myorder.mvp.MyOrderPresenter */
public class MyOrderPresenter extends BasePresenter implements MyOrderContractor.Presenter {
    private Disposable disposable;
    private MyOrderContractor.Model model = new MyOrderModel(this);
    private int position;
    private MyOrderContractor.View view;

    public MyOrderPresenter(MyOrderContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestMyOrder(LangRequest langRequest) {
        if (langRequest.getPageNo().equals("1")) {
            this.view.showLoadingView();
        }
        langRequest.setLang(this.appRepository.getLanguage());
        langRequest.setCusId(this.appRepository.getUserId());
        this.model.requestMyOrder(langRequest);
    }

    public void onResult(List<OrderList> list) {
        this.view.hideLoadingView();
        this.view.showResult(list);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showResult(new ArrayList());
    }
}
