package com.kiandashopping.kiandashopping.p011ui.ordertracking.adapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.AppConstants;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.myorder.OrderList;
import com.kiandashopping.kiandashopping.model.myorder.TrackingDetails;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.DateTime;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.OrdersTrackingAdapter */
public class OrdersTrackingAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    private static final int ORDER_CANCELLED = 6;
    private static final int ORDER_DELIVERED = 4;
    /* access modifiers changed from: private */
    public int lastItem = -1;
    /* access modifiers changed from: private */
    public OrderList orderList;
    /* access modifiers changed from: private */
    public List<TrackingDetails> orderTrackingList;

    public boolean isHeader() {
        return true;
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.OrdersTrackingAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.tvDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDate, "field 'tvDate'", TextView.class);
            viewHolder.top = Utils.findRequiredView(view, R.id.top, "field 'top'");
            viewHolder.center = (ImageView) Utils.findRequiredViewAsType(view, R.id.center, "field 'center'", ImageView.class);
            viewHolder.bottom = Utils.findRequiredView(view, R.id.bottom, "field 'bottom'");
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTitle, "field 'tvTitle'", TextView.class);
            viewHolder.tvDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDesc, "field 'tvDesc'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.tvDate = null;
                viewHolder.top = null;
                viewHolder.center = null;
                viewHolder.bottom = null;
                viewHolder.tvTitle = null;
                viewHolder.tvDesc = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.OrdersTrackingAdapter$HeaderViewHolder_ViewBinding */
    public class HeaderViewHolder_ViewBinding implements Unbinder {
        private HeaderViewHolder target;

        public HeaderViewHolder_ViewBinding(HeaderViewHolder headerViewHolder, View view) {
            this.target = headerViewHolder;
            headerViewHolder.llContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llContainer, "field 'llContainer'", LinearLayout.class);
            headerViewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivBg, "field 'ivBg'", ImageView.class);
            headerViewHolder.tvItem = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItem, "field 'tvItem'", TextView.class);
            headerViewHolder.tvAddress = (TextView) Utils.findRequiredViewAsType(view, R.id.tvAddress, "field 'tvAddress'", TextView.class);
            headerViewHolder.tvQuantity = (TextView) Utils.findRequiredViewAsType(view, R.id.tvQuantity, "field 'tvQuantity'", TextView.class);
            headerViewHolder.tvDeliveryStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDeliveryStatus, "field 'tvDeliveryStatus'", TextView.class);
            headerViewHolder.tvPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPrice, "field 'tvPrice'", TextView.class);
            headerViewHolder.trackingId = (TextView) Utils.findRequiredViewAsType(view, R.id.trackingId, "field 'trackingId'", TextView.class);
            headerViewHolder.paymentstatus = (TextView) Utils.findRequiredViewAsType(view, R.id.paymentstatus, "field 'paymentstatus'", TextView.class);
        }

        public void unbind() {
            HeaderViewHolder headerViewHolder = this.target;
            if (headerViewHolder != null) {
                this.target = null;
                headerViewHolder.llContainer = null;
                headerViewHolder.ivBg = null;
                headerViewHolder.tvItem = null;
                headerViewHolder.tvAddress = null;
                headerViewHolder.tvQuantity = null;
                headerViewHolder.tvDeliveryStatus = null;
                headerViewHolder.tvPrice = null;
                headerViewHolder.trackingId = null;
                headerViewHolder.paymentstatus = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void setOrderDetails(OrderList orderList2) {
        this.orderList = orderList2;
    }

    public void setLastItem(int i) {
        this.lastItem = i;
    }

    public OrdersTrackingAdapter(List<TrackingDetails> list) {
        super((MyAdapter.Listener) null);
        this.orderTrackingList = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.orderTrackingList.size();
    }

    public MyAdapter.ItemViewHolder getHeaderViewHolder() {
        return new HeaderViewHolder(this);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.OrdersTrackingAdapter$HeaderViewHolder */
    class HeaderViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362090)
        ImageView ivBg;
        @BindView(2131362128)
        LinearLayout llContainer;
        @BindView(2131362183)
        TextView paymentstatus;
        @BindView(2131362342)
        TextView trackingId;
        @BindView(2131362351)
        TextView tvAddress;
        @BindView(2131362367)
        TextView tvDeliveryStatus;
        @BindView(2131362381)
        TextView tvItem;
        @BindView(2131362396)
        TextView tvPrice;
        @BindView(2131362400)
        TextView tvQuantity;

        HeaderViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_order_details_header);
        }

        public void update(int i) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            super.update(i);
            if (OrdersTrackingAdapter.this.orderList != null) {
                this.llContainer.setVisibility(0);
                this.tvItem.setText(OrdersTrackingAdapter.this.orderList.getOrderTitle());
                this.trackingId.setText(OrdersTrackingAdapter.this.orderList.getOrderTransactionId());
                this.tvPrice.setText(AppUtils.showPrice(OrdersTrackingAdapter.this.orderList.getProductCurrencySymbol(), OrdersTrackingAdapter.this.orderList.getOrderAmount()));
                if (OrdersTrackingAdapter.this.orderList.getOrderQty().intValue() > 1) {
                    str = ResourceUtils.getString(R.string.items_text);
                } else {
                    str = ResourceUtils.getString(R.string.item_text) + AppConstants.SPACE + OrdersTrackingAdapter.this.orderList.getOrderQty();
                }
                this.tvQuantity.setText(str);
                this.paymentstatus.setText(OrdersTrackingAdapter.this.orderList.getOrderStatus());
                this.tvDeliveryStatus.setText(OrdersTrackingAdapter.this.orderList.getDeliveryStatus());
                GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), OrdersTrackingAdapter.this.orderList.getProductImage());
                StringBuilder sb = new StringBuilder();
                String str7 = "";
                if (OrdersTrackingAdapter.this.orderList.getShipAddress1().length() > 0) {
                    str2 = OrdersTrackingAdapter.this.orderList.getShipAddress1() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str2 = str7;
                }
                sb.append(str2);
                if (OrdersTrackingAdapter.this.orderList.getShipAddress2().length() > 0) {
                    str3 = OrdersTrackingAdapter.this.orderList.getShipAddress2() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str3 = str7;
                }
                sb.append(str3);
                if (OrdersTrackingAdapter.this.orderList.getShipCityName().length() > 0) {
                    str4 = OrdersTrackingAdapter.this.orderList.getShipCityName() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str4 = str7;
                }
                sb.append(str4);
                if (OrdersTrackingAdapter.this.orderList.getShipState().length() > 0) {
                    str5 = OrdersTrackingAdapter.this.orderList.getShipState() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str5 = str7;
                }
                sb.append(str5);
                if (OrdersTrackingAdapter.this.orderList.getShipCountryName().length() > 0) {
                    str6 = OrdersTrackingAdapter.this.orderList.getShipCountryName() + AppConstants.COMMA + AppConstants.SPACE;
                } else {
                    str6 = str7;
                }
                sb.append(str6);
                if (OrdersTrackingAdapter.this.orderList.getShipPostalcode().length() > 0) {
                    str7 = OrdersTrackingAdapter.this.orderList.getShipPostalcode();
                }
                sb.append(str7);
                this.tvAddress.setText(sb.toString());
                Drawable background = this.tvDeliveryStatus.getBackground();
                if (background instanceof ShapeDrawable) {
                    ShapeDrawable shapeDrawable = (ShapeDrawable) background;
                    if (OrdersTrackingAdapter.this.orderList.getDeliveryStatusKey() == 4) {
                        shapeDrawable.getPaint().setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_placed));
                        this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_placed_txt));
                    } else if (OrdersTrackingAdapter.this.orderList.getDeliveryStatusKey() == 6) {
                        shapeDrawable.getPaint().setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_canceled));
                        this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_canceled_txt));
                    } else {
                        shapeDrawable.getPaint().setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_other));
                        this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_other_txt));
                    }
                } else if (background instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) background;
                    if (OrdersTrackingAdapter.this.orderList.getDeliveryStatusKey() == 4) {
                        gradientDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_placed));
                        this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_placed_txt));
                    } else if (OrdersTrackingAdapter.this.orderList.getDeliveryStatusKey() == 6) {
                        gradientDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_canceled));
                        this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_canceled_txt));
                    } else {
                        gradientDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_other));
                        this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_other_txt));
                    }
                } else if (background instanceof ColorDrawable) {
                    ColorDrawable colorDrawable = (ColorDrawable) background;
                    if (OrdersTrackingAdapter.this.orderList.getDeliveryStatusKey() == 4) {
                        colorDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_placed));
                        this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_placed_txt));
                    } else if (OrdersTrackingAdapter.this.orderList.getDeliveryStatusKey() == 6) {
                        colorDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_canceled));
                        this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_canceled_txt));
                    } else {
                        colorDrawable.setColor(ContextCompat.getColor(BaseApplication.getContext(), R.color.order_other));
                        this.tvDeliveryStatus.setTextColor(ResourceUtils.getColor((int) R.color.order_other_txt));
                    }
                }
            } else {
                this.llContainer.setVisibility(8);
            }
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.OrdersTrackingAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131361889)
        View bottom;
        @BindView(2131361923)
        ImageView center;
        @BindView(2131362339)
        View top;
        TrackingDetails tracking;
        @BindView(2131362359)
        TextView tvDate;
        @BindView(2131362368)
        TextView tvDesc;
        @BindView(2131362420)
        TextView tvTitle;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_order_tracking);
        }

        public void update(int i) {
            super.update(i);
            TrackingDetails trackingDetails = (TrackingDetails) OrdersTrackingAdapter.this.orderTrackingList.get(i);
            this.tracking = trackingDetails;
            this.tvTitle.setText(trackingDetails.getTitle());
            this.tvDate.setText(new DateTime(this.tracking.getTime(), DateTime.SERVER_DATE_TIME).getTwoLineDateTime());
            this.tvDesc.setText(this.tracking.getDesc());
            int i2 = 8;
            this.top.setVisibility(i == 0 ? 8 : 0);
            View view = this.bottom;
            if (i != OrdersTrackingAdapter.this.lastItem) {
                i2 = 0;
            }
            view.setVisibility(i2);
            View view2 = this.top;
            boolean booleanValue = this.tracking.getStatus().booleanValue();
            int i3 = R.drawable.dotted_vertical_line_active;
            view2.setBackgroundResource(booleanValue ? R.drawable.dotted_vertical_line_active : R.drawable.dotted_vertical_line_inactive);
            View view3 = this.bottom;
            if (!this.tracking.getStatus().booleanValue()) {
                i3 = R.drawable.dotted_vertical_line_inactive;
            }
            view3.setBackgroundResource(i3);
            this.center.setImageResource(this.tracking.getStatus().booleanValue() ? R.drawable.ic_track_active : R.drawable.ic_track_inactive);
        }
    }
}
