package com.google.gson.internal.bind.util;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public final class ISO8601Utils {
    public static final TimeZone TIMEZONE_UTC = DesugarTimeZone.getTimeZone("UTC");

    public static boolean checkOffset(String str, int r2, char c) {
        if (r2 < str.length() && str.charAt(r2) == c) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e5 A[Catch: IllegalArgumentException -> 0x01d2, NumberFormatException -> 0x01d4, IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01d6, TRY_LEAVE, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01d6, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:18:0x0054, B:20:0x0064, B:21:0x0066, B:23:0x0072, B:24:0x0074, B:26:0x007a, B:30:0x0084, B:35:0x0094, B:37:0x009c, B:38:0x00a0, B:40:0x00a6, B:44:0x00b3, B:47:0x00ba, B:52:0x00df, B:54:0x00e5, B:59:0x019a, B:64:0x00fa, B:65:0x0115, B:66:0x0116, B:69:0x0132, B:71:0x013f, B:74:0x0148, B:76:0x0167, B:79:0x0177, B:80:0x0199, B:81:0x0121, B:82:0x01ca, B:83:0x01d1, B:84:0x00ca, B:85:0x00cd, B:88:0x00b6), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ca A[Catch: IllegalArgumentException -> 0x01d2, NumberFormatException -> 0x01d4, IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01d6, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01d6, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:18:0x0054, B:20:0x0064, B:21:0x0066, B:23:0x0072, B:24:0x0074, B:26:0x007a, B:30:0x0084, B:35:0x0094, B:37:0x009c, B:38:0x00a0, B:40:0x00a6, B:44:0x00b3, B:47:0x00ba, B:52:0x00df, B:54:0x00e5, B:59:0x019a, B:64:0x00fa, B:65:0x0115, B:66:0x0116, B:69:0x0132, B:71:0x013f, B:74:0x0148, B:76:0x0167, B:79:0x0177, B:80:0x0199, B:81:0x0121, B:82:0x01ca, B:83:0x01d1, B:84:0x00ca, B:85:0x00cd, B:88:0x00b6), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date parse(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int parseInt(int r5, int r6, String str) throws NumberFormatException {
        int r3;
        int r2;
        if (r5 >= 0 && r6 <= str.length() && r5 <= r6) {
            if (r5 < r6) {
                r2 = r5 + 1;
                int digit = Character.digit(str.charAt(r5), 10);
                if (digit >= 0) {
                    r3 = -digit;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(r5, r6));
                }
            } else {
                r3 = 0;
                r2 = r5;
            }
            while (r2 < r6) {
                int r4 = r2 + 1;
                int digit2 = Character.digit(str.charAt(r2), 10);
                if (digit2 >= 0) {
                    r3 = (r3 * 10) - digit2;
                    r2 = r4;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(r5, r6));
                }
            }
            return -r3;
        }
        throw new NumberFormatException(str);
    }
}
