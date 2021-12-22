package com.innomalist.taxi.shoppingapp.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.innomalist.taxi.shoppingapp.FragmentInterface;
import com.innomalist.taxi.shoppingapp.data.source.AppRepository;
import com.innomalist.taxi.shoppingapp.data.source.sharedpreference.AppPreferenceDataSource;
//import com.kiandashopping.kiandashopping.FragmentInterface;
//import com.kiandashopping.kiandashopping.data.source.AppRepository;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogConnectionErrorRetry;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.util.List;
import java.util.Locale;

public abstract class BaseFragment extends Fragment implements FragmentInterface, AppConstants {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected AppRepository appRepository;
    protected Context context;
    Unbinder unbinder;

    public abstract View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View provideYourFragmentView = provideYourFragmentView(layoutInflater, viewGroup, bundle);
        this.appRepository = new AppRepository(new AppPreferenceDataSource(getActivity()));
        setLanguage();
        this.context = getActivity();
        this.unbinder = ButterKnife.bind((Object) this, provideYourFragmentView);
        return provideYourFragmentView;
    }

    private void setLanguage() {
        Locale locale = new Locale(this.appRepository.getLanguage());
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
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

    public void showWarning(String str) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showWarning(str);
        }
    }

    public void showError(String str) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showError(str);
        }
    }

    public void showConnectionError(String str) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showConnectionError(str);
        }
    }

    public void showSuccess(String str, String str2, boolean z) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showSuccess(str, str2, z);
        }
    }

    public void showWarning(String str, boolean z) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showWarning(str, z);
        }
    }

    public void showError(String str, boolean z) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showError(str, z);
        }
    }

    public void showConnectionError(String str, boolean z) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showConnectionError(str, z);
        }
    }

    public void showTokenExpired(String str) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showTokenExpired(str);
        }
    }

    public void pickImage(int i, CropImageView.CropShape cropShape, int i2, int i3) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.pickImage(i, cropShape, i2, i3);
        }
    }

    public void showConnectionErrorRetry(String str, DialogConnectionErrorRetry.RetryListener retryListener) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showConnectionErrorRetry(str, retryListener);
        }
    }

    public void showToast(int i) {
        showToast(getResources().getString(i));
    }

    public void showToast(String str) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showToast(str);
        }
    }

    public void changeActivity(Intent intent) {
        startActivity(intent);
    }

    public void changeActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public void changeActivity(Class cls) {
        changeActivity(new Intent(getContext(), cls));
    }

    public void changeActivityClearBackStack(Class cls) {
        Intent intent = new Intent(getContext(), cls);
        intent.addFlags(335577088);
        changeActivity(intent);
    }

    public void onDestroyView() {
        if (getPresenterInterface() != null) {
            getPresenterInterface().close();
        }
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void hideKeyboard(Context context2, View view) {
        if (view != null) {
            ((InputMethodManager) context2.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public List<Fragment> getVisibleFragments() {
        return getChildFragmentManager().getFragments();
    }

    public void onImageChosen(int i, Uri uri) {
        for (Fragment next : getVisibleFragments()) {
            if (next instanceof BaseFragment) {
                ((BaseFragment) next).onImageChosen(i, uri);
            }
        }
    }
}
