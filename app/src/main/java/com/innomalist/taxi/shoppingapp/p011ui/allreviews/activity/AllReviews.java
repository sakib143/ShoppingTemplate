package com.innomalist.taxi.shoppingapp.p011ui.allreviews.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.model.allreviews.AllReviewRequest;
import com.innomalist.taxi.shoppingapp.model.allreviews.AllReviewResult;
import com.innomalist.taxi.shoppingapp.p011ui.allreviews.mvp.AllReviewContractor;
import com.kiandashopping.kiandashopping.p011ui.allreviews.adapter.AllReviewAdapter;
import com.kiandashopping.kiandashopping.p011ui.allreviews.mvp.AllReviewPresenter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.activity.AllReviews */
public class AllReviews extends BaseActivity implements AllReviewContractor.View, AllReviewAdapter.Listener {
    private static final String ARG_ID = "Id";
    private static final String ARG_VIEW_TYPE = "viewType";
    public static final String TYPE_DEAL = "DEAL";
    public static final String TYPE_PRODUCT = "PRODUCT";
    public static final String TYPE_STORE = "STORE";
    AllReviewRequest allReviewRequest = new AllReviewRequest();
    List<AllReviewResult> reviewResults;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f223rv;
    String type = "";
    AllReviewAdapter viewAllAdapter;
    AllReviewPresenter viewAllPresenter;

    public int getLayout() {
        return R.layout.activity_reviews;
    }

    public static Intent builtIntent(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, AllReviews.class);
        intent.putExtra(ARG_VIEW_TYPE, str);
        intent.putExtra(ARG_ID, i);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.title.setText(ResourceUtils.getString(R.string.all_reviews));
        this.viewAllPresenter = new AllReviewPresenter(this);
        this.allReviewRequest.setPageNo("1");
        String string = AppUtils.getString(getIntent(), ARG_VIEW_TYPE);
        this.type = string;
        if (string.equals(TYPE_PRODUCT)) {
            this.allReviewRequest.setProductId(String.valueOf(AppUtils.getInt(getIntent(), ARG_ID)));
        } else if (this.type.equals(TYPE_STORE)) {
            this.allReviewRequest.setStoreId(String.valueOf(AppUtils.getInt(getIntent(), ARG_ID)));
        } else {
            this.allReviewRequest.setDealId(String.valueOf(AppUtils.getInt(getIntent(), ARG_ID)));
        }
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList arrayList = new ArrayList();
        this.reviewResults = arrayList;
        AllReviewAdapter allReviewAdapter = new AllReviewAdapter(arrayList, this);
        this.viewAllAdapter = allReviewAdapter;
        this.f223rv.setAdapter(allReviewAdapter);
    }

    public PresenterInterface getPresenterInterface() {
        return this.viewAllPresenter;
    }

    public void onClickLoad(int i) {
        this.allReviewRequest.setPageNo(this.viewAllAdapter.getPageNumber());
        this.viewAllPresenter.requestAllReview(this.allReviewRequest, this.type);
    }

    public void showAllItemResult(List<AllReviewResult> list) {
        this.reviewResults.addAll(list);
        this.viewAllAdapter.onLoadFinished(list.size());
    }
}
