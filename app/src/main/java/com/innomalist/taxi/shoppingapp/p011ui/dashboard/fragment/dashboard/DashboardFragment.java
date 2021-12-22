package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.AppConstants;
//import com.kiandashopping.kiandashopping.base.BaseFragment;
//import com.kiandashopping.kiandashopping.model.dashboard.DashboardResponse;
//import com.kiandashopping.kiandashopping.p011ui.allcategory.activity.AllCategoryActivity;
//import com.kiandashopping.kiandashopping.p011ui.bycategory.activity.ByCategoryActivity;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.DashboardFragment;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.innomalist.taxi.shoppingapp.base.BaseFragment;
import com.innomalist.taxi.shoppingapp.model.dashboard.DashboardResponse;
import com.innomalist.taxi.shoppingapp.p011ui.bycategory.activity.ByCategoryActivity;
import com.innomalist.taxi.shoppingapp.p011ui.viewall.activity.ViewAllActivity;
import com.innomalist.taxi.shoppingapp.util.DateTime;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.DashboardAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.mvp.DashboardContractor;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.mvp.DashboardPresenter;
import com.kiandashopping.kiandashopping.p011ui.deallist.activity.DealListActivity;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.activity.ProductDetailActivity;
//import com.kiandashopping.kiandashopping.p011ui.viewall.activity.ViewAllActivity;
//import com.kiandashopping.kiandashopping.util.DateTime;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.DashboardFragment */
public class DashboardFragment extends BaseFragment implements DashboardContractor.View {
    private DashboardAdapter dashboardAdapter;
    private List<Object> objectList = new ArrayList();
    private DashboardContractor.Presenter presenter;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f231rv;
    private Timer timerObj = new Timer();
    private TimerTask timerTaskObj;

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        DashboardPresenter dashboardPresenter = new DashboardPresenter(this);
        this.presenter = dashboardPresenter;
        dashboardPresenter.requestDashboard();
        this.dashboardAdapter = new DashboardAdapter(this.objectList, new DashboardAdapter.Listener() {
            public void onClick(DashboardAdapter.AllType allType) {
                if (allType.equals(DashboardAdapter.AllType.MOST_POPPULAR)) {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.changeActivity(ViewAllActivity.builtIntent(dashboardFragment.getActivity(), ResourceUtils.getString(R.string.most_popular), "", "", "", "", ""));
                } else if (allType.equals(DashboardAdapter.AllType.TOP_OFFER)) {
                    DashboardFragment dashboardFragment2 = DashboardFragment.this;
                    dashboardFragment2.changeActivity(ViewAllActivity.builtIntent(dashboardFragment2.getActivity(), ResourceUtils.getString(R.string.best_offer), "", "", "", "", ""));
                } else if (allType.equals(DashboardAdapter.AllType.NEW_ARRIVAL)) {
                    DashboardFragment dashboardFragment3 = DashboardFragment.this;
                    dashboardFragment3.changeActivity(ViewAllActivity.builtIntent(dashboardFragment3.getActivity(), ResourceUtils.getString(R.string.new_arrivals), "", "", "", "", ""));
                } else if (allType.equals(DashboardAdapter.AllType.UP_TO_50)) {
                    DashboardFragment dashboardFragment4 = DashboardFragment.this;
                    dashboardFragment4.changeActivity(ViewAllActivity.builtIntent(dashboardFragment4.getActivity(), ResourceUtils.getString(R.string.up_50_percent), "", "", "", "", ""));
                } else if (allType.equals(DashboardAdapter.AllType.DEALS)) {
                    DashboardFragment dashboardFragment5 = DashboardFragment.this;
                    dashboardFragment5.changeActivity(DealListActivity.builtIntent(dashboardFragment5.getActivity()));
                } else {
                    DashboardFragment.this.changeActivity(AllCategoryActivity.class);
                }
            }

            public void onClickCategory(String str, String str2, String str3) {
                DashboardFragment dashboardFragment = DashboardFragment.this;
                dashboardFragment.changeActivity(ByCategoryActivity.builtIntent(dashboardFragment.getActivity(), str, str2, str3));
            }

            public void onClickCategory(String str, String str2) {
                DashboardFragment dashboardFragment = DashboardFragment.this;
                dashboardFragment.changeActivity(ViewAllActivity.builtIntent(dashboardFragment.getActivity(), str2, String.valueOf(str), "", "", "", ""));
            }

            public void onClickItem(int i) {
                DashboardFragment dashboardFragment = DashboardFragment.this;
                dashboardFragment.changeActivity(ProductDetailActivity.builtIntent(dashboardFragment.getActivity(), i, false));
            }

            public void onClickDeal(int i) {
                DashboardFragment dashboardFragment = DashboardFragment.this;
                dashboardFragment.changeActivity(ProductDetailActivity.builtIntent(dashboardFragment.getActivity(), i, true));
            }

            public void onGoSearch(String str) {
                if (str.isEmpty()) {
                    DashboardFragment.this.showToast(ResourceUtils.getString(R.string.error_search));
                    return;
                }
                DashboardFragment dashboardFragment = DashboardFragment.this;
                dashboardFragment.changeActivity(ViewAllActivity.builtIntent(dashboardFragment.getActivity(), ResourceUtils.getString(R.string.search_results), "", "", "", "", str));
            }
        });
        this.f231rv.setHasFixedSize(true);
        this.f231rv.setAdapter(this.dashboardAdapter);
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    public void showDashboardResponse(DashboardResponse dashboardResponse) {
        this.objectList.clear();
        this.objectList.add(AppConstants.KEY_SEARCH);
        if (dashboardResponse.getBannerDetails().size() > 0) {
            this.objectList.add(AppConstants.KEY_BANNER);
        }
        if (dashboardResponse.getCategoryDetails().size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.category));
            this.objectList.add(AppConstants.KEY_CATEGORY);
        }
        if (dashboardResponse.getDealsOfDayDetails().size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.flash_deals));
            this.objectList.add(AppConstants.KEY_DEALS);
        }
        if (dashboardResponse.getProductTopOffer().size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.best_offer));
            this.objectList.add(AppConstants.KEY_TOP_OFFER);
        }
        if (dashboardResponse.getProductTopOffer().size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.new_arrivals));
            this.objectList.add(AppConstants.KEY_NEW_ARRIVALS);
        }
        if (dashboardResponse.getProductFiftyPercent().size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.up_50_percent));
            this.objectList.add(AppConstants.KEY_UP_TO_50);
        }
        if (dashboardResponse.getMostPopularProduct().size() > 0) {
            this.objectList.add(ResourceUtils.getString(R.string.most_popular));
            this.objectList.add(AppConstants.KEY_MOST_POPULAR);
        }
        this.dashboardAdapter.setDashBoardData(dashboardResponse);
        if (dashboardResponse.getDealsOfDayDetails().size() > 0) {
            try {
                this.dashboardAdapter.setOffEnd(new DateTime(dashboardResponse.getTotalDealEndTime(), DateTime.SERVER_DATE_TIME).getCalendar().getTimeInMillis());
            } catch (Exception unused) {
                this.dashboardAdapter.setOffEnd(Calendar.getInstance().getTimeInMillis());
            }
        }
        this.dashboardAdapter.notifyDataSetChanged();
    }

    public void onResume() {
        super.onResume();
        Timer timer = this.timerObj;
        TimerTask newTimerTask = newTimerTask();
        this.timerTaskObj = newTimerTask;
        timer.schedule(newTimerTask, 0, 1000);
    }

    public void onPause() {
        super.onPause();
        this.timerTaskObj.cancel();
    }

    private TimerTask newTimerTask() {
        return new TimerTask() {
            public void run() {
                DashboardFragment.this.getActivity().runOnUiThread(new Runnable() {
                    public final void run() {
                        DashboardFragment.C14972.this.lambda$run$0$DashboardFragment$2();
                    }
                });
            }

            public /* synthetic */ void lambda$run$0$DashboardFragment$2() {
                try {
                    int childCount = DashboardFragment.this.f231rv.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        RecyclerView.ViewHolder childViewHolder = DashboardFragment.this.f231rv.getChildViewHolder(DashboardFragment.this.f231rv.getChildAt(i));
                        if (childViewHolder instanceof DashboardAdapter.DealsViewHolder) {
                            ((DashboardAdapter.DealsViewHolder) childViewHolder).updateRemainingTime();
                        }
                    }
                } catch (Exception e) {
                    Log.e(AppConstants.EXCEPTION, e.toString());
                }
            }
        };
    }
}
