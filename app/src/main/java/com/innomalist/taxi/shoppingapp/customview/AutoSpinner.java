package com.kiandashopping.kiandashopping.customview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.apptube.ecommerce.R;
import java.util.List;

public class AutoSpinner implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ArrayAdapter<String> arrayAdapter;
    private AutoCompleteTextView autoCompleteTextView;
    private Listener listener;
    private int selectedPosition;
    private List strings;

    public interface Listener {
        void onSelectItem(int i);
    }

    public AutoSpinner(AutoCompleteTextView autoCompleteTextView2, List list) {
        this.strings = list;
        this.autoCompleteTextView = autoCompleteTextView2;
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(autoCompleteTextView2.getContext(), R.layout.simple_drop_down, this.strings);
        this.arrayAdapter = arrayAdapter2;
        autoCompleteTextView2.setAdapter(arrayAdapter2);
        autoCompleteTextView2.setOnClickListener(this);
        autoCompleteTextView2.setOnItemClickListener(this);
        if (list.size() == 0) {
            autoCompleteTextView2.setText("");
        }
        autoCompleteTextView2.setOnClickListener(new View.OnClickListener(autoCompleteTextView2) {
            private final /* synthetic */ AutoCompleteTextView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                AutoSpinner.this.lambda$new$0$AutoSpinner(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$AutoSpinner(AutoCompleteTextView autoCompleteTextView2, View view) {
        if (this.strings.size() > 0) {
            if (!autoCompleteTextView2.getText().toString().equals("")) {
                this.arrayAdapter.getFilter().filter((CharSequence) null);
            }
            autoCompleteTextView2.showDropDown();
        }
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }

    public void onClick(View view) {
        this.autoCompleteTextView.showDropDown();
    }

    public void setSelectedPosition(int i) {
        this.autoCompleteTextView.setText(this.strings.get(i).toString());
        this.selectedPosition = i;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.selectedPosition = i;
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onSelectItem(i);
        }
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }
}
