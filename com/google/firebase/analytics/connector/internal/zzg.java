package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzg {
    public final AnalyticsConnector.AnalyticsConnectorListener zza;

    public zzg(AppMeasurementSdk appMeasurementSdk, CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        this.zza = crashlyticsAnalyticsListener;
        appMeasurementSdk.registerOnMeasurementEventListener(new zzf(this));
    }
}
