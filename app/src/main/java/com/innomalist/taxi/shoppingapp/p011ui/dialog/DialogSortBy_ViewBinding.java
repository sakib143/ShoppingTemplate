package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment_ViewBinding;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogSortBy_ViewBinding */
public class DialogSortBy_ViewBinding extends BaseSheetFragment_ViewBinding {
    private DialogSortBy target;

    public DialogSortBy_ViewBinding(DialogSortBy dialogSortBy, View view) {
        super(dialogSortBy, view);
        this.target = dialogSortBy;
        dialogSortBy.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.dialog_rv, "field 'recyclerView'", RecyclerView.class);
    }

    public void unbind() {
        DialogSortBy dialogSortBy = this.target;
        if (dialogSortBy != null) {
            this.target = null;
            dialogSortBy.recyclerView = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
