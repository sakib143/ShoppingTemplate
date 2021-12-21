package com.kiandashopping.kiandashopping;

import android.content.Context;
import android.net.Uri;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogConnectionErrorRetry;
import com.theartofdev.edmodo.cropper.CropImageView;

public interface ViewInterface {
    Context getContext();

    PresenterInterface getPresenterInterface();

    void hideLoadingView();

    void hideLoadingView(int i);

    void hideLoadingView(int i, boolean z);

    void onImageChosen(int i, Uri uri);

    void pickImage(int i, CropImageView.CropShape cropShape, int i2, int i3);

    void showConnectionError(String str);

    void showConnectionError(String str, boolean z);

    void showConnectionErrorRetry(String str, DialogConnectionErrorRetry.RetryListener retryListener);

    void showError(String str);

    void showError(String str, boolean z);

    void showLoadingView();

    void showLoadingView(int i);

    void showSuccess(String str, String str2, boolean z);

    void showToast(String str);

    void showTokenExpired(String str);

    void showWarning(String str);

    void showWarning(String str, boolean z);
}
