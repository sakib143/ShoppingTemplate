package com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.google.android.material.tabs.TabLayout;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.customview.StartSnapHelper;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult;
import com.kiandashopping.kiandashopping.model.itemdetails.RelatedProduct;
import com.kiandashopping.kiandashopping.model.itemdetails.StoreDetail;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ColorAdapter;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.RelatedProductAdapter;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ReviewAdapter;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.SizeAdapter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.ConversionUtils;
import com.kiandashopping.kiandashopping.util.DateTime;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter */
public class ProductDetailAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    public static final int VT_CANCELLATION_POLICY_DETAILS = 4;
    public static final int VT_CHOOSE_COLOR = 2;
    public static final int VT_CHOOSE_SIZE = 3;
    public static final int VT_ITEM_INFO = 1;
    public static final int VT_LABEL = 10;
    public static final int VT_RELATED_PRODUCTS = 8;
    public static final int VT_REPLACE_POLICY_DETAILS = 6;
    public static final int VT_RETURN_POLICY_DETAILS = 5;
    public static final int VT_SPECIFICATION = 7;
    public static final int VT_STORE_DETAILS = 9;
    private BaseActivity activity;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<Object> objectList;
    /* access modifiers changed from: private */
    public long offEnd;
    /* access modifiers changed from: private */
    public ProductDetailsResult productDetailsResult;
    /* access modifiers changed from: private */
    public int quantity = 1;
    /* access modifiers changed from: private */
    public int selectColor = -1;
    /* access modifiers changed from: private */
    public int selectSize = -1;
    /* access modifiers changed from: private */
    public int tabSelected = 0;

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$Listener */
    public interface Listener {
        void onCallStore(String str);

        void onClickColor(int i, int i2);

        void onClickPolicyDetails(String str, String str2);

        void onClickProduct(int i);

        void onClickQuantity(int i);

        void onClickSendReview(float f, String str, String str2);

        void onClickSize(int i, int i2);

        void onMoreReview();

        void onNavigation(String str, String str2);

        void onTabSelected(int i);

        void onWeb(String str);
    }

    public boolean isHeader() {
        return false;
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$CancellationPolicyViewHolder_ViewBinding */
    public class CancellationPolicyViewHolder_ViewBinding implements Unbinder {
        private CancellationPolicyViewHolder target;

        public CancellationPolicyViewHolder_ViewBinding(CancellationPolicyViewHolder cancellationPolicyViewHolder, View view) {
            this.target = cancellationPolicyViewHolder;
            cancellationPolicyViewHolder.tvPolicy = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPolicy, "field 'tvPolicy'", TextView.class);
        }

        public void unbind() {
            CancellationPolicyViewHolder cancellationPolicyViewHolder = this.target;
            if (cancellationPolicyViewHolder != null) {
                this.target = null;
                cancellationPolicyViewHolder.tvPolicy = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$ColorViewHolder_ViewBinding */
    public class ColorViewHolder_ViewBinding implements Unbinder {
        private ColorViewHolder target;

        public ColorViewHolder_ViewBinding(ColorViewHolder colorViewHolder, View view) {
            this.target = colorViewHolder;
            colorViewHolder.f246rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        }

        public void unbind() {
            ColorViewHolder colorViewHolder = this.target;
            if (colorViewHolder != null) {
                this.target = null;
                colorViewHolder.f246rv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$RelatedProductViewHolder_ViewBinding */
    public class RelatedProductViewHolder_ViewBinding implements Unbinder {
        private RelatedProductViewHolder target;

        public RelatedProductViewHolder_ViewBinding(RelatedProductViewHolder relatedProductViewHolder, View view) {
            this.target = relatedProductViewHolder;
            relatedProductViewHolder.f247rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        }

        public void unbind() {
            RelatedProductViewHolder relatedProductViewHolder = this.target;
            if (relatedProductViewHolder != null) {
                this.target = null;
                relatedProductViewHolder.f247rv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$ReplacePolicyViewHolder_ViewBinding */
    public class ReplacePolicyViewHolder_ViewBinding implements Unbinder {
        private ReplacePolicyViewHolder target;

        public ReplacePolicyViewHolder_ViewBinding(ReplacePolicyViewHolder replacePolicyViewHolder, View view) {
            this.target = replacePolicyViewHolder;
            replacePolicyViewHolder.tvPolicy = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPolicy, "field 'tvPolicy'", TextView.class);
        }

        public void unbind() {
            ReplacePolicyViewHolder replacePolicyViewHolder = this.target;
            if (replacePolicyViewHolder != null) {
                this.target = null;
                replacePolicyViewHolder.tvPolicy = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$ReturnPolicyViewHolder_ViewBinding */
    public class ReturnPolicyViewHolder_ViewBinding implements Unbinder {
        private ReturnPolicyViewHolder target;

        public ReturnPolicyViewHolder_ViewBinding(ReturnPolicyViewHolder returnPolicyViewHolder, View view) {
            this.target = returnPolicyViewHolder;
            returnPolicyViewHolder.tvPolicy = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPolicy, "field 'tvPolicy'", TextView.class);
        }

        public void unbind() {
            ReturnPolicyViewHolder returnPolicyViewHolder = this.target;
            if (returnPolicyViewHolder != null) {
                this.target = null;
                returnPolicyViewHolder.tvPolicy = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SizeViewHolder_ViewBinding */
    public class SizeViewHolder_ViewBinding implements Unbinder {
        private SizeViewHolder target;

        public SizeViewHolder_ViewBinding(SizeViewHolder sizeViewHolder, View view) {
            this.target = sizeViewHolder;
            sizeViewHolder.f248rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        }

        public void unbind() {
            SizeViewHolder sizeViewHolder = this.target;
            if (sizeViewHolder != null) {
                this.target = null;
                sizeViewHolder.f248rv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$TextViewHolder_ViewBinding */
    public class TextViewHolder_ViewBinding implements Unbinder {
        private TextViewHolder target;

        public TextViewHolder_ViewBinding(TextViewHolder textViewHolder, View view) {
            this.target = textViewHolder;
            textViewHolder.tvHead = (TextView) Utils.findRequiredViewAsType(view, R.id.tvHead, "field 'tvHead'", TextView.class);
            textViewHolder.btnSeeAll = (Button) Utils.findRequiredViewAsType(view, R.id.btnSeeAll, "field 'btnSeeAll'", Button.class);
        }

        public void unbind() {
            TextViewHolder textViewHolder = this.target;
            if (textViewHolder != null) {
                this.target = null;
                textViewHolder.tvHead = null;
                textViewHolder.btnSeeAll = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$ItemInfoHolder_ViewBinding */
    public class ItemInfoHolder_ViewBinding implements Unbinder {
        private ItemInfoHolder target;
        private View view7f0a0128;
        private View view7f0a0131;

        public ItemInfoHolder_ViewBinding(final ItemInfoHolder itemInfoHolder, View view) {
            this.target = itemInfoHolder;
            itemInfoHolder.tvStock = (TextView) Utils.findRequiredViewAsType(view, R.id.tvStock, "field 'tvStock'", TextView.class);
            itemInfoHolder.tvPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPrice, "field 'tvPrice'", TextView.class);
            itemInfoHolder.tvDiscountPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDiscountPrice, "field 'tvDiscountPrice'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.ivAdd, "field 'ivAdd' and method 'setAdd'");
            itemInfoHolder.ivAdd = (ImageView) Utils.castView(findRequiredView, R.id.ivAdd, "field 'ivAdd'", ImageView.class);
            this.view7f0a0128 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    itemInfoHolder.setAdd();
                }
            });
            itemInfoHolder.ivCount = (TextView) Utils.findRequiredViewAsType(view, R.id.ivCount, "field 'ivCount'", TextView.class);
            View findRequiredView2 = Utils.findRequiredView(view, R.id.ivMinus, "field 'ivMinus' and method 'setMin'");
            itemInfoHolder.ivMinus = (ImageView) Utils.castView(findRequiredView2, R.id.ivMinus, "field 'ivMinus'", ImageView.class);
            this.view7f0a0131 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    itemInfoHolder.setMin();
                }
            });
            itemInfoHolder.tvItemName = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItemName, "field 'tvItemName'", TextView.class);
            itemInfoHolder.tvItemDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItemDesc, "field 'tvItemDesc'", TextView.class);
            itemInfoHolder.tvDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDate, "field 'tvDate'", TextView.class);
            itemInfoHolder.llDealView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llDealView, "field 'llDealView'", LinearLayout.class);
            itemInfoHolder.tvDeliveredOnLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDeliveredOnLabel, "field 'tvDeliveredOnLabel'", TextView.class);
            itemInfoHolder.tvRating = (TextView) Utils.findRequiredViewAsType(view, R.id.tvRating, "field 'tvRating'", TextView.class);
            itemInfoHolder.tvDays = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDays, "field 'tvDays'", TextView.class);
            itemInfoHolder.tvDayTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDayTxt, "field 'tvDayTxt'", TextView.class);
            itemInfoHolder.tvHours = (TextView) Utils.findRequiredViewAsType(view, R.id.tvHours, "field 'tvHours'", TextView.class);
            itemInfoHolder.tvHoursTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.tvHoursTxt, "field 'tvHoursTxt'", TextView.class);
            itemInfoHolder.tvMinutes = (TextView) Utils.findRequiredViewAsType(view, R.id.tvMinutes, "field 'tvMinutes'", TextView.class);
            itemInfoHolder.tvMinutesTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.tvMinutesTxt, "field 'tvMinutesTxt'", TextView.class);
            itemInfoHolder.tvSec = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSec, "field 'tvSec'", TextView.class);
            itemInfoHolder.tvSecTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSecTxt, "field 'tvSecTxt'", TextView.class);
        }

        public void unbind() {
            ItemInfoHolder itemInfoHolder = this.target;
            if (itemInfoHolder != null) {
                this.target = null;
                itemInfoHolder.tvStock = null;
                itemInfoHolder.tvPrice = null;
                itemInfoHolder.tvDiscountPrice = null;
                itemInfoHolder.ivAdd = null;
                itemInfoHolder.ivCount = null;
                itemInfoHolder.ivMinus = null;
                itemInfoHolder.tvItemName = null;
                itemInfoHolder.tvItemDesc = null;
                itemInfoHolder.tvDate = null;
                itemInfoHolder.llDealView = null;
                itemInfoHolder.tvDeliveredOnLabel = null;
                itemInfoHolder.tvRating = null;
                itemInfoHolder.tvDays = null;
                itemInfoHolder.tvDayTxt = null;
                itemInfoHolder.tvHours = null;
                itemInfoHolder.tvHoursTxt = null;
                itemInfoHolder.tvMinutes = null;
                itemInfoHolder.tvMinutesTxt = null;
                itemInfoHolder.tvSec = null;
                itemInfoHolder.tvSecTxt = null;
                this.view7f0a0128.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0128 = null;
                this.view7f0a0131.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0131 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder_ViewBinding */
    public class SpecificationHolder_ViewBinding implements Unbinder {
        private SpecificationHolder target;
        private View view7f0a0074;

        public SpecificationHolder_ViewBinding(final SpecificationHolder specificationHolder, View view) {
            this.target = specificationHolder;
            specificationHolder.ratingView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ratingView, "field 'ratingView'", LinearLayout.class);
            specificationHolder.f249rb = (RatingBar) Utils.findRequiredViewAsType(view, R.id.rb, "field 'rb'", RatingBar.class);
            specificationHolder.etSummary = (EditText) Utils.findRequiredViewAsType(view, R.id.etSummary, "field 'etSummary'", EditText.class);
            specificationHolder.etDescription = (EditText) Utils.findRequiredViewAsType(view, R.id.etDescription, "field 'etDescription'", EditText.class);
            specificationHolder.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.gift_tabs, "field 'tabLayout'", TabLayout.class);
            specificationHolder.tvNoRecord = (TextView) Utils.findRequiredViewAsType(view, R.id.tvNoRecord, "field 'tvNoRecord'", TextView.class);
            specificationHolder.f250rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.btnSend, "method 'sendButton'");
            this.view7f0a0074 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    specificationHolder.sendButton();
                }
            });
        }

        public void unbind() {
            SpecificationHolder specificationHolder = this.target;
            if (specificationHolder != null) {
                this.target = null;
                specificationHolder.ratingView = null;
                specificationHolder.f249rb = null;
                specificationHolder.etSummary = null;
                specificationHolder.etDescription = null;
                specificationHolder.tabLayout = null;
                specificationHolder.tvNoRecord = null;
                specificationHolder.f250rv = null;
                this.view7f0a0074.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0074 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$StoreDetailsViewHolder_ViewBinding */
    public class StoreDetailsViewHolder_ViewBinding implements Unbinder {
        private StoreDetailsViewHolder target;
        private View view7f0a0111;
        private View view7f0a0115;
        private View view7f0a0116;

        public StoreDetailsViewHolder_ViewBinding(final StoreDetailsViewHolder storeDetailsViewHolder, View view) {
            this.target = storeDetailsViewHolder;
            storeDetailsViewHolder.ivStore = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivStore, "field 'ivStore'", ImageView.class);
            storeDetailsViewHolder.tvStoreName = (TextView) Utils.findRequiredViewAsType(view, R.id.tvStoreName, "field 'tvStoreName'", TextView.class);
            storeDetailsViewHolder.tvStoreDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tvStoreDesc, "field 'tvStoreDesc'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.icStoreCall, "field 'icStoreCall' and method 'setIcStoreCall'");
            storeDetailsViewHolder.icStoreCall = (ImageView) Utils.castView(findRequiredView, R.id.icStoreCall, "field 'icStoreCall'", ImageView.class);
            this.view7f0a0111 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    storeDetailsViewHolder.setIcStoreCall();
                }
            });
            View findRequiredView2 = Utils.findRequiredView(view, R.id.icStoreNavigation, "field 'icStoreNavigation' and method 'setIcStoreNavigation'");
            storeDetailsViewHolder.icStoreNavigation = (ImageView) Utils.castView(findRequiredView2, R.id.icStoreNavigation, "field 'icStoreNavigation'", ImageView.class);
            this.view7f0a0115 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    storeDetailsViewHolder.setIcStoreNavigation();
                }
            });
            View findRequiredView3 = Utils.findRequiredView(view, R.id.icStoreNavigationWeb, "field 'icStoreNavigationWeb' and method 'setIcStoreWeb'");
            storeDetailsViewHolder.icStoreNavigationWeb = (ImageView) Utils.castView(findRequiredView3, R.id.icStoreNavigationWeb, "field 'icStoreNavigationWeb'", ImageView.class);
            this.view7f0a0116 = findRequiredView3;
            findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    storeDetailsViewHolder.setIcStoreWeb();
                }
            });
        }

        public void unbind() {
            StoreDetailsViewHolder storeDetailsViewHolder = this.target;
            if (storeDetailsViewHolder != null) {
                this.target = null;
                storeDetailsViewHolder.ivStore = null;
                storeDetailsViewHolder.tvStoreName = null;
                storeDetailsViewHolder.tvStoreDesc = null;
                storeDetailsViewHolder.icStoreCall = null;
                storeDetailsViewHolder.icStoreNavigation = null;
                storeDetailsViewHolder.icStoreNavigationWeb = null;
                this.view7f0a0111.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0111 = null;
                this.view7f0a0115.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0115 = null;
                this.view7f0a0116.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0116 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void setListData(ProductDetailsResult productDetailsResult2) {
        this.productDetailsResult = productDetailsResult2;
    }

    public void setTabPosition(int i) {
        this.tabSelected = i;
    }

    public void setOffEnd(long j) {
        this.offEnd = j;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setColorPosition(int i) {
        this.selectColor = i;
    }

    public void setSizePosition(int i) {
        this.selectSize = i;
    }

    public ProductDetailAdapter(Listener listener2, List<Object> list, BaseActivity baseActivity) {
        super((MyAdapter.Listener) null);
        this.objectList = list;
        this.listener = listener2;
        this.activity = baseActivity;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        switch (i) {
            case 1:
                return new ItemInfoHolder(this);
            case 2:
                return new ColorViewHolder(this);
            case 3:
                return new SizeViewHolder(this);
            case 4:
                return new CancellationPolicyViewHolder(this);
            case 5:
                return new ReturnPolicyViewHolder(this);
            case 6:
                return new ReplacePolicyViewHolder(this);
            case 7:
                return new SpecificationHolder(this);
            case 8:
                return new RelatedProductViewHolder(this);
            case 9:
                return new StoreDetailsViewHolder(this);
            case 10:
                return new TextViewHolder(this);
            default:
                return new SizeViewHolder(this);
        }
    }

    public int _getItemCount() {
        return this.objectList.size();
    }

    public int _getItemViewType(int i) {
        if (this.objectList.get(i) instanceof String) {
            return 10;
        }
        return ((Integer) this.objectList.get(i)).intValue();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$ItemInfoHolder */
    public class ItemInfoHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362088)
        ImageView ivAdd;
        @BindView(2131362094)
        TextView ivCount;
        @BindView(2131362097)
        ImageView ivMinus;
        @BindView(2131362129)
        LinearLayout llDealView;
        @BindView(2131362359)
        TextView tvDate;
        @BindView(2131362360)
        TextView tvDayTxt;
        @BindView(2131362361)
        TextView tvDays;
        @BindView(2131362364)
        TextView tvDeliveredOnLabel;
        @BindView(2131362371)
        TextView tvDiscountPrice;
        @BindView(2131362378)
        TextView tvHours;
        @BindView(2131362379)
        TextView tvHoursTxt;
        @BindView(2131362382)
        TextView tvItemDesc;
        @BindView(2131362383)
        TextView tvItemName;
        @BindView(2131362390)
        TextView tvMinutes;
        @BindView(2131362391)
        TextView tvMinutesTxt;
        @BindView(2131362396)
        TextView tvPrice;
        @BindView(2131362401)
        TextView tvRating;
        @BindView(2131362406)
        TextView tvSec;
        @BindView(2131362407)
        TextView tvSecTxt;
        @BindView(2131362414)
        TextView tvStock;

        public ItemInfoHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_details_info);
        }

        public void update(int i) {
            super.update(i);
            this.ivCount.setText(ConversionUtils.parseString(ProductDetailAdapter.this.quantity));
            this.tvItemName.setText(ProductDetailAdapter.this.productDetailsResult.getProductTitle());
            this.tvItemDesc.setText(ProductDetailAdapter.this.productDetailsResult.getProductDescription());
            int i2 = 8;
            if (ProductDetailAdapter.this.productDetailsResult.getProductDelivery() == null) {
                this.tvDate.setVisibility(8);
                this.tvDeliveredOnLabel.setVisibility(8);
            } else {
                this.tvDate.setVisibility(0);
                this.tvDeliveredOnLabel.setVisibility(0);
                Calendar instance = Calendar.getInstance();
                instance.add(5, ProductDetailAdapter.this.productDetailsResult.getProductDelivery().intValue());
                this.tvDate.setText(new DateTime(instance).getDisplayProductDelivery());
            }
            if (ProductDetailAdapter.this.productDetailsResult.getDealEndDate() == null) {
                this.llDealView.setVisibility(8);
            } else {
                this.llDealView.setVisibility(0);
                updateRemainingTime();
            }
            this.tvRating.setText(ConversionUtils.parseString(ProductDetailAdapter.this.productDetailsResult.getAvgReview().doubleValue()));
            this.tvStock.setText(ProductDetailAdapter.this.productDetailsResult.getProductStatus());
            this.tvDiscountPrice.setText(AppUtils.showPrice(ProductDetailAdapter.this.productDetailsResult.getCurrencySymbol(), ProductDetailAdapter.this.productDetailsResult.getProductOriginalPrice()));
            this.tvPrice.setText(AppUtils.showPrice(ProductDetailAdapter.this.productDetailsResult.getCurrencySymbol(), !ProductDetailAdapter.this.productDetailsResult.getProductDiscountPrice().equals("") ? ProductDetailAdapter.this.productDetailsResult.getProductDiscountPrice() : ProductDetailAdapter.this.productDetailsResult.getProductOriginalPrice()));
            TextView textView = this.tvDiscountPrice;
            if (!ProductDetailAdapter.this.productDetailsResult.getProductDiscountPrice().equals("")) {
                i2 = 0;
            }
            textView.setVisibility(i2);
            TextView textView2 = this.tvDiscountPrice;
            textView2.setPaintFlags(textView2.getPaintFlags() | 16);
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362088})
        public void setAdd() {
            ProductDetailAdapter.this.listener.onClickQuantity(ConversionUtils.parseInt(this.ivCount.getText().toString()) + 1);
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362097})
        public void setMin() {
            int parseInt = ConversionUtils.parseInt(this.ivCount.getText().toString());
            if (parseInt > 1) {
                ProductDetailAdapter.this.listener.onClickQuantity(parseInt - 1);
            }
        }

        public void updateRemainingTime() {
            if (this.llDealView != null) {
                long access$300 = ProductDetailAdapter.this.offEnd - System.currentTimeMillis();
                if (access$300 > 0) {
                    long j = (access$300 / 1000) % 60;
                    long j2 = (access$300 / 60000) % 60;
                    long j3 = (access$300 / 3600000) % 24;
                    long j4 = access$300 / 86400000;
                    this.tvDays.setText(ConversionUtils.parseTimer(j4));
                    this.tvDayTxt.setText(ResourceUtils.getCamelCase(ConversionUtils.parseInt(j4) > 1 ? R.string.days : R.string.day));
                    this.tvHours.setText(ConversionUtils.parseTimer(j3));
                    this.tvHoursTxt.setText(ResourceUtils.getCamelCase(ConversionUtils.parseInt(j3) > 1 ? R.string.hrs : R.string.hr));
                    this.tvMinutes.setText(ConversionUtils.parseTimer(j2));
                    this.tvMinutesTxt.setText(ResourceUtils.getCamelCase(ConversionUtils.parseInt(j2) > 1 ? R.string.mins : R.string.min));
                    this.tvSec.setText(ConversionUtils.parseTimer(j));
                    this.tvSecTxt.setText(ResourceUtils.getCamelCase(ConversionUtils.parseInt(j) > 1 ? R.string.secs : R.string.sec));
                    return;
                }
                this.llDealView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$ColorViewHolder */
    class ColorViewHolder extends MyAdapter.ItemViewHolder {
        ColorAdapter colorAdapter;
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f246rv;

        public ColorViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            new StartSnapHelper().attachToRecyclerView(this.f246rv);
            ViewCompat.setNestedScrollingEnabled(this.f246rv, false);
        }

        public void update(int i) {
            super.update(i);
            ColorAdapter colorAdapter2 = this.colorAdapter;
            if (colorAdapter2 == null) {
                ColorAdapter colorAdapter3 = new ColorAdapter(ProductDetailAdapter.this.productDetailsResult.getProductColorDetails(), new ColorAdapter.Listener() {
                    public final void onClickColor(int i, int i2) {
                        ProductDetailAdapter.ColorViewHolder.this.lambda$update$0$ProductDetailAdapter$ColorViewHolder(i, i2);
                    }
                });
                this.colorAdapter = colorAdapter3;
                colorAdapter3.setPosition(ProductDetailAdapter.this.selectColor);
                this.f246rv.setAdapter(this.colorAdapter);
                return;
            }
            colorAdapter2.setPosition(ProductDetailAdapter.this.selectColor);
            this.colorAdapter.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$ProductDetailAdapter$ColorViewHolder(int i, int i2) {
            ProductDetailAdapter.this.listener.onClickColor(i, i2);
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SizeViewHolder */
    class SizeViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f248rv;
        SizeAdapter sizeAdapter;

        public SizeViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            new StartSnapHelper().attachToRecyclerView(this.f248rv);
            ViewCompat.setNestedScrollingEnabled(this.f248rv, false);
        }

        public void update(int i) {
            super.update(i);
            SizeAdapter sizeAdapter2 = this.sizeAdapter;
            if (sizeAdapter2 == null) {
                SizeAdapter sizeAdapter3 = new SizeAdapter(ProductDetailAdapter.this.productDetailsResult.getProductSizeDetails(), new SizeAdapter.Listener() {
                    public final void onClickSize(int i, int i2) {
                        ProductDetailAdapter.SizeViewHolder.this.lambda$update$0$ProductDetailAdapter$SizeViewHolder(i, i2);
                    }
                });
                this.sizeAdapter = sizeAdapter3;
                sizeAdapter3.setPosition(ProductDetailAdapter.this.selectSize);
                this.f248rv.setAdapter(this.sizeAdapter);
                return;
            }
            sizeAdapter2.setPosition(ProductDetailAdapter.this.selectSize);
            this.sizeAdapter.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$ProductDetailAdapter$SizeViewHolder(int i, int i2) {
            ProductDetailAdapter.this.listener.onClickSize(i, i2);
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$TextViewHolder */
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
            this.tvHead.setText((String) ProductDetailAdapter.this.objectList.get(i));
            this.btnSeeAll.setVisibility(8);
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$CancellationPolicyViewHolder */
    class CancellationPolicyViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131362395)
        TextView tvPolicy;

        CancellationPolicyViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_ploicy_details);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            if (ProductDetailAdapter.this.productDetailsResult.getCancelPolicy().getPolicyDesc() != null) {
                this.tvPolicy.setText(ProductDetailAdapter.this.productDetailsResult.getCancelPolicy().getNoOfDays());
            }
        }

        public void onClick(View view) {
            ProductDetailAdapter.this.listener.onClickPolicyDetails(ResourceUtils.getString(R.string.cancellation_policy_details), ProductDetailAdapter.this.productDetailsResult.getCancelPolicy().getPolicyDesc());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$ReturnPolicyViewHolder */
    class ReturnPolicyViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131362395)
        TextView tvPolicy;

        ReturnPolicyViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_ploicy_details);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            if (ProductDetailAdapter.this.productDetailsResult.getReturnPolicy().getPolicyDesc() != null) {
                this.tvPolicy.setText(ProductDetailAdapter.this.productDetailsResult.getReturnPolicy().getNoOfDays());
            }
        }

        public void onClick(View view) {
            ProductDetailAdapter.this.listener.onClickPolicyDetails(ResourceUtils.getString(R.string.return_policy_details), ProductDetailAdapter.this.productDetailsResult.getReturnPolicy().getPolicyDesc());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$ReplacePolicyViewHolder */
    class ReplacePolicyViewHolder extends MyAdapter.ItemViewHolder implements View.OnClickListener {
        @BindView(2131362395)
        TextView tvPolicy;

        ReplacePolicyViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_ploicy_details);
            this.itemView.setOnClickListener(this);
        }

        public void update(int i) {
            super.update(i);
            if (ProductDetailAdapter.this.productDetailsResult.getReplacePolicy().getPolicyDesc() != null) {
                this.tvPolicy.setText(ProductDetailAdapter.this.productDetailsResult.getReplacePolicy().getNoOfDays());
            }
        }

        public void onClick(View view) {
            ProductDetailAdapter.this.listener.onClickPolicyDetails(ResourceUtils.getString(R.string.replace_policy_details), ProductDetailAdapter.this.productDetailsResult.getReplacePolicy().getPolicyDesc());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$RelatedProductViewHolder */
    class RelatedProductViewHolder extends MyAdapter.ItemViewHolder {
        RelatedProductAdapter relatedProductAdapter;
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f247rv;

        public RelatedProductViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            new StartSnapHelper().attachToRecyclerView(this.f247rv);
            ViewCompat.setNestedScrollingEnabled(this.f247rv, false);
        }

        public void update(int i) {
            super.update(i);
            RelatedProductAdapter relatedProductAdapter2 = this.relatedProductAdapter;
            if (relatedProductAdapter2 == null) {
                RelatedProductAdapter relatedProductAdapter3 = new RelatedProductAdapter(ProductDetailAdapter.this.productDetailsResult.getRelatedProducts(), new RelatedProductAdapter.Listener() {
                    public final void onClickItem(RelatedProduct relatedProduct) {
                        ProductDetailAdapter.RelatedProductViewHolder.this.lambda$update$0$ProductDetailAdapter$RelatedProductViewHolder(relatedProduct);
                    }
                });
                this.relatedProductAdapter = relatedProductAdapter3;
                this.f247rv.setAdapter(relatedProductAdapter3);
                return;
            }
            relatedProductAdapter2.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$ProductDetailAdapter$RelatedProductViewHolder(RelatedProduct relatedProduct) {
            ProductDetailAdapter.this.listener.onClickProduct(relatedProduct.getProductId().intValue());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder */
    class SpecificationHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362009)
        EditText etDescription;
        @BindView(2131362025)
        EditText etSummary;
        @BindView(2131362225)
        LinearLayout ratingView;
        @BindView(2131362227)

        /* renamed from: rb */
        RatingBar f249rb;
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f250rv;
        @BindView(2131362052)
        TabLayout tabLayout;
        @BindView(2131362394)
        TextView tvNoRecord;

        public SpecificationHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_frame_layout);
            new StartSnapHelper().attachToRecyclerView(this.f250rv);
            ViewCompat.setNestedScrollingEnabled(this.f250rv, false);
        }

        public void update(int i) {
            super.update(i);
            if (this.tabLayout.getTabCount() == 0) {
                TabLayout tabLayout2 = this.tabLayout;
                tabLayout2.addTab(tabLayout2.newTab().setText((CharSequence) ResourceUtils.getString(R.string.specs)));
                TabLayout tabLayout3 = this.tabLayout;
                tabLayout3.addTab(tabLayout3.newTab().setText((CharSequence) ResourceUtils.getString(R.string.reviews)));
            }
            this.f249rb.setRating(0.0f);
            this.etSummary.setText("");
            this.etDescription.setText("");
            this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                public void onTabReselected(TabLayout.Tab tab) {
                }

                public void onTabUnselected(TabLayout.Tab tab) {
                }

                public void onTabSelected(TabLayout.Tab tab) {
                    ProductDetailAdapter.this.listener.onTabSelected(SpecificationHolder.this.tabLayout.getSelectedTabPosition());
                    if (SpecificationHolder.this.tabLayout.getSelectedTabPosition() == 0) {
                        SpecificationHolder.this.ratingView.setVisibility(8);
                        if (ProductDetailAdapter.this.productDetailsResult.getProductSpecificationDetails().size() > 0) {
                            SpecificationHolder.this.f250rv.setAdapter(new SpecificationAdapter(ProductDetailAdapter.this.productDetailsResult.getProductSpecificationDetails()));
                            return;
                        }
                        SpecificationHolder.this.tvNoRecord.setVisibility(0);
                        SpecificationHolder.this.f250rv.setAdapter(new SpecificationAdapter(ProductDetailAdapter.this.productDetailsResult.getProductSpecificationDetails()));
                        return;
                    }
                    SpecificationHolder.this.ratingView.setVisibility(0);
                    SpecificationHolder.this.tvNoRecord.setVisibility(8);
                    SpecificationHolder.this.f250rv.setAdapter(new ReviewAdapter(ProductDetailAdapter.this.productDetailsResult.getProductReview(), 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009a: INVOKE  
                          (wrap: androidx.recyclerview.widget.RecyclerView : 0x0098: IGET  (r0v9 androidx.recyclerview.widget.RecyclerView) = 
                          (wrap: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder : 0x0096: IGET  (r0v8 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder) = 
                          (r2v0 'this' com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder$1 A[THIS])
                         com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.1.this$1 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder)
                         com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.rv androidx.recyclerview.widget.RecyclerView)
                          (wrap: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter : 0x0093: CONSTRUCTOR  (r3v11 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter) = 
                          (wrap: java.util.List<com.kiandashopping.kiandashopping.model.itemdetails.ProductReview> : 0x008a: INVOKE  (r0v7 java.util.List<com.kiandashopping.kiandashopping.model.itemdetails.ProductReview>) = 
                          (wrap: com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult : 0x0086: INVOKE  (r0v6 com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult) = 
                          (wrap: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter : 0x0084: IGET  (r0v5 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter) = 
                          (wrap: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder : 0x0082: IGET  (r0v4 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder) = 
                          (r2v0 'this' com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder$1 A[THIS])
                         com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.1.this$1 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder)
                         com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this$0 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter)
                         com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.access$100(com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter):com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult type: STATIC)
                         com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult.getProductReview():java.util.List type: VIRTUAL)
                          (wrap: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI : 0x0090: CONSTRUCTOR  (r1v1 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI) = 
                          (r2v0 'this' com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder$1 A[THIS])
                         call: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI.<init>(com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder$1):void type: CONSTRUCTOR)
                         call: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter.<init>(java.util.List, com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter$Listener):void type: CONSTRUCTOR)
                         androidx.recyclerview.widget.RecyclerView.setAdapter(androidx.recyclerview.widget.RecyclerView$Adapter):void type: VIRTUAL in method: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.1.onTabSelected(com.google.android.material.tabs.TabLayout$Tab):void, dex: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0093: CONSTRUCTOR  (r3v11 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter) = 
                          (wrap: java.util.List<com.kiandashopping.kiandashopping.model.itemdetails.ProductReview> : 0x008a: INVOKE  (r0v7 java.util.List<com.kiandashopping.kiandashopping.model.itemdetails.ProductReview>) = 
                          (wrap: com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult : 0x0086: INVOKE  (r0v6 com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult) = 
                          (wrap: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter : 0x0084: IGET  (r0v5 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter) = 
                          (wrap: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder : 0x0082: IGET  (r0v4 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder) = 
                          (r2v0 'this' com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder$1 A[THIS])
                         com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.1.this$1 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder)
                         com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this$0 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter)
                         com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.access$100(com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter):com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult type: STATIC)
                         com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult.getProductReview():java.util.List type: VIRTUAL)
                          (wrap: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI : 0x0090: CONSTRUCTOR  (r1v1 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI) = 
                          (r2v0 'this' com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder$1 A[THIS])
                         call: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI.<init>(com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder$1):void type: CONSTRUCTOR)
                         call: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter.<init>(java.util.List, com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter$Listener):void type: CONSTRUCTOR in method: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.1.onTabSelected(com.google.android.material.tabs.TabLayout$Tab):void, dex: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	... 80 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0090: CONSTRUCTOR  (r1v1 com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI) = 
                          (r2v0 'this' com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder$1 A[THIS])
                         call: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI.<init>(com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder$1):void type: CONSTRUCTOR in method: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.1.onTabSelected(com.google.android.material.tabs.TabLayout$Tab):void, dex: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	... 86 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	... 92 more
                        */
                    /*
                        this = this;
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r3 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter r3 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.this
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$Listener r3 = r3.listener
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        com.google.android.material.tabs.TabLayout r0 = r0.tabLayout
                        int r0 = r0.getSelectedTabPosition()
                        r3.onTabSelected(r0)
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r3 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        com.google.android.material.tabs.TabLayout r3 = r3.tabLayout
                        int r3 = r3.getSelectedTabPosition()
                        r0 = 8
                        r1 = 0
                        if (r3 != 0) goto L_0x0072
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r3 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        android.widget.LinearLayout r3 = r3.ratingView
                        r3.setVisibility(r0)
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r3 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter r3 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.this
                        com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult r3 = r3.productDetailsResult
                        java.util.List r3 = r3.getProductSpecificationDetails()
                        int r3 = r3.size()
                        if (r3 <= 0) goto L_0x0052
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecificationAdapter r3 = new com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecificationAdapter
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.this
                        com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult r0 = r0.productDetailsResult
                        java.util.List r0 = r0.getProductSpecificationDetails()
                        r3.<init>(r0)
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        androidx.recyclerview.widget.RecyclerView r0 = r0.f250rv
                        r0.setAdapter(r3)
                        goto L_0x009d
                    L_0x0052:
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r3 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        android.widget.TextView r3 = r3.tvNoRecord
                        r3.setVisibility(r1)
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecificationAdapter r3 = new com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SpecificationAdapter
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.this
                        com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult r0 = r0.productDetailsResult
                        java.util.List r0 = r0.getProductSpecificationDetails()
                        r3.<init>(r0)
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        androidx.recyclerview.widget.RecyclerView r0 = r0.f250rv
                        r0.setAdapter(r3)
                        goto L_0x009d
                    L_0x0072:
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r3 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        android.widget.LinearLayout r3 = r3.ratingView
                        r3.setVisibility(r1)
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r3 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        android.widget.TextView r3 = r3.tvNoRecord
                        r3.setVisibility(r0)
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter r3 = new com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ReviewAdapter
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.this
                        com.kiandashopping.kiandashopping.model.itemdetails.ProductDetailsResult r0 = r0.productDetailsResult
                        java.util.List r0 = r0.getProductReview()
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI r1 = new com.kiandashopping.kiandashopping.ui.itemdetails.adapter.-$$Lambda$ProductDetailAdapter$SpecificationHolder$1$GF2PlCqDYMUT9PDhhH9MNWagcrI
                        r1.<init>(r2)
                        r3.<init>(r0, r1)
                        com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$SpecificationHolder r0 = com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.this
                        androidx.recyclerview.widget.RecyclerView r0 = r0.f250rv
                        r0.setAdapter(r3)
                    L_0x009d:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter.ProductDetailAdapter.SpecificationHolder.C15541.onTabSelected(com.google.android.material.tabs.TabLayout$Tab):void");
                }

                /* renamed from: lambda$onTabSelected$0$ProductDetailAdapter$SpecificationHolder$1 */
                public /* synthetic */ void mo26787x6b81bb4b() {
                    ProductDetailAdapter.this.listener.onMoreReview();
                }
            });
            this.ratingView.setVisibility(8);
            if (ProductDetailAdapter.this.productDetailsResult.getProductSpecificationDetails().size() > 0) {
                this.f250rv.setAdapter(new SpecificationAdapter(ProductDetailAdapter.this.productDetailsResult.getProductSpecificationDetails()));
            } else {
                this.tvNoRecord.setVisibility(0);
                this.f250rv.setAdapter(new SpecificationAdapter(ProductDetailAdapter.this.productDetailsResult.getProductSpecificationDetails()));
            }
            if (ProductDetailAdapter.this.tabSelected == 0) {
                this.ratingView.setVisibility(8);
                if (ProductDetailAdapter.this.productDetailsResult.getProductSpecificationDetails().size() > 0) {
                    this.f250rv.setAdapter(new SpecificationAdapter(ProductDetailAdapter.this.productDetailsResult.getProductSpecificationDetails()));
                } else {
                    this.tvNoRecord.setVisibility(0);
                    this.f250rv.setAdapter(new SpecificationAdapter(ProductDetailAdapter.this.productDetailsResult.getProductSpecificationDetails()));
                }
            } else {
                this.ratingView.setVisibility(0);
                this.tvNoRecord.setVisibility(8);
                this.f250rv.setAdapter(new ReviewAdapter(ProductDetailAdapter.this.productDetailsResult.getProductReview(), new ReviewAdapter.Listener() {
                    public final void onMoreReview() {
                        ProductDetailAdapter.SpecificationHolder.this.lambda$update$0$ProductDetailAdapter$SpecificationHolder();
                    }
                }));
            }
            ((TabLayout.Tab) Objects.requireNonNull(this.tabLayout.getTabAt(ProductDetailAdapter.this.tabSelected))).select();
        }

        public /* synthetic */ void lambda$update$0$ProductDetailAdapter$SpecificationHolder() {
            ProductDetailAdapter.this.listener.onMoreReview();
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131361908})
        public void sendButton() {
            ProductDetailAdapter.this.listener.onClickSendReview(this.f249rb.getRating(), this.etSummary.getText().toString(), this.etDescription.getText().toString());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.ProductDetailAdapter$StoreDetailsViewHolder */
    class StoreDetailsViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362065)
        ImageView icStoreCall;
        @BindView(2131362069)
        ImageView icStoreNavigation;
        @BindView(2131362070)
        ImageView icStoreNavigationWeb;
        @BindView(2131362106)
        ImageView ivStore;
        StoreDetail storeDetail;
        @BindView(2131362415)
        TextView tvStoreDesc;
        @BindView(2131362416)
        TextView tvStoreName;

        StoreDetailsViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_store_information);
        }

        public void update(int i) {
            super.update(i);
            List<StoreDetail> storeDetails = ProductDetailAdapter.this.productDetailsResult.getStoreDetails();
            if (storeDetails.size() > 0) {
                this.storeDetail = storeDetails.get(0);
                GlideUtils.showImage(BaseApplication.getContext(), this.ivStore, (Drawable) AppUtils.getProgressDrawable(), this.storeDetail.getStoreImg());
                this.tvStoreName.setText(this.storeDetail.getStoreName());
                this.tvStoreDesc.setText(AppUtils.append(this.storeDetail.getStoreAddress1(), this.storeDetail.getStoreAddress2()));
            }
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362065})
        public void setIcStoreCall() {
            if (ProductDetailAdapter.this.productDetailsResult.getStoreDetails().size() > 0) {
                ProductDetailAdapter.this.listener.onCallStore(ProductDetailAdapter.this.productDetailsResult.getStoreDetails().get(0).getStorePhone());
            }
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362069})
        public void setIcStoreNavigation() {
            if (ProductDetailAdapter.this.productDetailsResult.getStoreDetails().size() > 0) {
                ProductDetailAdapter.this.listener.onNavigation(ProductDetailAdapter.this.productDetailsResult.getStoreDetails().get(0).getStoreLatitude(), ProductDetailAdapter.this.productDetailsResult.getStoreDetails().get(0).getStoreLongitude());
            }
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362070})
        public void setIcStoreWeb() {
            if (ProductDetailAdapter.this.productDetailsResult.getStoreDetails().size() > 0) {
                ProductDetailAdapter.this.listener.onWeb(ProductDetailAdapter.this.productDetailsResult.getStoreDetails().get(0).getStoreWebsite());
            }
        }
    }
}
