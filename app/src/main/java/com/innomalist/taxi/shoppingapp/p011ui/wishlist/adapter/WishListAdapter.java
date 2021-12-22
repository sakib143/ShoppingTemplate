package com.innomalist.taxi.shoppingapp.p011ui.wishlist.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.customview.MyAdapter;
import com.innomalist.taxi.shoppingapp.model.wishlist.MyWishListResult;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.GlideUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
//import com.kiandashopping.kiandashopping.customview.MyAdapter;
//import com.kiandashopping.kiandashopping.model.wishlist.MyWishListResult;
//import com.kiandashopping.kiandashopping.p011ui.wishlist.adapter.WishListAdapter;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.GlideUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.adapter.WishListAdapter */
public class WishListAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public List<MyWishListResult> wishListResults;

    /* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.adapter.WishListAdapter$Listener */
    public interface Listener extends MyAdapter.Listener {
        void onAddWishList(int i, int i2);

        void onClickItem(MyWishListResult myWishListResult);
    }

    public boolean isLoadMoreEnabled() {
        return true;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.adapter.WishListAdapter$ViewHolder_ViewBinding */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a013c;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivBg, "field 'ivBg'", ImageView.class);
            viewHolder.tvItem = (TextView) Utils.findRequiredViewAsType(view, R.id.tvItem, "field 'tvItem'", TextView.class);
            viewHolder.tvDiscountDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDiscountDetails, "field 'tvDiscountDetails'", TextView.class);
            viewHolder.tvPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvPrice, "field 'tvPrice'", TextView.class);
            viewHolder.tvDiscount = (TextView) Utils.findRequiredViewAsType(view, R.id.tvDiscount, "field 'tvDiscount'", TextView.class);
            viewHolder.btnAdd = Utils.findRequiredView(view, R.id.linearLayout, "field 'btnAdd'");
            View findRequiredView = Utils.findRequiredView(view, R.id.iv_fav, "field 'ivFav' and method 'setFav'");
            viewHolder.ivFav = (CheckBox) Utils.castView(findRequiredView, R.id.iv_fav, "field 'ivFav'", CheckBox.class);
            this.view7f0a013c = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.setFav();
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.ivBg = null;
                viewHolder.tvItem = null;
                viewHolder.tvDiscountDetails = null;
                viewHolder.tvPrice = null;
                viewHolder.tvDiscount = null;
                viewHolder.btnAdd = null;
                viewHolder.ivFav = null;
                this.view7f0a013c.setOnClickListener((View.OnClickListener) null);
                this.view7f0a013c = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public WishListAdapter(List<MyWishListResult> list, Listener listener2) {
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

    public void removeAt(int i) {
        this.wishListResults.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, this.wishListResults.size());
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.wishlist.adapter.WishListAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
        @BindView(2131362122)
        View btnAdd;
        @BindView(2131362090)
        ImageView ivBg;
        @BindView(2131362108)
        CheckBox ivFav;
        MyWishListResult myWishListResult;
        @BindView(2131362369)
        TextView tvDiscount;
        @BindView(2131362370)
        TextView tvDiscountDetails;
        @BindView(2131362381)
        TextView tvItem;
        @BindView(2131362396)
        TextView tvPrice;

        ViewHolder(MyAdapter myAdapter) {
            super(myAdapter, (int) R.layout.item_wish_list);
        }

        public void update(int i) {
            super.update(i);
            MyWishListResult myWishListResult2 = (MyWishListResult) WishListAdapter.this.wishListResults.get(i);
            this.myWishListResult = myWishListResult2;
            this.tvItem.setText(myWishListResult2.getProductTitle());
            this.tvPrice.setText(AppUtils.showPrice(this.myWishListResult.getProductCurrencySymbol(), this.myWishListResult.getProductOriginalPrice()));
            this.tvDiscount.setText(AppUtils.showPrice(this.myWishListResult.getProductCurrencySymbol(), this.myWishListResult.getProductDiscountPrice()));
            this.tvDiscountDetails.setText(AppUtils.append(this.myWishListResult.getProductDiscountPercentage().intValue(), ResourceUtils.getString(R.string.off_text)));
            TextView textView = this.tvDiscount;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            GlideUtils.showImage(BaseApplication.getContext(), this.ivBg, (Drawable) AppUtils.getProgressDrawable(), this.myWishListResult.getProductImage());
            this.btnAdd.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    WishListAdapter.ViewHolder.this.lambda$update$0$WishListAdapter$ViewHolder(view);
                }
            });
            this.ivFav.setChecked(true);
        }

        public /* synthetic */ void lambda$update$0$WishListAdapter$ViewHolder(View view) {
            WishListAdapter.this.listener.onClickItem(this.myWishListResult);
        }

        /* access modifiers changed from: package-private */
        @OnClick({2131362108})
        public void setFav() {
            WishListAdapter.this.listener.onAddWishList(this.myWishListResult.getProductId().intValue(), getAdapterPosition());
        }
    }
}
