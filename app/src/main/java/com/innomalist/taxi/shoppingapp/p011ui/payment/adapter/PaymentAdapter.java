package com.innomalist.taxi.shoppingapp.p011ui.payment.adapter;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

import com.innomalist.taxi.shoppingapp.model.payment.ResultPaymentDetails;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.payment.adapter.PaymentAdapter */
public class PaymentAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    public static final String COD = "COD";
    public static final String PAY_PAL = "PAY_PAL";
    public static final String PAY_U_MONEY = "PAY_U_MONEY";
    public static final String PROXY_PAY = "PROXY_PAY";
    private static final int VH_BILL_DETAILS = 3;
    private static final int VH_PAYMENT_METHODS = 1;
    /* access modifiers changed from: private */
    public Listener listener;
    private List<Object> objectList;
    /* access modifiers changed from: private */
    public ResultPaymentDetails paymentDetails;
    /* access modifiers changed from: private */
    public String paymentOption = "";

    /* renamed from: com.kiandashopping.kiandashopping.ui.payment.adapter.PaymentAdapter$Listener */
    public interface Listener {
        void onCheckOut();

        void onPaymentOption(String str);

        void showError(String str);
    }

    public int _getItemViewType(int i) {
        return i == 0 ? 1 : 3;
    }

    public boolean isHeader() {
        return false;
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.payment.adapter.PaymentAdapter$BillingDetailsHolder_ViewBinding */
    public class BillingDetailsHolder_ViewBinding implements Unbinder {
        private BillingDetailsHolder target;
        private View view7f0a006c;

        public BillingDetailsHolder_ViewBinding(final BillingDetailsHolder billingDetailsHolder, View view) {
            this.target = billingDetailsHolder;
            billingDetailsHolder.tvItemTotalPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItemTotalPrice, "field 'tvItemTotalPrice'", TextView.class);
            billingDetailsHolder.tvDeliveryFeesPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDeliveryFeesPrice, "field 'tvDeliveryFeesPrice'", TextView.class);
            billingDetailsHolder.tvTotalPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTotalPrice, "field 'tvTotalPrice'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.btnCheckOut, "method 'setBtnCheckOut'");
            this.view7f0a006c = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    billingDetailsHolder.setBtnCheckOut();
                }
            });
        }

        public void unbind() {
            BillingDetailsHolder billingDetailsHolder = this.target;
            if (billingDetailsHolder != null) {
                this.target = null;
                billingDetailsHolder.tvItemTotalPrice = null;
                billingDetailsHolder.tvDeliveryFeesPrice = null;
                billingDetailsHolder.tvTotalPrice = null;
                this.view7f0a006c.setOnClickListener((View.OnClickListener) null);
                this.view7f0a006c = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.payment.adapter.PaymentAdapter$PaymentMethodHolder_ViewBinding */
    public class PaymentMethodHolder_ViewBinding implements Unbinder {
        private PaymentMethodHolder target;
        private View view7f0a01b4;
        private View view7f0a01b5;

        public PaymentMethodHolder_ViewBinding(final PaymentMethodHolder paymentMethodHolder, View view) {
            this.target = paymentMethodHolder;
            View findRequiredView = Utils.findRequiredView(view, R.id.rbProxyPay, "field 'rbProxyPay' and method 'setProxyPay'");
            paymentMethodHolder.rbProxyPay = (RadioButton) Utils.castView(findRequiredView, R.id.rbProxyPay, "field 'rbProxyPay'", RadioButton.class);
            this.view7f0a01b5 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    paymentMethodHolder.setProxyPay();
                }
            });
            View findRequiredView2 = Utils.findRequiredView(view, R.id.rbCOD, "field 'rbCOD' and method 'setCOD'");
            paymentMethodHolder.rbCOD = (RadioButton) Utils.castView(findRequiredView2, R.id.rbCOD, "field 'rbCOD'", RadioButton.class);
            this.view7f0a01b4 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    paymentMethodHolder.setCOD();
                }
            });
        }

        public void unbind() {
            PaymentMethodHolder paymentMethodHolder = this.target;
            if (paymentMethodHolder != null) {
                this.target = null;
                paymentMethodHolder.rbProxyPay = null;
                paymentMethodHolder.rbCOD = null;
                this.view7f0a01b5.setOnClickListener((View.OnClickListener) null);
                this.view7f0a01b5 = null;
                this.view7f0a01b4.setOnClickListener((View.OnClickListener) null);
                this.view7f0a01b4 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void setResultDetails(ResultPaymentDetails resultPaymentDetails) {
        this.paymentDetails = resultPaymentDetails;
    }

    public void setPaymentOption(String str) {
        this.paymentOption = str;
    }

    public PaymentAdapter(List<Object> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.objectList = list;
        this.listener = listener2;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        if (i == 1) {
            return new PaymentMethodHolder(this);
        }
        return new BillingDetailsHolder(this);
    }

    public int _getItemCount() {
        return this.objectList.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.payment.adapter.PaymentAdapter$PaymentMethodHolder */
    public class PaymentMethodHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362228)
        public RadioButton rbCOD;
        @BindView(2131362229)
        public RadioButton rbProxyPay;

        PaymentMethodHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_view_payment);
        }

        public void update(int i) {
            super.update(i);
            PaymentgatewayStatus paymentgatewayStatus = PaymentAdapter.this.paymentDetails.getPaymentgatewayStatus();
            int i2 = 8;
            this.rbCOD.setVisibility(paymentgatewayStatus.getCOD().booleanValue() ? 0 : 8);
            RadioButton radioButton = this.rbProxyPay;
            if (paymentgatewayStatus.getProxypay().booleanValue()) {
                i2 = 0;
            }
            radioButton.setVisibility(i2);
            String access$100 = PaymentAdapter.this.paymentOption;
            char c = 65535;
            int hashCode = access$100.hashCode();
            if (hashCode != -1983095017) {
                if (hashCode == 66904 && access$100.equals(PaymentAdapter.COD)) {
                    c = 0;
                }
            } else if (access$100.equals(PaymentAdapter.PROXY_PAY)) {
                c = 1;
            }
            if (c == 0) {
                this.rbCOD.setChecked(true);
            } else if (c != 1) {
                this.rbCOD.setChecked(false);
                this.rbProxyPay.setChecked(false);
            } else {
                this.rbProxyPay.setChecked(true);
            }
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362228})
        public void setCOD() {
            PaymentAdapter.this.listener.onPaymentOption(PaymentAdapter.COD);
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362229})
        public void setProxyPay() {
            PaymentAdapter.this.listener.onPaymentOption(PaymentAdapter.PROXY_PAY);
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.payment.adapter.PaymentAdapter$BillingDetailsHolder */
    class BillingDetailsHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362366)
        TextView tvDeliveryFeesPrice;
        @BindView(2131362386)
        TextView tvItemTotalPrice;
        @BindView(2131362422)
        TextView tvTotalPrice;

        BillingDetailsHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_view_payment_invoice);
        }

        public void update(int i) {
            super.update(i);
            this.tvItemTotalPrice.setText(AppUtils.showPrice(PaymentAdapter.this.paymentDetails.getCartCurrencySymbol(), PaymentAdapter.this.paymentDetails.getCartSubTotal()));
            this.tvDeliveryFeesPrice.setText(AppUtils.showPrice(PaymentAdapter.this.paymentDetails.getCartCurrencySymbol(), PaymentAdapter.this.paymentDetails.getCartGrandShipping()));
            this.tvTotalPrice.setText(AppUtils.showPrice(PaymentAdapter.this.paymentDetails.getCartCurrencySymbol(), PaymentAdapter.this.paymentDetails.getCartGrandTotalShow()));
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131361900})
        public void setBtnCheckOut() {
            PaymentAdapter.this.listener.onCheckOut();
        }
    }
}
