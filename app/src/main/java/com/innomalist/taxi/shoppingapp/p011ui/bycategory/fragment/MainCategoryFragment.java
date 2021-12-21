package com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.base.BaseFragment;
import com.innomalist.taxi.shoppingapp.model.bycategory.ByCategoryResult;
import com.innomalist.taxi.shoppingapp.model.bycategory.SecMaincategoryList;
import com.innomalist.taxi.shoppingapp.p011ui.allcategory.activity.AllCategoryActivity;
import com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment.adapter.ByCategoryAdapter;
import com.innomalist.taxi.shoppingapp.p011ui.bycategory.mvp.ByCategoryContractor;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.kiandashopping.kiandashopping.p011ui.bycategory.mvp.ByCategoryPresenter;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.activity.ProductDetailActivity;
import com.kiandashopping.kiandashopping.p011ui.viewall.activity.ViewAllActivity;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.MainCategoryFragment */
public class MainCategoryFragment extends BaseFragment implements ByCategoryContractor.View {
    private static final String ARG_CATEGORY_ID = "categoryId";
    private static final String ARG_SUB_CATEGORY_ID = "subCategoryId";
    private static final String ARG_SUB_CATEGORY_LIST = "subCategoryList";
    private ByCategoryPresenter byCategoryPresenter;
    private ByCategoryAdapter dashboardAdapter;
    private List<Object> objectList = new ArrayList();
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f224rv;

    public static Fragment builtFragment(String str, SecMaincategoryList secMaincategoryList) {
        MainCategoryFragment mainCategoryFragment = new MainCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_CATEGORY_ID, str);
        bundle.putString(ARG_SUB_CATEGORY_ID, secMaincategoryList.getSecCategoryId());
        bundle.putParcelableArrayList(ARG_SUB_CATEGORY_LIST, secMaincategoryList.getSubCategoryList());
        mainCategoryFragment.setArguments(bundle);
        return mainCategoryFragment;
    }

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ByCategoryPresenter byCategoryPresenter2 = new ByCategoryPresenter(this);
        this.byCategoryPresenter = byCategoryPresenter2;
        byCategoryPresenter2.requestByCategory(AppUtils.getString(getArguments(), ARG_CATEGORY_ID), AppUtils.getString(getArguments(), ARG_SUB_CATEGORY_ID));
        ArrayList arrayList = new ArrayList();
        this.objectList = arrayList;
        this.dashboardAdapter = new ByCategoryAdapter(arrayList, new ByCategoryAdapter.Listener() {
            public void onClick(ByCategoryAdapter.AllType allType) {
                if (allType.equals(ByCategoryAdapter.AllType.MOST_POPPULAR)) {
                    MainCategoryFragment mainCategoryFragment = MainCategoryFragment.this;
                    mainCategoryFragment.changeActivity(ViewAllActivity.builtIntent(mainCategoryFragment.getActivity(), ResourceUtils.getString(R.string.most_popular), AppUtils.getString(MainCategoryFragment.this.getArguments(), MainCategoryFragment.ARG_CATEGORY_ID), "", "", "", ""));
                } else if (allType.equals(ByCategoryAdapter.AllType.TOP_OFFER)) {
                    MainCategoryFragment mainCategoryFragment2 = MainCategoryFragment.this;
                    mainCategoryFragment2.changeActivity(ViewAllActivity.builtIntent(mainCategoryFragment2.getActivity(), ResourceUtils.getString(R.string.best_offer), AppUtils.getString(MainCategoryFragment.this.getArguments(), MainCategoryFragment.ARG_CATEGORY_ID), "", "", "", ""));
                } else {
                    MainCategoryFragment.this.changeActivity(AllCategoryActivity.class);
                }
            }

            public void onClickCategory(int i, String str) {
                MainCategoryFragment mainCategoryFragment = MainCategoryFragment.this;
                mainCategoryFragment.changeActivity(ViewAllActivity.builtIntent((BaseActivity) mainCategoryFragment.getActivity(), str, "", String.valueOf(i), "", "", ""));
            }

            public void onClickItem(int i) {
                MainCategoryFragment mainCategoryFragment = MainCategoryFragment.this;
                mainCategoryFragment.changeActivity(ProductDetailActivity.builtIntent(mainCategoryFragment.getActivity(), i, false));
            }
        });
        this.f224rv.setHasFixedSize(true);
        this.f224rv.setAdapter(this.dashboardAdapter);
    }

    public PresenterInterface getPresenterInterface() {
        return this.byCategoryPresenter;
    }

    public void showResult(ByCategoryResult byCategoryResult) {
        this.objectList.clear();
        if (byCategoryResult.getBannerDetails().size() > 0) {
            this.objectList.add(AppConstants.KEY_BANNER);
        }
        ArrayList parcelableArrayList = getArguments().getParcelableArrayList(ARG_SUB_CATEGORY_LIST);
        if (parcelableArrayList.size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.category));
            this.objectList.add(AppConstants.KEY_CATEGORY);
            this.dashboardAdapter.setSubCategoryLists(parcelableArrayList);
        }
        if (byCategoryResult.getProductTopOffer().size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.best_offer));
            this.objectList.add(AppConstants.KEY_TOP_OFFER);
        }
        if (byCategoryResult.getMostPopularProduct().size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.flash_deals));
            this.objectList.add(AppConstants.KEY_MOST_POPULAR);
        }
        this.dashboardAdapter.setData(byCategoryResult);
        this.dashboardAdapter.onLoadFinished(this.objectList.size());
        this.dashboardAdapter.notifyDataSetChanged();
    }

    public void showResultError(String str) {
        this.dashboardAdapter.onLoadFinished(this.objectList.size());
    }
}
