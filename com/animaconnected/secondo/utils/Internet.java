package com.animaconnected.secondo.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.animaconnected.secondo.KronabyApplication;

/* compiled from: Internet.kt */
/* loaded from: classes3.dex */
public final class Internet {
    public static final int $stable = 0;
    public static final Internet INSTANCE = new Internet();

    private Internet() {
    }

    public final boolean isAvailable() {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Object systemService = KronabyApplication.Companion.getContext().getSystemService("connectivity");
        if (systemService instanceof ConnectivityManager) {
            connectivityManager = (ConnectivityManager) systemService;
        } else {
            connectivityManager = null;
        }
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(3)) {
            return false;
        }
        return true;
    }
}
