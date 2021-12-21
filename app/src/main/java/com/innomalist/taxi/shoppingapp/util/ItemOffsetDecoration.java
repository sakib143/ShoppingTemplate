package com.kiandashopping.kiandashopping.util;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
    private int offset;

    public ItemOffsetDecoration(int i) {
        this.offset = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.left = this.offset;
        rect.right = this.offset;
        rect.bottom = this.offset;
        if (recyclerView.getChildAdapterPosition(view) != 0 && recyclerView.getChildAdapterPosition(view) != 1) {
            rect.top = this.offset;
        }
    }
}
