package com.kiandashopping.kiandashopping.customview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.maps.SupportMapFragment;

public class WorkaroundMapFragment extends SupportMapFragment {
    /* access modifiers changed from: private */
    public OnTouchListener mListener;

    public interface OnTouchListener {
        void onTouch();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        TouchableWrapper touchableWrapper = new TouchableWrapper(getActivity());
        touchableWrapper.setBackgroundColor(getResources().getColor(17170445));
        ((ViewGroup) onCreateView).addView(touchableWrapper, new ViewGroup.LayoutParams(-1, -1));
        return onCreateView;
    }

    public void setListener(OnTouchListener onTouchListener) {
        this.mListener = onTouchListener;
    }

    public class TouchableWrapper extends FrameLayout {
        public TouchableWrapper(Context context) {
            super(context);
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                WorkaroundMapFragment.this.mListener.onTouch();
            } else if (action == 1) {
                WorkaroundMapFragment.this.mListener.onTouch();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }
}
