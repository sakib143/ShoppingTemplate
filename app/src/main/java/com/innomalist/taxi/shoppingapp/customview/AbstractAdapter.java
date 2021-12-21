package com.kiandashopping.kiandashopping.customview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.kiandashopping.kiandashopping.customview.MyAdapter;
import java.util.List;

public abstract class AbstractAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements View.OnClickListener {
    public abstract int _getItemCount();

    public abstract int _getItemViewType(int i);

    public abstract int getBgBottom();

    public abstract int getBgCenter();

    public abstract int getBgSingle();

    public abstract int getBgTop();

    public abstract MyAdapter.ItemViewHolder getFooterViewHolder();

    public abstract MyAdapter.ItemViewHolder getHeaderViewHolder();

    public abstract String getNoItemMessage();

    public abstract int getNoItemResource();

    public abstract boolean isFooter();

    public abstract boolean isHeader();

    public abstract boolean isLoadMoreEnabled();

    public abstract boolean isLoadingEnabled();

    public abstract boolean isNoItemEnabled();

    public abstract VH onCreateHolder(int i);

    public abstract void setFullWidthViewTypes(List<Integer> list);
}
