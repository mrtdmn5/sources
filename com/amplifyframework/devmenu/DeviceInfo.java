package com.amplifyframework.devmenu;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes.dex */
public final class DeviceInfo {
    public boolean isEmulator() {
        if (Build.DEVICE.toLowerCase(Locale.getDefault()).contains("generic") && Build.MODEL.toLowerCase(Locale.getDefault()).contains("sdk")) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        Locale locale = Locale.US;
        Object[] objArr = new Object[5];
        objArr[0] = Build.MANUFACTURER;
        objArr[1] = Build.MODEL;
        objArr[2] = Build.VERSION.RELEASE;
        objArr[3] = Integer.valueOf(Build.VERSION.SDK_INT);
        if (isEmulator()) {
            str = "Yes";
        } else {
            str = "No";
        }
        objArr[4] = str;
        return String.format(locale, "Device Manufacturer: %s\nDevice Model: %s\nAndroid System Version: %s\nSDK Version: %d\nDevice is an Emulator: %s", objArr);
    }
}
