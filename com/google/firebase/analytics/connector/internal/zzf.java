package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzf implements AppMeasurementSdk.OnEventListener {
    public final /* synthetic */ zzg zza;

    public zzf(zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final void onEvent(long j, Bundle bundle, String str, String str2) {
        if (str != null && (!zzc.zza.contains(str2))) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle("params", bundle);
            ((CrashlyticsAnalyticsListener) this.zza.zza).onMessageTriggered(3, bundle2);
        }
    }
}
