package com.innomalist.taxi.shoppingapp.p011ui.allreviews.mvp;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.model.allreviews.AllReviewRequest;
import com.innomalist.taxi.shoppingapp.model.allreviews.AllReviewResult;
import com.kiandashopping.kiandashopping.ViewInterface;
import java.util.List;

import io.reactivex.disposables.Disposable;

/* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.mvp.AllReviewContractor */
public interface AllReviewContractor {

    /* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.mvp.AllReviewContractor$Model */
    public interface Model extends ModelInterface {
        Disposable requestAllProductReview(AllReviewRequest allReviewRequest);

        Disposable requestDealAllReview(AllReviewRequest allReviewRequest);

        Disposable requestStoreAllReview(AllReviewRequest allReviewRequest);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.mvp.AllReviewContractor$Presenter */
    public interface Presenter extends PresenterInterface {
        void onProductReviewResult(List<AllReviewResult> list);

        void onResultError(String str);

        void requestAllReview(AllReviewRequest allReviewRequest, String str);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.mvp.AllReviewContractor$View */
    public interface View extends ViewInterface {
        void showAllItemResult(List<AllReviewResult> list);
    }
}
