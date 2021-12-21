package com.kiandashopping.kiandashopping.p011ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment;
import com.kiandashopping.kiandashopping.model.viewall.ProductSortBy;
import com.kiandashopping.kiandashopping.p011ui.dialog.adapter.DialogSortByAdapter;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogSortBy */
public class DialogSortBy extends BaseSheetFragment implements DialogSortByAdapter.SortByListener {
    private DialogSortByAdapter dialogAddReviewAdapter;
    @BindView(2131361982)
    RecyclerView recyclerView;
    private String sortBy = "";
    private ArrayList<ProductSortBy> sortByArrayList;
    private SortByListener sortByListener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogSortBy$SortByListener */
    public interface SortByListener {
        void onClick(String str);
    }

    public static DialogSortBy newInstance(BaseActivity baseActivity) {
        DialogSortBy dialogSortBy = new DialogSortBy();
        dialogSortBy.setTitle(ResourceUtils.getString(R.string.sort_by));
        dialogSortBy.setActivity(baseActivity);
        dialogSortBy.setCustomLayout(R.layout.dialog_recyclerview);
        dialogSortBy.setPositive(ResourceUtils.getString(R.string.btn_submit));
        return dialogSortBy;
    }

    public void setSort(int i) {
        for (int i2 = 0; i2 < this.sortByArrayList.size(); i2++) {
            this.sortByArrayList.get(i2).setChecked(false);
        }
        this.sortByArrayList.get(i).setChecked(true);
        this.sortBy = this.sortByArrayList.get(i).getId();
        this.dialogAddReviewAdapter.notifyDataSetChanged();
    }

    public void show(SortByListener sortByListener2, String str) {
        this.sortByListener = sortByListener2;
        this.sortBy = str;
        show();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList<ProductSortBy> sortBy2 = AppUtils.getSortBy(this.sortBy);
        this.sortByArrayList = sortBy2;
        this.dialogAddReviewAdapter = new DialogSortByAdapter(this, sortBy2);
        this.recyclerView.addItemDecoration(new DividerItemDecoration((Context) Objects.requireNonNull(getActivity()), 1));
        this.recyclerView.setAdapter(this.dialogAddReviewAdapter);
    }

    public void onClickPositive() {
        this.sortByListener.onClick(this.sortBy);
        dismiss();
    }
}
