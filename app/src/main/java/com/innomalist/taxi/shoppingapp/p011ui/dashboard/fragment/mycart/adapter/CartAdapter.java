package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.mycart.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.AppConstants;
//import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.innomalist.taxi.shoppingapp.customview.MyAdapter;
import com.innomalist.taxi.shoppingapp.model.mycart.CartDetail;
import com.innomalist.taxi.shoppingapp.model.mycart.MyCartResult;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
import com.kiandashopping.kiandashopping.customview.StartSnapHelper;
//import com.kiandashopping.kiandashopping.model.mycart.CartDetail;
//import com.kiandashopping.kiandashopping.model.mycart.MyCartResult;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.adapter.ItemAdapter;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.CartAdapter */
public class CartAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    private static final int VH_BILL_DETAILS = 3;
    private static final int VH_ITEM_DETAILS = 1;
    /* access modifiers changed from: private */
    public List<CartDetail> cartDetails;
    /* access modifiers changed from: private */
    public ItemAdapter itemAdapter;
    /* access modifiers changed from: private */
    public Listener listener;
    private List<Object> objectList;
    /* access modifiers changed from: private */
    public MyCartResult resultCartDetails;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.CartAdapter$Listener */
    public interface Listener {
        void clickMinusBtn(CartDetail cartDetail, int i, int i2);

        void clickPlusBtn(CartDetail cartDetail, int i, int i2);

        void onRemoveCart(CartDetail cartDetail, int i);

        void onSubmit();

        void outOfQuantity();
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

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.CartAdapter$CartItemHolder_ViewBinding */
    public class CartItemHolder_ViewBinding implements Unbinder {
        private CartItemHolder target;

        public CartItemHolder_ViewBinding(CartItemHolder cartItemHolder, View view) {
            this.target = cartItemHolder;
            cartItemHolder.f240rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
            cartItemHolder.tvItemTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItemTitle, "field 'tvItemTitle'", TextView.class);
            cartItemHolder.tvCostTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvCostTitle, "field 'tvCostTitle'", TextView.class);
        }

        public void unbind() {
            CartItemHolder cartItemHolder = this.target;
            if (cartItemHolder != null) {
                this.target = null;
                cartItemHolder.f240rv = null;
                cartItemHolder.tvItemTitle = null;
                cartItemHolder.tvCostTitle = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.CartAdapter$BillingDetailsHolder_ViewBinding */
    public class BillingDetailsHolder_ViewBinding implements Unbinder {
        private BillingDetailsHolder target;
        private View view7f0a006c;

        public BillingDetailsHolder_ViewBinding(final BillingDetailsHolder billingDetailsHolder, View view) {
            this.target = billingDetailsHolder;
            billingDetailsHolder.tvItemTotalPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItemTotalPrice, "field 'tvItemTotalPrice'", TextView.class);
            billingDetailsHolder.tvShippingFeesPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvShippingFeesPrice, "field 'tvShippingFeesPrice'", TextView.class);
            billingDetailsHolder.tvTax = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTax, "field 'tvTax'", TextView.class);
            billingDetailsHolder.tvTotalPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTotalPrice, "field 'tvTotalPrice'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.btnCheckOut, "field 'btnCheckOut' and method 'setSaveOrderMode'");
            billingDetailsHolder.btnCheckOut = (Button) Utils.castView(findRequiredView, R.id.btnCheckOut, "field 'btnCheckOut'", Button.class);
            this.view7f0a006c = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    billingDetailsHolder.setSaveOrderMode();
                }
            });
        }

        public void unbind() {
            BillingDetailsHolder billingDetailsHolder = this.target;
            if (billingDetailsHolder != null) {
                this.target = null;
                billingDetailsHolder.tvItemTotalPrice = null;
                billingDetailsHolder.tvShippingFeesPrice = null;
                billingDetailsHolder.tvTax = null;
                billingDetailsHolder.tvTotalPrice = null;
                billingDetailsHolder.btnCheckOut = null;
                this.view7f0a006c.setOnClickListener((View.OnClickListener) null);
                this.view7f0a006c = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void setResultCartDetails(MyCartResult myCartResult) {
        this.resultCartDetails = myCartResult;
    }

    public void setCartDetails(List<CartDetail> list) {
        this.cartDetails = list;
    }

    public void removeAt(int i) {
        ItemAdapter itemAdapter2 = this.itemAdapter;
        if (itemAdapter2 != null) {
            itemAdapter2.removeAt(i);
        }
    }

    public CartAdapter(List<Object> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.objectList = list;
        this.listener = listener2;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        if (i == 1) {
            return new CartItemHolder(this);
        }
        return new BillingDetailsHolder(this);
    }

    public int _getItemCount() {
        return this.objectList.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.CartAdapter$BillingDetailsHolder */
    class BillingDetailsHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131361900)
        Button btnCheckOut;
        @BindView(2131362386)
        TextView tvItemTotalPrice;
        @BindView(2131362409)
        TextView tvShippingFeesPrice;
        @BindView(2131362417)
        TextView tvTax;
        @BindView(2131362422)
        TextView tvTotalPrice;

        BillingDetailsHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_billing_details);
        }

        public void update(int i) {
            super.update(i);
            this.tvTotalPrice.setText(AppUtils.showPrice(CartAdapter.this.resultCartDetails.getCartCurrencySymbol(), CartAdapter.this.resultCartDetails.getCartGrandTotal()));
            this.tvItemTotalPrice.setText(AppUtils.showPrice(CartAdapter.this.resultCartDetails.getCartCurrencySymbol(), CartAdapter.this.resultCartDetails.getCartSubTotal()));
            this.tvTax.setText(AppUtils.showPrice(CartAdapter.this.resultCartDetails.getCartCurrencySymbol(), CartAdapter.this.resultCartDetails.getCartGrandTax()));
            this.tvShippingFeesPrice.setText(AppUtils.showPrice(CartAdapter.this.resultCartDetails.getCartCurrencySymbol(), CartAdapter.this.resultCartDetails.getCartGrandShipping()));
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131361900})
        public void setSaveOrderMode() {
            CartAdapter.this.listener.onSubmit();
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.CartAdapter$CartItemHolder */
    class CartItemHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f240rv;
        @BindView(2131362358)
        TextView tvCostTitle;
        @BindView(2131362384)
        TextView tvItemTitle;

        CartItemHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_cart_header);
            new StartSnapHelper().attachToRecyclerView(this.f240rv);
        }

        public void update(int i) {
            super.update(i);
            this.tvItemTitle.setText(CartAdapter.this.cartDetails.size() + AppConstants.SPACE + ResourceUtils.getString(R.string.items) + AppConstants.SPACE);
            this.tvCostTitle.setText(AppUtils.showPrice(CartAdapter.this.resultCartDetails.getCartCurrencySymbol(), CartAdapter.this.resultCartDetails.getCartGrandTotal()));
            CartAdapter cartAdapter = CartAdapter.this;
            ItemAdapter unused = cartAdapter.itemAdapter = new ItemAdapter(cartAdapter.cartDetails, new ItemAdapter.Listener() {
                public void onDelete(CartDetail cartDetail, int i) {
                    CartAdapter.this.listener.onRemoveCart(cartDetail, i);
                }

                public void clickMinusBtn(CartDetail cartDetail, int i, int i2) {
                    CartAdapter.this.listener.clickMinusBtn(cartDetail, i, i2);
                }

                public void clickPlusBtn(CartDetail cartDetail, int i, int i2) {
                    CartAdapter.this.listener.clickPlusBtn(cartDetail, i, i2);
                }

                public void outOfQuantity() {
                    CartAdapter.this.listener.outOfQuantity();
                }
            });
            this.f240rv.setAdapter(CartAdapter.this.itemAdapter);
        }
    }
}
