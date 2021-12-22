package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
import com.innomalist.taxi.shoppingapp.R;
import com.kiandashopping.kiandashopping.base.BaseDialogFragment_ViewBinding;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogChangeLanguage_ViewBinding */
public class DialogChangeLanguage_ViewBinding extends BaseDialogFragment_ViewBinding {
    private DialogChangeLanguage target;

    public DialogChangeLanguage_ViewBinding(DialogChangeLanguage dialogChangeLanguage, View view) {
        super(dialogChangeLanguage, view);
        this.target = dialogChangeLanguage;
        dialogChangeLanguage.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.dialog_rv, "field 'recyclerView'", RecyclerView.class);
    }

    public void unbind() {
        DialogChangeLanguage dialogChangeLanguage = this.target;
        if (dialogChangeLanguage != null) {
            this.target = null;
            dialogChangeLanguage.recyclerView = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
