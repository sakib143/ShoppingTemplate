package com.kiandashopping.kiandashopping.p011ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.apptube.ecommerce.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.kiandashopping.kiandashopping.base.BaseActivity;
import com.kiandashopping.kiandashopping.p011ui.dialog.DialogEmail;
import com.kiandashopping.kiandashopping.p011ui.login.SocialActivity;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.Arrays;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kiandashopping.kiandashopping.ui.login.SocialActivity */
public abstract class SocialActivity extends BaseActivity {
    private static final String EMAIL = "email";
    public static final String FACEBOOK = "facebook";
    public static final String GOOGLE = "google";

    /* renamed from: ID */
    private static final String f252ID = "id";
    private static final String NAME = "name";
    private static final String PUBLIC_PROFILE = "public_profile";
    private static final int REQ_GOOGLE = 100;
    private static final String TAG = "SocialActivity";
    private CallbackManager callbackManager;
    FacebookCallback facebookCallback = new FacebookCallback<LoginResult>() {
        public void onSuccess(LoginResult loginResult) {
            GraphRequest newMeRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                public final void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
                    SocialActivity.C15671.this.lambda$onSuccess$0$SocialActivity$1(jSONObject, graphResponse);
                }
            });
            newMeRequest.setParameters(SocialActivity.this.getLoginBundle());
            newMeRequest.executeAsync();
        }

        public /* synthetic */ void lambda$onSuccess$0$SocialActivity$1(JSONObject jSONObject, GraphResponse graphResponse) {
            Log.i(SocialActivity.TAG, graphResponse.toString());
            try {
                getFacebookData(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private void getFacebookData(JSONObject jSONObject) throws JSONException {
            if (jSONObject.has("email")) {
                SocialActivity.this.onSocialLoginSuccess(jSONObject.getString("id"), jSONObject.getString("name"), "", jSONObject.getString("email"), SocialActivity.FACEBOOK);
            } else if (!jSONObject.has("email")) {
                showEmailDialog(jSONObject.getString("id"), jSONObject.getString("name"));
            }
        }

        public void showEmailDialog(String str, String str2) {
            DialogEmail newInstance = DialogEmail.newInstance(SocialActivity.this);
            newInstance.show(new DialogEmail.EmailListener(newInstance, str, str2) {
                private final /* synthetic */ DialogEmail f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ String f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onSubmitEmail(String str) {
                    SocialActivity.C15671.this.lambda$showEmailDialog$1$SocialActivity$1(this.f$1, this.f$2, this.f$3, str);
                }
            });
        }

        public /* synthetic */ void lambda$showEmailDialog$1$SocialActivity$1(DialogEmail dialogEmail, String str, String str2, String str3) {
            LoginManager.getInstance().logOut();
            dialogEmail.dismiss();
            SocialActivity.this.onSocialLoginSuccess(str, str2, "", str3, SocialActivity.FACEBOOK);
        }

        public void onCancel() {
            SocialActivity socialActivity = SocialActivity.this;
            socialActivity.showToast(socialActivity.getString(R.string.login_request_cancelled));
        }

        public void onError(FacebookException facebookException) {
            SocialActivity.this.showConnectionError(facebookException.getMessage());
        }
    };
    private GoogleApiClient mGoogleApiClient;
    GoogleApiClient.OnConnectionFailedListener onConnectionFailed = new GoogleApiClient.OnConnectionFailedListener() {
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            SocialActivity.this.lambda$new$0$SocialActivity(connectionResult);
        }
    };

    public abstract void onSocialLoginSuccess(String str, String str2, String str3, String str4, String str5);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.callbackManager = CallbackManager.Factory.create();
        this.mGoogleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this.onConnectionFailed).addApi(Auth.GOOGLE_SIGN_IN_API, getGoogleSignInOption()).build();
    }

    private GoogleSignInOptions getGoogleSignInOption() {
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
    }

    /* access modifiers changed from: private */
    public Bundle getLoginBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id, name, email, picture");
        return bundle;
    }

    public /* synthetic */ void lambda$new$0$SocialActivity(ConnectionResult connectionResult) {
        showConnectionError(ResourceUtils.getString(R.string.no_internet_connection));
    }

    public void onClickFaceBook() {
        LoginManager.getInstance().logInWithReadPermissions((Activity) this, (Collection<String>) Arrays.asList(new String[]{PUBLIC_PROFILE, "email"}));
        LoginManager.getInstance().registerCallback(this.callbackManager, this.facebookCallback);
    }

    public void onClickGooglePlus() {
        startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(this.mGoogleApiClient), 100);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            handleSignInResult(Auth.GoogleSignInApi.getSignInResultFromIntent(intent));
        } else {
            this.callbackManager.onActivityResult(i, i2, intent);
        }
    }

    private void handleSignInResult(GoogleSignInResult googleSignInResult) {
        if (googleSignInResult.isSuccess()) {
            GoogleSignInAccount signInAccount = googleSignInResult.getSignInAccount();
            onSocialLoginSuccess(signInAccount.getId(), signInAccount.getDisplayName(), "", signInAccount.getEmail(), GOOGLE);
            return;
        }
        Log.e(TAG, googleSignInResult.getStatus().toString());
    }
}
