package com.kiandashopping.kiandashopping.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTime {
    public static final String DISPLAY_DASH_DATE = "dd-MM-yyyy";
    public static final String DISPLAY_DATE = "d MMM yyyy";
    public static final String DISPLAY_DATE_MONTH = "d MMM";
    public static final String DISPLAY_DATE_TIME = "d MMM yyyy h:mm a";
    public static final String DISPLAY_DATE_TIME_CONVERSATION = "MMM d, h:mm a";
    public static final String DISPLAY_DELIVERY_DATE = "EEE dd, MMM yyyy";
    public static final String DISPLAY_TIME = "h:mm a";
    public static final String MY_TRIP_FORMAT = "MMM dd yyyy";
    public static final String SERVER_DATE = "yyyy-MM-dd";
    public static final String SERVER_DATE_PAYMENT = "MMM dd, yyyy";
    public static final String SERVER_DATE_SLASH = "d/M/yyyy";
    public static final String SERVER_DATE_TIME = "yyyy-MM-dd hh:mm:ss";
    public static final String SERVER_TIME = "hh:mm:ss";
    public static final String SERVER_TIME_SMALL = "hh:mma";
    public static final String TWO_LINE_DATE_TIME = "d MMM yyyy\nh:mm a";
    String EMPTY;
    Calendar calendar;
    Locale locale;

    public DateTime() {
        Locale locale2 = Locale.US;
        this.locale = locale2;
        this.EMPTY = null;
        this.calendar = Calendar.getInstance(locale2);
    }

    public DateTime(String str) {
        this.locale = Locale.US;
        this.EMPTY = null;
        init(str, SERVER_DATE_TIME);
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public DateTime(String str, String str2) {
        this.locale = Locale.US;
        this.EMPTY = null;
        init(str, str2);
    }

    public DateTime(Calendar calendar2) {
        this.locale = Locale.US;
        this.EMPTY = null;
        this.calendar = calendar2;
    }

    private void init(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance(this.locale);
        this.calendar = instance;
        instance.set(1, i);
        this.calendar.set(2, i2);
        this.calendar.set(5, i3);
    }

    public DateTime(int i, int i2, int i3) {
        this.locale = Locale.US;
        this.EMPTY = null;
        init(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 0
            int r1 = r4.length()     // Catch:{ Exception -> 0x0053 }
            r2 = 8
            if (r1 != r2) goto L_0x001b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r1.<init>()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r2 = "0000-00-00 "
            r1.append(r2)     // Catch:{ Exception -> 0x0053 }
            r1.append(r4)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0053 }
            goto L_0x0034
        L_0x001b:
            int r1 = r4.length()     // Catch:{ Exception -> 0x0053 }
            r2 = 10
            if (r1 != r2) goto L_0x0034
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r1.<init>()     // Catch:{ Exception -> 0x0053 }
            r1.append(r4)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = " 00:00:00"
            r1.append(r4)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0053 }
        L_0x0034:
            java.util.Locale r1 = r3.locale     // Catch:{ Exception -> 0x0053 }
            java.util.Calendar r1 = java.util.Calendar.getInstance(r1)     // Catch:{ Exception -> 0x0053 }
            r3.calendar = r1     // Catch:{ Exception -> 0x0053 }
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0053 }
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0053 }
            r1.<init>(r5, r2)     // Catch:{ Exception -> 0x0053 }
            java.util.Calendar r5 = r3.calendar     // Catch:{ NullPointerException -> 0x0050, ParseException -> 0x004d }
            java.util.Date r4 = r1.parse(r4)     // Catch:{ NullPointerException -> 0x0050, ParseException -> 0x004d }
            r5.setTime(r4)     // Catch:{ NullPointerException -> 0x0050, ParseException -> 0x004d }
            goto L_0x0055
        L_0x004d:
            r3.calendar = r0     // Catch:{ Exception -> 0x0053 }
            goto L_0x0055
        L_0x0050:
            r3.calendar = r0     // Catch:{ Exception -> 0x0053 }
            goto L_0x0055
        L_0x0053:
            r3.calendar = r0
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kiandashopping.kiandashopping.util.DateTime.init(java.lang.String, java.lang.String):void");
    }

    public String getDisplayProductDelivery() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(DISPLAY_DELIVERY_DATE, this.locale).format(this.calendar.getTime());
    }

    public String getDisplayDateTime() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(DISPLAY_DATE_TIME, this.locale).format(this.calendar.getTime());
    }

    public String getTwoLineDateTime() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(TWO_LINE_DATE_TIME, this.locale).format(this.calendar.getTime());
    }

    public String getDisplayDateTimeConversation() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(DISPLAY_DATE_TIME_CONVERSATION, this.locale).format(this.calendar.getTime());
    }

    public String getDisplayDate() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(DISPLAY_DATE, this.locale).format(this.calendar.getTime());
    }

    public String getMyTripDate() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(MY_TRIP_FORMAT, this.locale).format(this.calendar.getTime());
    }

    public String getDisplayTime() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(DISPLAY_TIME, this.locale).format(this.calendar.getTime());
    }

    public String getServerDateTime() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(SERVER_DATE_TIME, this.locale).format(this.calendar.getTime());
    }

    public String getServerDate() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(SERVER_DATE, this.locale).format(this.calendar.getTime());
    }

    public String getServerDateSlash() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(SERVER_DATE_SLASH, this.locale).format(this.calendar.getTime());
    }

    public String getServerTime() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(SERVER_TIME, this.locale).format(this.calendar.getTime());
    }

    public String getServerTimeSmall() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(SERVER_TIME_SMALL, this.locale).format(this.calendar.getTime());
    }

    public String getDisplayDashDate() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(DISPLAY_DASH_DATE, this.locale).format(this.calendar.getTime());
    }

    public String getDisplayDateMoth() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(DISPLAY_DATE_MONTH, this.locale).format(this.calendar.getTime());
    }

    public static String getFormatMonth(Date date) {
        return new SimpleDateFormat("MM", Locale.getDefault()).format(date);
    }

    public static String getFormatYear(Date date) {
        return new SimpleDateFormat("yyyy", Locale.getDefault()).format(date);
    }

    public String getDisplayBirtDay() {
        return this.calendar == null ? this.EMPTY : new SimpleDateFormat(SERVER_DATE_PAYMENT, this.locale).format(this.calendar.getTime());
    }
}
