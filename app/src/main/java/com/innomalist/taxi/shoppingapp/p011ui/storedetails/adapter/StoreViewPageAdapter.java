package com.kiandashopping.kiandashopping.p011ui.storedetails.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.model.storelist.StoreDetailsResult;
import com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.deals.DealsFragment;
import com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.product.ProductsFragment;
import com.kiandashopping.kiandashopping.p011ui.storedetails.fragment.store.StoreFragment;
import com.kiandashopping.kiandashopping.util.ResourceUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.storedetails.adapter.StoreViewPageAdapter */
public class StoreViewPageAdapter extends FragmentPagerAdapter {
    private StoreDetailsResult storeDetailsResult;
    private int storeId;

    public int getCount() {
        return 3;
    }

    public StoreViewPageAdapter(FragmentManager fragmentManager, StoreDetailsResult storeDetailsResult2, int i) {
        super(fragmentManager, 1);
        this.storeId = i;
        this.storeDetailsResult = storeDetailsResult2;
    }

    public Fragment getItem(int i) {
        if (i == 0) {
            return StoreFragment.builtFragment(this.storeId, this.storeDetailsResult.getStoreDetails(), this.storeDetailsResult.getStoreReview(), this.storeDetailsResult.isMoreReviewStatus());
        }
        if (i == 1) {
            return DealsFragment.builtFragment(this.storeId, this.storeDetailsResult.getDealListByShop());
        }
        if (i != 2) {
            return StoreFragment.builtFragment(this.storeId, this.storeDetailsResult.getStoreDetails(), this.storeDetailsResult.getStoreReview(), this.storeDetailsResult.isMoreReviewStatus());
        }
        return ProductsFragment.builtFragment(this.storeId, this.storeDetailsResult.getProductListByShop());
    }

    public CharSequence getPageTitle(int i) {
        if (i == 0) {
            return ResourceUtils.getString(R.string.store);
        }
        if (i == 1) {
            return ResourceUtils.getString(R.string.deals);
        }
        if (i != 2) {
            return ResourceUtils.getString(R.string.store);
        }
        return ResourceUtils.getString(R.string.product);
    }
}
