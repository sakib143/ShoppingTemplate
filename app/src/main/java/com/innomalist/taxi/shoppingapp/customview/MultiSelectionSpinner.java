package com.kiandashopping.kiandashopping.customview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;
import com.kiandashopping.kiandashopping.base.AppConstants;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MultiSelectionSpinner extends AppCompatSpinner implements DialogInterface.OnMultiChoiceClickListener {
    String[] _items = null;
    boolean[] mSelection = null;
    ArrayAdapter<String> simple_adapter;

    public MultiSelectionSpinner(Context context) {
        super(context);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, 17367048);
        this.simple_adapter = arrayAdapter;
        super.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    public MultiSelectionSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, 17367048);
        this.simple_adapter = arrayAdapter;
        super.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    public void onClick(DialogInterface dialogInterface, int i, boolean z) {
        boolean[] zArr = this.mSelection;
        if (zArr == null || i >= zArr.length) {
            throw new IllegalArgumentException("Argument 'which' is out of bounds.");
        }
        zArr[i] = z;
        this.simple_adapter.clear();
        this.simple_adapter.add(buildSelectedItemString());
    }

    public boolean performClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMultiChoiceItems(this._items, this.mSelection, this);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        throw new RuntimeException("setAdapter is not supported by MultiSelectSpinner.");
    }

    public void setItems(String[] strArr, String str) {
        this._items = strArr;
        this.mSelection = new boolean[strArr.length];
        this.simple_adapter.clear();
        this.simple_adapter.add(str);
        Arrays.fill(this.mSelection, false);
    }

    public void setItems(List<String> list) {
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        this._items = strArr;
        this.mSelection = new boolean[strArr.length];
        this.simple_adapter.clear();
        this.simple_adapter.add(this._items[0]);
        Arrays.fill(this.mSelection, false);
    }

    public void setSelection(String[] strArr) {
        for (String str : strArr) {
            int i = 0;
            while (true) {
                String[] strArr2 = this._items;
                if (i >= strArr2.length) {
                    break;
                }
                if (strArr2[i].equals(str)) {
                    this.mSelection[i] = true;
                }
                i++;
            }
        }
    }

    public void setSelection(List<String> list) {
        int i = 0;
        while (true) {
            boolean[] zArr = this.mSelection;
            if (i >= zArr.length) {
                break;
            }
            zArr[i] = false;
            i++;
        }
        for (String next : list) {
            int i2 = 0;
            while (true) {
                String[] strArr = this._items;
                if (i2 < strArr.length) {
                    if (strArr[i2].equals(next)) {
                        this.mSelection[i2] = true;
                    }
                    i2++;
                }
            }
        }
        this.simple_adapter.clear();
        this.simple_adapter.add(buildSelectedItemString());
    }

    public void setSelection(int i) {
        boolean[] zArr;
        int i2 = 0;
        while (true) {
            zArr = this.mSelection;
            if (i2 >= zArr.length) {
                break;
            }
            zArr[i2] = false;
            i2++;
        }
        if (i < 0 || i >= zArr.length) {
            throw new IllegalArgumentException("Index " + i + " is out of bounds.");
        }
        zArr[i] = true;
        this.simple_adapter.clear();
        this.simple_adapter.add(buildSelectedItemString());
    }

    public void setSelection(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.mSelection;
            if (i2 >= zArr.length) {
                break;
            }
            zArr[i2] = false;
            i2++;
        }
        int length = iArr.length;
        while (i < length) {
            int i3 = iArr[i];
            if (i3 >= 0) {
                boolean[] zArr2 = this.mSelection;
                if (i3 < zArr2.length) {
                    zArr2[i3] = true;
                    i++;
                }
            }
            throw new IllegalArgumentException("Index " + i3 + " is out of bounds.");
        }
        this.simple_adapter.clear();
        this.simple_adapter.add(buildSelectedItemString());
    }

    public List<String> getSelectedStrings() {
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            String[] strArr = this._items;
            if (i >= strArr.length) {
                return linkedList;
            }
            if (this.mSelection[i]) {
                linkedList.add(strArr[i]);
            }
            i++;
        }
    }

    public List<Integer> getSelectedIndicies() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < this._items.length; i++) {
            if (this.mSelection[i]) {
                linkedList.add(Integer.valueOf(i));
            }
        }
        return linkedList;
    }

    private String buildSelectedItemString() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < this._items.length; i++) {
            if (this.mSelection[i]) {
                if (z) {
                    sb.append(", ");
                }
                sb.append(this._items[i]);
                z = true;
            }
        }
        return sb.toString();
    }

    public String getSelectedItemsAsString() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < this._items.length; i++) {
            if (this.mSelection[i]) {
                if (z) {
                    sb.append(AppConstants.COMMA);
                }
                sb.append(this._items[i]);
                z = true;
            }
        }
        return sb.toString();
    }
}
