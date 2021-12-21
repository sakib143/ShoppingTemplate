package com.kiandashopping.kiandashopping.p011ui.dialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;
import java.util.Objects;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogDatePicker */
public class DialogDatePicker extends DialogFragment {
    /* access modifiers changed from: private */
    public Calendar MaxDate;
    /* access modifiers changed from: private */
    public Calendar MinDate;
    private Context context;

    /* renamed from: dd */
    DatePickerDialog f244dd;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    public DialogDatePicker() {
    }

    public DialogDatePicker(DatePickerDialog.OnDateSetListener onDateSetListener, Calendar calendar, Calendar calendar2, Context context2) {
        this.mDateSetListener = onDateSetListener;
        this.MinDate = calendar;
        this.MaxDate = calendar2;
        this.context = context2;
    }

    public DialogDatePicker(DatePickerDialog.OnDateSetListener onDateSetListener, Context context2) {
        this.mDateSetListener = onDateSetListener;
        this.context = context2;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog((Context) Objects.requireNonNull(getActivity()), this.mDateSetListener, instance.get(1), instance.get(2), instance.get(5));
        this.f244dd = datePickerDialog;
        datePickerDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                try {
                    if (DialogDatePicker.this.MinDate != null && DialogDatePicker.this.MaxDate != null) {
                        ((DatePickerDialog) dialogInterface).getDatePicker().setMaxDate(DialogDatePicker.this.MaxDate.getTimeInMillis());
                        ((DatePickerDialog) dialogInterface).getDatePicker().setMinDate(DialogDatePicker.this.MinDate.getTimeInMillis());
                    }
                } catch (NullPointerException e) {
                    dialogInterface.dismiss();
                    e.printStackTrace();
                }
            }
        });
        getActivity().getWindow().setSoftInputMode(3);
        return this.f244dd;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
