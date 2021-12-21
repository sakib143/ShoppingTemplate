package com.kiandashopping.kiandashopping.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageUtil {
    private static String getImageFromFilePath(Context context, Intent intent) {
        if (intent == null || intent.getData() == null) {
            return getCaptureImageOutputUri(context).getPath();
        }
        return getPathFromURI(context, intent.getData());
    }

    public static String getImageFilePath(Context context, Intent intent) {
        return getImageFromFilePath(context, intent);
    }

    private static String getPathFromURI(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
        query.moveToFirst();
        return query.getString(columnIndexOrThrow);
    }

    private static Uri getCaptureImageOutputUri(Context context) {
        File externalFilesDir = context.getExternalFilesDir("");
        if (externalFilesDir != null) {
            return Uri.fromFile(new File(externalFilesDir.getPath(), "profile.png"));
        }
        return null;
    }

    public static Intent getPickImageChooserIntent(Context context) {
        Uri captureImageOutputUri = getCaptureImageOutputUri(context);
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
            intent2.setPackage(next.activityInfo.packageName);
            if (captureImageOutputUri != null) {
                intent2.putExtra("output", captureImageOutputUri);
            }
            arrayList.add(intent2);
        }
        Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
        intent3.setType("image/*");
        for (ResolveInfo next2 : packageManager.queryIntentActivities(intent3, 0)) {
            Intent intent4 = new Intent(intent3);
            intent4.setComponent(new ComponentName(next2.activityInfo.packageName, next2.activityInfo.name));
            intent4.setPackage(next2.activityInfo.packageName);
            arrayList.add(intent4);
        }
        Intent intent5 = (Intent) arrayList.get(arrayList.size() - 1);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Intent intent6 = (Intent) it.next();
            if (intent6.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                intent5 = intent6;
                break;
            }
        }
        arrayList.remove(intent5);
        Intent createChooser = Intent.createChooser(intent5, "Select source");
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
        return createChooser;
    }

    public static String ResizeImage(Context context, String str) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        int i = options.outHeight;
        int i2 = options.outWidth;
        float f = (float) (i2 / i);
        float f2 = (float) i;
        if (f2 > 816.0f || ((float) i2) > 612.0f) {
            if (f < 0.75f) {
                i2 = (int) ((816.0f / f2) * ((float) i2));
                i = (int) 816.0f;
            } else {
                i = f > 0.75f ? (int) ((612.0f / ((float) i2)) * f2) : (int) 816.0f;
                i2 = (int) 612.0f;
            }
        }
        options.inSampleSize = calculateInSampleSize(options, i2, i);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        try {
            decodeFile = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        try {
            bitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            bitmap = null;
        }
        float f3 = (float) i2;
        float f4 = f3 / ((float) options.outWidth);
        float f5 = (float) i;
        float f6 = f5 / ((float) options.outHeight);
        float f7 = f3 / 2.0f;
        float f8 = f5 / 2.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f6, f7, f8);
        Canvas canvas = new Canvas(bitmap);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(decodeFile, f7 - ((float) (decodeFile.getWidth() / 2)), f8 - ((float) (decodeFile.getHeight() / 2)), new Paint(2));
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + attributeInt);
            Matrix matrix2 = new Matrix();
            if (attributeInt == 6) {
                matrix2.postRotate(90.0f);
                Log.d("EXIF", "Exif: " + attributeInt);
            } else if (attributeInt == 3) {
                matrix2.postRotate(180.0f);
                Log.d("EXIF", "Exif: " + attributeInt);
            } else if (attributeInt == 8) {
                matrix2.postRotate(270.0f);
                Log.d("EXIF", "Exif: " + attributeInt);
            }
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        String filename = getFilename();
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(filename));
            return filename;
        } catch (FileNotFoundException unused) {
            return str;
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i2 || i5 > i) {
            i3 = Math.round(((float) i4) / ((float) i2));
            int round = Math.round(((float) i5) / ((float) i));
            if (i3 >= round) {
                i3 = round;
            }
        } else {
            i3 = 1;
        }
        while (((float) (i5 * i4)) / ((float) (i3 * i3)) > ((float) (i * i2 * 2))) {
            i3++;
        }
        return i3;
    }

    private static String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "ShopurFood/Profile");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg";
    }
}
