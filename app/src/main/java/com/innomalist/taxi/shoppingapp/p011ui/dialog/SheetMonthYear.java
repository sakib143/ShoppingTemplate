package com.kiandashopping.kiandashopping.p011ui.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.base.BaseSheetFragment;
import com.kiandashopping.kiandashopping.util.DateTime;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import com.kiandashopping.kiandashopping.util.ViewUtils;
import java.util.Calendar;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.SheetMonthYear */
public class SheetMonthYear extends BaseSheetFragment {
    Calendar calendar;
    String cardMonth = "";
    String cardYear = "";
    @BindView(2131361969)
    DatePicker datePicker;
    Listener listener;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.SheetMonthYear$Listener */
    public interface Listener {
        void onSubmit(String str, String str2);
    }

    public static SheetMonthYear newInstance(BaseActivity baseActivity) {
        SheetMonthYear sheetMonthYear = new SheetMonthYear();
        sheetMonthYear.setCustomLayout(R.layout.dialog_month_year);
        sheetMonthYear.setActivity(baseActivity);
        sheetMonthYear.setTitle(ResourceUtils.getString(R.string.expiration_date));
        sheetMonthYear.setPositive(ResourceUtils.getString(R.string.dialog_btn_submit));
        sheetMonthYear.setCanceledOnTouchOutside(true);
        return sheetMonthYear;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Calendar instance = Calendar.getInstance();
        this.calendar = instance;
        this.datePicker.setMinDate(instance.getTimeInMillis());
        ViewUtils.hideDay(this.datePicker);
    }

    public void show(Listener listener2) {
        this.listener = listener2;
        show();
    }

    public void onClickPositive() {
        this.calendar.set(1, this.datePicker.getYear());
        this.calendar.set(2, this.datePicker.getMonth());
        this.cardMonth = DateTime.getFormatMonth(this.calendar.getTime());
        String formatYear = DateTime.getFormatYear(this.calendar.getTime());
        this.cardYear = formatYear;
        this.listener.onSubmit(this.cardMonth, formatYear);
        dismiss();
    }
}
