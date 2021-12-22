package com.innomalist.taxi.shoppingapp.customview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MyAdapter<VH extends MyAdapter.ItemViewHolder> extends AbstractAdapter<VH> implements View.OnClickListener {
    public static final int VT_FOOTER = -1002;
    public static final int VT_HEADER = -1001;
    public static final int VT_LOADING = -1003;
    public static final int VT_LOADING_ERROR = -1004;
    public static final int VT_LOADING_MORE = -1005;
    public static final int VT_LOADING_MORE_ERROR = -1006;
    public static final int VT_NO_ITEM = -1000;
    boolean binding = false;
    EndlessRecyclerViewScrollListener endlessRvScrollListener;
    String errorMessage;
    private ItemViewHolder footer;
    List<Integer> fullWidthViewTypes = Arrays.asList(new Integer[]{-1000, Integer.valueOf(VT_HEADER), Integer.valueOf(VT_FOOTER), Integer.valueOf(VT_LOADING), Integer.valueOf(VT_LOADING_ERROR), Integer.valueOf(VT_LOADING_MORE), Integer.valueOf(VT_LOADING_MORE_ERROR)});
    private ItemViewHolder header;
    HeaderCreatedListener headerCreatedListener;
    boolean isLoadingErrorVisible = false;
    boolean isLoadingMoreErrorVisible = false;
    boolean isLoadingMoreVisible = false;
    boolean isLoadingVisible = false;
    boolean isNoItemVisible = false;
    protected Listener listener;
    private MyAdapter<VH>.LoadingErrorViewHolder loadingErrorViewHolder;
    private MyAdapter<VH>.LoadingMoreErrorViewHolder loadingMoreErrorViewHolder;
    private MyAdapter<VH>.LoadingMoreViewHolder loadingMoreViewHolder;
    private MyAdapter<VH>.LoadingViewHolder loadingViewHolder;
    private MyAdapter<VH>.NoItemViewHolder noItemViewHolder;
    public ViewGroup parent;
    RecyclerView recyclerView;

    public interface HeaderCreatedListener {
        void onHeaderCreated(ItemViewHolder itemViewHolder);
    }

    public interface Listener {
        void onClickLoad(int i);
    }

    public abstract int _getItemCount();

    public int _getItemViewType(int i) {
        return 0;
    }

    public int getBgBottom() {
        return 0;
    }

    public int getBgCenter() {
        return 0;
    }

    public int getBgSingle() {
        return 0;
    }

    public int getBgTop() {
        return 0;
    }

    public ItemViewHolder getFooterViewHolder() {
        return null;
    }

    public ItemViewHolder getHeaderViewHolder() {
        return null;
    }

    public String getNoItemMessage() {
        return null;
    }

    public int getNoItemResource() {
        return 0;
    }

    public boolean isFooter() {
        return false;
    }

    public boolean isHeader() {
        return false;
    }

    public boolean isLoadingEnabled() {
        return false;
    }

    public boolean isNoItemEnabled() {
        return true;
    }

    public abstract VH onCreateHolder(int i);

    public boolean isNoItemVisible() {
        return this.isNoItemVisible;
    }

    public boolean isLoadingVisible() {
        return this.isLoadingVisible;
    }

    public boolean isLoadingErrorVisible() {
        return this.isLoadingErrorVisible;
    }

    public MyAdapter(Listener listener2) {
        this.listener = listener2;
    }

    public void reset() {
        setNoItemVisible(false);
        setLoadingVisible(true);
        this.isLoadingErrorVisible = false;
        this.isLoadingMoreVisible = false;
        this.isLoadingMoreErrorVisible = false;
        notifyDataSetChanged();
        EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener = this.endlessRvScrollListener;
        if (endlessRecyclerViewScrollListener != null) {
            endlessRecyclerViewScrollListener.reset();
        }
    }

    public void reLoad() {
        reset();
        this.listener.onClickLoad(0);
    }

    public int getPageIndex() {
        return this.endlessRvScrollListener.getCurrentPage();
    }

    public String getPageNumber() {
        return String.valueOf(this.endlessRvScrollListener.getCurrentPage() + 1);
    }

    public void onLoadFailed(String str) {
        this.errorMessage = str;
        if (this.isLoadingVisible) {
            setLoadingVisible(false);
            setLoadingErrorVisible(true);
            notifyDataSetChanged();
        } else if (this.isLoadingMoreVisible) {
            this.isLoadingMoreVisible = false;
            this.isLoadingMoreErrorVisible = true;
            notifyItemChanged(getItemCount());
        }
    }

    private void setLoadingVisible(boolean z) {
        this.isLoadingVisible = z;
    }

    private void setLoadingErrorVisible(boolean z) {
        this.isLoadingErrorVisible = z;
    }

    private void setNoItemVisible(boolean z) {
        this.isNoItemVisible = z;
    }

    public void onLoadFinished(int i) {
        if (this.isLoadingVisible) {
            setLoadingVisible(false);
            if (i == 0) {
                setNoItemVisible(true);
            }
            notifyDataSetChanged();
        } else if (this.isLoadingMoreVisible) {
            this.isLoadingMoreVisible = false;
            if (i == 0) {
                $notifyItemRemoved(getItemCount());
            }
        } else if (i == 0 && !isLoadMoreEnabled()) {
            setNoItemVisible(true);
            notifyDataSetChanged();
        }
        if (i != 0) {
            int itemCount = getItemCount();
            notifyItemRangeInserted(itemCount, i + itemCount);
            EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener = this.endlessRvScrollListener;
            if (endlessRecyclerViewScrollListener != null) {
                endlessRecyclerViewScrollListener.loadingFinished(getItemCount());
            }
        }
    }

    public void onClickLoad() {
        Log.d("ON_CLICK", "" + _getItemCount());
        if (_getItemCount() == 0) {
            if (this.isLoadingErrorVisible) {
                setLoadingErrorVisible(false);
            }
            setLoadingVisible(true);
            notifyDataSetChanged();
        } else {
            if (this.isLoadingMoreErrorVisible) {
                this.isLoadingMoreErrorVisible = false;
                $notifyItemRemoved(getItemCount());
            }
            if (isLoadMoreEnabled()) {
                this.isLoadingMoreVisible = true;
                $notifyItemInserted(getItemCount() - 1);
            }
        }
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onClickLoad(_getItemCount());
        }
    }

    public void _notifyItemRemoved(int i) {
        if (isHeader()) {
            i++;
        }
        $notifyItemRemoved(i);
    }

    public void $notifyItemRemoved(int i) {
        if (i > 0) {
            notifyItemChanged(i - 1);
        }
        notifyItemRemoved(i);
    }

    public void _notifyItemInserted(int i) {
        if (isHeader()) {
            i++;
        }
        $notifyItemInserted(i);
    }

    public void $notifyItemInserted(int i) {
        if (i > 0) {
            notifyItemChanged(i - 1);
        }
        notifyItemInserted(i);
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public void setFullWidthViewTypes(List<Integer> list) {
        ArrayList arrayList = new ArrayList(this.fullWidthViewTypes);
        this.fullWidthViewTypes = arrayList;
        arrayList.addAll(list);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView2) {
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                public int getSpanSize(int i) {
                    boolean z = false;
                    for (Integer intValue : MyAdapter.this.fullWidthViewTypes) {
                        if (intValue.intValue() == MyAdapter.this.getItemViewType(i)) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                    if (z) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return 1;
                }
            });
        }
        this.isLoadingVisible = _getItemCount() == 0;
        this.recyclerView = recyclerView2;
        if (isLoadMoreEnabled()) {
            EndlessRecyclerViewScrollListener r0 = new EndlessRecyclerViewScrollListener(recyclerView2.getLayoutManager()) {
                public void onLoadMore(int i, int i2) {
                    MyAdapter.this.recyclerView.post(new Runnable() {
                        public void run() {
                            MyAdapter.this.onClickLoad();
                        }
                    });
                }
            };
            this.endlessRvScrollListener = r0;
            recyclerView2.addOnScrollListener(r0);
        }
        super.onAttachedToRecyclerView(recyclerView2);
        onClickLoad();
    }

    public ItemViewHolder getHeader() {
        return this.header;
    }

    public ItemViewHolder getFooter() {
        return this.footer;
    }

    public final void _notifyItemRangeInserted(int i, int i2) {
        int i3 = i - 2;
        if (i3 > -1) {
            notifyItemChanged(i3);
        }
        super.notifyItemRangeInserted(i + (isHeader() ? 1 : 0), i2);
    }

    public final void _notifyItemRangeRemoved(int i, int i2) {
        super.notifyItemRangeRemoved(i + (isHeader() ? 1 : 0), i2);
    }

    public final void _notifyItemChanged(int i) {
        super.notifyItemChanged(i + (isHeader() ? 1 : 0));
    }

    public final void _notifyItemRangeChanged(int i, int i2) {
        super.notifyItemRangeChanged(i + (isHeader() ? 1 : 0), i2);
    }

    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.parent = viewGroup;
        switch (i) {
            case VT_LOADING_MORE_ERROR /*-1006*/:
                VH loadingMoreErrorViewHolder2 = new LoadingMoreErrorViewHolder();
                this.loadingMoreErrorViewHolder = loadingMoreErrorViewHolder2;
                return loadingMoreErrorViewHolder2;
            case VT_LOADING_MORE /*-1005*/:
                VH loadingMoreViewHolder2 = new LoadingMoreViewHolder();
                this.loadingMoreViewHolder = loadingMoreViewHolder2;
                return loadingMoreViewHolder2;
            case VT_LOADING_ERROR /*-1004*/:
                VH loadingErrorViewHolder2 = new LoadingErrorViewHolder();
                this.loadingErrorViewHolder = loadingErrorViewHolder2;
                return loadingErrorViewHolder2;
            case VT_LOADING /*-1003*/:
                VH loadingViewHolder2 = new LoadingViewHolder();
                this.loadingViewHolder = loadingViewHolder2;
                return loadingViewHolder2;
            case VT_FOOTER /*-1002*/:
                VH footerViewHolder = getFooterViewHolder();
                this.footer = footerViewHolder;
                return footerViewHolder;
            case VT_HEADER /*-1001*/:
                VH headerViewHolder = getHeaderViewHolder();
                this.header = headerViewHolder;
                HeaderCreatedListener headerCreatedListener2 = this.headerCreatedListener;
                if (headerCreatedListener2 == null) {
                    return headerViewHolder;
                }
                headerCreatedListener2.onHeaderCreated(headerViewHolder);
                return headerViewHolder;
            case -1000:
                VH noItemViewHolder2 = new NoItemViewHolder();
                this.noItemViewHolder = noItemViewHolder2;
                return noItemViewHolder2;
            default:
                return onCreateHolder(i);
        }
    }

    public void setHeaderCreatedListener(HeaderCreatedListener headerCreatedListener2) {
        this.headerCreatedListener = headerCreatedListener2;
    }

    public boolean isBinding() {
        return this.binding;
    }

    public void onBindViewHolder(VH vh, int i) {
        if (i >= 0) {
            this.binding = true;
            vh.update(i - (isHeader() ? 1 : 0));
            this.binding = false;
        }
    }

    public int getItemViewType(int i) {
        if (isNoItemEnabled() && this.isNoItemVisible && i == isHeader() && !this.isLoadingVisible && !this.isLoadingErrorVisible) {
            return -1000;
        }
        if (this.isLoadingMoreVisible && i == getItemCount() - 1) {
            return VT_LOADING_MORE;
        }
        if (this.isLoadingMoreErrorVisible && i == getItemCount() - 1) {
            return VT_LOADING_MORE_ERROR;
        }
        if (isLoadingEnabled() && this.isLoadingVisible && i == isHeader()) {
            return VT_LOADING;
        }
        if (isFooter() && i == getItemCount() - 1) {
            return VT_FOOTER;
        }
        if (isHeader() && i == 0) {
            return VT_HEADER;
        }
        if (_getItemCount() == 0 && i == isHeader() && this.isLoadingErrorVisible) {
            return VT_LOADING_ERROR;
        }
        return _getItemViewType(i - (isHeader() ? 1 : 0));
    }

    public int getItemCount() {
        int _getItemCount = _getItemCount();
        int i = 1;
        int i2 = (!isLoadingEnabled() || !this.isLoadingVisible) ? 0 : 1;
        boolean z = this.isLoadingErrorVisible;
        if (!isNoItemEnabled() || !this.isNoItemVisible) {
            i = 0;
        }
        return _getItemCount + i2 + i + (isHeader() ? 1 : 0) + (isFooter() ? 1 : 0) + (this.isLoadingMoreVisible ? 1 : 0) + (this.isLoadingMoreErrorVisible ? 1 : 0) + (z ? 1 : 0);
    }

    public static abstract class AbstractViewHolder extends RecyclerView.ViewHolder {
        public abstract void update(int i);

        public AbstractViewHolder(View view) {
            super(view);
        }
    }

    public static abstract class ItemViewHolder extends AbstractViewHolder {

        /* renamed from: bg */
        private int f218bg = 0;
        MyAdapter myAdapter;

        public ItemViewHolder(MyAdapter myAdapter2, int i) {
            super(LayoutInflater.from(myAdapter2.recyclerView.getContext()).inflate(i, myAdapter2.recyclerView, false));
            ButterKnife.bind((Object) this, this.itemView);
            this.myAdapter = myAdapter2;
        }

        public ItemViewHolder(MyAdapter myAdapter2, View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
            this.myAdapter = myAdapter2;
        }

        public void update(int i) {
            if (getAdapterPosition() == 0) {
                if (this.myAdapter.getItemCount() == 1) {
                    if (this.myAdapter.getBgSingle() != 0) {
                        setBb(this.myAdapter.getBgSingle());
                    }
                } else if (this.myAdapter.getBgTop() != 0) {
                    setBb(this.myAdapter.getBgTop());
                }
            } else if (getAdapterPosition() == this.myAdapter.getItemCount() - 1) {
                if (this.myAdapter.getBgBottom() != 0) {
                    setBb(this.myAdapter.getBgBottom());
                }
            } else if (this.myAdapter.getBgCenter() != 0) {
                setBb(this.myAdapter.getBgCenter());
            }
        }

        private void setBb(int i) {
            if (this.f218bg != i) {
                this.itemView.setBackgroundResource(i);
                this.f218bg = i;
            }
        }

        public int _getAdapterPosition() {
            return getAdapterPosition() - (this.myAdapter.isHeader() ? 1 : 0);
        }
    }

    class NoItemViewHolder extends ItemViewHolder {
        TextView tvNoItem;

        public NoItemViewHolder() {
            super((MyAdapter) MyAdapter.this, (int) R.layout.li_no_item);
            TextView textView = (TextView) this.itemView.findViewById(R.id.tvNoItem);
            this.tvNoItem = textView;
            textView.setText(MyAdapter.this.getNoItemMessage() != null ? MyAdapter.this.getNoItemMessage() : this.itemView.getResources().getString(R.string.no_item));
            this.tvNoItem.setCompoundDrawablesWithIntrinsicBounds(0, MyAdapter.this.getNoItemResource(), 0, 0);
        }

        public void update(int i) {
            super.update(i);
        }
    }

    class LoadingErrorViewHolder extends ItemViewHolder {
        LinearLayout llLoadingError = ((LinearLayout) this.itemView.findViewById(R.id.llLoadingError));
        TextView tvLoadingError;

        public LoadingErrorViewHolder() {
            super((MyAdapter) MyAdapter.this, (int) R.layout.li_loading_error);
            TextView textView = (TextView) this.itemView.findViewById(R.id.tvLoadingError);
            this.tvLoadingError = textView;
            textView.setCompoundDrawablesWithIntrinsicBounds(0, MyAdapter.this.getNoItemResource(), 0, 0);
            this.llLoadingError.setOnClickListener(MyAdapter.this);
        }

        public void update(int i) {
            super.update(i);
            this.tvLoadingError.setText(ResourceUtils.getString(R.string.loading_error, MyAdapter.this.errorMessage));
        }
    }

    class LoadingViewHolder extends ItemViewHolder {
        public LoadingViewHolder() {
            super((MyAdapter) MyAdapter.this, (int) R.layout.li_loading);
        }

        public void update(int i) {
            super.update(i);
        }
    }

    class LoadingMoreViewHolder extends ItemViewHolder {
        public LoadingMoreViewHolder() {
            super((MyAdapter) MyAdapter.this, (int) R.layout.li_loading_more);
        }

        public void update(int i) {
            super.update(i);
        }
    }

    class LoadingMoreErrorViewHolder extends ItemViewHolder {
        TextView tvLoadingMoreError;

        public LoadingMoreErrorViewHolder() {
            super((MyAdapter) MyAdapter.this, (int) R.layout.li_loading_more_error);
            TextView textView = (TextView) this.itemView.findViewById(R.id.tvLoadingMoreError);
            this.tvLoadingMoreError = textView;
            textView.setCompoundDrawablesWithIntrinsicBounds(0, MyAdapter.this.getNoItemResource(), 0, 0);
            this.tvLoadingMoreError.setOnClickListener(MyAdapter.this);
        }

        public void update(int i) {
            super.update(i);
            this.tvLoadingMoreError.setText(ResourceUtils.getString(R.string.loading_more_error, MyAdapter.this.errorMessage));
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llLoadingError:
            case R.id.tvLoadingMoreError:
                onClickLoad();
                return;
            case R.id.tvLoadingError:
                onClickLoad();
                return;
            default:
                return;
        }
    }
}
