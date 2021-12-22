package com.innomalist.taxi.shoppingapp.p011ui.allcategory.activity;

import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.model.category.CategoriesList;
import com.innomalist.taxi.shoppingapp.p011ui.allcategory.adapter.AllCategoryAdapter;
import com.innomalist.taxi.shoppingapp.p011ui.allcategory.mvp.AllCategoryContractor;
import com.innomalist.taxi.shoppingapp.p011ui.allcategory.mvp.AllCategoryPresenter;
import com.innomalist.taxi.shoppingapp.p011ui.viewall.activity.ViewAllActivity;
//import com.kiandashopping.kiandashopping.p011ui.allcategory.adapter.AllCategoryAdapter;
//import com.kiandashopping.kiandashopping.p011ui.allcategory.mvp.AllCategoryPresenter;
//import com.kiandashopping.kiandashopping.p011ui.viewall.activity.ViewAllActivity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.allcategory.activity.AllCategoryActivity */
public class AllCategoryActivity extends BaseActivity implements AllCategoryContractor.View {
    AllCategoryAdapter allCategoryAdapter;
    List<Object> objectList;
    AllCategoryPresenter presenter;
    @BindView(2131362247)

    /* renamed from: rv */
    RecyclerView f222rv;

    public int getLayout() {
        return R.layout.activity_view_all_category;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupToolBar();
        this.title.setText(getResources().getString(R.string.category));
        AllCategoryPresenter allCategoryPresenter = new AllCategoryPresenter(this);
        this.presenter = allCategoryPresenter;
        allCategoryPresenter.requestCategory();
        ArrayList arrayList = new ArrayList();
        this.objectList = arrayList;
        this.allCategoryAdapter = new AllCategoryAdapter(this, arrayList, new AllCategoryAdapter.Listener() {
            public final void clickCategory(int i, String str, int i2) {
                AllCategoryActivity.this.lambda$onCreate$0$AllCategoryActivity(i, str, i2);
            }
        });
        this.f222rv.addItemDecoration(new DividerItemDecoration(this, 1));
        this.f222rv.setAdapter(this.allCategoryAdapter);
    }

    public /* synthetic */ void lambda$onCreate$0$AllCategoryActivity(int i, String str, int i2) {
        if (i == 0) {
            changeActivity(ViewAllActivity.builtIntent(this, str, String.valueOf(i2), "", "", "", ""));
        } else if (i == 1) {
            changeActivity(ViewAllActivity.builtIntent(this, str, "", String.valueOf(i2), "", "", ""));
        } else if (i == 2) {
            changeActivity(ViewAllActivity.builtIntent(this, str, "", "", String.valueOf(i2), "", ""));
        } else if (i == 3) {
            changeActivity(ViewAllActivity.builtIntent(this, str, "", "", "", String.valueOf(i2), ""));
        }
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    public void showDashBoardActivity(List<CategoriesList> list) {
        this.objectList.addAll(list);
        this.allCategoryAdapter.notifyDataSetChanged();
    }
}
