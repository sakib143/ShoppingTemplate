package com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.store.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.model.storelist.StoreDetail;
import com.kiandashopping.kiandashopping.model.storelist.StoreReview;
import com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.store.adapter.StoreDetailAdapter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.DateTime;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.store.adapter.StoreDetailAdapter */
public class StoreDetailAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public boolean isMoreReview = false;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public boolean sessionClean = false;
    /* access modifiers changed from: private */
    public StoreDetail storeDetails;
    /* access modifiers changed from: private */
    public List<StoreReview> storeReviews;

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.store.adapter.StoreDetailAdapter$Listener */
    public interface Listener {
        void onCallStore(String str);

        void onClickSendReview(float f, String str, String str2);

        void onMoreReview();

        void onNavigation(String str, String str2);

        void onWeb(String str);
    }

    public boolean isFooter() {
        return true;
    }

    public boolean isHeader() {
        return true;
    }

    public boolean isLoadMoreEnabled() {
        return true;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    public boolean isNoItemEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.store.adapter.StoreDetailAdapter$FooterViewHolder_ViewBinding */
    public class FooterViewHolder_ViewBinding implements Unbinder {
        private FooterViewHolder target;

        public FooterViewHolder_ViewBinding(FooterViewHolder footerViewHolder, View view) {
            this.target = footerViewHolder;
            footerViewHolder.btnMoreReviews = (Button) Utils.findRequiredViewAsType(view, R.id.btnMoreReviews, "field 'btnMoreReviews'", Button.class);
        }

        public void unbind() {
            FooterViewHolder footerViewHolder = this.target;
            if (footerViewHolder != null) {
                this.target = null;
                footerViewHolder.btnMoreReviews = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.store.adapter.StoreDetailAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.tvRating = (TextView) Utils.findRequiredViewAsType(view, R.id.tvRating, "field 'tvRating'", TextView.class);
            viewHolder.tvReviewTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tvReviewTitle, "field 'tvReviewTitle'", TextView.class);
            viewHolder.tvReviewBy = (TextView) Utils.findRequiredViewAsType(view, R.id.tvReviewBy, "field 'tvReviewBy'", TextView.class);
            viewHolder.tvDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDate, "field 'tvDate'", TextView.class);
            viewHolder.tvReviewDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tvReviewDesc, "field 'tvReviewDesc'", TextView.class);
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
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.store.adapter.StoreDetailAdapter$HeaderViewHolder_ViewBinding */
    public class HeaderViewHolder_ViewBinding implements Unbinder {
        private HeaderViewHolder target;
        private View view7f0a0074;
        private View view7f0a0111;
        private View view7f0a0115;
        private View view7f0a0116;

        public HeaderViewHolder_ViewBinding(final HeaderViewHolder headerViewHolder, View view) {
            this.target = headerViewHolder;
            headerViewHolder.ivStore = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivStore, "field 'ivStore'", ImageView.class);
            headerViewHolder.tvStoreName = (TextView) Utils.findRequiredViewAsType(view, R.id.tvStoreName, "field 'tvStoreName'", TextView.class);
            headerViewHolder.tvStoreDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tvStoreDesc, "field 'tvStoreDesc'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.icStoreCall, "field 'icStoreCall' and method 'setIcStoreCall'");
            headerViewHolder.icStoreCall = (ImageView) Utils.castView(findRequiredView, R.id.icStoreCall, "field 'icStoreCall'", ImageView.class);
            this.view7f0a0111 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    headerViewHolder.setIcStoreCall();
                }
            });
            View findRequiredView2 = Utils.findRequiredView(view, R.id.icStoreNavigation, "field 'icStoreNavigation' and method 'setIcStoreNavigation'");
            headerViewHolder.icStoreNavigation = (ImageView) Utils.castView(findRequiredView2, R.id.icStoreNavigation, "field 'icStoreNavigation'", ImageView.class);
            this.view7f0a0115 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    headerViewHolder.setIcStoreNavigation();
                }
            });
            View findRequiredView3 = Utils.findRequiredView(view, R.id.icStoreNavigationWeb, "field 'icStoreNavigationWeb' and method 'setIcStoreWeb'");
            headerViewHolder.icStoreNavigationWeb = (ImageView) Utils.castView(findRequiredView3, R.id.icStoreNavigationWeb, "field 'icStoreNavigationWeb'", ImageView.class);
            this.view7f0a0116 = findRequiredView3;
            findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    headerViewHolder.setIcStoreWeb();
                }
            });
            headerViewHolder.f260rb = (RatingBar) Utils.findRequiredViewAsType(view, R.id.rb, "field 'rb'", RatingBar.class);
            headerViewHolder.etSummary = (EditText) Utils.findRequiredViewAsType(view, R.id.etSummary, "field 'etSummary'", EditText.class);
            headerViewHolder.etDescription = (EditText) Utils.findRequiredViewAsType(view, R.id.etDescription, "field 'etDescription'", EditText.class);
            View findRequiredView4 = Utils.findRequiredView(view, R.id.btnSend, "method 'sendButton'");
            this.view7f0a0074 = findRequiredView4;
            findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    headerViewHolder.sendButton();
                }
            });
        }

        public void unbind() {
            HeaderViewHolder headerViewHolder = this.target;
            if (headerViewHolder != null) {
                this.target = null;
                headerViewHolder.ivStore = null;
                headerViewHolder.tvStoreName = null;
                headerViewHolder.tvStoreDesc = null;
                headerViewHolder.icStoreCall = null;
                headerViewHolder.icStoreNavigation = null;
                headerViewHolder.icStoreNavigationWeb = null;
                headerViewHolder.f260rb = null;
                headerViewHolder.etSummary = null;
                headerViewHolder.etDescription = null;
                this.view7f0a0111.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0111 = null;
                this.view7f0a0115.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0115 = null;
                this.view7f0a0116.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0116 = null;
                this.view7f0a0074.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0074 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void setStoreDetails(StoreDetail storeDetail) {
        this.storeDetails = storeDetail;
    }

    public StoreDetailAdapter(List<StoreReview> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.listener = listener2;
        this.storeReviews = list;
    }

    public void setShowMoreOption(boolean z) {
        this.isMoreReview = z;
    }

    public void cleanSession(boolean z) {
        this.sessionClean = z;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.storeReviews.size();
    }

    public MyAdapter.ItemViewHolder getHeaderViewHolder() {
        return new HeaderViewHolder(this);
    }

    public MyAdapter.ItemViewHolder getFooterViewHolder() {
        return new FooterViewHolder(this);
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.store.adapter.StoreDetailAdapter$FooterViewHolder */
    class FooterViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131361904)
        Button btnMoreReviews;

        FooterViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_more_reviews);
        }

        public void update(int i) {
            super.update(i);
            if (StoreDetailAdapter.this.isMoreReview) {
                this.btnMoreReviews.setVisibility(0);
            } else {
                this.btnMoreReviews.setVisibility(8);
            }
            this.btnMoreReviews.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    StoreDetailAdapter.FooterViewHolder.this.lambda$update$0$StoreDetailAdapter$FooterViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$update$0$StoreDetailAdapter$FooterViewHolder(View view) {
            StoreDetailAdapter.this.listener.onMoreReview();
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.store.adapter.StoreDetailAdapter$HeaderViewHolder */
    class HeaderViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362009)
        EditText etDescription;
        @BindView(2131362025)
        EditText etSummary;
        @BindView(2131362065)
        ImageView icStoreCall;
        @BindView(2131362069)
        ImageView icStoreNavigation;
        @BindView(2131362070)
        ImageView icStoreNavigationWeb;
        @BindView(2131362106)
        ImageView ivStore;
        @BindView(2131362227)

        /* renamed from: rb */
        RatingBar f260rb;
        @BindView(2131362415)
        TextView tvStoreDesc;
        @BindView(2131362416)
        TextView tvStoreName;

        HeaderViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.header_store_details);
        }

        public void update(int i) {
            super.update(i);
            if (StoreDetailAdapter.this.storeDetails != null) {
                GlideUtils.showImage(BaseApplication.getContext(), this.ivStore, (Drawable) AppUtils.getProgressDrawable(), StoreDetailAdapter.this.storeDetails.getStoreImg());
                this.tvStoreName.setText(StoreDetailAdapter.this.storeDetails.getStoreName());
                this.tvStoreDesc.setText(AppUtils.append(StoreDetailAdapter.this.storeDetails.getStoreAddress1(), StoreDetailAdapter.this.storeDetails.getStoreAddress2()));
                if (StoreDetailAdapter.this.sessionClean) {
                    boolean unused = StoreDetailAdapter.this.sessionClean = false;
                    this.f260rb.setRating(0.0f);
                    this.etSummary.setText("");
                    this.etDescription.setText("");
                }
            }
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362065})
        public void setIcStoreCall() {
            StoreDetailAdapter.this.listener.onCallStore(StoreDetailAdapter.this.storeDetails.getStorePhone());
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362069})
        public void setIcStoreNavigation() {
            StoreDetailAdapter.this.listener.onNavigation(StoreDetailAdapter.this.storeDetails.getStoreLatitude(), StoreDetailAdapter.this.storeDetails.getStoreLongitude());
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362070})
        public void setIcStoreWeb() {
            StoreDetailAdapter.this.listener.onWeb(StoreDetailAdapter.this.storeDetails.getStoreWebsite());
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131361908})
        public void sendButton() {
            StoreDetailAdapter.this.listener.onClickSendReview(this.f260rb.getRating(), this.etSummary.getText().toString(), this.etDescription.getText().toString());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.fragment.store.adapter.StoreDetailAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
        StoreReview storeReview;
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
            super(myAdapter, (int) R.layout.item_store_derails);
        }

        public void update(int i) {
            super.update(i);
            StoreReview storeReview2 = (StoreReview) StoreDetailAdapter.this.storeReviews.get(i);
            this.storeReview = storeReview2;
            this.tvRating.setText(storeReview2.getRatings());
            this.tvReviewTitle.setText(this.storeReview.getReviewTitle());
            this.tvReviewBy.setText(this.storeReview.getCusName());
            this.tvReviewDesc.setText(this.storeReview.getReviewComments());
            this.tvDate.setText(new DateTime(this.storeReview.getReviewDate()).getDisplayDate());
        }
    }
}
