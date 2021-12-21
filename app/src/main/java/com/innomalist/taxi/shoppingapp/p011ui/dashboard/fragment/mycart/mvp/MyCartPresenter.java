package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.mvp;

import com.kiandashopping.kiandashopping.ModelInterface;
import com.kiandashopping.kiandashopping.base.BasePresenter;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.mycart.DeleteCartRequest;
import com.kiandashopping.kiandashopping.model.mycart.MyCartResult;
import com.kiandashopping.kiandashopping.model.mycart.UpdateCartDealRequest;
import com.kiandashopping.kiandashopping.model.mycart.UpdateCartProductRequest;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.mvp.MyCartContractor;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.mvp.MyCartPresenter */
public class MyCartPresenter extends BasePresenter implements MyCartContractor.Presenter {
    private MyCartContractor.Model model = new MyCartModel(this);
    private int position;
    private int quantity;
    private MyCartContractor.View view;

    public MyCartPresenter(MyCartContractor.View view2) {
        this.view = view2;
    }

    public void requestCart() {
        this.view.showLoadingView();
        this.model.requestCart(new LangRequest(this.appRepository.getLanguage(), this.appRepository.getUserId()));
    }

    public void updateCartProduct(int i, int i2, int i3, int i4) {
        this.position = i4;
        this.quantity = i3;
        this.view.showLoadingView();
        this.model.requestUpdateCartProduct(new UpdateCartProductRequest(i, i2, "", "", i3, this.appRepository.getUserId(), this.appRepository.getLanguage()));
    }

    public void updateCartDeal(int i, int i2, int i3, int i4) {
        this.position = i4;
        this.quantity = i3;
        this.view.showLoadingView();
        this.model.requestUpdateCartDeal(new UpdateCartDealRequest(i, i2, i3, this.appRepository.getUserId(), this.appRepository.getLanguage()));
    }

    public void deleteCart(int i, int i2, int i3) {
        this.position = i3;
        this.view.showLoadingView();
        this.model.requestDeleteCart(i, new DeleteCartRequest(i2, this.appRepository.getLanguage()));
    }

    public void onResult(MyCartResult myCartResult) {
        this.view.hideLoadingView();
        this.view.showResponse(myCartResult);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.noRecordView();
    }

    public void onUpdateSuccess(MyCartResult myCartResult) {
        this.view.hideLoadingView();
        this.view.updateCartSuccess(myCartResult, this.quantity, this.position);
    }

    public void onDeleteSuccess(MyCartResult myCartResult) {
        this.view.hideLoadingView();
        this.view.deleteCartSuccess(myCartResult, this.position);
    }

    public void onUpdateError(String str) {
        this.view.hideLoadingView();
        this.view.showUpdateError(str);
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }
}
