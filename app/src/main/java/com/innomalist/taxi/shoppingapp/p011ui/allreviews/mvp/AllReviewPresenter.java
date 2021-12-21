package com.innomalist.taxi.shoppingapp.p011ui.allreviews.mvp;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.base.BasePresenter;
import com.innomalist.taxi.shoppingapp.model.allreviews.AllReviewRequest;
import com.innomalist.taxi.shoppingapp.model.allreviews.AllReviewResult;
import com.innomalist.taxi.shoppingapp.p011ui.allreviews.activity.AllReviews;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.mvp.AllReviewPresenter */
public class AllReviewPresenter extends BasePresenter implements AllReviewContractor.Presenter {
    private AllReviewContractor.Model model = new AllReviewModel(this);
    private AllReviewContractor.View view;

    public AllReviewPresenter(AllReviewContractor.View view2) {
        this.view = view2;
    }

    public ModelInterface getModelInterface() {
        return this.model;
    }

    public void requestAllReview(AllReviewRequest allReviewRequest, String str) {
        if (allReviewRequest.getPageNo().equals("1")) {
            this.view.showLoadingView();
        }
        allReviewRequest.setLang(this.appRepository.getLanguage());
        if (str.equals(AllReviews.TYPE_PRODUCT)) {
            this.model.requestAllProductReview(allReviewRequest);
        } else if (str.equals(AllReviews.TYPE_STORE)) {
            this.model.requestStoreAllReview(allReviewRequest);
        } else {
            this.model.requestDealAllReview(allReviewRequest);
        }
    }

    public void onProductReviewResult(List<AllReviewResult> list) {
        this.view.hideLoadingView();
        this.view.showAllItemResult(list);
    }

    public void onResultError(String str) {
        this.view.hideLoadingView();
        this.view.showAllItemResult(new ArrayList());
    }
}
