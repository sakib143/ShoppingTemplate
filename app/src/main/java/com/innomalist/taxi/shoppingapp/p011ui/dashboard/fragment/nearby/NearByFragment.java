package com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnTextChanged;
import com.apptube.ecommerce.R;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.kiandashopping.kiandashopping.BuildConfig;
import com.kiandashopping.kiandashopping.PresenterInterface;
import com.kiandashopping.kiandashopping.base.AppConstants;
import com.kiandashopping.kiandashopping.base.BaseFragment;
import com.kiandashopping.kiandashopping.customview.CustomInfoWindowAdapter;
import com.kiandashopping.kiandashopping.model.nearme.NearByResult;
import com.kiandashopping.kiandashopping.model.nearme.Snippet;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.adapter.SearchAdapter;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.mvp.NearByContractor;
import com.kiandashopping.kiandashopping.p011ui.dashboard.fragment.nearby.mvp.NearByPresenter;
import com.kiandashopping.kiandashopping.p011ui.storedetails.activity.StoreDetailsActivity;
import com.kiandashopping.kiandashopping.util.AppUtils;
import com.kiandashopping.kiandashopping.util.ResourceUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* renamed from: com.kiandashopping.kiandashopping.ui.dashboard.fragment.nearby.NearByFragment */
public class NearByFragment extends BaseFragment implements NearByContractor.View, OnMapReadyCallback {
    private static final int REQUEST_CHECK_SETTINGS = 100;
    private static final String TAG = NearByFragment.class.getSimpleName();
    @BindView(2131362023)
    EditText etSearch;

    /* renamed from: hm */
    public HashMap<String, Bitmap> f241hm = new HashMap<>();
    /* access modifiers changed from: private */
    public Location mCurrentLocation;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;
    private LocationRequest mLocationRequest;
    private LocationSettingsRequest mLocationSettingsRequest;
    private GoogleMap mMap;
    /* access modifiers changed from: private */
    public Boolean mRequestingLocationUpdates;
    private SettingsClient mSettingsClient;
    private NearByPresenter presenter;
    @BindView(2131362248)
    RecyclerView rvSearch;
    private SearchAdapter searchAdapter;
    public String snippet;

    static /* synthetic */ void lambda$stopLocationUpdates$2(Task task) {
    }

    public View provideYourFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_near_me, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.presenter = new NearByPresenter(this);
        initMap();
        init();
        restoreValuesFromBundle(bundle);
        permissionRequest();
    }

    public PresenterInterface getPresenterInterface() {
        return this.presenter;
    }

    private void initMap() {
        this.rvSearch.setVisibility(8);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this);
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        this.mMap.getUiSettings().setMapToolbarEnabled(false);
        this.mMap.setMapType(3);
        this.mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));
    }

    private void init() {
        this.etSearch.setHint(ResourceUtils.getString(R.string.search_your_location));
        this.mFusedLocationClient = LocationServices.getFusedLocationProviderClient((Activity) Objects.requireNonNull(getActivity()));
        this.mSettingsClient = LocationServices.getSettingsClient((Activity) getActivity());
        this.mLocationCallback = new LocationCallback() {
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                Location unused = NearByFragment.this.mCurrentLocation = locationResult.getLastLocation();
                NearByFragment.this.updateLocationUI();
            }
        };
        this.mRequestingLocationUpdates = false;
        this.mLocationRequest = new LocationRequest();
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(this.mLocationRequest);
        this.mLocationSettingsRequest = builder.build();
    }

    private void restoreValuesFromBundle(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("is_requesting_updates")) {
                this.mRequestingLocationUpdates = Boolean.valueOf(bundle.getBoolean("is_requesting_updates"));
            }
            if (bundle.containsKey("last_known_location")) {
                this.mCurrentLocation = (Location) bundle.getParcelable("last_known_location");
            }
        }
        updateLocationUI();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_requesting_updates", this.mRequestingLocationUpdates.booleanValue());
        bundle.putParcelable("last_known_location", this.mCurrentLocation);
    }

    /* access modifiers changed from: private */
    public void startLocationUpdates() {
        this.mSettingsClient.checkLocationSettings(this.mLocationSettingsRequest).addOnSuccessListener((Activity) Objects.requireNonNull(getActivity()), new OnSuccessListener() {
            public final void onSuccess(Object obj) {
                NearByFragment.this.lambda$startLocationUpdates$0$NearByFragment((LocationSettingsResponse) obj);
            }
        }).addOnFailureListener((Activity) getActivity(), (OnFailureListener) new OnFailureListener() {
            public final void onFailure(Exception exc) {
                NearByFragment.this.lambda$startLocationUpdates$1$NearByFragment(exc);
            }
        });
    }

    public /* synthetic */ void lambda$startLocationUpdates$0$NearByFragment(LocationSettingsResponse locationSettingsResponse) {
        Log.i(TAG, "All location settings are satisfied.");
        this.mFusedLocationClient.requestLocationUpdates(this.mLocationRequest, this.mLocationCallback, Looper.myLooper());
        updateLocationUI();
    }

    public /* synthetic */ void lambda$startLocationUpdates$1$NearByFragment(Exception exc) {
        int statusCode = ((ApiException) exc).getStatusCode();
        if (statusCode == 6) {
            try {
                ((ResolvableApiException) exc).startResolutionForResult(getActivity(), 100);
            } catch (IntentSender.SendIntentException unused) {
                Log.i(TAG, "PendingIntent unable to execute request.");
            }
        } else if (statusCode == 8502) {
            Toast.makeText(getActivity(), "Location settings are inadequate, and cannot be fixed here. Fix in Settings.", 1).show();
        }
        updateLocationUI();
    }

    private void stopLocationUpdates() {
        this.mFusedLocationClient.removeLocationUpdates(this.mLocationCallback).addOnCompleteListener((Activity) Objects.requireNonNull(getActivity()), $$Lambda$NearByFragment$Y1tcsbqbJlKno7Dhz4k6fjy5_7c.INSTANCE);
    }

    /* access modifiers changed from: private */
    public void openSettings() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID, (String) null));
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void onPause() {
        super.onPause();
        if (this.mRequestingLocationUpdates.booleanValue()) {
            stopLocationUpdates();
        }
    }

    /* access modifiers changed from: private */
    public void updateLocationUI() {
        Location location = this.mCurrentLocation;
        if (location != null) {
            String valueOf = String.valueOf(location.getLatitude());
            String valueOf2 = String.valueOf(this.mCurrentLocation.getLongitude());
            updateNewLocation(Double.valueOf(valueOf).doubleValue(), Double.valueOf(valueOf2).doubleValue());
            this.presenter.requestNearBy(valueOf, valueOf2);
        }
    }

    private void updateNewLocation(double d, double d2) {
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
        this.mMap.animateCamera(CameraUpdateFactory.zoomTo(13.0f));
    }

    private void permissionRequest() {
        Dexter.withActivity(getActivity()).withPermission("android.permission.ACCESS_FINE_LOCATION").withListener(new PermissionListener() {
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Boolean unused = NearByFragment.this.mRequestingLocationUpdates = true;
                NearByFragment.this.startLocationUpdates();
            }

            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                if (permissionDeniedResponse.isPermanentlyDenied()) {
                    NearByFragment.this.openSettings();
                }
            }

            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    public void showResult(List<NearByResult> list) {
        this.mMap.clear();
        for (NearByResult next : list) {
            String str = "";
            if (next.getDealCount().intValue() != 0) {
                str = str + ResourceUtils.getString(R.string.dealsTxt) + AppConstants.SPACE + next.getDealCount();
            }
            if (next.getProductCount().intValue() != 0) {
                if (!str.isEmpty()) {
                    str = str + AppConstants.SPACE;
                }
                str = str + ResourceUtils.getString(R.string.productsTxt) + AppConstants.SPACE + next.getProductCount();
            }
            this.mMap.addMarker(new MarkerOptions().position(new LatLng(next.getStoreLatitude().doubleValue(), next.getStoreLongitude().doubleValue())).title(next.getStoreName()).snippet(new Gson().toJson((Object) new Snippet(next.getStoreName(), str, next.getStoreImg(), next.getStoreId().intValue()))).icon(AppUtils.getBitmapFromVectorDrawable(getActivity(), R.drawable.ic_marker_map)));
        }
        this.mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            public final void onInfoWindowClick(Marker marker) {
                NearByFragment.this.lambda$showResult$3$NearByFragment(marker);
            }
        });
        SearchAdapter searchAdapter2 = new SearchAdapter(list, new SearchAdapter.Listener() {
            public final void onClick(NearByResult nearByResult) {
                NearByFragment.this.lambda$showResult$4$NearByFragment(nearByResult);
            }
        });
        this.searchAdapter = searchAdapter2;
        this.rvSearch.setAdapter(searchAdapter2);
        this.rvSearch.setVisibility(8);
    }

    public /* synthetic */ void lambda$showResult$3$NearByFragment(Marker marker) {
        try {
            Snippet snippet2 = (Snippet) new Gson().fromJson(marker.getSnippet(), Snippet.class);
            if (snippet2 != null) {
                changeActivity(StoreDetailsActivity.builtIntent(getActivity(), snippet2.getName(), snippet2.getId()));
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public /* synthetic */ void lambda$showResult$4$NearByFragment(NearByResult nearByResult) {
        this.etSearch.setText("");
        hideKeyboard(getActivity(), this.etSearch);
        updateNewLocation(nearByResult.getStoreLatitude().doubleValue(), nearByResult.getStoreLongitude().doubleValue());
    }

    /* access modifiers changed from: package-private */
    @OnTextChanged({2131362023})
    public void onTextChanged(CharSequence charSequence) {
        if (charSequence.toString().equals("")) {
            this.rvSearch.setVisibility(8);
            return;
        }
        this.searchAdapter.getFilter().filter(charSequence);
        this.rvSearch.setVisibility(0);
    }
}
