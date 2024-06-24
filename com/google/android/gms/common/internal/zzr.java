package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;
import no.nordicsemi.android.dfu.DfuServiceInitiator;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzr extends GmsClientSupervisor {
    public final HashMap zzb = new HashMap();
    public final Context zzc;
    public volatile zzi zzd;
    public final ConnectionTracker zzf;
    public final long zzg;
    public final long zzh;

    public zzr(Context context, Looper looper) {
        zzq zzqVar = new zzq(this);
        this.zzc = context.getApplicationContext();
        this.zzd = new zzi(looper, zzqVar);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT;
        this.zzh = 300000L;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zzc(zzn zznVar, zze zzeVar, String str, Executor executor) {
        boolean z;
        synchronized (this.zzb) {
            try {
                zzo zzoVar = (zzo) this.zzb.get(zznVar);
                if (zzoVar == null) {
                    zzoVar = new zzo(this, zznVar);
                    zzoVar.zzb.put(zzeVar, zzeVar);
                    zzoVar.zze(str, executor);
                    this.zzb.put(zznVar, zzoVar);
                } else {
                    this.zzd.removeMessages(0, zznVar);
                    if (!zzoVar.zzb.containsKey(zzeVar)) {
                        zzoVar.zzb.put(zzeVar, zzeVar);
                        int r6 = zzoVar.zzc;
                        if (r6 != 1) {
                            if (r6 == 2) {
                                zzoVar.zze(str, executor);
                            }
                        } else {
                            zzeVar.onServiceConnected(zzoVar.zzg, zzoVar.zze);
                        }
                    } else {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(zznVar.toString()));
                    }
                }
                z = zzoVar.zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
