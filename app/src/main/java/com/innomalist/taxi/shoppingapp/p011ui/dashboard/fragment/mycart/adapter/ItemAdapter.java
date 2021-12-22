package com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.mycart.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devs.vectorchildfinder.VectorChildFinder;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.customview.MyAdapter;
import com.innomalist.taxi.shoppingapp.model.mycart.CartDetail;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.ConversionUtils;
import com.innomalist.taxi.shoppingapp.util.GlideUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
//import com.devs.vectorchildfinder.VectorChildFinder;
//import com.kiandashopping.kiandashopping.base.AppConstants;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.customview.MyAdapter;
//import com.kiandashopping.kiandashopping.model.mycart.CartDetail;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.ConversionUtils;
//import com.kiandashopping.kiandashopping.util.GlideUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.ItemAdapter */
public class ItemAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public List<CartDetail> cartLists;
    /* access modifiers changed from: private */
    public Listener listener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.ItemAdapter$Listener */
    public interface Listener {
        void clickMinusBtn(CartDetail cartDetail, int i, int i2);

        void clickPlusBtn(CartDetail cartDetail, int i, int i2);

        void onDelete(CartDetail cartDetail, int i);

        void outOfQuantity();
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.ItemAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a012c;
        private View view7f0a013d;
        private View view7f0a013e;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivBg, "field 'ivBg'", ImageView.class);
            viewHolder.tvProduct = (TextView) Utils.findRequiredViewAsType(view, R.id.tvProduct, "field 'tvProduct'", TextView.class);
            viewHolder.tvSize = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSize, "field 'tvSize'", TextView.class);
            viewHolder.tvColor = (TextView) Utils.findRequiredViewAsType(view, R.id.tvColor, "field 'tvColor'", TextView.class);
            viewHolder.tvQuantity = (TextView) Utils.findRequiredViewAsType(view, R.id.tvQuantity, "field 'tvQuantity'", TextView.class);
            viewHolder.tvPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPrice, "field 'tvPrice'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.ivClose, "field 'ivClose' and method 'setClose'");
            viewHolder.ivClose = (ImageView) Utils.castView(findRequiredView, R.id.ivClose, "field 'ivClose'", ImageView.class);
            this.view7f0a012c = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.setClose();
                }
            });
            viewHolder.ivColor = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivColor, "field 'ivColor'", ImageView.class);
            View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_minus, "method 'setMinus'");
            this.view7f0a013d = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.setMinus();
                }
            });
            View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_plus, "method 'setPlus'");
            this.view7f0a013e = findRequiredView3;
            findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.setPlus();
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.ivBg = null;
                viewHolder.tvProduct = null;
                viewHolder.tvSize = null;
                viewHolder.tvColor = null;
                viewHolder.tvQuantity = null;
                viewHolder.tvPrice = null;
                viewHolder.ivClose = null;
                viewHolder.ivColor = null;
                this.view7f0a012c.setOnClickListener((View.OnClickListener) null);
                this.view7f0a012c = null;
                this.view7f0a013d.setOnClickListener((View.OnClickListener) null);
                this.view7f0a013d = null;
                this.view7f0a013e.setOnClickListener((View.OnClickListener) null);
                this.view7f0a013e = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* access modifiers changed from: package-private */
    public void removeAt(int i) {
        this.cartLists.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, this.cartLists.size());
    }

    ItemAdapter(List<CartDetail> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.listener = listener2;
        this.cartLists = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.cartLists.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.adapter.ItemAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
        CartDetail cartList;
        @BindView(2131362090)
        ImageView ivBg;
        @BindView(2131362092)
        ImageView ivClose;
        @BindView(2131362093)
        ImageView ivColor;
        @BindView(2131362357)
        TextView tvColor;
        @BindView(2131362396)
        TextView tvPrice;
        @BindView(2131362397)
        TextView tvProduct;
        @BindView(2131362400)
        TextView tvQuantity;
        @BindView(2131362410)
        TextView tvSize;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_cart_item);
        }

        public void update(int i) {
            String str;
            super.update(i);
            CartDetail cartDetail = (CartDetail) ItemAdapter.this.cartLists.get(i);
            this.cartList = cartDetail;
            this.tvProduct.setText(cartDetail.getCartTitle());
            this.tvProduct.setSelected(true);
            this.tvPrice.setText(AppUtils.showPrice(this.cartList.getCartCurrencySymbol(), this.cartList.getCartPrice()));
            this.tvQuantity.setText(ConversionUtils.parseString(this.cartList.getCartQuantity().intValue()));
            String str2 = " N/A";
            if (this.cartList.getCartSizeDetails().size() > 0) {
                str = AppConstants.SPACE + this.cartList.getCartSizeDetails().get(0).getSizeName();
            } else {
                str = str2;
            }
            if (this.cartList.getCartColorDetails().size() > 0) {
                str2 = this.cartList.getCartColorDetails().get(0).getColorName();
                this.ivColor.setImageResource(R.drawable.ic_active_color);
                new VectorChildFinder(BaseApplication.getContext(), R.drawable.ic_active_color, this.ivColor).findPathByName("path2").setFillColor(ResourceUtils.getColor(this.cartList.getCartColorDetails().get(0).getColorCode()));
                this.ivColor.setVisibility(0);
            } else {
                this.ivColor.setVisibility(8);
            }
            this.tvSize.setText(str);
            this.tvColor.setText(str2);
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (int) R.color.white, this.cartList.getCartImage());
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362109})
        public void setMinus() {
            int intValue = this.cartList.getCartQuantity().intValue();
            if (intValue > 1) {
                int i = intValue - 1;
                this.tvQuantity.setText("" + i);
                ItemAdapter.this.listener.clickMinusBtn(this.cartList, getAdapterPosition(), i);
            }
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362110})
        public void setPlus() {
            int intValue = this.cartList.getCartQuantity().intValue();
            if (intValue < this.cartList.getProductAvailableQty().intValue()) {
                int i = intValue + 1;
                this.tvQuantity.setText("" + i);
                ItemAdapter.this.listener.clickPlusBtn(this.cartList, getAdapterPosition(), i);
                return;
            }
            ItemAdapter.this.listener.outOfQuantity();
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362092})
        public void setClose() {
            ItemAdapter.this.listener.onDelete(this.cartList, getAdapterPosition());
        }
    }
}
