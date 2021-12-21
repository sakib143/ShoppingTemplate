package com.kiandashopping.kiandashopping.customview;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.apptube.ecommerce.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;
import com.kiandashopping.kiandashopping.customview.CustomInfoWindowAdapter;
import com.kiandashopping.kiandashopping.model.nearme.Snippet;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.NearByFragment;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    /* access modifiers changed from: private */
    public NearByFragment mapActivity;

    public View getInfoContents(Marker marker) {
        return null;
    }

    public CustomInfoWindowAdapter(NearByFragment nearByFragment) {
        this.mapActivity = nearByFragment;
    }

    public View getInfoWindow(final Marker marker) {
        final Snippet snippet = (Snippet) new Gson().fromJson(marker.getSnippet(), Snippet.class);
        View inflate = this.mapActivity.getActivity().getLayoutInflater().inflate(R.layout.store_info_window, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ivThumb);
        ((TextView) inflate.findViewById(R.id.tvName)).setText(snippet.getName().trim());
        ((TextView) inflate.findViewById(R.id.tvType)).setText(snippet.getDescription());
        this.mapActivity.snippet = marker.getSnippet();
        if (this.mapActivity.f241hm.containsKey(snippet.getImage())) {
            imageView.setImageBitmap(this.mapActivity.f241hm.get(snippet.getImage()));
        } else {
            imageView.setImageResource(R.drawable.user_placeholder);
            Glide.with((Fragment) this.mapActivity).asBitmap().load(snippet.getImage()).apply((BaseRequestOptions<?>) RequestOptions.circleCropTransform()).listener(new RequestListener<Bitmap>() {
                public boolean onLoadFailed(GlideException glideException, Object obj, Target<Bitmap> target, boolean z) {
                    return false;
                }

                public boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                    CustomInfoWindowAdapter.this.mapActivity.f241hm.put(snippet.getImage(), bitmap);
                    new Handler(Looper.getMainLooper()).post(new Runnable(marker) {
                        private final /* synthetic */ Marker f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CustomInfoWindowAdapter.C14291.this.lambda$onResourceReady$0$CustomInfoWindowAdapter$1(this.f$1);
                        }
                    });
                    return false;
                }

                public /* synthetic */ void lambda$onResourceReady$0$CustomInfoWindowAdapter$1(Marker marker) {
                    if (CustomInfoWindowAdapter.this.mapActivity.snippet.equals(marker.getSnippet())) {
                        marker.showInfoWindow();
                    }
                }
            }).submit(70, 70);
        }
        return inflate;
    }
}
