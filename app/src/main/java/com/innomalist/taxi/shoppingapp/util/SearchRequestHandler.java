package com.kiandashopping.kiandashopping.util;

import android.os.Handler;
import com.kiandashopping.kiandashopping.util.SearchRequestHandler;
import p013io.reactivex.disposables.Disposable;

public class SearchRequestHandler {
    private Disposable disposable;
    Handler handler = new Handler();
    Runnable runnable;

    public interface Listener {
        Disposable onRequest();
    }

    public void close() {
        Disposable disposable2 = this.disposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Runnable runnable2 = this.runnable;
        if (runnable2 != null) {
            this.handler.removeCallbacks(runnable2);
        }
    }

    public void putRequest(Listener listener) {
        close();
        $$Lambda$SearchRequestHandler$cmKdz1Pb2h7DIWUoOkYE_mUvPc r0 = new Runnable(listener) {
            private final /* synthetic */ SearchRequestHandler.Listener f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SearchRequestHandler.this.lambda$putRequest$0$SearchRequestHandler(this.f$1);
            }
        };
        this.runnable = r0;
        this.handler.postDelayed(r0, 500);
    }

    public /* synthetic */ void lambda$putRequest$0$SearchRequestHandler(Listener listener) {
        this.disposable = listener.onRequest();
    }
}
