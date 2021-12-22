package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
import com.innomalist.taxi.shoppingapp.R;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment_ViewBinding;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogFilter_ViewBinding */
public class DialogFilter_ViewBinding extends BaseSheetFragment_ViewBinding {
    private DialogFilter target;

    public DialogFilter_ViewBinding(DialogFilter dialogFilter, View view) {
        super(dialogFilter, view);
        this.target = dialogFilter;
        dialogFilter.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.dialog_rv, "field 'recyclerView'", RecyclerView.class);
    }

    public void unbind() {
        DialogFilter dialogFilter = this.target;
        if (dialogFilter != null) {
            this.target = null;
            dialogFilter.recyclerView = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
