package com.innomalist.taxi.shoppingapp.p011ui.allreviews.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.model.allreviews.AllReviewResult;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import com.kiandashopping.kiandashopping.util.DateTime;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.adapter.AllReviewAdapter */
public class AllReviewAdapter extends MyAdapter<MyAdapter.ItemViewHolder> {
    private Listener listener;
    /* access modifiers changed from: private */
    public List<AllReviewResult> reviewResults;

    /* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.adapter.AllReviewAdapter$Listener */
    public interface Listener extends MyAdapter.Listener {
    }

    public boolean isLoadMoreEnabled() {
        return true;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.adapter.AllReviewAdapter$ViewHolder_ViewBinding */
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

    public AllReviewAdapter(List<AllReviewResult> list, Listener listener2) {
        super(listener2);
        this.listener = listener2;
        this.reviewResults = list;
    }

    public MyAdapter.ItemViewHolder onCreateHolder(int i) {
        return new ViewHolder(this);
    }

    public int _getItemCount() {
        return this.reviewResults.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.allreviews.adapter.AllReviewAdapter$ViewHolder */
    class ViewHolder extends MyAdapter.ItemViewHolder {
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
            AllReviewResult allReviewResult = (AllReviewResult) AllReviewAdapter.this.reviewResults.get(i);
            this.tvRating.setText(allReviewResult.getRatings());
            this.tvReviewTitle.setText(allReviewResult.getReviewTitle());
            this.tvReviewBy.setText(allReviewResult.getCusName());
            this.tvReviewDesc.setText(allReviewResult.getReviewComments());
            this.tvDate.setText(new DateTime(allReviewResult.getReviewDate()).getDisplayDate());
        }
    }
}
