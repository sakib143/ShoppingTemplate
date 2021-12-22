package com.innomalist.taxi.shoppingapp.p011ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.base.BaseDialogFragment;
import com.innomalist.taxi.shoppingapp.model.lang.Languages;
import com.innomalist.taxi.shoppingapp.p011ui.dialog.adapter.DialogLanguageAdapter;
import com.innomalist.taxi.shoppingapp.util.AppUtils;
import com.innomalist.taxi.shoppingapp.util.ResourceUtils;

import butterknife.BindView;
//import com.apptube.ecommerce.R;
//import com.kiandashopping.kiandashopping.base.BaseActivity;
//import com.kiandashopping.kiandashopping.base.BaseDialogFragment;
//import com.kiandashopping.kiandashopping.model.lang.Languages;
//import com.kiandashopping.kiandashopping.p011ui.dialog.adapter.DialogLanguageAdapter;
//import com.kiandashopping.kiandashopping.util.AppUtils;
//import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogChangeLanguage */
public class DialogChangeLanguage extends BaseDialogFragment implements DialogLanguageAdapter.LanguageListener {
    DialogLanguageAdapter adapter;
    private String lang = "";
    private LanguageListener languageListener;
    private ArrayList<Languages> languages;
    @BindView(2131361982)
    RecyclerView recyclerView;

    /* renamed from: com.kiandashopping.kiandashopping.ui.dialog.DialogChangeLanguage$LanguageListener */
    public interface LanguageListener {
        void onSelected(String str);
    }

    public static DialogChangeLanguage newInstance(BaseActivity baseActivity) {
        DialogChangeLanguage dialogChangeLanguage = new DialogChangeLanguage();
        dialogChangeLanguage.setCustomLayout(R.layout.dialog_recyclerview);
        dialogChangeLanguage.setActivity(baseActivity);
        dialogChangeLanguage.setTitle(ResourceUtils.getString(R.string.dialog_change_language));
        dialogChangeLanguage.setMessage(ResourceUtils.getString(R.string.dialog_select_your_language));
        dialogChangeLanguage.setPositive(ResourceUtils.getString(R.string.dialog_btn_submit));
        dialogChangeLanguage.setNegative((String) null);
        dialogChangeLanguage.setCanceledOnTouchOutside(false);
        return dialogChangeLanguage;
    }

    public void setLang(int i) {
        this.lang = this.languages.get(i).getLanguageCode();
        for (int i2 = 0; i2 < this.languages.size(); i2++) {
            this.languages.get(i2).setActive(false);
        }
        this.languages.get(i).setActive(true);
        this.adapter.notifyDataSetChanged();
    }

    public void show(LanguageListener languageListener2, String str) {
        this.languageListener = languageListener2;
        this.lang = str;
        show();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ArrayList<Languages> languages2 = AppUtils.getLanguages(this.lang);
        this.languages = languages2;
        this.adapter = new DialogLanguageAdapter(this, languages2);
        this.recyclerView.addItemDecoration(new DividerItemDecoration((Context) Objects.requireNonNull(getActivity()), 1));
        this.recyclerView.setAdapter(this.adapter);
    }

    public void onClickPositive() {
        dismiss();
        this.languageListener.onSelected(this.lang);
    }
}
