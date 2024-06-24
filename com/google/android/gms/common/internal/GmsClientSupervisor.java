package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class GmsClientSupervisor {
    public static HandlerThread zza;
    public static final Object zzc = new Object();
    public static zzr zzd;

    public static zzr getInstance(Context context) {
        synchronized (zzc) {
            if (zzd == null) {
                zzd = new zzr(context.getApplicationContext(), context.getMainLooper());
            }
        }
        return zzd;
    }

    public final void zzb(String str, String str2, int r5, zze zzeVar, boolean z) {
        zzn zznVar = new zzn(str, r5, str2, z);
        zzr zzrVar = (zzr) this;
        synchronized (zzrVar.zzb) {
            zzo zzoVar = (zzo) zzrVar.zzb.get(zznVar);
            if (zzoVar != null) {
                if (zzoVar.zzb.containsKey(zzeVar)) {
                    zzoVar.zzb.remove(zzeVar);
                    if (zzoVar.zzb.isEmpty()) {
                        zzrVar.zzd.sendMessageDelayed(zzrVar.zzd.obtainMessage(0, zznVar), zzrVar.zzg);
                    }
                } else {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(zznVar.toString()));
                }
            } else {
                throw new IllegalStateException("Nonexistent connection status for service config: ".concat(zznVar.toString()));
            }
        }
    }

    public abstract boolean zzc(zzn zznVar, zze zzeVar, String str, Executor executor);
}
