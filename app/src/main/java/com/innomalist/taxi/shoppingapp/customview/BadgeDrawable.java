package com.kiandashopping.kiandashopping.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.apptube.ecommerce.R;
import com.facebook.appevents.AppEventsConstants;

public class BadgeDrawable extends Drawable {
    private Paint mBadgePaint;
    private Paint mBadgePaint1;
    private String mCount = "";
    private Paint mTextPaint;
    private Rect mTxtRect = new Rect();
    private boolean mWillDraw;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public BadgeDrawable(Context context) {
        float dimension = context.getResources().getDimension(R.dimen.badge_text_size);
        Paint paint = new Paint();
        this.mBadgePaint = paint;
        paint.setColor(ContextCompat.getColor(context.getApplicationContext(), R.color.colorAccent));
        this.mBadgePaint.setAntiAlias(true);
        this.mBadgePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.mBadgePaint1 = paint2;
        paint2.setColor(ContextCompat.getColor(context.getApplicationContext(), R.color.colorAccent));
        this.mBadgePaint1.setAntiAlias(true);
        this.mBadgePaint1.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.mTextPaint = paint3;
        paint3.setColor(-1);
        this.mTextPaint.setTypeface(Typeface.DEFAULT);
        this.mTextPaint.setTextSize(dimension);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    public void draw(Canvas canvas) {
        if (this.mWillDraw) {
            Rect bounds = getBounds();
            float f = (float) (bounds.right - bounds.left);
            float max = (Math.max(f, (float) (bounds.bottom - bounds.top)) / 2.0f) / 2.0f;
            float f2 = ((f - max) - 1.0f) + 5.0f;
            float f3 = max - 5.0f;
            if (this.mCount.length() <= 2) {
                double d = (double) max;
                canvas.drawCircle(f2, f3, (float) ((int) (7.5d + d)), this.mBadgePaint1);
                canvas.drawCircle(f2, f3, (float) ((int) (d + 5.5d)), this.mBadgePaint);
            } else {
                double d2 = (double) max;
                canvas.drawCircle(f2, f3, (float) ((int) (8.5d + d2)), this.mBadgePaint1);
                canvas.drawCircle(f2, f3, (float) ((int) (d2 + 6.5d)), this.mBadgePaint);
            }
            Paint paint = this.mTextPaint;
            String str = this.mCount;
            paint.getTextBounds(str, 0, str.length(), this.mTxtRect);
            float f4 = f3 + (((float) (this.mTxtRect.bottom - this.mTxtRect.top)) / 2.0f);
            if (this.mCount.length() > 2) {
                canvas.drawText("99+", f2, f4, this.mTextPaint);
            } else {
                canvas.drawText(this.mCount, f2, f4, this.mTextPaint);
            }
        }
    }

    public void setCount(String str) {
        this.mCount = str;
        this.mWillDraw = !str.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        invalidateSelf();
    }
}
