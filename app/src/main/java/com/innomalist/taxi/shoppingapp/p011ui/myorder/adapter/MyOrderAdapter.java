package com.kiandashopping.kiandashopping.p011ui.myorder.adapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.myorder.OrderList;
import com.kiandashopping.kiandashopping.p011ui.myorder.adapter.MyOrderAdapter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.DateTime;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.myorder.adapter.MyOrderAdapter */
public class MyOrderAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    private static final int ORDER_CANCELLED = 6;
    private static final int ORDER_DELIVERED = 4;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<OrderList> wishListResults;

    /* renamed from: com.kiandashopping.kiandashopping.ui.myorder.adapter.MyOrderAdapter$Listener */
    public interface Listener extends MyAdapter.Listener {
        void onClickDHLItem(OrderList orderList);

        void onClickItem(OrderList orderList);
    }

    public boolean isLoadMoreEnabled() {
        return true;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.myorder.adapter.MyOrderAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivBg, "field 'ivBg'", ImageView.class);
            viewHolder.tvItem = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItem, "field 'tvItem'", TextView.class);
            viewHolder.tvDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDate, "field 'tvDate'", TextView.class);
            viewHolder.tvDeliveryStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDeliveryStatus, "field 'tvDeliveryStatus'", TextView.class);
            viewHolder.tvPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPrice, "field 'tvPrice'", TextView.class);
            viewHolder.btnTrack = (Button) Utils.findRequiredViewAsType(view, R.id.btnTrack, "field 'btnTrack'", Button.class);
            viewHolder.btnDHLTrack = (Button) Utils.findRequiredViewAsType(view, R.id.btnDHLTrack, "field 'btnDHLTrack'", Button.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.ivBg = null;
                viewHolder.tvItem = null;
                viewHolder.tvDate = null;
                viewHolder.tvDeliveryStatus = null;
                viewHolder.tvPrice = null;
                viewHolder.btnTrack = null;
                viewHolder.btnDHLTrack = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public MyOrderAdapter(List<OrderList> list, Listener listener2) {
        super(listener2);
        this.listener = listener2;
        this.wishListResults = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.wishListResults.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.myorder.adapter.MyOrderAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131361902)
        Button btnDHLTrack;
        @BindView(2131361911)
        Button btnTrack;
        @BindView(2131362090)
        ImageView ivBg;
        OrderList orderList;
        @BindView(2131362359)
        TextView tvDate;
        @BindView(2131362367)
        TextView tvDeliveryStatus;
        @BindView(2131362381)
        TextView tvItem;
        @BindView(2131362396)
        TextView tvPrice;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_order_list);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            OrderList orderList2 = (OrderList) MyOrderAdapter.this.wishListResults.get(i);
            this.orderList = orderList2;
            this.tvItem.setText(orderList2.getOrderTitle());
            this.tvPrice.setText(AppUtils.showPrice(this.orderList.getProductCurrencySymbol(), this.orderList.getOrderAmount()));
            this.tvDate.setText(new DateTime(this.orderList.getOrderDate(), DateTime.SERVER_DATE_TIME).getDisplayDateTime());
            this.tvDeliveryStatus.setText(this.orderList.getDeliveryStatus());
            int i2 = 0;
            this.btnTrack.setVisibility((this.orderList.getDeliveryStatusKey() == 4 || this.orderList.getDeliveryStatusKey() == 6) ? 8 : 0);
            Button button = this.btnDHLTrack;
            if (this.orderList.getDhlTrackingId() == null || this.orderList.getDhlTrackingId().equals("")) {
                i2 = 8;
            }
            button.setVisibility(i2);
            Drawable background = this.tvDeliveryStatus.getBackground();
            if (background instanceof ShapeDrawable) {
                ShapeDrawable shapeDrawable = (ShapeDrawable) background;
                if (this.orderList.getDeliveryStatusKey() == 4) {
                    shapeDrawable.getPaint().setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_placed));
                    this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_placed_txt));
                } else if (this.orderList.getDeliveryStatusKey() == 6) {
                    shapeDrawable.getPaint().setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_canceled));
                    this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_canceled_txt));
                } else {
                    shapeDrawable.getPaint().setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_other));
                    this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_other_txt));
                }
            } else if (background instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (this.orderList.getDeliveryStatusKey() == 4) {
                    gradientDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_placed));
                    this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_placed_txt));
                } else if (this.orderList.getDeliveryStatusKey() == 6) {
                    gradientDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_canceled));
                    this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_canceled_txt));
                } else {
                    gradientDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_other));
                    this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_other_txt));
                }
            } else if (background instanceof ColorDrawable) {
                ColorDrawable colorDrawable = (ColorDrawable) background;
                if (this.orderList.getDeliveryStatusKey() == 4) {
                    colorDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_placed));
                    this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_placed_txt));
                } else if (this.orderList.getDeliveryStatusKey() == 6) {
                    colorDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_canceled));
                    this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_canceled_txt));
                } else {
                    colorDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_other));
                    this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_other_txt));
                }
            }
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.orderList.getProductImage());
            this.btnTrack.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MyOrderAdapter.ViewHolder.this.lambda$update$0$MyOrderAdapter$ViewHolder(view);
                }
            });
            this.btnDHLTrack.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MyOrderAdapter.ViewHolder.this.lambda$update$1$MyOrderAdapter$ViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$update$0$MyOrderAdapter$ViewHolder(View view) {
            MyOrderAdapter.this.listener.onClickItem(this.orderList);
        }

        public /* synthetic */ void lambda$update$1$MyOrderAdapter$ViewHolder(View view) {
            MyOrderAdapter.this.listener.onClickDHLItem(this.orderList);
        }

        public void onClick(View view) {
            MyOrderAdapter.this.listener.onClickItem(this.orderList);
        }
    }
}
