package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.measurement.zzbp;
import com.google.android.gms.internal.measurement.zzbq;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzey implements ServiceConnection {
    public final /* synthetic */ zzez zza;
    public final String zzb;

    public zzey(zzez zzezVar, String str) {
        this.zza = zzezVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.measurement.zzbr zzbpVar;
        zzez zzezVar = this.zza;
        if (iBinder != null) {
            try {
                int r0 = zzbq.$r8$clinit;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                if (queryLocalInterface instanceof com.google.android.gms.internal.measurement.zzbr) {
                    zzbpVar = (com.google.android.gms.internal.measurement.zzbr) queryLocalInterface;
                } else {
                    zzbpVar = new zzbp(iBinder);
                }
                if (zzbpVar == null) {
                    zzeh zzehVar = zzezVar.zza.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzg.zza("Install Referrer Service implementation was not found");
                    return;
                } else {
                    zzeh zzehVar2 = zzezVar.zza.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzl.zza("Install Referrer Service connected");
                    zzfo zzfoVar = zzezVar.zza.zzn;
                    zzfr.zzR(zzfoVar);
                    zzfoVar.zzp(new zzex(this, zzbpVar, this));
                    return;
                }
            } catch (RuntimeException e) {
                zzeh zzehVar3 = zzezVar.zza.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzg.zzb(e, "Exception occurred while calling Install Referrer API");
                return;
            }
        }
        zzeh zzehVar4 = zzezVar.zza.zzm;
        zzfr.zzR(zzehVar4);
        zzehVar4.zzg.zza("Install Referrer connection returned with null binder");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzeh zzehVar = this.zza.zza.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Install Referrer Service disconnected");
    }
}
