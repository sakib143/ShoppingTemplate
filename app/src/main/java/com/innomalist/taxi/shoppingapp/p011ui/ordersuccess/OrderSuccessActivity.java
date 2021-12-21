package com.kiandashopping.kiandashopping.p011ui.ordersuccess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.p011ui.payment.adapter.PaymentAdapter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.DateTime;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordersuccess.OrderSuccessActivity */
public class OrderSuccessActivity extends BaseActivity {
    private static final String ARG_AMOUNT = "amount";
    private static final String ARG_ENTITY = "entity";
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_PAYMENT_MODE = "paymentMode";
    private static final String ARG_REFERENCE = "reference";
    private static final String ARG_SYMBOL = "symbol";
    private static final String ARG_TITLE = "title";
    private static final String ARG_VALIDITY = "validty";
    @BindView(2131361879)
    LottieAnimationView avEmpty;
    @BindView(2131362125)
    LinearLayout llAmountDetails;
    @BindView(2131362134)
    LinearLayout llProxyPay;
    @BindView(2131362352)
    TextView tvAmount;
    @BindView(2131362368)
    TextView tvDesc;
    @BindView(2131362373)
    TextView tvEntity;
    @BindView(2131362402)
    TextView tvReference;
    @BindView(2131362420)
    TextView tvTitle;
    @BindView(2131362425)
    TextView tvValidity;
    @BindView(2131362426)
    TextView tvValue;

    public int getLayout() {
        return R.layout.activity_order_success;
    }

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    public static Intent builtIntent(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intent intent = new Intent(activity, OrderSuccessActivity.class);
        intent.putExtra(ARG_PAYMENT_MODE, str);
        intent.putExtra("title", str2);
        intent.putExtra("message", str3);
        intent.putExtra(ARG_ENTITY, str4);
        intent.putExtra(ARG_REFERENCE, str5);
        intent.putExtra(ARG_SYMBOL, str6);
        intent.putExtra("amount", str7);
        intent.putExtra(ARG_VALIDITY, str8);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.title.setText("");
        String string = AppUtils.getString(getIntent(), "title");
        if (string.equals(ResourceUtils.getString(R.string.dialog_title_success))) {
            this.avEmpty.setAnimation((int) R.raw.tick);
            this.tvTitle.setText(ResourceUtils.getString(R.string.thank_you));
            this.appRepository.setCartCount(0);
        } else {
            this.avEmpty.setAnimation((int) R.raw.failed);
            this.tvTitle.setText(ResourceUtils.getString(R.string.order_failed));
        }
        this.avEmpty.playAnimation();
        this.tvDesc.setText(AppUtils.getString(getIntent(), "message"));
        String string2 = AppUtils.getString(getIntent(), ARG_SYMBOL);
        this.tvAmount.setText(AppUtils.showPrice(string2, AppUtils.getString(getIntent(), "amount")));
        if (!AppUtils.getString(getIntent(), ARG_PAYMENT_MODE).equals(PaymentAdapter.PROXY_PAY) || !string.equals(ResourceUtils.getString(R.string.dialog_title_success))) {
            this.llAmountDetails.setVisibility(0);
            this.llProxyPay.setVisibility(8);
        } else {
            this.llAmountDetails.setVisibility(8);
            this.llProxyPay.setVisibility(0);
            this.tvEntity.setText(AppUtils.getString(getIntent(), ARG_ENTITY));
            this.tvReference.setText(AppUtils.getString(getIntent(), ARG_REFERENCE));
            this.tvValue.setText(AppUtils.showPrice(string2, AppUtils.getString(getIntent(), "amount")));
            this.tvValidity.setText(new DateTime(AppUtils.getString(getIntent(), ARG_VALIDITY), DateTime.SERVER_DATE).getDisplayDate());
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        this.menuItem.setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        hideKeyboard();
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362030})
    public void setDone() {
        onBackPressed();
    }

    public void onBackPressed() {
        openDashBoard(1);
    }
}
