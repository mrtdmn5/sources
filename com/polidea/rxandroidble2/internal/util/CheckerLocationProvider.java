package com.polidea.rxandroidble2.internal.util;

import android.content.ContentResolver;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import com.polidea.rxandroidble2.internal.RxBleLog;

/* loaded from: classes3.dex */
public final class CheckerLocationProvider {
    public final ContentResolver contentResolver;
    public final LocationManager locationManager;

    public CheckerLocationProvider(ContentResolver contentResolver, LocationManager locationManager) {
        this.contentResolver = contentResolver;
        this.locationManager = locationManager;
    }

    public final boolean isLocationProviderEnabled() {
        boolean isLocationEnabled;
        int r0 = Build.VERSION.SDK_INT;
        LocationManager locationManager = this.locationManager;
        if (r0 >= 28) {
            isLocationEnabled = locationManager.isLocationEnabled();
            return isLocationEnabled;
        }
        try {
            if (Settings.Secure.getInt(this.contentResolver, "location_mode") != 0) {
                return true;
            }
        } catch (Settings.SettingNotFoundException e) {
            RxBleLog.throwShade(5, e, "Could not use LOCATION_MODE check. Falling back to a legacy/heuristic function.", new Object[0]);
            if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps")) {
                return true;
            }
        }
        return false;
    }
}
