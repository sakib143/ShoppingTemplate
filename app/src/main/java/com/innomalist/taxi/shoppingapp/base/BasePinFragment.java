package com.kiandashopping.kiandashopping.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.DialogInterface;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogConnectionErrorRetry;
import com.theartofdev.edmodo.cropper.CropImageView;

public abstract class BasePinFragment extends DialogFragment implements DialogInterface, View.OnClickListener {
    protected BaseActivity baseActivity;
    ImageButton btnClose;
    int customLayout;
    FrameLayout flContainer;
    @BindView(2131362045)
    LinearLayout flPin;
    FragmentManager fragmentManager;

    /* renamed from: h */
    int f214h = 0;
    boolean isCancelOnOutSideTouch;
    boolean isShowing = false;
    @BindView(2131362098)
    ImageView ivPinBottom;
    @BindView(2131362099)
    ImageView ivPinTop;
    Unbinder unbinder;
    ViewGroup view;

    /* renamed from: w */
    int f215w = 0;

    /* renamed from: x */
    int f216x = 0;

    /* renamed from: y */
    int f217y = 0;

    public int getLayout() {
        return R.layout.dialog_pin;
    }

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    public void onClickNegative() {
    }

    public void onClickPositive() {
    }

    public void onImageChosen(int i, Uri uri) {
    }

    public void setMessage(String str) {
    }

    public void setNegative(String str) {
    }

    public void setPositive(String str) {
    }

    public void setTitle(String str) {
    }

    public void setXY(int i, int i2, int i3, int i4) {
        this.f216x = i;
        this.f217y = i2;
        this.f215w = i3;
        this.f214h = i4;
        Log.d("SIZE", "X:" + i + ", Y:" + i2 + ", W:" + i3 + ", H:" + i4);
    }

    /* access modifiers changed from: protected */
    public void setActivity(BaseActivity baseActivity2) {
        this.baseActivity = baseActivity2;
        this.fragmentManager = baseActivity2.getSupportFragmentManager();
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.isCancelOnOutSideTouch = z;
    }

    public void show() {
        if (this.isShowing) {
            dismiss();
        }
        this.isShowing = true;
        show(this.fragmentManager, (String) null);
    }

    public void onDismiss(android.content.DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.isShowing = false;
    }

    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        measure();
    }

    /* access modifiers changed from: package-private */
    public void measure() {
        this.flPin = (LinearLayout) this.view.findViewById(R.id.flPin);
        this.ivPinTop = (ImageView) this.view.findViewById(R.id.ivPinTop);
        this.ivPinBottom = (ImageView) this.view.findViewById(R.id.ivPinBottom);
        this.flContainer.post(new Runnable() {
            public final void run() {
                BasePinFragment.this.lambda$measure$0$BasePinFragment();
            }
        });
    }

    public /* synthetic */ void lambda$measure$0$BasePinFragment() {
        int height = this.baseActivity.getWindow().getDecorView().getHeight() / 2;
        int i = this.f217y;
        if (height > i) {
            this.flPin.setY((float) i);
            ImageView imageView = this.ivPinTop;
            imageView.setX((float) ((this.f216x + (this.f215w / 2)) - (imageView.getWidth() / 2)));
            return;
        }
        this.ivPinTop.setVisibility(8);
        this.ivPinBottom.setVisibility(0);
        this.flPin.setY((float) ((this.f217y - this.flContainer.getHeight()) - this.ivPinTop.getHeight()));
        this.ivPinBottom.setX((float) ((this.f216x + (this.f215w / 2)) - (this.ivPinTop.getWidth() / 2)));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(getLayout(), viewGroup, false);
        this.view = viewGroup2;
        viewGroup2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BasePinFragment.this.lambda$onCreateView$1$BasePinFragment(view);
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.view.findViewById(R.id.flContainer);
        this.flContainer = frameLayout;
        int i = this.customLayout;
        if (i != 0) {
            frameLayout.addView(layoutInflater.inflate(i, frameLayout, false));
        }
        this.btnClose = (ImageButton) this.view.findViewById(R.id.btnClose);
        this.unbinder = ButterKnife.bind((Object) this, (View) this.view);
        ImageButton imageButton = this.btnClose;
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        return this.view;
    }

    public /* synthetic */ void lambda$onCreateView$1$BasePinFragment(View view2) {
        if (this.isCancelOnOutSideTouch && isCancelable()) {
            dismiss();
        }
    }

    public void setCustomLayout(int i) {
        this.customLayout = i;
    }

    public void onCreate(Bundle bundle) {
        setStyle(0, R.style.PinView);
        super.onCreate(bundle);
    }

    public void showLoadingView() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showLoadingView();
        }
    }

    public void hideLoadingView() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).hideLoadingView();
        }
    }

    public void showLoadingView(int i) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showLoadingView(i);
        }
    }

    public void hideLoadingView(int i) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).hideLoadingView(i);
        }
    }

    public void hideLoadingView(int i, boolean z) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).hideLoadingView(i, z);
        }
    }

    public void pickImage(int i, CropImageView.CropShape cropShape, int i2, int i3) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.pickImage(i, cropShape, i2, i3);
        }
    }

    public void showWarning(String str) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showWarning(str);
        }
    }

    public void showError(String str) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showError(str);
        }
    }

    public void showConnectionError(String str) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showConnectionError(str);
        }
    }

    public void showWarning(String str, boolean z) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showWarning(str, z);
        }
    }

    public void showError(String str, boolean z) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showError(str, z);
        }
    }

    public void showConnectionError(String str, boolean z) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showConnectionError(str, z);
        }
    }

    public void showSuccess(String str, String str2, boolean z) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showSuccess(str, str2, z);
        }
    }

    public void showTokenExpired(String str) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showTokenExpired(str);
        }
    }

    public void showConnectionErrorRetry(String str, DialogConnectionErrorRetry.RetryListener retryListener) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showConnectionErrorRetry(str, retryListener);
        }
    }

    public void showToast(int i) {
        showToast(getResources().getString(i));
    }

    public void showToast(String str) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.showToast(str);
        }
    }

    public void changeActivity(Intent intent) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.changeActivity(intent);
        }
    }

    public void changeActivityForResult(Intent intent) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.startActivityForResult(intent, 0);
        }
    }

    public void changeActivity(Class cls) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.changeActivity(cls);
        }
    }

    public void changeActivityClearBackStack(Class cls) {
        BaseActivity baseActivity2 = (BaseActivity) getActivity();
        if (baseActivity2 != null) {
            baseActivity2.changeActivityClearBackStack(cls);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void onClick(View view2) {
        if (view2.getId() == R.id.btnClose) {
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void setTargetView(View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        setXY(iArr[0], iArr[1], view2.getWidth(), view2.getHeight());
    }
}
