package com.kiandashopping.kiandashopping.p011ui.dashboard.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.base.BaseApplication;
import com.kiandashopping.kiandashopping.base.BaseViewHolder;
import com.kiandashopping.kiandashopping.p011ui.dashboard.adapter.NavigationAdapter;
import com.kiandashopping.kiandashopping.util.GlideUtils;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.viewholder.UserInfoViewHolder */
public class UserInfoViewHolder extends BaseViewHolder implements View.OnClickListener {
    @BindView(2131362101)
    ImageView ivProfile;
    private NavigationAdapter.Listener listener;
    @BindView(2131362372)
    TextView tvEmail;
    @BindView(2131362424)
    TextView tvUserName;

    public void setListener(NavigationAdapter.Listener listener2) {
        this.listener = listener2;
    }

    public UserInfoViewHolder(View view) {
        super(view);
        view.setOnClickListener(this);
    }

    public void onBind(int i, Object obj) {
        this.tvUserName.setText(BaseApplication.getAppRepository().getFirstName());
        this.tvEmail.setText(BaseApplication.getAppRepository().getEmail());
        GlideUtils.showRoundImage(this.itemView.getContext(), this.ivProfile, R.drawable.user_placeholder, BaseApplication.getAppRepository().getAvatar());
    }

    public void onClick(View view) {
        this.listener.onClickProfile();
    }
}
