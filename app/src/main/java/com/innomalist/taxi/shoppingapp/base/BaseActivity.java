package com.innomalist.taxi.shoppingapp.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;

import com.innomalist.taxi.shoppingapp.R;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.ViewInterface;
import com.innomalist.taxi.shoppingapp.ViewInterface;
import com.innomalist.taxi.shoppingapp.data.source.AppRepository;
import com.innomalist.taxi.shoppingapp.data.source.sharedpreference.AppPreferenceDataSource;
import com.innomalist.taxi.shoppingapp.util.NetworkUtils;
import com.kiandashopping.kiandashopping.customview.BadgeDrawable;
//import com.kiandashopping.kiandashopping.data.source.AppRepository;
//import com.kiandashopping.kiandashopping.data.source.sharedpreference.AppPreferenceDataSource;
import com.kiandashopping.kiandashopping.p011ui.dashboard.activity.DashboardActivity;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogConnectionError;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogConnectionErrorRetry;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogError;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogWarning;
//import com.kiandashopping.kiandashopping.util.NetworkUtils;
//import com.kiandashopping.kiandashopping.util.PermissionUtil;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class BaseActivity extends AppCompatActivity implements ViewInterface {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected String ARG_OPEN_PAGE = "OPEN_PAGE";
    int REQ_WRITE_EXTERNAL_STORAGE = 2323;
    public AppRepository appRepository;
    protected Context context;
    CropImageView.CropShape cropShape = CropImageView.CropShape.OVAL;
    Handler handler;
    boolean isDestroyed;
    List<String> loadingCountList = new ArrayList();
    protected MenuItem menuItem;
    protected Dialog progressDialog;
    int ratioX;
    int ratioY;
    int requestCode;
    List<View> snackbar = new ArrayList();
    protected TextView title;
    public Toolbar toolbar;

    public abstract int getLayout();

    public void showTokenExpired(String str) {
    }

    public Context getContext() {
        return this.context;
    }

    public void showLoadingView(int i) {
        this.loadingCountList.add(String.valueOf(i));
        showLoadingView();
    }

    public void hideLoadingView(int i) {
        getHandler().postDelayed(new Runnable(i) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                BaseActivity.this.lambda$hideLoadingView$0$BaseActivity(this.f$1);
            }
        }, 1000);
    }

    public /* synthetic */ void lambda$hideLoadingView$0$BaseActivity(int i) {
        Iterator<String> it = this.loadingCountList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().equals(String.valueOf(i))) {
                    this.loadingCountList.remove(String.valueOf(i));
                    break;
                }
            } else {
                break;
            }
        }
        if (this.loadingCountList.size() == 0) {
            hideLoadingView();
        }
    }

    public void hideLoadingView(int i, boolean z) {
        getHandler().postDelayed(new Runnable(i) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                BaseActivity.this.lambda$hideLoadingView$1$BaseActivity(this.f$1);
            }
        }, z ? 0 : 1000);
    }

    public /* synthetic */ void lambda$hideLoadingView$1$BaseActivity(int i) {
        Iterator<String> it = this.loadingCountList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().equals(String.valueOf(i))) {
                    this.loadingCountList.remove(String.valueOf(i));
                    break;
                }
            } else {
                break;
            }
        }
        if (this.loadingCountList.size() == 0) {
            hideLoadingView();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appRepository = new AppRepository(new AppPreferenceDataSource(this));
        setLanguage();
        if (getLayout() != 0) {
            setContentView(getLayout());
        }
        ButterKnife.bind((Activity) this);
        this.context = this;
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    public void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public void showLoadingView() {
        if (this.progressDialog == null) {
            this.progressDialog = loading();
        }
        if (this.progressDialog != null && !isDestroyed()) {
            this.progressDialog.show();
        }
    }

    public Dialog loading() {
        Dialog dialog = new Dialog(this);
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_loading, (ViewGroup) null);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawableResource(17170445);
        dialog.getWindow().clearFlags(2);
        dialog.setCancelable(false);
        dialog.setContentView(inflate);
        return dialog;
    }

    public void hideLoadingView() {
        if (this.progressDialog != null) {
            if (!isDestroyed()) {
                this.progressDialog.dismiss();
            }
            this.progressDialog = null;
        }
    }

    public void setupToolBar() {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        this.title = (TextView) toolbar2.findViewById(R.id.toolbar_title);
        setTitle(getTitle());
        setSupportActionBar(this.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.ic_back_arrow);
        }
    }

    /* access modifiers changed from: protected */
    public void showMenu() {
        MenuItem menuItem2 = this.menuItem;
        if (menuItem2 != null) {
            menuItem2.setVisible(true);
        }
    }

    /* access modifiers changed from: protected */
    public void hideMenu() {
        MenuItem menuItem2 = this.menuItem;
        if (menuItem2 != null) {
            menuItem2.setVisible(false);
        }
    }

    public void hideMenuInFragment() {
        MenuItem menuItem2 = this.menuItem;
        if (menuItem2 != null) {
            menuItem2.setVisible(false);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem2) {
        int itemId = menuItem2.getItemId();
        if (itemId == 16908332) {
            hideKeyboard();
            onBackPressed();
            return true;
        } else if (itemId != R.id.notification) {
            return super.onOptionsItemSelected(menuItem2);
        } else {
            openDashBoard(2);
            return true;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        setBadgeIcon();
        return true;
    }

    public void setBadgeIcon() {
        BadgeDrawable badgeDrawable;
        try {
            if (this.menuItem != null) {
                LayerDrawable layerDrawable = (LayerDrawable) this.menuItem.getIcon();
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.ic_badge);
                if (findDrawableByLayerId instanceof BadgeDrawable) {
                    badgeDrawable = (BadgeDrawable) findDrawableByLayerId;
                } else {
                    badgeDrawable = new BadgeDrawable(this.context);
                }
                badgeDrawable.setCount("" + this.appRepository.getCartCount());
                layerDrawable.mutate();
                layerDrawable.setDrawableByLayerId(R.id.ic_badge, badgeDrawable);
            }
        } catch (Exception unused) {
        }
    }

    public void setLanguage() {
        Locale locale = new Locale(this.appRepository.getLanguage());
        Locale.setDefault(locale);
        Log.d("Locale Language", this.appRepository.getLanguage());
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    public void changeActivity(Intent intent) {
        startActivity(intent);
    }

    public void changeActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public void changeActivity(Class cls) {
        changeActivity(new Intent(this, cls));
    }

    public void changeActivityClearBackStack(Class cls) {
        changeActivityClearBackStack(new Intent(this, cls));
    }

    public void openDashBoard(int i) {
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.putExtra(this.ARG_OPEN_PAGE, i);
        intent.addFlags(335577088);
        changeActivity(intent);
    }

    public void changeActivityClearBackStack(Intent intent) {
        intent.addFlags(335577088);
        changeActivity(intent);
    }

    public void showError(String str, boolean z) {
        DialogError.newInstance(this).show(str, z);
    }

    public void showError(String str) {
        DialogError.newInstance(this).show(str, false);
    }

    public void showWarning(String str, boolean z) {
        DialogWarning.newInstance(this).show(str, z);
    }

    public void showWarning(String str) {
        DialogWarning.newInstance(this).show(str, false);
    }

    public void showSuccess(String str, String str2, boolean z) {
        DialogWarning.newInstance(this).show(str, str2, z);
    }

    public void showConnectionError(String str, boolean z) {
        DialogConnectionError.newInstance(this).show(str, z);
    }

    public void showConnectionErrorRetry(String str, DialogConnectionErrorRetry.RetryListener retryListener) {
        DialogConnectionErrorRetry.newInstance(this).show(str, retryListener);
    }

    public void showConnectionError(String str) {
        showConnectionError(str, false);
    }

    public void showToast(String str) {
        showCustomSnackbar(str);
    }

    private void showCustomSnackbar(String str) {
        final View inflate = LayoutInflater.from(this.context).inflate(R.layout.custom_snackbar, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.text)).setText(str);
        this.snackbar.add(inflate);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -2;
        layoutParams.width = -1;
        layoutParams.format = -3;
        layoutParams.gravity = 80;
        layoutParams.flags = 262184;
        inflate.setLayoutParams(layoutParams);
        if (getWindowManager() != null) {
            getWindowManager().addView(inflate, inflate.getLayoutParams());
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getSize(point);
            inflate.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(point.x, BasicMeasure.EXACTLY), 0, layoutParams.width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(point.y, BasicMeasure.EXACTLY), 0, layoutParams.height));
            inflate.setTranslationY((float) inflate.getMeasuredHeight());
            inflate.animate().setDuration(300).translationX(0.0f).translationY(0.0f);
        }
        getHandler().postDelayed(new Runnable() {
            public void run() {
                inflate.animate().setDuration(300).translationX(0.0f).translationY((float) inflate.getMeasuredHeight()).withEndAction(new Runnable(inflate) {
                    private final /* synthetic */ View f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        BaseActivity.C14231.this.lambda$run$0$BaseActivity$1(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$run$0$BaseActivity$1(View view) {
                WindowManager windowManager = (WindowManager) BaseActivity.this.context.getSystemService("window");
                if (windowManager != null && !BaseActivity.this.isDestroyed) {
                    view.setVisibility(8);
                    if (BaseActivity.this.snackbar.contains(view)) {
                        windowManager.removeViewImmediate(view);
                        BaseActivity.this.snackbar.remove(view);
                    }
                }
            }
        }, 1700);
    }

    public Handler getHandler() {
        if (this.handler == null) {
            this.handler = new Handler();
        }
        return this.handler;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        setBadgeIcon();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        PresenterInterface presenterInterface = getPresenterInterface();
        if (presenterInterface != null) {
            presenterInterface.close();
        }
        Dialog dialog = this.progressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.progressDialog = null;
        getHandler().removeCallbacksAndMessages((Object) null);
        for (View removeViewImmediate : this.snackbar) {
            getWindowManager().removeViewImmediate(removeViewImmediate);
        }
        this.isDestroyed = true;
        super.onDestroy();
    }

    public void addFragment(int i, Fragment fragment, String str) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(17432576, 17432577);
        beginTransaction.add(i, fragment, str);
        beginTransaction.commitAllowingStateLoss();
    }

    public Fragment replaceFragment(int i, Fragment fragment, String str) {
        return replaceFragment(getSupportFragmentManager(), i, fragment, str);
    }

    public Fragment replaceFragment(FragmentManager fragmentManager, int i, Fragment fragment, String str) {
        hideKeyboard();
        try {
            fragmentManager.popBackStackImmediate();
        } catch (IllegalStateException unused) {
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.setCustomAnimations(17432576, 17432577);
        beginTransaction.replace(i, fragment, str);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commitAllowingStateLoss();
        return fragment;
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public int getActionBarHeight() {
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void onAllowed(int i) {
        if (i == this.REQ_WRITE_EXTERNAL_STORAGE) {
            pickImage(this.requestCode, this.cropShape, this.ratioX, this.ratioY);
        }
    }

    public void pickImage(int i, CropImageView.CropShape cropShape2, int i2, int i3) {
        this.requestCode = i;
        this.cropShape = cropShape2;
        this.ratioX = i2;
        this.ratioY = i3;
        if (isAllowed(this, PermissionUtil.WRITE_STORAGE_PERMISSION, this.REQ_WRITE_EXTERNAL_STORAGE)) {
            CropImage.startPickImageActivity(this);
        }
    }

    public List<Fragment> getFragments() {
        return getSupportFragmentManager().getFragments();
    }

    public void onImageChosen(int i, Uri uri) {
        for (Fragment next : getFragments()) {
            if (next instanceof BaseFragment) {
                ((BaseFragment) next).onImageChosen(i, uri);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1) {
            CropImage.activity(CropImage.getPickImageResultUri(this, intent)).setCropShape(this.cropShape).setFixAspectRatio(true).setAspectRatio(this.ratioX, this.ratioY).setRequestedSize(0, 512).setOutputCompressFormat(Bitmap.CompressFormat.JPEG).setOutputCompressQuality(40).start(this);
        }
        if (i == 203) {
            CropImage.ActivityResult activityResult = CropImage.getActivityResult(intent);
            if (i2 == -1) {
                onImageChosen(this.requestCode, activityResult.getUri());
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public static boolean isAllowed(AppCompatActivity appCompatActivity, String str, int i) {
        if (ActivityCompat.checkSelfPermission(appCompatActivity, str) == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(appCompatActivity, new String[]{str}, i);
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length > 0 && iArr[0] == 0) {
            onAllowed(i);
        }
    }

    public String getString(EditText editText) {
        return editText.getText().toString();
    }

    /* access modifiers changed from: protected */
    public void openFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.flContainer, fragment);
            beginTransaction.commit();
        }
    }
}
