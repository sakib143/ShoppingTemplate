package com.innomalist.taxi.shoppingapp.p011ui.dashboard.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
//import com.kiandashopping.kiandashopping.PresenterInterface;
//import com.kiandashopping.kiandashopping.base.AppConstants;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
//import com.kiandashopping.kiandashopping.base.BaseApplication;
//import com.kiandashopping.kiandashopping.model.dashboard.NavigationMenu;
//import com.kiandashopping.kiandashopping.p011ui.account.activity.EditProfile;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.base.BaseApplication;
import com.innomalist.taxi.shoppingapp.model.dashboard.NavigationMenu;
import com.innomalist.taxi.shoppingapp.p011ui.account.activity.EditProfile;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.adapter.NavigationAdapter;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.aboutus.AboutUsFragment;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.account.AccountFragment;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.contactus.ContactUsFragment;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.dashboard.DashboardFragment;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.mycart.MyCartFragment;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.fragment.store.StoreFragment;
import com.innomalist.taxi.shoppingapp.p011ui.dashboard.viewholder.BottomTabs;
import com.innomalist.taxi.shoppingapp.p011ui.dialog.DialogLogout;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.adapter.NavigationAdapter;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.aboutus.AboutUsFragment;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.account.AccountFragment;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.contactus.ContactUsFragment;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.dashboard.DashboardFragment;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.MyCartFragment;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.NearByFragment;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.store.StoreFragment;
import com.kiandashopping.kiandashopping.p011ui.dashboard.mvp.DashboardContractor;
import com.kiandashopping.kiandashopping.p011ui.dashboard.mvp.DashboardPresenter;
//import com.kiandashopping.kiandashopping.p011ui.dashboard.viewholder.BottomTabs;
import com.kiandashopping.kiandashopping.p011ui.dashboard.viewholder.MenuViewHolder;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogChangeLanguage;
//import com.kiandashopping.kiandashopping.p011ui.dialog.DialogLogout;
import com.kiandashopping.kiandashopping.p011ui.login.activity.Login;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.activity.DashboardActivity */
public class DashboardActivity extends BaseActivity implements BottomTabs.TabListener, NavigationAdapter.Listener, DashboardContractor.View {
    private static final String PROFILE = "PROFILE";
    @BindView(2131361868)
    AppBarLayout appBar;
    @BindView(2131361880)
    LottieAnimationView avHome;
    @BindView(2131361881)
    LottieAnimationView avMyCart;
    BottomTabs bottomTabs;
    DashboardPresenter dashboardPresenter;
    @BindView(2131361996)
    DrawerLayout drawerLayout;
    @BindView(2131362042)
    FrameLayout flHome;
    @BindView(2131362043)
    FrameLayout flMyCart;
    boolean isActiveHome = false;
    @BindView(2131362136)
    LinearLayout llTab;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationAdapter navigationAdapter;
    List<Object> objectList;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f229rv;

    public int getLayout() {
        return R.layout.activity_dashboard;
    }

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dashboardPresenter = new DashboardPresenter(this);
        setupToolBar();
        initDrawerConfig();
        initConfiguration();
        openPage(AppUtils.getInt(getIntent(), this.ARG_OPEN_PAGE));
    }

    private void initDrawerConfig() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, this.toolbar, R.string.app_name, R.string.app_name);
        this.mDrawerToggle = actionBarDrawerToggle;
        this.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_menu_drawer, getTheme());
        this.mDrawerToggle.setDrawerIndicatorEnabled(false);
        this.mDrawerToggle.setHomeAsUpIndicator(drawable);
        this.mDrawerToggle.syncState();
        this.mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DashboardActivity.this.lambda$initDrawerConfig$0$DashboardActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$initDrawerConfig$0$DashboardActivity(View view) {
        hideKeyboard();
        if (this.drawerLayout.isDrawerVisible((int) GravityCompat.START)) {
            this.drawerLayout.closeDrawer((int) GravityCompat.START);
        } else {
            this.drawerLayout.openDrawer((int) GravityCompat.START);
        }
    }

    private void initConfiguration() {
        ArrayList arrayList = new ArrayList();
        this.objectList = arrayList;
        NavigationAdapter navigationAdapter2 = new NavigationAdapter(this, arrayList);
        this.navigationAdapter = navigationAdapter2;
        navigationAdapter2.setListener(this);
        MenuViewHolder.selectedPosition = AppUtils.getInt(getIntent(), this.ARG_OPEN_PAGE);
        this.f229rv.setAdapter(this.navigationAdapter);
        this.objectList.add(PROFILE);
        this.objectList.addAll(AppUtils.getMenu());
        this.navigationAdapter.notifyDataSetChanged();
        this.title.setText(ResourceUtils.getString(R.string.menu_home));
        replaceFragment(R.id.flContainer, new DashboardFragment(), ResourceUtils.getString(R.string.menu_home));
        this.bottomTabs = new BottomTabs(this.llTab, this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.navigationAdapter.notifyDataSetChanged();
    }

    public void onTabSelected(int i) {
        Fragment fragment;
        switch (i) {
            case R.id.flAccount:
                fragment = new AccountFragment();
                MenuViewHolder.selectedPosition = 4;
                coloredToolbar(ResourceUtils.getString(R.string.menu_my_account));
                break;
            case R.id.flHome:
                fragment = new DashboardFragment();
                MenuViewHolder.selectedPosition = 1;
                whiteToolbar(ResourceUtils.getString(R.string.menu_home));
                break;
            case R.id.flMyCart:
                fragment = MyCartFragment.newInstance(true);
                MenuViewHolder.selectedPosition = 5;
                whiteToolbar(ResourceUtils.getString(R.string.menu_my_cart));
                break;
            case R.id.flNearMe:
                fragment = new NearByFragment();
                MenuViewHolder.selectedPosition = 3;
                whiteToolbar(ResourceUtils.getString(R.string.menu_near_me));
                break;
            case R.id.flStore:
                fragment = new StoreFragment();
                MenuViewHolder.selectedPosition = 2;
                whiteToolbar(ResourceUtils.getString(R.string.menu_stores));
                break;
            default:
                fragment = null;
                break;
        }
        openFragment(fragment);
        this.navigationAdapter.notifyDataSetChanged();
    }

    private void whiteToolbar(String str) {
        this.appBar.setElevation(8.0f);
        this.toolbar.setElevation(8.0f);
        this.appBar.setBackgroundColor(ResourceUtils.getColor((int) R.color.white));
        this.title.setText(str);
        this.title.setTextColor(ResourceUtils.getColor((int) R.color.category_defaullt));
        this.mDrawerToggle.setHomeAsUpIndicator(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_menu_drawer, getTheme()));
        this.isActiveHome = str.equals(ResourceUtils.getString(R.string.menu_home));
        if (str.equals(ResourceUtils.getString(R.string.menu_my_cart))) {
            hideMenu();
        } else {
            showMenu();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(ResourceUtils.getColor((int) R.color.white));
        }
        if (this.isActiveHome) {
            this.llTab.setVisibility(0);
        }
    }

    private void coloredToolbar(String str) {
        this.appBar.setElevation(0.0f);
        this.appBar.setBackgroundColor(ResourceUtils.getColor(17170445));
        this.toolbar.setElevation(0.0f);
        this.title.setTextColor(ResourceUtils.getColor((int) R.color.white));
        this.title.setText(str);
        this.isActiveHome = str.equals(ResourceUtils.getString(R.string.menu_home));
        this.mDrawerToggle.setHomeAsUpIndicator(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_menu_drawer_white, getTheme()));
        hideMenu();
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(ResourceUtils.getColor((int) R.color.colorAccent));
        }
    }

    public void onClick(NavigationMenu navigationMenu) {
        Fragment fragment;
        MenuViewHolder.selectedPosition = navigationMenu.getMenuId();
        boolean z = false;
        this.llTab.setVisibility(navigationMenu.getMenuId() == 1 ? 0 : 8);
        if (navigationMenu.getMenuId() == 1) {
            z = true;
        }
        this.isActiveHome = z;
        switch (navigationMenu.getMenuId()) {
            case 1:
                fragment = new DashboardFragment();
                this.bottomTabs.startAnimation(this.avHome);
                whiteToolbar(ResourceUtils.getString(R.string.menu_home));
                break;
            case 2:
                fragment = new StoreFragment();
                whiteToolbar(ResourceUtils.getString(R.string.menu_stores));
                break;
            case 3:
                fragment = new NearByFragment();
                whiteToolbar(ResourceUtils.getString(R.string.menu_near_me));
                break;
            case 4:
                fragment = new AccountFragment();
                coloredToolbar(ResourceUtils.getString(R.string.menu_my_account));
                break;
            case 5:
                fragment = MyCartFragment.newInstance(true);
                this.bottomTabs.startAnimation(this.avMyCart);
                whiteToolbar(ResourceUtils.getString(R.string.menu_my_cart));
                break;
            case 6:
                DialogChangeLanguage.newInstance(this).show(new DialogChangeLanguage.LanguageListener() {
                    public final void onSelected(String str) {
                        DashboardActivity.this.lambda$onClick$1$DashboardActivity(str);
                    }
                }, this.appRepository.getLanguage());
                whiteToolbar(ResourceUtils.getString(R.string.menu_language));
                break;
            case 7:
                fragment = AboutUsFragment.newInstance(AppConstants.ABOUT_US);
                whiteToolbar(ResourceUtils.getString(R.string.menu_about_us));
                break;
            case 8:
                fragment = new ContactUsFragment();
                whiteToolbar(ResourceUtils.getString(R.string.menu_contact_us));
                break;
            case 9:
                fragment = AboutUsFragment.newInstance(AppConstants.PRIVACY_POLICY);
                whiteToolbar(ResourceUtils.getString(R.string.menu_privacy_policy));
                break;
            case 10:
                DialogLogout.newInstance(this).show(new DialogLogout.LogoutListener() {
                    public final void onClickLogout() {
                        DashboardActivity.this.lambda$onClick$2$DashboardActivity();
                    }
                });
                break;
        }
        fragment = null;
        openFragment(fragment);
        this.drawerLayout.closeDrawer((int) GravityCompat.START);
        this.navigationAdapter.notifyDataSetChanged();
    }

    public /* synthetic */ void lambda$onClick$1$DashboardActivity(String str) {
        this.appRepository.setLanguage(str);
        setLanguage();
        BaseApplication.factoryReset();
        openDashBoard(1);
    }

    public /* synthetic */ void lambda$onClick$2$DashboardActivity() {
        this.dashboardPresenter.requestLogout();
    }

    public void onClickProfile() {
        changeActivity(EditProfile.class);
    }

    public void openPage(int i) {
        MenuViewHolder.selectedPosition = i;
        if (i == 1) {
            onTabSelected(R.id.flHome);
            this.llTab.setVisibility(0);
            this.bottomTabs.startAnimation(this.avHome);
            this.title.setText(ResourceUtils.getString(R.string.menu_home));
        } else if (i == 2) {
            onTabSelected(R.id.flMyCart);
            this.bottomTabs.startAnimation(this.avMyCart);
            this.title.setText(ResourceUtils.getString(R.string.menu_my_cart));
        }
    }

    public void onBackPressed() {
        if (this.isActiveHome) {
            DialogLogout.newInstance(this).show(new DialogLogout.LogoutListener() {
                public final void onClickLogout() {
                    DashboardActivity.this.lambda$onBackPressed$3$DashboardActivity();
                }
            });
        } else {
            openPage(1);
        }
    }

    public /* synthetic */ void lambda$onBackPressed$3$DashboardActivity() {
        this.dashboardPresenter.requestLogout();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            hideKeyboard();
            onBackPressed();
            return true;
        } else if (itemId != R.id.notification) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            openPage(2);
            return true;
        }
    }

    public void showLogin() {
        this.appRepository.delete();
        changeActivityClearBackStack(Login.class);
    }
}
