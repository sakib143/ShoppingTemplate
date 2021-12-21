package com.kiandashopping.kiandashopping.p011ui.itemdetails.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.kiandashopping.kiandashopping.model.itemdetails.ProductImage;
import com.kiandashopping.kiandashopping.p011ui.itemdetails.fragment.SliderFragment;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.itemdetails.adapter.SliderPagerAdapter */
public class SliderPagerAdapter extends FragmentPagerAdapter {
    private List<ProductImage> list;

    public SliderPagerAdapter(FragmentManager fragmentManager, List<ProductImage> list2) {
        super(fragmentManager);
        this.list = list2;
    }

    public int getCount() {
        return this.list.size();
    }

    public Fragment getItem(int i) {
        return SliderFragment.newInstance(this.list.get(i).getImages());
    }

    public CharSequence getPageTitle(int i) {
        return "Page " + i;
    }
}
