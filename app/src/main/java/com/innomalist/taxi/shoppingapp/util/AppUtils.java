package com.innomalist.taxi.shoppingapp.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.util.Base64;
import android.util.Log;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.innomalist.taxi.shoppingapp.base.AppConstants;
import com.innomalist.taxi.shoppingapp.model.register.RequestRegister;
import com.innomalist.taxi.shoppingapp.model.storelist.DealListByShop;
import com.innomalist.taxi.shoppingapp.model.storelist.ProductListByShop;
import com.innomalist.taxi.shoppingapp.model.storelist.StoreReview;
import com.kiandashopping.kiandashopping.customview.CustomTypefaceSpan;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit2.HttpException;

public final class AppUtils {
    public static float getAlpha(float f, float f2, float f3) {
        if (f < f2) {
            return 0.0f;
        }
        if (f3 < f) {
            return 1.0f;
        }
        return (f - f2) * (f3 / (f3 - f2));
    }

    private AppUtils() {
    }

    public static void getHashKey(Context context) {
        try {
            for (Signature byteArray : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
                MessageDigest instance = MessageDigest.getInstance("SHA");
                instance.update(byteArray.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(instance.digest(), 0));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("KeyHash:", e.toString());
        } catch (NoSuchAlgorithmException e2) {
            Log.e("KeyHash:", e2.toString());
        }
    }

    public static String append(String str, double d) {
        return str + com.kiandashopping.kiandashopping.util.ConversionUtils.parseString(d);
    }

    public static String getAmount(String str, String str2) {
        return str + str2;
    }

    public static String getAmountSymbol(String str, String str2) {
        return str2 + str;
    }

    public static String getPercentageSymbol(String str, String str2) {
        return str + str2;
    }

    public static String getBonusPts(String str, String str2) {
        return str + AppConstants.SPACE + str2;
    }

    public static String appendFromTo(String str, String str2) {
        return str + AppConstants.HYPHEN + str2;
    }

    public static String getString(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return "";
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return "";
        }
    }

    public static int getInt(Intent intent, String str) {
        try {
            return intent.getIntExtra(str, 0);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return 0;
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return 0;
        }
    }

    public static Boolean getBoolean(Intent intent, String str) {
        try {
            return Boolean.valueOf(intent.getBooleanExtra(str, false));
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return false;
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return false;
        }
    }

    public static Boolean getBoolean(Bundle bundle, String str) {
        try {
            return Boolean.valueOf(bundle.getBoolean(str, false));
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return false;
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return false;
        }
    }

    public static ShippingDetail getShippingDetails(Intent intent, String str) {
        try {
            return (ShippingDetail) intent.getParcelableExtra(str);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return new ShippingDetail();
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return new ShippingDetail();
        }
    }

    public static ArrayList<StoreDetail> getStoreDetails(Bundle bundle, String str) {
        try {
            return bundle.getParcelableArrayList(str);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return new ArrayList<>();
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return new ArrayList<>();
        }
    }

    public static ArrayList<DealListByShop> getDealDetails(Bundle bundle, String str) {
        try {
            return bundle.getParcelableArrayList(str);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return new ArrayList<>();
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return new ArrayList<>();
        }
    }

    public static List<ProductListByShop> getProductDetails(Bundle bundle, String str) {
        try {
            return bundle.getParcelableArrayList(str);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return new ArrayList();
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return new ArrayList();
        }
    }

    public static ArrayList<StoreReview> getStoreReviews(Bundle bundle, String str) {
        try {
            return bundle.getParcelableArrayList(str);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return new ArrayList<>();
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return new ArrayList<>();
        }
    }

    public static RequestRegister getRegisterDetails(Intent intent, String str) {
        try {
            return (RequestRegister) intent.getParcelableExtra(str);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return null;
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return null;
        }
    }

    public static int getInt(Bundle bundle, String str) {
        try {
            return bundle.getInt(str, 0);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return 0;
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return 0;
        }
    }

    public static String getString(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (NullPointerException e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return "";
        } catch (Exception e2) {
            Log.e(AppConstants.EXCEPTION, e2.toString());
            return "";
        }
    }

    public static Fragment replaceFragment(FragmentManager fragmentManager, int i, Fragment fragment, String str) {
        try {
            fragmentManager.popBackStackImmediate();
        } catch (IllegalStateException unused) {
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.setCustomAnimations(17432576, 17432577);
        beginTransaction.replace(i, fragment, str);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commitAllowingStateLoss();
        return fragment;
    }

    public static CircularProgressDrawable getProgressDrawable() {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(BaseApplication.getContext());
        circularProgressDrawable.setStrokeWidth(5.0f);
        circularProgressDrawable.setCenterRadius(30.0f);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }

    public static SpannableString setHyphenColor(String str) {
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(AppConstants.HYPHEN).matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(BaseApplication.getContext().getResources().getColor(R.color._colorPrimary)), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    public static SpannableStringBuilder setSuperScript(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getAmount(str, str2));
        spannableStringBuilder.setSpan(new SuperscriptSpan(), 0, 1, 33);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.75f), 0, 1, 33);
        return spannableStringBuilder;
    }

    public static String getError(Throwable th) {
        ResourceUtils.getString(R.string.network_error);
        if (th instanceof HttpException) {
            return NetworkUtils.getErrorMessage(((HttpException) th).response().errorBody());
        }
        if (th instanceof SocketTimeoutException) {
            return ResourceUtils.getString(R.string.time_out_error);
        }
        if (th instanceof IOException) {
            return ResourceUtils.getString(R.string.network_error);
        }
        return th.getMessage();
    }

    public static ArrayList<NavigationMenu> getMenu() {
        ArrayList<NavigationMenu> arrayList = new ArrayList<>();
        arrayList.add(new NavigationMenu(1, R.drawable.ic_nav_home, ResourceUtils.getString(R.string.menu_home)));
        arrayList.add(new NavigationMenu(2, R.drawable.ic_nav_store, ResourceUtils.getString(R.string.menu_stores)));
        arrayList.add(new NavigationMenu(3, R.drawable.ic_nav_nearby, ResourceUtils.getString(R.string.menu_near_me)));
        arrayList.add(new NavigationMenu(4, R.drawable.ic_nav_account, ResourceUtils.getString(R.string.menu_my_account)));
        arrayList.add(new NavigationMenu(5, R.drawable.ic_nav_mycart, ResourceUtils.getString(R.string.menu_my_cart)));
        arrayList.add(new NavigationMenu(7, R.drawable.ic_nav_about_us, ResourceUtils.getString(R.string.menu_about_us)));
        arrayList.add(new NavigationMenu(8, R.drawable.ic_nav_contacts_us, ResourceUtils.getString(R.string.menu_contact_us)));
        arrayList.add(new NavigationMenu(9, R.drawable.ic_nav_privacy_policy, ResourceUtils.getString(R.string.menu_privacy_policy)));
        arrayList.add(new NavigationMenu(10, R.drawable.ic_nav_logout, ResourceUtils.getString(R.string.menu_logout)));
        return arrayList;
    }

    public static ArrayList<ProductSortBy> getSortBy(String str) {
        ArrayList<ProductSortBy> arrayList = new ArrayList<>();
        arrayList.add(new ProductSortBy(ResourceUtils.getString(R.string.most_popular), "1", str.equals("1")));
        arrayList.add(new ProductSortBy(ResourceUtils.getString(R.string.price_high_to_low), ExifInterface.GPS_MEASUREMENT_3D, str.equals(ExifInterface.GPS_MEASUREMENT_3D)));
        arrayList.add(new ProductSortBy(ResourceUtils.getString(R.string.price_low_to_high), ExifInterface.GPS_MEASUREMENT_2D, str.equals(ExifInterface.GPS_MEASUREMENT_2D)));
        arrayList.add(new ProductSortBy(ResourceUtils.getString(R.string.newest), "4", str.equals("4")));
        arrayList.add(new ProductSortBy(ResourceUtils.getString(R.string.reset), "5", str.equals("5")));
        return arrayList;
    }

    public static ArrayList<Languages> getLanguages(String str) {
        ArrayList<Languages> arrayList = new ArrayList<>();
        arrayList.add(new Languages(ResourceUtils.getString(R.string.english), ResourceUtils.getString(R.string.en), str.equals(ResourceUtils.getString(R.string.en))));
        arrayList.add(new Languages(ResourceUtils.getString(R.string.portugal), ResourceUtils.getString(R.string.pt), str.equals(ResourceUtils.getString(R.string.pt))));
        return arrayList;
    }

    public static ArrayList<ProductFilter> getFilters(String str, String str2) {
        ArrayList<ProductFilter> arrayList = new ArrayList<>();
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.price_range), "1", ProductFilter.FilterType.HEADER, str.equals("1")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.under_thousand), ExifInterface.GPS_MEASUREMENT_2D, ProductFilter.FilterType.PRICE, str.equals(ExifInterface.GPS_MEASUREMENT_2D)));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.thousand_to_two), ExifInterface.GPS_MEASUREMENT_3D, ProductFilter.FilterType.PRICE, str.equals(ExifInterface.GPS_MEASUREMENT_3D)));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.two_thousand_to_five), "4", ProductFilter.FilterType.PRICE, str.equals("4")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.five_thousand_to_ten), "5", ProductFilter.FilterType.PRICE, str.equals("5")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.over_ten_thousand), "6", ProductFilter.FilterType.PRICE, str.equals("6")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.discount), "7", ProductFilter.FilterType.HEADER, str2.equals("7")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.discount_below_10), "8", ProductFilter.FilterType.DISCOUNT, str2.equals("8")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.discount_10_to_20), "9", ProductFilter.FilterType.DISCOUNT, str2.equals("9")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.discount_20_to_30), "10", ProductFilter.FilterType.DISCOUNT, str2.equals("10")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.discount_30_to_40), "11", ProductFilter.FilterType.DISCOUNT, str2.equals("11")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.discount_40_to_50), "12", ProductFilter.FilterType.DISCOUNT, str2.equals("12")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.discount_50_to_100), "13", ProductFilter.FilterType.DISCOUNT, str2.equals("13")));
        arrayList.add(new ProductFilter(ResourceUtils.getString(R.string.reset), "14", ProductFilter.FilterType.DISCOUNT, str2.equals("14")));
        return arrayList;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPriceRangeMin(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case 50: goto L_0x0034;
                case 51: goto L_0x002a;
                case 52: goto L_0x0020;
                case 53: goto L_0x0016;
                case 54: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "6"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 4
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "5"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 3
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "4"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 2
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 1
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "2"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 0
            goto L_0x003f
        L_0x003e:
            r5 = -1
        L_0x003f:
            if (r5 == 0) goto L_0x0058
            if (r5 == r4) goto L_0x0055
            if (r5 == r3) goto L_0x0052
            if (r5 == r2) goto L_0x004f
            if (r5 == r1) goto L_0x004c
            java.lang.String r5 = ""
            goto L_0x005a
        L_0x004c:
            java.lang.String r5 = "10000"
            goto L_0x005a
        L_0x004f:
            java.lang.String r5 = "5000"
            goto L_0x005a
        L_0x0052:
            java.lang.String r5 = "2500"
            goto L_0x005a
        L_0x0055:
            java.lang.String r5 = "1000"
            goto L_0x005a
        L_0x0058:
            java.lang.String r5 = "0"
        L_0x005a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kiandashopping.kiandashopping.util.AppUtils.getPriceRangeMin(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPriceRangeMax(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case 50: goto L_0x0034;
                case 51: goto L_0x002a;
                case 52: goto L_0x0020;
                case 53: goto L_0x0016;
                case 54: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "6"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 4
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "5"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 3
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "4"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 2
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 1
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "2"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 0
            goto L_0x003f
        L_0x003e:
            r5 = -1
        L_0x003f:
            if (r5 == 0) goto L_0x0058
            if (r5 == r4) goto L_0x0055
            if (r5 == r3) goto L_0x0052
            if (r5 == r2) goto L_0x004f
            if (r5 == r1) goto L_0x004c
            java.lang.String r5 = ""
            goto L_0x005a
        L_0x004c:
            java.lang.String r5 = "10000000"
            goto L_0x005a
        L_0x004f:
            java.lang.String r5 = "10000"
            goto L_0x005a
        L_0x0052:
            java.lang.String r5 = "5000"
            goto L_0x005a
        L_0x0055:
            java.lang.String r5 = "2500"
            goto L_0x005a
        L_0x0058:
            java.lang.String r5 = "1000"
        L_0x005a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kiandashopping.kiandashopping.util.AppUtils.getPriceRangeMax(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDiscount(java.lang.String r7) {
        /*
            int r0 = r7.hashCode()
            r1 = 56
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r0 == r1) goto L_0x0047
            r1 = 57
            if (r0 == r1) goto L_0x003d
            switch(r0) {
                case 1567: goto L_0x0033;
                case 1568: goto L_0x0029;
                case 1569: goto L_0x001f;
                case 1570: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0051
        L_0x0015:
            java.lang.String r0 = "13"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0051
            r7 = 5
            goto L_0x0052
        L_0x001f:
            java.lang.String r0 = "12"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0051
            r7 = 4
            goto L_0x0052
        L_0x0029:
            java.lang.String r0 = "11"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0051
            r7 = 3
            goto L_0x0052
        L_0x0033:
            java.lang.String r0 = "10"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0051
            r7 = 2
            goto L_0x0052
        L_0x003d:
            java.lang.String r0 = "9"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0051
            r7 = 1
            goto L_0x0052
        L_0x0047:
            java.lang.String r0 = "8"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0051
            r7 = 0
            goto L_0x0052
        L_0x0051:
            r7 = -1
        L_0x0052:
            if (r7 == 0) goto L_0x0070
            if (r7 == r6) goto L_0x006d
            if (r7 == r5) goto L_0x006a
            if (r7 == r4) goto L_0x0067
            if (r7 == r3) goto L_0x0064
            if (r7 == r2) goto L_0x0061
            java.lang.String r7 = ""
            goto L_0x0072
        L_0x0061:
            java.lang.String r7 = "6"
            goto L_0x0072
        L_0x0064:
            java.lang.String r7 = "5"
            goto L_0x0072
        L_0x0067:
            java.lang.String r7 = "4"
            goto L_0x0072
        L_0x006a:
            java.lang.String r7 = "3"
            goto L_0x0072
        L_0x006d:
            java.lang.String r7 = "2"
            goto L_0x0072
        L_0x0070:
            java.lang.String r7 = "1"
        L_0x0072:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kiandashopping.kiandashopping.util.AppUtils.getDiscount(java.lang.String):java.lang.String");
    }

    public static String append(String str, String str2) {
        return str + str2;
    }

    public static String append(String str, int i) {
        return str + i;
    }

    public static String append(int i, String str) {
        return i + str;
    }

    public static SpannableStringBuilder showPrice(String str, String str2) {
        String str3 = str + AppConstants.SPACE;
        Typeface font = ResourcesCompat.getFont(BaseApplication.getContext(), R.font.roboto_thin);
        Typeface font2 = ResourcesCompat.getFont(BaseApplication.getContext(), R.font.roboto_bold);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3 + str2);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.7f), 0, str3.length(), 0);
        spannableStringBuilder.setSpan(new CustomTypefaceSpan("", font), 0, str3.length(), 34);
        spannableStringBuilder.setSpan(new CustomTypefaceSpan("", font2), str3.length(), str3.length() + str2.length(), 34);
        return spannableStringBuilder;
    }

    public static BitmapDescriptor getBitmapFromVectorDrawable(Context context, int i) {
        try {
            Drawable drawable = ContextCompat.getDrawable(context, i);
            if (Build.VERSION.SDK_INT < 21) {
                drawable = DrawableCompat.wrap(drawable).mutate();
            }
            Bitmap createBitmap = drawable != null ? Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888) : null;
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return BitmapDescriptorFactory.fromBitmap(createBitmap);
        } catch (Exception e) {
            Log.e(AppConstants.EXCEPTION, e.toString());
            return null;
        }
    }

    public static void hideFabButton(FloatingActionButton floatingActionButton) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
        layoutParams.setAnchorId(-1);
        floatingActionButton.setLayoutParams(layoutParams);
        floatingActionButton.setVisibility(8);
    }

    public static void showFabButton(FloatingActionButton floatingActionButton) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
        layoutParams.setAnchorId(-1);
        floatingActionButton.setLayoutParams(layoutParams);
        floatingActionButton.setVisibility(0);
    }
}
