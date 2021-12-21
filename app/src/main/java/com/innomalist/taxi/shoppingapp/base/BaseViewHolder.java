package com.kiandashopping.kiandashopping.base;

import android.view.View;
import android.view.animation.ScaleAnimation;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private static final long FADE_DURATION = 1000;
    private int lastPosition = -1;

    public abstract void onBind(int i, Object obj);

    public BaseViewHolder(View view) {
        super(view);
        ButterKnife.bind((Object) this, view);
    }

    /* access modifiers changed from: protected */
    public void setAnimation(View view, int i) {
        if (i > this.lastPosition) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(FADE_DURATION);
            view.startAnimation(scaleAnimation);
            this.lastPosition = i;
        }
    }
}
