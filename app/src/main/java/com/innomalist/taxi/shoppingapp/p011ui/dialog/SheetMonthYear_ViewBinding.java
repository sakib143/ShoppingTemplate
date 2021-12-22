package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.view.View;
import android.widget.DatePicker;
import butterknife.internal.Utils;
//import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment_ViewBinding;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.SheetMonthYear_ViewBinding */
public class SheetMonthYear_ViewBinding extends BaseSheetFragment_ViewBinding {
    private SheetMonthYear target;

    public SheetMonthYear_ViewBinding(SheetMonthYear sheetMonthYear, View view) {
        super(sheetMonthYear, view);
        this.target = sheetMonthYear;
        sheetMonthYear.datePicker = (DatePicker) Utils.findRequiredViewAsType(view, R.id.date_picker, "field 'datePicker'", DatePicker.class);
    }

    public void unbind() {
        SheetMonthYear sheetMonthYear = this.target;
        if (sheetMonthYear != null) {
            this.target = null;
            sheetMonthYear.datePicker = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
