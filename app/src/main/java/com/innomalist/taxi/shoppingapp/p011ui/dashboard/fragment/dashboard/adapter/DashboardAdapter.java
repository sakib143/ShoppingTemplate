package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.AppConstants;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.customview.StartSnapHelper;
import com.kiandashopping.kiandashopping.model.dashboard.CategoryDetail;
import com.kiandashopping.kiandashopping.model.dashboard.DashboardResponse;
import com.kiandashopping.kiandashopping.model.dashboard.DealsOfDayDetail;
import com.kiandashopping.kiandashopping.model.dashboard.MostPopularProduct;
import com.kiandashopping.kiandashopping.model.dashboard.ProductFiftyPercent;
import com.kiandashopping.kiandashopping.model.dashboard.ProductNewArrivals;
import com.kiandashopping.kiandashopping.model.dashboard.ProductTopOffer;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.CategoryAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.DashboardAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.DealsInfiniteAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.MostAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.NewArrivalsAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.OfferAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.Top50Adapter;
import com.kiandashopping.kiandashopping.util.ConversionUtils;
import com.kiandashopping.kiandashopping.util.ItemOffsetDecoration;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter */
public class DashboardAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    private static final int VT_BANNER = 1;
    private static final int VT_CATEGORY = 2;
    private static final int VT_DEAL = 6;
    private static final int VT_MOST_POPULAR = 5;
    private static final int VT_NEW_ARRIVALS = 8;
    private static final int VT_SEARCH = 0;
    private static final int VT_TOP_OFFER = 3;
    private static final int VT_TV = 7;
    private static final int VT_UP_TO_50 = 4;
    /* access modifiers changed from: private */
    public DashboardResponse dashboardResponse;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<Object> objectList;
    /* access modifiers changed from: private */
    public long offEnd;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$AllType */
    public enum AllType {
        CATEGORY,
        TOP_OFFER,
        NEW_ARRIVAL,
        UP_TO_50,
        MOST_POPPULAR,
        DEALS
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$Listener */
    public interface Listener {
        void onClick(AllType allType);

        void onClickCategory(String str, String str2);

        void onClickCategory(String str, String str2, String str3);

        void onClickDeal(int i);

        void onClickItem(int i);

        void onGoSearch(String str);
    }

    public boolean isHeader() {
        return false;
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$CategoryViewHolder_ViewBinding */
    public class CategoryViewHolder_ViewBinding implements Unbinder {
        private CategoryViewHolder target;

        public CategoryViewHolder_ViewBinding(CategoryViewHolder categoryViewHolder, View view) {
            this.target = categoryViewHolder;
            categoryViewHolder.f232rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        }

        public void unbind() {
            CategoryViewHolder categoryViewHolder = this.target;
            if (categoryViewHolder != null) {
                this.target = null;
                categoryViewHolder.f232rv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$DealsViewHolder_ViewBinding */
    public class DealsViewHolder_ViewBinding implements Unbinder {
        private DealsViewHolder target;

        public DealsViewHolder_ViewBinding(DealsViewHolder dealsViewHolder, View view) {
            this.target = dealsViewHolder;
            dealsViewHolder.tvGreatSale = (TextView) Utils.findRequiredViewAsType(view, R.id.tvGreatSale, "field 'tvGreatSale'", TextView.class);
            dealsViewHolder.tvTimer = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTimer, "field 'tvTimer'", TextView.class);
        }

        public void unbind() {
            DealsViewHolder dealsViewHolder = this.target;
            if (dealsViewHolder != null) {
                this.target = null;
                dealsViewHolder.tvGreatSale = null;
                dealsViewHolder.tvTimer = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$MostViewHolder_ViewBinding */
    public class MostViewHolder_ViewBinding implements Unbinder {
        private MostViewHolder target;

        public MostViewHolder_ViewBinding(MostViewHolder mostViewHolder, View view) {
            this.target = mostViewHolder;
            mostViewHolder.f233rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_card, "field 'rv'", RecyclerView.class);
            mostViewHolder.visibleView = Utils.findRequiredView(view, R.id.cardView, "field 'visibleView'");
            mostViewHolder.hidableView = Utils.findRequiredView(view, R.id.rv, "field 'hidableView'");
        }

        public void unbind() {
            MostViewHolder mostViewHolder = this.target;
            if (mostViewHolder != null) {
                this.target = null;
                mostViewHolder.f233rv = null;
                mostViewHolder.visibleView = null;
                mostViewHolder.hidableView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$NewArrivalsViewHolder_ViewBinding */
    public class NewArrivalsViewHolder_ViewBinding implements Unbinder {
        private NewArrivalsViewHolder target;

        public NewArrivalsViewHolder_ViewBinding(NewArrivalsViewHolder newArrivalsViewHolder, View view) {
            this.target = newArrivalsViewHolder;
            newArrivalsViewHolder.f234rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_card, "field 'rv'", RecyclerView.class);
            newArrivalsViewHolder.visibleView = Utils.findRequiredView(view, R.id.cardView, "field 'visibleView'");
            newArrivalsViewHolder.hidableView = Utils.findRequiredView(view, R.id.rv, "field 'hidableView'");
        }

        public void unbind() {
            NewArrivalsViewHolder newArrivalsViewHolder = this.target;
            if (newArrivalsViewHolder != null) {
                this.target = null;
                newArrivalsViewHolder.f234rv = null;
                newArrivalsViewHolder.visibleView = null;
                newArrivalsViewHolder.hidableView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$TopOfferViewHolder_ViewBinding */
    public class TopOfferViewHolder_ViewBinding implements Unbinder {
        private TopOfferViewHolder target;

        public TopOfferViewHolder_ViewBinding(TopOfferViewHolder topOfferViewHolder, View view) {
            this.target = topOfferViewHolder;
            topOfferViewHolder.f236rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_card, "field 'rv'", RecyclerView.class);
            topOfferViewHolder.visibleView = Utils.findRequiredView(view, R.id.cardView, "field 'visibleView'");
            topOfferViewHolder.hidableView = Utils.findRequiredView(view, R.id.rv, "field 'hidableView'");
        }

        public void unbind() {
            TopOfferViewHolder topOfferViewHolder = this.target;
            if (topOfferViewHolder != null) {
                this.target = null;
                topOfferViewHolder.f236rv = null;
                topOfferViewHolder.visibleView = null;
                topOfferViewHolder.hidableView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$UpToViewHolder_ViewBinding */
    public class UpToViewHolder_ViewBinding implements Unbinder {
        private UpToViewHolder target;

        public UpToViewHolder_ViewBinding(UpToViewHolder upToViewHolder, View view) {
            this.target = upToViewHolder;
            upToViewHolder.f237rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_card, "field 'rv'", RecyclerView.class);
            upToViewHolder.visibleView = Utils.findRequiredView(view, R.id.cardView, "field 'visibleView'");
            upToViewHolder.hidableView = Utils.findRequiredView(view, R.id.rv, "field 'hidableView'");
        }

        public void unbind() {
            UpToViewHolder upToViewHolder = this.target;
            if (upToViewHolder != null) {
                this.target = null;
                upToViewHolder.f237rv = null;
                upToViewHolder.visibleView = null;
                upToViewHolder.hidableView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$TextViewHolder_ViewBinding */
    public class TextViewHolder_ViewBinding implements Unbinder {
        private TextViewHolder target;
        private View view7f0a0073;

        public TextViewHolder_ViewBinding(final TextViewHolder textViewHolder, View view) {
            this.target = textViewHolder;
            textViewHolder.tvHead = (TextView) Utils.findRequiredViewAsType(view, R.id.tvHead, "field 'tvHead'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.btnSeeAll, "field 'btnSeeAll' and method 'onClickSeeAll'");
            textViewHolder.btnSeeAll = (Button) Utils.castView(findRequiredView, R.id.btnSeeAll, "field 'btnSeeAll'", Button.class);
            this.view7f0a0073 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    textViewHolder.onClickSeeAll();
                }
            });
        }

        public void unbind() {
            TextViewHolder textViewHolder = this.target;
            if (textViewHolder != null) {
                this.target = null;
                textViewHolder.tvHead = null;
                textViewHolder.btnSeeAll = null;
                this.view7f0a0073.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0073 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$SearchHolder_ViewBinding */
    public class SearchHolder_ViewBinding implements Unbinder {
        private SearchHolder target;
        private View view7f0a00e7;
        private View view7f0a0138;

        public SearchHolder_ViewBinding(final SearchHolder searchHolder, View view) {
            this.target = searchHolder;
            searchHolder.f235cv = (CardView) Utils.findRequiredViewAsType(view, R.id.cv, "field 'cv'", CardView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.ivSearch, "field 'ivSearch' and method 'onActionGo'");
            searchHolder.ivSearch = (ImageView) Utils.castView(findRequiredView, R.id.ivSearch, "field 'ivSearch'", ImageView.class);
            this.view7f0a0138 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    searchHolder.onActionGo();
                }
            });
            View findRequiredView2 = Utils.findRequiredView(view, R.id.etSearch, "field 'etSearch' and method 'onActionDone'");
            searchHolder.etSearch = (EditText) Utils.castView(findRequiredView2, R.id.etSearch, "field 'etSearch'", EditText.class);
            this.view7f0a00e7 = findRequiredView2;
            ((TextView) findRequiredView2).setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return searchHolder.onActionDone();
                }
            });
        }

        public void unbind() {
            SearchHolder searchHolder = this.target;
            if (searchHolder != null) {
                this.target = null;
                searchHolder.f235cv = null;
                searchHolder.ivSearch = null;
                searchHolder.etSearch = null;
                this.view7f0a0138.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0138 = null;
                ((TextView) this.view7f0a00e7).setOnEditorActionListener((TextView.OnEditorActionListener) null);
                this.view7f0a00e7 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void setDashBoardData(DashboardResponse dashboardResponse2) {
        this.dashboardResponse = dashboardResponse2;
    }

    public void setOffEnd(long j) {
        this.offEnd = j;
    }

    public DashboardAdapter(List<Object> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.objectList = list;
        this.listener = listener2;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        switch (i) {
            case 0:
                return new SearchHolder(this);
            case 1:
                return new BannerViewHolder(this);
            case 2:
                return new CategoryViewHolder(this);
            case 3:
                return new TopOfferViewHolder(this);
            case 4:
                return new UpToViewHolder(this);
            case 5:
                return new MostViewHolder(this);
            case 6:
                return new DealsViewHolder(this);
            case 8:
                return new NewArrivalsViewHolder(this);
            default:
                return new TextViewHolder(this);
        }
    }

    public int _getItemCount() {
        return this.objectList.size();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int _getItemViewType(int r10) {
        /*
            r9 = this;
            java.util.List<java.lang.Object> r0 = r9.objectList
            java.lang.Object r10 = r0.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            int r0 = r10.hashCode()
            r1 = 7
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 6
            r6 = 2
            r7 = 1
            r8 = 0
            switch(r0) {
                case -1822469688: goto L_0x005e;
                case -1390047818: goto L_0x0054;
                case -1334452334: goto L_0x004a;
                case -981207545: goto L_0x0040;
                case -28833446: goto L_0x0036;
                case 65904999: goto L_0x002c;
                case 590570872: goto L_0x0022;
                case 1982491468: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0068
        L_0x0018:
            java.lang.String r0 = "Banner"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0068
            r10 = 1
            goto L_0x0069
        L_0x0022:
            java.lang.String r0 = "CategoryType"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0068
            r10 = 2
            goto L_0x0069
        L_0x002c:
            java.lang.String r0 = "Deals"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0068
            r10 = 3
            goto L_0x0069
        L_0x0036:
            java.lang.String r0 = "newArrivals"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0068
            r10 = 5
            goto L_0x0069
        L_0x0040:
            java.lang.String r0 = "topOffer"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0068
            r10 = 4
            goto L_0x0069
        L_0x004a:
            java.lang.String r0 = "50%Offer"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0068
            r10 = 6
            goto L_0x0069
        L_0x0054:
            java.lang.String r0 = "MostPopular"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0068
            r10 = 7
            goto L_0x0069
        L_0x005e:
            java.lang.String r0 = "Search"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0068
            r10 = 0
            goto L_0x0069
        L_0x0068:
            r10 = -1
        L_0x0069:
            switch(r10) {
                case 0: goto L_0x0076;
                case 1: goto L_0x0075;
                case 2: goto L_0x0074;
                case 3: goto L_0x0073;
                case 4: goto L_0x0072;
                case 5: goto L_0x006f;
                case 6: goto L_0x006e;
                case 7: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            return r1
        L_0x006d:
            return r2
        L_0x006e:
            return r3
        L_0x006f:
            r10 = 8
            return r10
        L_0x0072:
            return r4
        L_0x0073:
            return r5
        L_0x0074:
            return r6
        L_0x0075:
            return r7
        L_0x0076:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.adapter.DashboardAdapter._getItemViewType(int):int");
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$TextViewHolder */
    class TextViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131361907)
        Button btnSeeAll;
        @BindView(2131362376)
        TextView tvHead;

        TextViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_head);
        }

        public void update(int i) {
            super.update(i);
            this.tvHead.setText((String) DashboardAdapter.this.objectList.get(i));
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131361907})
        public void onClickSeeAll() {
            String str = (String) DashboardAdapter.this.objectList.get(getAdapterPosition());
            if (str.equals(ResourceUtils.getString(R.string.category))) {
                DashboardAdapter.this.listener.onClick(AllType.CATEGORY);
            } else if (str.equals(ResourceUtils.getString(R.string.best_offer))) {
                DashboardAdapter.this.listener.onClick(AllType.TOP_OFFER);
            } else if (str.equals(ResourceUtils.getString(R.string.new_arrivals))) {
                DashboardAdapter.this.listener.onClick(AllType.NEW_ARRIVAL);
            } else if (str.equals(ResourceUtils.getString(R.string.up_50_percent))) {
                DashboardAdapter.this.listener.onClick(AllType.UP_TO_50);
            } else if (str.equals(ResourceUtils.getString(R.string.most_popular))) {
                DashboardAdapter.this.listener.onClick(AllType.MOST_POPPULAR);
            } else if (str.equals(ResourceUtils.getString(R.string.flash_deals))) {
                DashboardAdapter.this.listener.onClick(AllType.DEALS);
            }
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$SearchHolder */
    class SearchHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131361966)

        /* renamed from: cv */
        CardView f235cv;
        @BindView(2131362023)
        EditText etSearch;
        @BindView(2131362104)
        ImageView ivSearch;

        SearchHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dash_board_search);
        }

        public void update(int i) {
            super.update(i);
        }

        /* access modifiers changed from: package-private */
        @OnEditorAction({2131362023})
        public boolean onActionDone() {
            DashboardAdapter.this.listener.onGoSearch(this.etSearch.getText().toString());
            return true;
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362104})
        public void onActionGo() {
            DashboardAdapter.this.listener.onGoSearch(this.etSearch.getText().toString());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$BannerViewHolder */
    class BannerViewHolder extends MyAdapter.ItemViewHolder {
        BannerViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_banner);
        }

        public void update(int i) {
            super.update(i);
            new BannerInfinitePager(this.itemView.getRootView(), "").setData(DashboardAdapter.this.dashboardResponse.getBannerDetails());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$DealsViewHolder */
    public class DealsViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362374)
        TextView tvGreatSale;
        @BindView(2131362419)
        TextView tvTimer;

        DealsViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_deals);
        }

        public void update(int i) {
            super.update(i);
            new DealsInfinitePager(this.itemView.getRootView(), new DealsInfiniteAdapter.DealsListener() {
                public final void onClick(DealsOfDayDetail dealsOfDayDetail) {
                    DashboardAdapter.DealsViewHolder.this.lambda$update$0$DashboardAdapter$DealsViewHolder(dealsOfDayDetail);
                }
            }).setData(DashboardAdapter.this.dashboardResponse.getDealsOfDayDetails());
            int i2 = Calendar.getInstance().get(1);
            this.tvGreatSale.setText(ResourceUtils.getString(R.string.great_sale) + AppConstants.SPACE + i2);
            updateRemainingTime();
        }

        public /* synthetic */ void lambda$update$0$DashboardAdapter$DealsViewHolder(DealsOfDayDetail dealsOfDayDetail) {
            DashboardAdapter.this.listener.onClickDeal(dealsOfDayDetail.getDealId().intValue());
        }

        public void updateRemainingTime() {
            if (this.tvTimer != null) {
                long access$300 = DashboardAdapter.this.offEnd - System.currentTimeMillis();
                if (access$300 > 0) {
                    long j = (access$300 / 60000) % 60;
                    long j2 = access$300 / 86400000;
                    this.tvTimer.setVisibility(0);
                    this.tvTimer.setText(showInterVal(j2, (access$300 / 3600000) % 24, j, (access$300 / 1000) % 60));
                    return;
                }
                this.tvTimer.setVisibility(8);
            }
        }

        private String showInterVal(long j, long j2, long j3, long j4) {
            if (j > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(ConversionUtils.parseInt(j));
                sb.append(AppConstants.SPACE);
                sb.append(ResourceUtils.getString(ConversionUtils.parseInt(j) > 1 ? R.string.days : R.string.day));
                sb.append(" | ");
                sb.append(ConversionUtils.parseInt(j2));
                sb.append(AppConstants.SPACE);
                sb.append(ConversionUtils.parseInt(j2) > 1 ? ResourceUtils.getString(R.string.hrs) : ResourceUtils.getString(R.string.hr));
                sb.append(" | ");
                sb.append(ConversionUtils.parseInt(j3));
                sb.append(AppConstants.SPACE);
                sb.append(ConversionUtils.parseInt(j3) > 1 ? ResourceUtils.getString(R.string.mins) : ResourceUtils.getString(R.string.min));
                sb.append(" | ");
                sb.append(ConversionUtils.parseInt(j4));
                sb.append(AppConstants.SPACE);
                sb.append(ConversionUtils.parseInt(j4) > 1 ? ResourceUtils.getString(R.string.secs) : ResourceUtils.getString(R.string.sec));
                return sb.toString();
            } else if (j2 > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ConversionUtils.parseInt(j2));
                sb2.append(AppConstants.SPACE);
                sb2.append(ConversionUtils.parseInt(j2) > 1 ? ResourceUtils.getString(R.string.hrs) : ResourceUtils.getString(R.string.hr));
                sb2.append(" | ");
                sb2.append(ConversionUtils.parseInt(j3));
                sb2.append(AppConstants.SPACE);
                sb2.append(ConversionUtils.parseInt(j3) > 1 ? ResourceUtils.getString(R.string.mins) : ResourceUtils.getString(R.string.min));
                sb2.append(" | ");
                sb2.append(ConversionUtils.parseInt(j4));
                sb2.append(AppConstants.SPACE);
                sb2.append(ConversionUtils.parseInt(j4) > 1 ? ResourceUtils.getString(R.string.secs) : ResourceUtils.getString(R.string.sec));
                return sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(ConversionUtils.parseInt(j3));
                sb3.append(AppConstants.SPACE);
                sb3.append(ConversionUtils.parseInt(j3) > 1 ? ResourceUtils.getString(R.string.mins) : ResourceUtils.getString(R.string.min));
                sb3.append(" | ");
                sb3.append(ConversionUtils.parseInt(j4));
                sb3.append(AppConstants.SPACE);
                sb3.append(ConversionUtils.parseInt(j4) > 1 ? ResourceUtils.getString(R.string.secs) : ResourceUtils.getString(R.string.sec));
                return sb3.toString();
            }
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$CategoryViewHolder */
    class CategoryViewHolder extends MyAdapter.ItemViewHolder {
        CategoryAdapter categoryAdapter;
        List<CategoryDetail> categoryDetails = new ArrayList();
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f232rv;

        CategoryViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            new StartSnapHelper().attachToRecyclerView(this.f232rv);
        }

        public void update(int i) {
            super.update(i);
            CategoryAdapter categoryAdapter2 = this.categoryAdapter;
            if (categoryAdapter2 == null) {
                this.categoryDetails.add(new CategoryDetail(0, "", ResourceUtils.getString(R.string.deals), "", new ArrayList()));
                this.categoryDetails.addAll(DashboardAdapter.this.dashboardResponse.getCategoryDetails());
                this.categoryAdapter = new CategoryAdapter(this.categoryDetails, new CategoryAdapter.Listener() {
                    public void onClickCategory(CategoryDetail categoryDetail) {
                        if (categoryDetail.getSubCategoryList().size() > 0) {
                            DashboardAdapter.this.listener.onClickCategory(categoryDetail.getCategoryId(), categoryDetail.getSubCategoryList().get(0).getCategoryId(), categoryDetail.getCategoryName());
                        } else {
                            DashboardAdapter.this.listener.onClickCategory(categoryDetail.getCategoryId(), categoryDetail.getCategoryName());
                        }
                    }

                    public void onAllDeals() {
                        DashboardAdapter.this.listener.onClick(AllType.DEALS);
                    }
                });
                RecyclerView recyclerView = this.f232rv;
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
                this.f232rv.setAdapter(this.categoryAdapter);
                return;
            }
            categoryAdapter2.notifyDataSetChanged();
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$TopOfferViewHolder */
    class TopOfferViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362247)
        View hidableView;
        OfferAdapter offerAdapter;
        @BindView(2131362249)

        /* renamed from: rv */
        RecyclerView f236rv;
        @BindView(2131361921)
        View visibleView;

        TopOfferViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            this.hidableView.setVisibility(8);
            this.visibleView.setVisibility(0);
            new StartSnapHelper().attachToRecyclerView(this.f236rv);
        }

        public void update(int i) {
            super.update(i);
            OfferAdapter offerAdapter2 = this.offerAdapter;
            if (offerAdapter2 == null) {
                this.f236rv.setLayoutManager(new GridLayoutManager(BaseApplication.getContext(), 2, 1, false));
                this.offerAdapter = new OfferAdapter(DashboardAdapter.this.dashboardResponse.getProductTopOffer(), new OfferAdapter.Listener() {
                    public final void onClickItem(ProductTopOffer productTopOffer) {
                        DashboardAdapter.TopOfferViewHolder.this.lambda$update$0$DashboardAdapter$TopOfferViewHolder(productTopOffer);
                    }
                });
                this.f236rv.addItemDecoration(new ItemOffsetDecoration(1));
                this.f236rv.setAdapter(this.offerAdapter);
                return;
            }
            offerAdapter2.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$DashboardAdapter$TopOfferViewHolder(ProductTopOffer productTopOffer) {
            DashboardAdapter.this.listener.onClickItem(productTopOffer.getProductId().intValue());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$NewArrivalsViewHolder */
    class NewArrivalsViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362247)
        View hidableView;
        NewArrivalsAdapter newArrivalsAdapter;
        @BindView(2131362249)

        /* renamed from: rv */
        RecyclerView f234rv;
        @BindView(2131361921)
        View visibleView;

        NewArrivalsViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            this.hidableView.setVisibility(8);
            this.visibleView.setVisibility(0);
            new StartSnapHelper().attachToRecyclerView(this.f234rv);
        }

        public void update(int i) {
            super.update(i);
            NewArrivalsAdapter newArrivalsAdapter2 = this.newArrivalsAdapter;
            if (newArrivalsAdapter2 == null) {
                this.f234rv.setLayoutManager(new GridLayoutManager(BaseApplication.getContext(), 2, 1, false));
                this.newArrivalsAdapter = new NewArrivalsAdapter(DashboardAdapter.this.dashboardResponse.getProductNewArrivals(), new NewArrivalsAdapter.Listener() {
                    public final void onClickItem(ProductNewArrivals productNewArrivals) {
                        DashboardAdapter.NewArrivalsViewHolder.this.lambda$update$0$DashboardAdapter$NewArrivalsViewHolder(productNewArrivals);
                    }
                });
                this.f234rv.addItemDecoration(new ItemOffsetDecoration(1));
                this.f234rv.setAdapter(this.newArrivalsAdapter);
                return;
            }
            newArrivalsAdapter2.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$DashboardAdapter$NewArrivalsViewHolder(ProductNewArrivals productNewArrivals) {
            DashboardAdapter.this.listener.onClickItem(productNewArrivals.getProductId().intValue());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$UpToViewHolder */
    class UpToViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362247)
        View hidableView;
        @BindView(2131362249)

        /* renamed from: rv */
        RecyclerView f237rv;
        Top50Adapter top50Adapter;
        @BindView(2131361921)
        View visibleView;

        UpToViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            this.hidableView.setVisibility(8);
            this.visibleView.setVisibility(0);
            new StartSnapHelper().attachToRecyclerView(this.f237rv);
        }

        public void update(int i) {
            super.update(i);
            Top50Adapter top50Adapter2 = this.top50Adapter;
            if (top50Adapter2 == null) {
                this.f237rv.setLayoutManager(new LinearLayoutManager(BaseApplication.getContext()));
                Top50Adapter top50Adapter3 = new Top50Adapter(DashboardAdapter.this.dashboardResponse.getProductFiftyPercent(), new Top50Adapter.Listener() {
                    public final void onClickItem(ProductFiftyPercent productFiftyPercent) {
                        DashboardAdapter.UpToViewHolder.this.lambda$update$0$DashboardAdapter$UpToViewHolder(productFiftyPercent);
                    }
                });
                this.top50Adapter = top50Adapter3;
                this.f237rv.setAdapter(top50Adapter3);
                return;
            }
            top50Adapter2.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$DashboardAdapter$UpToViewHolder(ProductFiftyPercent productFiftyPercent) {
            DashboardAdapter.this.listener.onClickItem(productFiftyPercent.getProductId().intValue());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.dashboard.adapter.DashboardAdapter$MostViewHolder */
    class MostViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362247)
        View hidableView;
        @BindView(2131362249)

        /* renamed from: rv */
        RecyclerView f233rv;
        MostAdapter top50Adapter;
        @BindView(2131361921)
        View visibleView;

        MostViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            this.hidableView.setVisibility(8);
            this.visibleView.setVisibility(0);
            new StartSnapHelper().attachToRecyclerView(this.f233rv);
        }

        public void update(int i) {
            super.update(i);
            MostAdapter mostAdapter = this.top50Adapter;
            if (mostAdapter == null) {
                this.f233rv.setLayoutManager(new GridLayoutManager(BaseApplication.getContext(), 2, 1, false));
                this.top50Adapter = new MostAdapter(DashboardAdapter.this.dashboardResponse.getMostPopularProduct(), new MostAdapter.Listener() {
                    public final void onClickItem(MostPopularProduct mostPopularProduct) {
                        DashboardAdapter.MostViewHolder.this.lambda$update$0$DashboardAdapter$MostViewHolder(mostPopularProduct);
                    }
                });
                this.f233rv.addItemDecoration(new ItemOffsetDecoration(1));
                this.f233rv.setAdapter(this.top50Adapter);
                return;
            }
            mostAdapter.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$DashboardAdapter$MostViewHolder(MostPopularProduct mostPopularProduct) {
            DashboardAdapter.this.listener.onClickItem(mostPopularProduct.getProductId().intValue());
        }
    }
}
