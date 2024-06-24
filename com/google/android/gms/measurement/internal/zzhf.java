package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhf implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzhx zzb;

    public zzhf(zzhx zzhxVar, Bundle bundle) {
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
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        zzfr zzfrVar = zzhxVar.zzt;
        if (!zzfrVar.zzJ()) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkw zzkwVar = new zzkw(bundle.getLong("triggered_timestamp"), bundle.get("value"), string, string2);
        try {
            zzlb zzlbVar = zzfrVar.zzp;
            zzfr.zzP(zzlbVar);
            bundle.getString(AnalyticsConstants.USER_PROPERTY_APP_ID);
            zzaw zzz = zzlbVar.zzz(bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true);
            zzlb zzlbVar2 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar2);
            bundle.getString(AnalyticsConstants.USER_PROPERTY_APP_ID);
            zzaw zzz2 = zzlbVar2.zzz(bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true);
            zzlb zzlbVar3 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar3);
            bundle.getString(AnalyticsConstants.USER_PROPERTY_APP_ID);
            zzfrVar.zzt().zzE(new zzac(bundle.getString(AnalyticsConstants.USER_PROPERTY_APP_ID), string2, zzkwVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), zzz2, bundle.getLong("trigger_timeout"), zzz, bundle.getLong("time_to_live"), zzlbVar3.zzz(bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
