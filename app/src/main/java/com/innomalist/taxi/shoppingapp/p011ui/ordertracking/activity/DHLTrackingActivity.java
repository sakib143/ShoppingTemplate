package com.kiandashopping.kiandashopping.p011ui.ordertracking.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.AppConstants;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.model.myorder.OrderList;
import com.kiandashopping.kiandashopping.model.tracking.OrderDetails;
import com.kiandashopping.kiandashopping.model.tracking.ShipDetail;
import com.kiandashopping.kiandashopping.p011ui.ordertracking.activity.DHLTrackingActivity;
import com.kiandashopping.kiandashopping.p011ui.ordertracking.adapter.DHLTrackingAdapter;
import com.kiandashopping.kiandashopping.p011ui.ordertracking.mvp.OrderTrackingContractor;
import com.kiandashopping.kiandashopping.p011ui.ordertracking.mvp.OrderTrackingPresenter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.activity.DHLTrackingActivity */
public class DHLTrackingActivity extends BaseActivity implements OrderTrackingContractor.View {
    public static final String ARG_CLASS = "class";
    public static final String ARG_ORDER_ID = "OrderId";
    private static final String MY_ORDER = "myOrder";
    /* access modifiers changed from: private */
    public static final String TAG = DHLTrackingActivity.class.getSimpleName();
    protected int API_CALL_INTERVAL = 10000;
    DHLTrackingAdapter adapter;
    String className = "";
    boolean isLoading = true;
    String orderId;
    OrderTrackingPresenter presenter;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f254rv;
    List<ShipDetail> shipDetailList;
    public Timer timer;

    public int getLayout() {
        return R.layout.activity_orders_details;
    }

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    public void showOrderDetails(OrderList orderList) {
    }

    public static Intent builtIntent(Activity activity, String str) {
        Intent intent = new Intent(activity, DHLTrackingActivity.class);
        intent.putExtra("OrderId", str);
        intent.putExtra("class", MY_ORDER);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.presenter = new OrderTrackingPresenter(this);
        this.title.setText(ResourceUtils.getString(R.string.order_detail));
        this.orderId = AppUtils.getString(getIntent(), "OrderId");
        this.className = AppUtils.getString(getIntent(), "class");
        setRecyclerView();
        this.presenter.requestDHLOrderDetail(this.orderId, this.isLoading);
    }

    private void setRecyclerView() {
        try {
            ArrayList arrayList = new ArrayList();
            this.shipDetailList = arrayList;
            DHLTrackingAdapter dHLTrackingAdapter = new DHLTrackingAdapter(arrayList);
            this.adapter = dHLTrackingAdapter;
            this.f254rv.setAdapter(dHLTrackingAdapter);
        } catch (Exception e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        this.menuItem.setVisible(false);
        return true;
    }

    private void startTimer() {
        stopTimer();
        Timer timer2 = new Timer();
        this.timer = timer2;
        TrackTimerTask trackTimerTask = new TrackTimerTask();
        int i = this.API_CALL_INTERVAL;
        timer2.schedule(trackTimerTask, (long) i, (long) i);
    }

    private void stopTimer() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer.purge();
        }
    }

    public void showOrderDetails(OrderDetails orderDetails) {
        this.shipDetailList.clear();
        this.shipDetailList.addAll(orderDetails.getShipDetails());
        this.adapter.setHeaderDetails(orderDetails.getAWBNumber(), orderDetails.getShipmentStaus());
        this.adapter.notifyDataSetChanged();
        Log.i(TAG, "run: auto refreshed");
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.activity.DHLTrackingActivity$TrackTimerTask */
    private class TrackTimerTask extends TimerTask {
        private TrackTimerTask() {
        }

        public void run() {
            DHLTrackingActivity.this.runOnUiThread(new Runnable() {
                public final void run() {
                    DHLTrackingActivity.TrackTimerTask.this.lambda$run$0$DHLTrackingActivity$TrackTimerTask();
                }
            });
        }

        public /* synthetic */ void lambda$run$0$DHLTrackingActivity$TrackTimerTask() {
            DHLTrackingActivity.this.isLoading = false;
            Log.i(DHLTrackingActivity.TAG, "run: auto refresh");
            DHLTrackingActivity.this.presenter.requestDHLOrderDetail(DHLTrackingActivity.this.orderId, DHLTrackingActivity.this.isLoading);
        }
    }

    public void onResume() {
        super.onResume();
        startTimer();
    }

    public void onPause() {
        super.onPause();
        stopTimer();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        stopTimer();
    }

    public void onBackPressed() {
        if (this.className.equals(MY_ORDER)) {
            super.onBackPressed();
            return;
        }
        finish();
        openDashBoard(1);
    }
}
