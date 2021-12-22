package com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.store;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.base.BaseFragment;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreDetail;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreDetailsResult;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreReview;
import com.innomalist.taxi.shoppingapp.p011ui.allreviews.activity.AllReviews;
import com.innomalist.taxi.shoppingapp.p011ui.storedetails.fragment.store.adapter.StoreDetailAdapter;
import com.innomalist.taxi.shoppingapp.p011ui.storedetails.mvp.StoreDetailsContractor;
import com.innomalist.taxi.shoppingapp.p011ui.storedetails.mvp.StoreDetailsPresenter;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;

import butterknife.BindView;
//import com.apptube.ecommerce.R;
//import com.karumi.dexter.Dexter;
//import com.karumi.dexter.PermissionToken;
//import com.karumi.dexter.listener.PermissionDeniedResponse;
//import com.karumi.dexter.listener.PermissionGrantedResponse;
//import com.karumi.dexter.listener.PermissionRequest;
//import com.karumi.dexter.listener.single.PermissionListener;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.AppConstants;
//import com.kiandashopping.kiandashopping.base.BaseFragment;
//import com.kiandashopping.kiandashopping.model.storelist.StoreDetail;
//import com.kiandashopping.kiandashopping.model.storelist.StoreDetailsResult;
//import com.kiandashopping.kiandashopping.model.storelist.StoreReview;
//import com.kiandashopping.kiandashopping.p011ui.allreviews.activity.AllReviews;
//import com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.store.adapter.StoreDetailAdapter;
//import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsContractor;
//import com.kiandashopping.kiandashopping.p011ui.storedetails.mvp.StoreDetailsPresenter;
//import com.kiandashopping.kiandashopping.util.AppUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.store.StoreFragment */
public class StoreFragment extends BaseFragment implements StoreDetailsContractor.View, StoreDetailAdapter.Listener {
    private static final String ARG_IS_MORE_REVIEW = "isMoreReview";
    private static final String ARG_STORE_DETAILS = "storeDetails";
    private static final String ARG_STORE_ID = "storeId";
    private static final String ARG_STORE_REVIEWS = "storeReviews";
    private List<StoreReview> objectList = new ArrayList();
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f259rv;
    private StoreDetailAdapter storeDetailAdapter;
    private StoreDetailsPresenter storeDetailsPresenter;

    public static Fragment builtFragment(int i, ArrayList<StoreDetail> arrayList, ArrayList<StoreReview> arrayList2, boolean z) {
        StoreFragment storeFragment = new StoreFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_STORE_ID, i);
        bundle.putParcelableArrayList(ARG_STORE_DETAILS, arrayList);
        bundle.putParcelableArrayList(ARG_STORE_REVIEWS, arrayList2);
        bundle.putBoolean(ARG_IS_MORE_REVIEW, z);
        storeFragment.setArguments(bundle);
        return storeFragment;
    }

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_store_details, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.storeDetailsPresenter = new StoreDetailsPresenter(this);
        ArrayList arrayList = new ArrayList();
        this.objectList = arrayList;
        StoreDetailAdapter storeDetailAdapter2 = new StoreDetailAdapter(arrayList, this);
        this.storeDetailAdapter = storeDetailAdapter2;
        storeDetailAdapter2.setShowMoreOption(AppUtils.getBoolean(getArguments(), ARG_IS_MORE_REVIEW).booleanValue());
        this.f259rv.setVisibility(8);
        this.f259rv.setHasFixedSize(true);
        this.f259rv.setAdapter(this.storeDetailAdapter);
        showData(AppUtils.getStoreDetails(getArguments(), ARG_STORE_DETAILS), AppUtils.getStoreReviews(getArguments(), ARG_STORE_REVIEWS));
    }

    private void showData(ArrayList<StoreDetail> arrayList, ArrayList<StoreReview> arrayList2) {
        this.storeDetailAdapter.isNoItemVisible();
        this.f259rv.setVisibility(0);
        this.objectList.addAll(arrayList2);
        if (arrayList.size() > 0) {
            this.storeDetailAdapter.setStoreDetails(arrayList.get(0));
        }
        this.storeDetailAdapter.onLoadFinished(this.objectList.size());
    }

    public PresenterInterface getPresenterInterface() {
        return this.storeDetailsPresenter;
    }

    public void showResult(StoreDetailsResult storeDetailsResult) {
        this.objectList.clear();
        this.objectList.addAll(storeDetailsResult.getStoreReview());
        this.storeDetailAdapter.cleanSession(true);
        this.storeDetailAdapter.notifyDataSetChanged();
    }

    public void onClickSendReview(float f, String str, String str2) {
        this.storeDetailsPresenter.onAddReview(AppUtils.getInt(getArguments(), ARG_STORE_ID), f, str, str2);
    }

    public void showResultError(String str) {
        showError(str);
    }

    public void onCallStore(final String str) {
        Dexter.withActivity(getActivity()).withPermission("android.permission.CALL_PHONE").withListener(new PermissionListener() {
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + str));
                StoreFragment.this.startActivity(intent);
            }

            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                if (permissionDeniedResponse.isPermanentlyDenied()) {
                    StoreFragment.this.onCallStore(str);
                }
            }

            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    public void onNavigation(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + str + AppConstants.COMMA + str2));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void onWeb(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void onMoreReview() {
        changeActivity(AllReviews.builtIntent(getActivity(), AllReviews.TYPE_STORE, AppUtils.getInt(getArguments(), ARG_STORE_ID)));
    }
}
