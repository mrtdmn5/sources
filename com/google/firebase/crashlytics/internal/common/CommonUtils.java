package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/* loaded from: classes3.dex */
public final class CommonUtils {
    public static final char[] HEX_VALUES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static long totalRamInBytes = -1;

    /* loaded from: classes3.dex */
    public enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;

        private static final Map<String, Architecture> matcher;

        static {
            Architecture architecture = X86_32;
            Architecture architecture2 = ARMV6;
            Architecture architecture3 = ARMV7;
            Architecture architecture4 = ARM64;
            HashMap hashMap = new HashMap(4);
            matcher = hashMap;
            hashMap.put("armeabi-v7a", architecture3);
            hashMap.put("armeabi", architecture2);
            hashMap.put("arm64-v8a", architecture4);
            hashMap.put("x86", architecture);
        }

        public static Architecture getValue() {
            boolean z;
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Log.v("FirebaseCrashlytics", "Architecture#getValue()::Build.CPU_ABI returned null or empty", null);
                }
                return UNKNOWN;
            }
            Architecture architecture = matcher.get(str.toLowerCase(Locale.US));
            if (architecture == null) {
                return UNKNOWN;
            }
            return architecture;
        }
    }

    public static void closeOrLog(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e("FirebaseCrashlytics", str, e);
            }
        }
    }

    public static long convertMemInfoToBytes(String str, int r3, String str2) {
        return Long.parseLong(str.split(str2)[0].trim()) * r3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:            r3 = r4[1];     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String extractFieldFromSystemFile(java.io.File r7) {
        /*
            java.lang.String r0 = "MemTotal"
            java.lang.String r1 = "Failed to close system file reader."
            boolean r2 = r7.exists()
            r3 = 0
            if (r2 == 0) goto L5f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r5 = 1024(0x400, float:1.435E-42)
            r2.<init>(r4, r5)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
        L17:
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L59
            if (r4 == 0) goto L55
            java.lang.String r5 = "\\s*:\\s*"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L59
            r6 = 2
            java.lang.String[] r4 = r5.split(r4, r6)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L59
            int r5 = r4.length     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L59
            r6 = 1
            if (r5 <= r6) goto L17
            r5 = 0
            r5 = r4[r5]     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L59
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L59
            if (r5 == 0) goto L17
            r7 = r4[r6]     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L59
            r3 = r7
            goto L55
        L39:
            r0 = move-exception
            goto L3f
        L3b:
            r7 = move-exception
            goto L5b
        L3d:
            r0 = move-exception
            r2 = r3
        L3f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r4.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r5 = "Error parsing "
            r4.append(r5)     // Catch: java.lang.Throwable -> L59
            r4.append(r7)     // Catch: java.lang.Throwable -> L59
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = "FirebaseCrashlytics"
            android.util.Log.e(r4, r7, r0)     // Catch: java.lang.Throwable -> L59
        L55:
            closeOrLog(r2, r1)
            goto L5f
        L59:
            r7 = move-exception
            r3 = r2
        L5b:
            closeOrLog(r3, r1)
            throw r7
        L5f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CommonUtils.extractFieldFromSystemFile(java.io.File):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static int getDeviceState() {
        boolean z;
        boolean isEmulator = isEmulator();
        ?? r0 = isEmulator;
        if (isRooted()) {
            r0 = (isEmulator ? 1 : 0) | 2;
        }
        if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return r0 | 4;
        }
        return r0;
    }

    public static String getMappingFileId(Context context) {
        int resourcesIdentifier = getResourcesIdentifier(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (resourcesIdentifier == 0) {
            resourcesIdentifier = getResourcesIdentifier(context, "com.crashlytics.android.build_id", "string");
        }
        if (resourcesIdentifier != 0) {
            return context.getResources().getString(resourcesIdentifier);
        }
        return null;
    }

    public static int getResourcesIdentifier(Context context, String str, String str2) {
        String packageName;
        Resources resources = context.getResources();
        int r1 = context.getApplicationContext().getApplicationInfo().icon;
        if (r1 > 0) {
            try {
                packageName = context.getResources().getResourcePackageName(r1);
                if ("android".equals(packageName)) {
                    packageName = context.getPackageName();
                }
            } catch (Resources.NotFoundException unused) {
                packageName = context.getPackageName();
            }
        } else {
            packageName = context.getPackageName();
        }
        return resources.getIdentifier(str, str2, packageName);
    }

    public static synchronized long getTotalRamInBytes() {
        long j;
        long j2;
        synchronized (CommonUtils.class) {
            if (totalRamInBytes == -1) {
                String extractFieldFromSystemFile = extractFieldFromSystemFile(new File("/proc/meminfo"));
                if (!TextUtils.isEmpty(extractFieldFromSystemFile)) {
                    String upperCase = extractFieldFromSystemFile.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            j2 = convertMemInfoToBytes(upperCase, 1024, "KB");
                        } else if (upperCase.endsWith("MB")) {
                            j2 = convertMemInfoToBytes(upperCase, Constants.MB, "MB");
                        } else if (upperCase.endsWith("GB")) {
                            j2 = convertMemInfoToBytes(upperCase, 1073741824, "GB");
                        } else {
                            Log.w("FirebaseCrashlytics", "Unexpected meminfo format while computing RAM: ".concat(upperCase), null);
                        }
                    } catch (NumberFormatException e) {
                        Log.e("FirebaseCrashlytics", "Unexpected meminfo format while computing RAM: " + upperCase, e);
                    }
                    totalRamInBytes = j2;
                }
                j2 = 0;
                totalRamInBytes = j2;
            }
            j = totalRamInBytes;
        }
        return j;
    }

    public static String hexify(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int r1 = 0; r1 < bArr.length; r1++) {
            int r2 = bArr[r1] & 255;
            int r3 = r1 * 2;
            char[] cArr2 = HEX_VALUES;
            cArr[r3] = cArr2[r2 >>> 4];
            cArr[r3 + 1] = cArr2[r2 & 15];
        }
        return new String(cArr);
    }

    public static boolean isEmulator() {
        if (!Build.PRODUCT.contains("sdk")) {
            String str = Build.HARDWARE;
            if (!str.contains("goldfish") && !str.contains("ranchu")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRooted() {
        boolean isEmulator = isEmulator();
        String str = Build.TAGS;
        if ((!isEmulator && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (!isEmulator && file.exists()) {
            return true;
        }
        return false;
    }

    public static String sha1(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bytes);
            return hexify(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            Log.e("FirebaseCrashlytics", "Could not create hashing algorithm: SHA-1, returning empty string.", e);
            return "";
        }
    }

    public static String streamToString(FileInputStream fileInputStream) {
        Scanner useDelimiter = new Scanner(fileInputStream).useDelimiter("\\A");
        if (useDelimiter.hasNext()) {
            return useDelimiter.next();
        }
        return "";
    }
}
