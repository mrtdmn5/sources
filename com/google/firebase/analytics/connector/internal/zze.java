package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zze {
    public final HashSet zza;
    public final AnalyticsConnector.AnalyticsConnectorListener zzb;

    public zze(AppMeasurementSdk appMeasurementSdk, CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        this.zzb = crashlyticsAnalyticsListener;
        appMeasurementSdk.registerOnMeasurementEventListener(new zzd(this));
        this.zza = new HashSet();
    }
}
