package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.actvity;

import android.os.Bundle;
import android.view.Menu;
import androidx.fragment.app.FragmentTransaction;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.mycart.MyCartFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.mycart.actvity.MyCartActivity */
public class MyCartActivity extends BaseActivity {
    public int getLayout() {
        return R.layout.activity_my_cart;
    }

    public PresenterInterface getPresenterInterface() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.title.setText(ResourceUtils.getString(R.string.buy_now));
        openCartFragment();
    }

    private void openCartFragment() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.container_body, MyCartFragment.newInstance(false));
        beginTransaction.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        this.menuItem.setVisible(false);
        return true;
    }
}
