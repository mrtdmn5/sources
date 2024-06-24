package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhg implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzhx zzb;

    public zzhg(zzhx zzhxVar, Bundle bundle) {
        this.zzb = zzhxVar;
        this.zza = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhx zzhxVar = this.zzb;
        zzhxVar.zzg();
        zzhxVar.zza();
        Bundle bundle = this.zza;
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        Preconditions.checkNotEmpty(string);
        zzfr zzfrVar = zzhxVar.zzt;
        if (!zzfrVar.zzJ()) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkw zzkwVar = new zzkw(0L, null, string, "");
        try {
            zzlb zzlbVar = zzfrVar.zzp;
            zzfr.zzP(zzlbVar);
            bundle.getString(AnalyticsConstants.USER_PROPERTY_APP_ID);
            zzfrVar.zzt().zzE(new zzac(bundle.getString(AnalyticsConstants.USER_PROPERTY_APP_ID), "", zzkwVar, bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), zzlbVar.zzz(bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
