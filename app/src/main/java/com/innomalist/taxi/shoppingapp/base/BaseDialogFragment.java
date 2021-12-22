package com.innomalist.taxi.shoppingapp.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.DialogInterface;
//import com.kiandashopping.kiandashopping.PresenterInterface;
import com.innomalist.taxi.shoppingapp.DialogInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogConnectionErrorRetry;
import com.theartofdev.edmodo.cropper.CropImageView;

public abstract class BaseDialogFragment extends DialogFragment implements DialogInterface, View.OnClickListener {
    protected BaseActivity baseActivity;
    ImageButton btnClose;
    @BindView(2131361905)
    Button btnNegative;
    @BindView(2131361906)
    Button btnPositive;
    int customLayout;
    FrameLayout flContainer;
    FragmentManager fragmentManager;
    boolean isCancelOnOutSideTouch;
    boolean isShowing = false;
    String message;
    String negative;
    String positive;
    String title;
    @BindView(2131362389)
    TextView tvMessage;
    @BindView(2131362420)
    TextView tvTitle;
    Unbinder unbinder;
    ViewGroup view;

    public int getLayout() {
        return R.layout.dialog;
    }

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    @OnClick({2131361905})
    public void onClickNegative() {
    }

    @OnClick({2131361906})
    public void onClickPositive() {
    }

    public void onImageChosen(int i, Uri uri) {
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
        getDialog().getWindow().setBackgroundDrawableResource(R.color.colorDialogScreen);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(getLayout(), viewGroup, false);
        this.view = viewGroup2;
        viewGroup2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BaseDialogFragment.this.lambda$onCreateView$0$BaseDialogFragment(view);
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
        setText(this.btnNegative, this.negative);
        setText(this.btnPositive, this.positive);
        setText(this.tvMessage, this.message);
        setText(this.tvTitle, this.title);
        ImageButton imageButton = this.btnClose;
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        return this.view;
    }

    public /* synthetic */ void lambda$onCreateView$0$BaseDialogFragment(View view2) {
        if (this.isCancelOnOutSideTouch && isCancelable()) {
            dismiss();
        }
    }

    public void setCustomLayout(int i) {
        this.customLayout = i;
    }

    /* access modifiers changed from: package-private */
    public void setText(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    public void setTitle(String str) {
        this.title = str;
        setText(this.tvTitle, str);
    }

    public void setMessage(String str) {
        this.message = str;
        setText(this.tvMessage, str);
    }

    public void setPositive(String str) {
        this.positive = str;
        setText(this.btnPositive, str);
    }

    public void setNegative(String str) {
        this.negative = str;
        setText(this.btnNegative, str);
    }

    public void onCreate(Bundle bundle) {
        setStyle(1, R.style.Dialog);
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
}
