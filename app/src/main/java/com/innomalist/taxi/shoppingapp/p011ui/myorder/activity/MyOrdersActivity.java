package com.kiandashopping.kiandashopping.p011ui.myorder.activity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.airbnb.lottie.LottieAnimationView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.model.category.LangRequest;
import com.kiandashopping.kiandashopping.model.myorder.OrderList;
import com.kiandashopping.kiandashopping.p011ui.myorder.adapter.MyOrderAdapter;
import com.kiandashopping.kiandashopping.p011ui.myorder.mvp.MyOrderContractor;
import com.kiandashopping.kiandashopping.p011ui.myorder.mvp.MyOrderPresenter;
import com.kiandashopping.kiandashopping.p011ui.ordertracking.activity.DHLTrackingActivity;
import com.kiandashopping.kiandashopping.p011ui.ordertracking.activity.OrdersTrackingActivity;
import com.kiandashopping.kiandashopping.util.ConversionUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.myorder.activity.MyOrdersActivity */
public class MyOrdersActivity extends BaseActivity implements MyOrderContractor.View, MyOrderAdapter.Listener {
    MyOrderAdapter adapter;
    @BindView(2131361879)
    LottieAnimationView avEmpty;
    LangRequest langRequest = new LangRequest();
    @BindView(2131362132)
    LinearLayout llListEmpty;
    MyOrderPresenter presenter;
    List<OrderList> results;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f253rv;

    public int getLayout() {
        return R.layout.activity_my_orders;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.title.setText(ResourceUtils.getString(R.string.my_orders));
        this.presenter = new MyOrderPresenter(this);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList arrayList = new ArrayList();
        this.results = arrayList;
        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(arrayList, this);
        this.adapter = myOrderAdapter;
        this.f253rv.setAdapter(myOrderAdapter);
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    public void onClickLoad(int i) {
        this.langRequest.setPageNo(this.adapter.getPageNumber());
        this.presenter.requestMyOrder(this.langRequest);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        this.menuItem.setVisible(false);
        return true;
    }

    public void showResult(List<OrderList> list) {
        this.results.addAll(list);
        this.adapter.onLoadFinished(list.size());
        if (this.results.size() == 0) {
            showResultError();
        }
    }

    public void showResultError() {
        this.f253rv.setVisibility(8);
        this.llListEmpty.setVisibility(0);
        this.avEmpty.setVisibility(0);
        this.avEmpty.setAnimation((int) R.raw.no_orders);
        this.avEmpty.playAnimation();
    }

    public void onClickItem(OrderList orderList) {
        changeActivity(OrdersTrackingActivity.builtIntent(this, ConversionUtils.parseString(orderList.getOrderId().intValue())));
    }

    public void onClickDHLItem(OrderList orderList) {
        changeActivity(DHLTrackingActivity.builtIntent(this, orderList.getDhlTrackingId()));
    }
}
