package com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductReview;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ReviewAdapter;
import com.kiandashopping.kiandashopping.util.DateTime;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter */
public class ReviewAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public int lastItem = 0;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<ProductReview> productReviewList;

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter$Listener */
    public interface Listener {
        void onMoreReview();
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.tvRating = (TextView) Utils.findRequiredViewAsType(view, R.id.tvRating, "field 'tvRating'", TextView.class);
            viewHolder.tvReviewTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvReviewTitle, "field 'tvReviewTitle'", TextView.class);
            viewHolder.tvReviewBy = (TextView) Utils.findRequiredViewAsType(view, R.id.tvReviewBy, "field 'tvReviewBy'", TextView.class);
            viewHolder.tvDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDate, "field 'tvDate'", TextView.class);
            viewHolder.tvReviewDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tvReviewDesc, "field 'tvReviewDesc'", TextView.class);
            viewHolder.btnMoreReviews = (Button) Utils.findRequiredViewAsType(view, R.id.btnMoreReviews, "field 'btnMoreReviews'", Button.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.tvRating = null;
                viewHolder.tvReviewTitle = null;
                viewHolder.tvReviewBy = null;
                viewHolder.tvDate = null;
                viewHolder.tvReviewDesc = null;
                viewHolder.btnMoreReviews = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ReviewAdapter(List<ProductReview> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.productReviewList = list;
        this.listener = listener2;
        this.lastItem = list.size() - 1;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.productReviewList.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131361904)
        Button btnMoreReviews;
        ProductReview productReview;
        @BindView(2131362359)
        TextView tvDate;
        @BindView(2131362401)
        TextView tvRating;
        @BindView(2131362403)
        TextView tvReviewBy;
        @BindView(2131362404)
        TextView tvReviewDesc;
        @BindView(2131362405)
        TextView tvReviewTitle;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_reviews);
        }

        public void update(int i) {
            super.update(i);
            this.productReview = (ProductReview) ReviewAdapter.this.productReviewList.get(i);
            this.btnMoreReviews.setVisibility(ReviewAdapter.this.lastItem == i ? 0 : 8);
            this.tvRating.setText(this.productReview.getRatings());
            this.tvReviewTitle.setText(this.productReview.getReviewTitle());
            this.tvReviewBy.setText(this.productReview.getCusName());
            this.tvReviewDesc.setText(this.productReview.getReviewComments());
            this.tvDate.setText(new DateTime(this.productReview.getReviewDate()).getDisplayDate());
            this.btnMoreReviews.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ReviewAdapter.ViewHolder.this.lambda$update$0$ReviewAdapter$ViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$update$0$ReviewAdapter$ViewHolder(View view) {
            ReviewAdapter.this.listener.onMoreReview();
        }
    }
}
