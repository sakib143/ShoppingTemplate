package com.kiandashopping.kiandashopping.p011ui.dashboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseViewHolder;
import com.kiandashopping.kiandashopping.model.category.CategoriesList;
import com.kiandashopping.kiandashopping.model.category.SubCategoryList;
import com.kiandashopping.kiandashopping.model.dashboard.NavigationMenu;
import com.kiandashopping.kiandashopping.p011ui.dashboard.adapter.NavigationAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.viewholder.MenuViewHolder;
import com.kiandashopping.kiandashopping.p011ui.dashboard.viewholder.UserInfoViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.adapter.NavigationAdapter */
public class NavigationAdapter extends RecyclerView.Adapter {
    private static final int HEADER = 1;
    private static final int MENU = 4;
    private static final int TYPE_CATEGORY = 2;
    private static final int TYPE_SUB_CATEGORY = 3;
    private Listener listener;
    private final Context mContext;
    /* access modifiers changed from: private */
    public List<Object> objectList;
    private int selectedPosition = -1;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.adapter.NavigationAdapter$Listener */
    public interface Listener {
        void onClick(NavigationMenu navigationMenu);

        void onClickProfile();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.adapter.NavigationAdapter$HeaderViewHolder_ViewBinding */
    public class HeaderViewHolder_ViewBinding implements Unbinder {
        private HeaderViewHolder target;

        public HeaderViewHolder_ViewBinding(HeaderViewHolder headerViewHolder, View view) {
            this.target = headerViewHolder;
            headerViewHolder.tvFilterName = (TextView) Utils.findRequiredViewAsType(view, R.id.tvHeader, "field 'tvFilterName'", TextView.class);
            headerViewHolder.ivArrow = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ivExpand, "field 'ivArrow'", CheckBox.class);
        }

        public void unbind() {
            HeaderViewHolder headerViewHolder = this.target;
            if (headerViewHolder != null) {
                this.target = null;
                headerViewHolder.tvFilterName = null;
                headerViewHolder.ivArrow = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.adapter.NavigationAdapter$SubServiceViewHolder_ViewBinding */
    public class SubServiceViewHolder_ViewBinding implements Unbinder {
        private SubServiceViewHolder target;

        public SubServiceViewHolder_ViewBinding(SubServiceViewHolder subServiceViewHolder, View view) {
            this.target = subServiceViewHolder;
            subServiceViewHolder.tvHeader = (TextView) Utils.findRequiredViewAsType(view, R.id.tvHeader, "field 'tvHeader'", TextView.class);
            subServiceViewHolder.ivArrow = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ivExpand, "field 'ivArrow'", CheckBox.class);
        }

        public void unbind() {
            SubServiceViewHolder subServiceViewHolder = this.target;
            if (subServiceViewHolder != null) {
                this.target = null;
                subServiceViewHolder.tvHeader = null;
                subServiceViewHolder.ivArrow = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }

    public NavigationAdapter(Context context, List<Object> list) {
        this.mContext = context;
        this.objectList = list;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        if (1 == i) {
            return new UserInfoViewHolder(layoutInflater.inflate(R.layout.drawer_header, viewGroup, false));
        }
        if (2 == i) {
            return new HeaderViewHolder(layoutInflater.inflate(R.layout.item_nav_header, viewGroup, false));
        }
        if (3 == i) {
            return new SubServiceViewHolder(layoutInflater.inflate(R.layout.item_nav_sub_header, viewGroup, false));
        }
        return new MenuViewHolder(layoutInflater.inflate(R.layout.item_nav_menu, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof UserInfoViewHolder) {
            UserInfoViewHolder userInfoViewHolder = (UserInfoViewHolder) viewHolder;
            userInfoViewHolder.onBind(i, this.objectList.get(i));
            userInfoViewHolder.setListener(this.listener);
        } else if (viewHolder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) viewHolder).onBind(i, this.objectList.get(i));
        } else if (viewHolder instanceof SubServiceViewHolder) {
            ((SubServiceViewHolder) viewHolder).onBind(i, this.objectList.get(i));
        } else if (viewHolder instanceof MenuViewHolder) {
            MenuViewHolder menuViewHolder = (MenuViewHolder) viewHolder;
            menuViewHolder.onBind(i, this.objectList.get(i));
            menuViewHolder.setListener(this.listener);
        }
    }

    public int getItemViewType(int i) {
        Object obj = this.objectList.get(i);
        if (obj instanceof String) {
            return 1;
        }
        if (obj instanceof CategoriesList) {
            return 2;
        }
        return obj instanceof SubCategoryList ? 3 : 4;
    }

    public int getItemCount() {
        return this.objectList.size();
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.adapter.NavigationAdapter$HeaderViewHolder */
    public class HeaderViewHolder extends BaseViewHolder {
        private CategoriesList categoriesList;
        @BindView(2131362095)
        CheckBox ivArrow;
        @BindView(2131362377)
        TextView tvFilterName;

        HeaderViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    NavigationAdapter.HeaderViewHolder.this.lambda$new$0$NavigationAdapter$HeaderViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$NavigationAdapter$HeaderViewHolder(View view) {
            CategoriesList categoriesList2 = this.categoriesList;
            categoriesList2.setExpanded(!categoriesList2.isExpanded());
            NavigationAdapter.this.notifyItemChanged(getAdapterPosition());
            int size = this.categoriesList.getSubCategoryList().size();
            int adapterPosition = getAdapterPosition() + 1;
            if (this.categoriesList.isExpanded()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = new ArrayList(this.categoriesList.getSubCategoryList()).iterator();
                while (it.hasNext()) {
                    SubCategoryList subCategoryList = (SubCategoryList) it.next();
                    arrayList.add(subCategoryList);
                    if (subCategoryList.getSubCategoryList() != null && this.ivArrow.isChecked()) {
                        arrayList.addAll(subCategoryList.getSubCategoryList());
                    }
                }
                NavigationAdapter.this.objectList.addAll(adapterPosition, arrayList);
                if (this.categoriesList.getSubCategoryList().size() == 0) {
                    CategoriesList categoriesList3 = this.categoriesList;
                    categoriesList3.setExpanded(!categoriesList3.isExpanded());
                }
                NavigationAdapter.this.notifyItemRangeInserted(adapterPosition, size);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = new ArrayList(this.categoriesList.getSubCategoryList()).iterator();
            while (it2.hasNext()) {
                SubCategoryList subCategoryList2 = (SubCategoryList) it2.next();
                if (NavigationAdapter.this.objectList.contains(subCategoryList2)) {
                    subCategoryList2.setExpanded(false);
                    arrayList2.add(subCategoryList2);
                }
                for (SubCategoryList next : subCategoryList2.getSubCategoryList()) {
                    if (NavigationAdapter.this.objectList.contains(next)) {
                        next.setExpanded(false);
                        arrayList2.add(next);
                    }
                }
            }
            NavigationAdapter.this.objectList.removeAll(arrayList2);
            NavigationAdapter.this.notifyItemRangeRemoved(getAdapterPosition() + 1, arrayList2.size());
        }

        public void onBind(int i, Object obj) {
            CategoriesList categoriesList2 = (CategoriesList) obj;
            this.categoriesList = categoriesList2;
            this.tvFilterName.setText(categoriesList2.getCategoryName());
            this.ivArrow.setVisibility(this.categoriesList.getSubCategoryList().size() > 0 ? 0 : 8);
            this.ivArrow.setChecked(this.categoriesList.isExpanded());
        }
    }

    /* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.adapter.NavigationAdapter$SubServiceViewHolder */
    public class SubServiceViewHolder extends BaseViewHolder {
        @BindView(2131362095)
        CheckBox ivArrow;
        SubCategoryList subCategoryList;
        @BindView(2131362377)
        TextView tvHeader;

        SubServiceViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    NavigationAdapter.SubServiceViewHolder.this.lambda$new$0$NavigationAdapter$SubServiceViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$NavigationAdapter$SubServiceViewHolder(View view) {
            SubCategoryList subCategoryList2 = this.subCategoryList;
            subCategoryList2.setExpanded(!subCategoryList2.isExpanded());
            NavigationAdapter.this.notifyItemChanged(getAdapterPosition());
            int size = this.subCategoryList.getSubCategoryList().size();
            int adapterPosition = getAdapterPosition() + 1;
            if (this.subCategoryList.isExpanded()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = new ArrayList(this.subCategoryList.getSubCategoryList()).iterator();
                while (it.hasNext()) {
                    SubCategoryList subCategoryList3 = (SubCategoryList) it.next();
                    arrayList.add(subCategoryList3);
                    if (subCategoryList3.getSubCategoryList() != null && this.ivArrow.isChecked()) {
                        arrayList.addAll(subCategoryList3.getSubCategoryList());
                    }
                }
                NavigationAdapter.this.objectList.addAll(adapterPosition, arrayList);
                if (this.subCategoryList.getSubCategoryList().size() == 0) {
                    SubCategoryList subCategoryList4 = this.subCategoryList;
                    subCategoryList4.setExpanded(!subCategoryList4.isExpanded());
                }
                NavigationAdapter.this.notifyItemRangeInserted(adapterPosition, size);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = new ArrayList(this.subCategoryList.getSubCategoryList()).iterator();
            while (it2.hasNext()) {
                SubCategoryList subCategoryList5 = (SubCategoryList) it2.next();
                if (NavigationAdapter.this.objectList.contains(subCategoryList5)) {
                    subCategoryList5.setExpanded(false);
                    arrayList2.add(subCategoryList5);
                }
                for (SubCategoryList next : subCategoryList5.getSubCategoryList()) {
                    if (NavigationAdapter.this.objectList.contains(next)) {
                        next.setExpanded(false);
                        arrayList2.add(next);
                    }
                }
            }
            NavigationAdapter.this.objectList.removeAll(arrayList2);
            NavigationAdapter.this.notifyItemRangeRemoved(getAdapterPosition() + 1, arrayList2.size());
        }

        public void onBind(int i, Object obj) {
            SubCategoryList subCategoryList2 = (SubCategoryList) obj;
            this.subCategoryList = subCategoryList2;
            this.tvHeader.setText(subCategoryList2.getCategoryName());
            this.ivArrow.setVisibility(this.subCategoryList.getSubCategoryList().size() > 0 ? 0 : 8);
            this.ivArrow.setChecked(this.subCategoryList.isExpanded());
        }
    }
}
