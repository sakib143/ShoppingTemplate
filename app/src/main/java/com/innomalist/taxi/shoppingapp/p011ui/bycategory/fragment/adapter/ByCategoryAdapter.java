package com.innomalist.taxi.shoppingapp.p011ui.bycategory.fragment.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.innomalist.taxi.shoppingapp.model.bycategory.ByCategoryResult;
import com.innomalist.taxi.shoppingapp.model.category.SubCategoryList;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.customview.StartSnapHelper;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter */
public class ByCategoryAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    private static final int VT_BANNER = 1;
    private static final int VT_CATEGORY = 2;
    private static final int VT_MOST_POPULAR = 5;
    private static final int VT_TOP_OFFER = 3;
    private static final int VT_TV = 6;
    private static final int VT_UP_TO_50 = 4;
    /* access modifiers changed from: private */
    public ByCategoryResult byCategoryResult;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<Object> objectList;
    /* access modifiers changed from: private */
    public ArrayList<SubCategoryList> subCategoryLists;

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$AllType */
    public enum AllType {
        CATEGORY,
        TOP_OFFER,
        MOST_POPPULAR
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$Listener */
    public interface Listener {
        void onClick(AllType allType);

        void onClickCategory(int i, String str);

        void onClickItem(int i);
    }

    public boolean isHeader() {
        return false;
    }

    public boolean isLoadMoreEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$CategoryViewHolder_ViewBinding */
    public class CategoryViewHolder_ViewBinding implements Unbinder {
        private CategoryViewHolder target;

        public CategoryViewHolder_ViewBinding(CategoryViewHolder categoryViewHolder, View view) {
            this.target = categoryViewHolder;
            categoryViewHolder.f225rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        }

        public void unbind() {
            CategoryViewHolder categoryViewHolder = this.target;
            if (categoryViewHolder != null) {
                this.target = null;
                categoryViewHolder.f225rv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$MostViewHolder_ViewBinding */
    public class MostViewHolder_ViewBinding implements Unbinder {
        private MostViewHolder target;

        public MostViewHolder_ViewBinding(MostViewHolder mostViewHolder, View view) {
            this.target = mostViewHolder;
            mostViewHolder.f226rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        }

        public void unbind() {
            MostViewHolder mostViewHolder = this.target;
            if (mostViewHolder != null) {
                this.target = null;
                mostViewHolder.f226rv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$TopOfferViewHolder_ViewBinding */
    public class TopOfferViewHolder_ViewBinding implements Unbinder {
        private TopOfferViewHolder target;

        public TopOfferViewHolder_ViewBinding(TopOfferViewHolder topOfferViewHolder, View view) {
            this.target = topOfferViewHolder;
            topOfferViewHolder.f227rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        }

        public void unbind() {
            TopOfferViewHolder topOfferViewHolder = this.target;
            if (topOfferViewHolder != null) {
                this.target = null;
                topOfferViewHolder.f227rv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$TextViewHolder_ViewBinding */
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

    public void setData(ByCategoryResult byCategoryResult2) {
        this.byCategoryResult = byCategoryResult2;
    }

    public void setSubCategoryLists(ArrayList<SubCategoryList> arrayList) {
        this.subCategoryLists = arrayList;
    }

    public ByCategoryAdapter(List<Object> list, Listener listener2) {
        super((MyAdapter.Listener) null);
        this.objectList = list;
        this.listener = listener2;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        if (i == 1) {
            return new BannerViewHolder(this);
        }
        if (i == 2) {
            return new CategoryViewHolder(this);
        }
        if (i == 3) {
            return new TopOfferViewHolder(this);
        }
        if (i != 5) {
            return new TextViewHolder(this);
        }
        return new MostViewHolder(this);
    }

    public int _getItemCount() {
        return this.objectList.size();
    }

    public int _getItemViewType(int i) {
        String str = (String) this.objectList.get(i);
        if (str.equals(AppConstants.KEY_BANNER)) {
            return 1;
        }
        if (str.equals(AppConstants.KEY_CATEGORY)) {
            return 2;
        }
        if (str.equals(AppConstants.KEY_TOP_OFFER)) {
            return 3;
        }
        return str.equals(AppConstants.KEY_MOST_POPULAR) ? 5 : 6;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$TextViewHolder */
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
            String str = (String) ByCategoryAdapter.this.objectList.get(i);
            if (str.equals(ResourceUtils.getString(R.string.category)) || str.equals(ResourceUtils.getString(R.string.flash_deals))) {
                this.btnSeeAll.setVisibility(8);
            } else {
                this.btnSeeAll.setVisibility(0);
            }
            this.tvHead.setText(str);
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131361907})
        public void onClickSeeAll() {
            String str = (String) ByCategoryAdapter.this.objectList.get(getAdapterPosition());
            if (str.equals(ResourceUtils.getString(R.string.category))) {
                ByCategoryAdapter.this.listener.onClick(AllType.CATEGORY);
            } else if (str.equals(ResourceUtils.getString(R.string.best_offer))) {
                ByCategoryAdapter.this.listener.onClick(AllType.TOP_OFFER);
            } else if (str.equals(ResourceUtils.getString(R.string.most_popular))) {
                ByCategoryAdapter.this.listener.onClick(AllType.MOST_POPPULAR);
            }
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$BannerViewHolder */
    class BannerViewHolder extends MyAdapter.ItemViewHolder {
        BannerViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_banner);
        }

        public void update(int i) {
            super.update(i);
            new InfinitePager(this.itemView.getRootView(), "").setData(ByCategoryAdapter.this.byCategoryResult.getBannerDetails());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$CategoryViewHolder */
    class CategoryViewHolder extends MyAdapter.ItemViewHolder {
        CategoryAdapter categoryAdapter;
        List<SubCategoryList> categoryDetails = new ArrayList();
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f225rv;

        public CategoryViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            new StartSnapHelper().attachToRecyclerView(this.f225rv);
        }

        public void update(int i) {
            super.update(i);
            CategoryAdapter categoryAdapter2 = this.categoryAdapter;
            if (categoryAdapter2 == null) {
                this.categoryDetails.addAll(ByCategoryAdapter.this.subCategoryLists);
                CategoryAdapter categoryAdapter3 = new CategoryAdapter(ByCategoryAdapter.this.subCategoryLists, new CategoryAdapter.Listener() {
                    public final void onClickCategory(SubCategoryList subCategoryList) {
                        ByCategoryAdapter.CategoryViewHolder.this.lambda$update$0$ByCategoryAdapter$CategoryViewHolder(subCategoryList);
                    }
                });
                this.categoryAdapter = categoryAdapter3;
                this.f225rv.setAdapter(categoryAdapter3);
                return;
            }
            categoryAdapter2.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$ByCategoryAdapter$CategoryViewHolder(SubCategoryList subCategoryList) {
            ByCategoryAdapter.this.listener.onClickCategory(subCategoryList.getSubCategoryId().intValue(), subCategoryList.getSubCategoryName());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$TopOfferViewHolder */
    class TopOfferViewHolder extends MyAdapter.ItemViewHolder {
        OfferAdapter offerAdapter;
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f227rv;

        TopOfferViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            new StartSnapHelper().attachToRecyclerView(this.f227rv);
        }

        public void update(int i) {
            super.update(i);
            OfferAdapter offerAdapter2 = this.offerAdapter;
            if (offerAdapter2 == null) {
                this.f227rv.setLayoutManager(new GridLayoutManager(BaseApplication.getContext(), 2, 1, false));
                OfferAdapter offerAdapter3 = new OfferAdapter(ByCategoryAdapter.this.byCategoryResult.getProductTopOffer(), new OfferAdapter.Listener() {
                    public final void onClickItem(ProductTopOffer productTopOffer) {
                        ByCategoryAdapter.TopOfferViewHolder.this.lambda$update$0$ByCategoryAdapter$TopOfferViewHolder(productTopOffer);
                    }
                });
                this.offerAdapter = offerAdapter3;
                this.f227rv.setAdapter(offerAdapter3);
                return;
            }
            offerAdapter2.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$ByCategoryAdapter$TopOfferViewHolder(ProductTopOffer productTopOffer) {
            ByCategoryAdapter.this.listener.onClickItem(productTopOffer.getProductId().intValue());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.fragment.adapter.ByCategoryAdapter$MostViewHolder */
    class MostViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362247)

        /* renamed from: rv */
        RecyclerView f226rv;
        MostAdapter top50Adapter;

        MostViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_dashboard_category);
            new StartSnapHelper().attachToRecyclerView(this.f226rv);
        }

        public void update(int i) {
            super.update(i);
            MostAdapter mostAdapter = this.top50Adapter;
            if (mostAdapter == null) {
                this.f226rv.setLayoutManager(new GridLayoutManager(BaseApplication.getContext(), 2, 1, false));
                MostAdapter mostAdapter2 = new MostAdapter(ByCategoryAdapter.this.byCategoryResult.getMostPopularProduct(), new MostAdapter.Listener() {
                    public final void onClickItem(MostPopularProduct mostPopularProduct) {
                        ByCategoryAdapter.MostViewHolder.this.lambda$update$0$ByCategoryAdapter$MostViewHolder(mostPopularProduct);
                    }
                });
                this.top50Adapter = mostAdapter2;
                this.f226rv.setAdapter(mostAdapter2);
                return;
            }
            mostAdapter.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$update$0$ByCategoryAdapter$MostViewHolder(MostPopularProduct mostPopularProduct) {
            ByCategoryAdapter.this.listener.onClickItem(mostPopularProduct.getProductId().intValue());
        }
    }
}
