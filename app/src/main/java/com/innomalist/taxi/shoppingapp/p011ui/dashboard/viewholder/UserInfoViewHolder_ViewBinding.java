package com.kiandashopping.kiandashopping.p011ui.dashboard.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.apptube.ecommerce.R;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.viewholder.UserInfoViewHolder_ViewBinding */
public class UserInfoViewHolder_ViewBinding implements Unbinder {
    private UserInfoViewHolder target;

    public UserInfoViewHolder_ViewBinding(UserInfoViewHolder userInfoViewHolder, View view) {
        this.target = userInfoViewHolder;
        userInfoViewHolder.ivProfile = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivProfile, "field 'ivProfile'", ImageView.class);
        userInfoViewHolder.tvUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tvUserName, "field 'tvUserName'", TextView.class);
        userInfoViewHolder.tvEmail = (TextView) Utils.findRequiredViewAsType(view, R.id.tvEmail, "field 'tvEmail'", TextView.class);
    }

    public void unbind() {
        UserInfoViewHolder userInfoViewHolder = this.target;
        if (userInfoViewHolder != null) {
            this.target = null;
            userInfoViewHolder.ivProfile = null;
            userInfoViewHolder.tvUserName = null;
            userInfoViewHolder.tvEmail = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
