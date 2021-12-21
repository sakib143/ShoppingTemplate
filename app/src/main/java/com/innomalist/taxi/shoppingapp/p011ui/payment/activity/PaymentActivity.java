package com.innomalist.taxi.shoppingapp.p011ui.payment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.model.payment.ResultPaymentDetails;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.kiandashopping.kiandashopping.p011ui.ordersuccess.OrderSuccessActivity;
import com.kiandashopping.kiandashopping.p011ui.payment.adapter.PaymentAdapter;
import com.kiandashopping.kiandashopping.p011ui.payment.mvp.PaymentContractor;
import com.kiandashopping.kiandashopping.p011ui.payment.mvp.PaymentPresenter;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.payment.activity.PaymentActivity */
public class PaymentActivity extends BaseActivity implements PaymentContractor.View, PaymentAdapter.Listener {
    private static final String ARG_SHIPPING_DETAILS = "shippingDetails";
    private List<Object> objectList;
    PaymentAdapter paymentAdapter;
    String paymentOption = "";
    PaymentPresenter presenter;
    ResultPaymentDetails resultPaymentDetails;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f256rv;
    private ShippingDetail shippingDetail;

    public int getLayout() {
        return R.layout.activity_wish_list;
    }

    public static Intent builtIntent(Activity activity, ShippingDetail shippingDetail2) {
        Intent intent = new Intent(activity, PaymentActivity.class);
        intent.putExtra(ARG_SHIPPING_DETAILS, shippingDetail2);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.title.setText(ResourceUtils.getString(R.string.payment));
        this.presenter = new PaymentPresenter(this);
        setRecyclerView();
        this.shippingDetail = AppUtils.getShippingDetails(getIntent(), ARG_SHIPPING_DETAILS);
    }

    private void setRecyclerView() {
        this.presenter.onRequestPaymentDetail();
        ArrayList arrayList = new ArrayList();
        this.objectList = arrayList;
        PaymentAdapter paymentAdapter2 = new PaymentAdapter(arrayList, this);
        this.paymentAdapter = paymentAdapter2;
        this.f256rv.setAdapter(paymentAdapter2);
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    public void onPaymentDetails(ResultPaymentDetails resultPaymentDetails2) {
        this.resultPaymentDetails = resultPaymentDetails2;
        this.paymentAdapter.setResultDetails(resultPaymentDetails2);
        this.objectList.clear();
        this.objectList.add(1);
        this.objectList.add(2);
        this.paymentAdapter.onLoadFinished(this.objectList.size());
        this.paymentAdapter.notifyDataSetChanged();
    }

    public void showPaymentSuccess(String str, String str2) {
        this.appRepository.setCartCount(0);
        if (this.paymentOption.equals(PaymentAdapter.PAY_U_MONEY)) {
            openDashBoard(1);
            return;
        }
        changeActivity(OrderSuccessActivity.builtIntent(this, this.paymentOption, ResourceUtils.getString(R.string.dialog_title_success), str, "", "", this.resultPaymentDetails.getCartCurrencySymbol(), this.resultPaymentDetails.getCartGrandTotalShow(), ""));
    }

    public void showPaymentSuccess(String str, String str2, String str3, String str4, String str5) {
        changeActivity(OrderSuccessActivity.builtIntent(this, this.paymentOption, ResourceUtils.getString(R.string.dialog_title_success), str, str3, str4, this.resultPaymentDetails.getCartCurrencySymbol(), this.resultPaymentDetails.getCartGrandTotalShow(), str5));
    }

    public void showPaymentError(String str) {
        if (this.paymentOption.equals(PaymentAdapter.PAY_U_MONEY)) {
            openDashBoard(1);
            return;
        }
        changeActivity(OrderSuccessActivity.builtIntent(this, this.paymentOption, ResourceUtils.getString(R.string.dialog_title_error), str, "", "", this.resultPaymentDetails.getCartCurrencySymbol(), this.resultPaymentDetails.getCartGrandTotalShow(), ""));
    }

    public void onPaymentOption(String str) {
        this.paymentOption = str;
        this.paymentAdapter.setPaymentOption(str);
        this.paymentAdapter.notifyDataSetChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCheckOut() {
        /*
            r4 = this;
            java.lang.String r0 = r4.paymentOption
            int r1 = r0.hashCode()
            r2 = -1983095017(0xffffffff89cc5f17, float:-4.9200636E-33)
            r3 = 1
            if (r1 == r2) goto L_0x001c
            r2 = 66904(0x10558, float:9.3752E-41)
            if (r1 == r2) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r1 = "COD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 0
            goto L_0x0027
        L_0x001c:
            java.lang.String r1 = "PROXY_PAY"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = -1
        L_0x0027:
            if (r0 == 0) goto L_0x0044
            if (r0 == r3) goto L_0x0036
            r0 = 2131820824(0x7f110118, float:1.9274374E38)
            java.lang.String r0 = com.kiandashopping.kiandashopping.util.ResourceUtils.getString(r0)
            r4.showToast(r0)
            goto L_0x004b
        L_0x0036:
            com.kiandashopping.kiandashopping.ui.payment.mvp.PaymentPresenter r0 = r4.presenter
            com.kiandashopping.kiandashopping.model.accountdetail.ShippingDetail r1 = r4.shippingDetail
            com.kiandashopping.kiandashopping.model.payment.ResultPaymentDetails r2 = r4.resultPaymentDetails
            java.lang.String r2 = r2.getCartGrandTotal()
            r0.onRequestProxyPay(r1, r2)
            goto L_0x004b
        L_0x0044:
            com.kiandashopping.kiandashopping.ui.payment.mvp.PaymentPresenter r0 = r4.presenter
            com.kiandashopping.kiandashopping.model.accountdetail.ShippingDetail r1 = r4.shippingDetail
            r0.onRequestCOD(r1)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kiandashopping.kiandashopping.p011ui.payment.activity.PaymentActivity.onCheckOut():void");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        this.menuItem.setVisible(false);
        return true;
    }
}
