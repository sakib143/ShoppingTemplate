package com.kiandashopping.kiandashopping.customview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import java.util.List;

public class AutoSpinnerValue<T> implements View.OnClickListener, AdapterView.OnItemClickListener {
    ArrayAdapter<T> arrayAdapter;
    ClickListener<T> clickListener;
    IdListener<T> idListener;
    Integer selectedPosition;
    AppCompatAutoCompleteTextView textView;
    List<T> values;

    public interface ClickListener<T> {
        void onSelectItem(int i, T t);
    }

    public interface IdListener<T> {
        String getId(T t);
    }

    public AutoSpinnerValue(AppCompatAutoCompleteTextView appCompatAutoCompleteTextView, List<T> list, IdListener<T> idListener2, ClickListener<T> clickListener2, String str) {
        this.textView = appCompatAutoCompleteTextView;
        this.values = list;
        this.idListener = idListener2;
        this.clickListener = clickListener2;
        ArrayAdapter<T> arrayAdapter2 = new ArrayAdapter<>(appCompatAutoCompleteTextView.getContext(), 17367050, list);
        this.arrayAdapter = arrayAdapter2;
        appCompatAutoCompleteTextView.setAdapter(arrayAdapter2);
        if (str != null) {
            setSelectionById(str);
        }
        appCompatAutoCompleteTextView.setOnClickListener(this);
        appCompatAutoCompleteTextView.setOnItemClickListener(this);
        appCompatAutoCompleteTextView.setOnClickListener(new View.OnClickListener(list, appCompatAutoCompleteTextView) {
            private final /* synthetic */ List f$1;
            private final /* synthetic */ AppCompatAutoCompleteTextView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                AutoSpinnerValue.this.lambda$new$0$AutoSpinnerValue(this.f$1, this.f$2, view);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$AutoSpinnerValue(List list, AppCompatAutoCompleteTextView appCompatAutoCompleteTextView, View view) {
        if (list.size() > 0) {
            if (!appCompatAutoCompleteTextView.getText().toString().equals("")) {
                this.arrayAdapter.getFilter().filter((CharSequence) null);
            }
            appCompatAutoCompleteTextView.showDropDown();
        }
    }

    private void setSelectionById(String str) {
        for (T next : this.values) {
            if (String.valueOf(this.idListener.getId(next)).equals(str)) {
                this.selectedPosition = Integer.valueOf(this.values.indexOf(next));
                this.textView.setText(next.toString());
                return;
            }
        }
    }

    public void onClick(View view) {
        this.textView.showDropDown();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Integer valueOf = Integer.valueOf(i);
        this.selectedPosition = valueOf;
        this.clickListener.onSelectItem(valueOf.intValue(), getSelectedValue());
    }

    public T getSelectedValue() {
        Integer num = this.selectedPosition;
        if (num == null) {
            return null;
        }
        return this.values.get(num.intValue());
    }

    public int getSelectedPosition() {
        return this.selectedPosition.intValue();
    }
}
