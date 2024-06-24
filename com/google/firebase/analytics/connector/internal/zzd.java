package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import androidx.compose.ui.geometry.MutableRectKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgo;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzd implements AppMeasurementSdk.OnEventListener {
    public final /* synthetic */ zze zza;

    public zzd(zze zzeVar) {
        this.zza = zzeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final void onEvent(long j, Bundle bundle, String str, String str2) {
        zze zzeVar = this.zza;
        if (!zzeVar.zza.contains(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        HashSet hashSet = zzc.zza;
        String zzb = MutableRectKt.zzb(str2, zzgo.zzc, zzgo.zza);
        if (zzb != null) {
            str2 = zzb;
        }
        bundle2.putString("events", str2);
        ((CrashlyticsAnalyticsListener) zzeVar.zzb).onMessageTriggered(2, bundle2);
    }
}
