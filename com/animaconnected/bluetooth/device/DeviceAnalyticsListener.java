package com.animaconnected.bluetooth.device;

/* compiled from: DeviceAnalyticsListener.kt */
/* loaded from: classes.dex */
public interface DeviceAnalyticsListener {
    static /* synthetic */ void onSendAnalytics$default(DeviceAnalyticsListener deviceAnalyticsListener, String str, boolean z, Boolean bool, int r4, Object obj) {
        if (obj == null) {
            if ((r4 & 4) != 0) {
                bool = null;
            }
            deviceAnalyticsListener.onSendAnalytics(str, z, bool);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSendAnalytics");
    }

    void onSendAnalytics(String str, boolean z, Boolean bool);

    void onServicesNotFound(int r1);
}
