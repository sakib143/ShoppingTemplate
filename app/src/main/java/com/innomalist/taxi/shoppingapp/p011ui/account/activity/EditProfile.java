package com.innomalist.taxi.shoppingapp.p011ui.account.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.OnClick;

import com.innomalist.taxi.shoppingapp.R;
import com.innomalist.taxi.shoppingapp.base.BaseActivity;
import com.innomalist.taxi.shoppingapp.model.accountdetail.ShippingDetail;
import com.innomalist.taxi.shoppingapp.model.accountdetail.UserDetail;
import com.kiandashopping.kiandashopping.customview.AutoSpinner;
import com.kiandashopping.kiandashopping.p011ui.account.mvp.EditProfileContractor;
import com.kiandashopping.kiandashopping.p011ui.account.mvp.EditProfilePresenter;
import com.kiandashopping.kiandashopping.util.ConversionUtils;
import com.kiandashopping.kiandashopping.util.GlideUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kiandashopping.kiandashopping.ui.account.activity.EditProfile */
public class EditProfile extends BaseActivity implements EditProfileContractor.View {
    public static final int IMAGE_REQUEST = 201;
    String cityId = "";
    String countryId = "";
    @BindView(2131362006)
    AppCompatAutoCompleteTextView etCity;
    @BindView(2131362008)
    AppCompatAutoCompleteTextView etCountry;
    @BindView(2131362010)
    EditText etEmail;
    @BindView(2131362020)
    EditText etPhone;
    @BindView(2131362026)
    EditText etUserName;
    File imageFile = null;
    @BindView(2131362089)
    ImageView ivAvatar;
    @BindView(2131362166)
    NestedScrollView nsv;
    EditProfilePresenter presenter;
    ArrayList<ShippingDetail> shippingDetails;
    ArrayList<UserDetail> userDetails;

    public int getLayout() {
        return R.layout.activity_edit_profile;
    }

    public void onImageChosen(int i, Uri uri) {
        super.onImageChosen(i, uri);
        if (201 == i) {
            File file = new File(uri.getPath());
            GlideUtils.showRoundImage((Context) this, this.ivAvatar, file);
            this.imageFile = file;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menuItem = menu.findItem(R.id.notification);
        this.menuItem.setVisible(false);
        return true;
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361967})
    public void onClickAvatar() {
        pickImage(201, CropImageView.CropShape.RECTANGLE, 4, 4);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.presenter = new EditProfilePresenter(this);
        setupToolBar();
        this.nsv.setVisibility(8);
        this.title.setText(ResourceUtils.getString(R.string.edit_profile));
        this.presenter.requestCountry();
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    @OnClick({2131361913})
    public void onClickUpdateProfile() {
        String trim = this.etUserName.getText().toString().trim();
        String trim2 = this.etEmail.getText().toString().trim();
        String trim3 = this.etPhone.getText().toString().trim();
        if (this.shippingDetails.size() > 0) {
            this.presenter.updateProfile(this.imageFile, trim, trim2, trim3, this.countryId, this.cityId, this.shippingDetails.get(0));
        }
    }

    public void showUpdateSuccess(String str) {
        showSuccess(ResourceUtils.getString(R.string.dialog_title_success), str, true);
    }

    public void showResult(List<CountryDetail> list, AccountDetailResult accountDetailResult) {
        new AutoSpinner(this.etCountry, list).setListener(new AutoSpinner.Listener(list) {
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void onSelectItem(int i) {
                EditProfile.this.lambda$showResult$1$EditProfile(this.f$1, i);
            }
        });
        this.userDetails = accountDetailResult.getUserDetails();
        this.shippingDetails = accountDetailResult.getShippingDetails();
        setProfileDetails(this.userDetails);
    }

    public /* synthetic */ void lambda$showResult$1$EditProfile(List list, int i) {
        this.countryId = ConversionUtils.parseString(((CountryDetail) list.get(i)).getCountryId().intValue());
        new AutoSpinner(this.etCity, ((CountryDetail) list.get(i)).getCityDetails()).setListener(new AutoSpinner.Listener(list, i) {
            private final /* synthetic */ List f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onSelectItem(int i) {
                EditProfile.this.lambda$null$0$EditProfile(this.f$1, this.f$2, i);
            }
        });
    }

    public /* synthetic */ void lambda$null$0$EditProfile(List list, int i, int i2) {
        this.cityId = ConversionUtils.parseString(((CountryDetail) list.get(i)).getCityDetails().get(i2).getCityId().intValue());
    }

    private void setProfileDetails(ArrayList<UserDetail> arrayList) {
        this.nsv.setVisibility(0);
        if (arrayList.size() > 0) {
            this.etUserName.setText(arrayList.get(0).getCusName());
            this.etPhone.setText(arrayList.get(0).getCusPhone());
            this.etEmail.setText(arrayList.get(0).getCusEmail());
            this.etCountry.setText(arrayList.get(0).getCusCountryName());
            this.etCity.setText(arrayList.get(0).getCusCityName());
            this.cityId = arrayList.get(0).getCityId();
            this.countryId = arrayList.get(0).getCountryId();
            GlideUtils.showRoundImage(this, this.ivAvatar, R.drawable.user_placeholder, arrayList.get(0).getCusImage());
        }
    }
}
