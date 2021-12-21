package com.kiandashopping.kiandashopping.p011ui.ordertracking.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.tracking.ShipDetail;
import com.kiandashopping.kiandashopping.util.DateTime;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.DHLTrackingAdapter */
public class DHLTrackingAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public String awbNumber;
    /* access modifiers changed from: private */
    public List<ShipDetail> shipDetailList;
    /* access modifiers changed from: private */
    public String shipmentStatus;

    public boolean isHeader() {
        return true;
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.DHLTrackingAdapter$HeaderViewHolder_ViewBinding */
    public class HeaderViewHolder_ViewBinding implements Unbinder {
        private HeaderViewHolder target;

        public HeaderViewHolder_ViewBinding(HeaderViewHolder headerViewHolder, View view) {
            this.target = headerViewHolder;
            headerViewHolder.tvShipmentStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_shipment_staus, "field 'tvShipmentStatus'", TextView.class);
            headerViewHolder.tvAwbNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_awb_number, "field 'tvAwbNumber'", TextView.class);
        }

        public void unbind() {
            HeaderViewHolder headerViewHolder = this.target;
            if (headerViewHolder != null) {
                this.target = null;
                headerViewHolder.tvShipmentStatus = null;
                headerViewHolder.tvAwbNumber = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.DHLTrackingAdapter$ViewHolder_ViewBinding */
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

    public void setHeaderDetails(String str, String str2) {
        this.awbNumber = str;
        this.shipmentStatus = str2;
    }

    public DHLTrackingAdapter(List<ShipDetail> list) {
        super((MyAdapter.Listener) null);
        this.shipDetailList = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.shipDetailList.size();
    }

    public MyAdapter.ItemViewHolder getHeaderViewHolder() {
        return new HeaderViewHolder(this);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.DHLTrackingAdapter$HeaderViewHolder */
    class HeaderViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362428)
        TextView tvAwbNumber;
        @BindView(2131362429)
        TextView tvShipmentStatus;

        HeaderViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_order_details_dhl_header);
        }

        public void update(int i) {
            super.update(i);
            this.tvShipmentStatus.setText(DHLTrackingAdapter.this.shipmentStatus);
            this.tvAwbNumber.setText(DHLTrackingAdapter.this.awbNumber);
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.ordertracking.adapter.DHLTrackingAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131361889)
        View bottom;
        @BindView(2131361923)
        ImageView center;
        ShipDetail shipDetail;
        @BindView(2131362339)
        View top;
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
            ShipDetail shipDetail2 = (ShipDetail) DHLTrackingAdapter.this.shipDetailList.get(i);
            this.shipDetail = shipDetail2;
            this.tvTitle.setText(shipDetail2.getStatus());
            this.tvDate.setText(new DateTime(this.shipDetail.getDateTime(), DateTime.SERVER_DATE_TIME).getDisplayDateTime());
            this.tvDesc.setText("");
            this.top.setVisibility(i == 0 ? 8 : 0);
            this.bottom.setVisibility(0);
            this.top.setBackgroundResource(R.drawable.dotted_vertical_line_active);
            this.bottom.setBackgroundResource(R.drawable.dotted_vertical_line_inactive);
            this.center.setImageResource(R.drawable.ic_track_active);
        }
    }
}
