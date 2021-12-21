package com.innomalist.taxi.shoppingapp.p011ui.bycategory.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.innomalist.taxi.shoppingapp.model.bycategory.SecMaincategoryList;
import com.kiandashopping.kiandashopping.p011ui.bycategory.fragment.MainCategoryFragment;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.bycategory.adapter.ViewPageAdapter */
public class ViewPageAdapter extends FragmentPagerAdapter {
    private List<SecMaincategoryList> categoriesLists;
    private String categoryId;

    public ViewPageAdapter(FragmentManager fragmentManager, List<SecMaincategoryList> list, String str) {
        super(fragmentManager, 1);
        this.categoriesLists = list;
        this.categoryId = str;
    }

    public Fragment getItem(int i) {
        return MainCategoryFragment.builtFragment(this.categoryId, this.categoriesLists.get(i));
    }

    public int getCount() {
        return this.categoriesLists.size();
    }

    public CharSequence getPageTitle(int i) {
        return this.categoriesLists.get(i).getSecCategoryName();
    }
}
