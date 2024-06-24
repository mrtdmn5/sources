package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzq implements Handler.Callback {
    public final /* synthetic */ zzr zza;

    public /* synthetic */ zzq(zzr zzrVar) {
        this.zza = zzrVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int r1 = message.what;
        if (r1 != 0) {
            if (r1 != 1) {
                return false;
            }
            synchronized (this.zza.zzb) {
                zzn zznVar = (zzn) message.obj;
                zzo zzoVar = (zzo) this.zza.zzb.get(zznVar);
                if (zzoVar != null && zzoVar.zzc == 3) {
                    String valueOf = String.valueOf(zznVar);
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(valueOf), new Exception());
                    ComponentName componentName = zzoVar.zzg;
                    if (componentName == null) {
                        zznVar.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = zznVar.zzc;
                        Preconditions.checkNotNull(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    zzoVar.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
        synchronized (this.zza.zzb) {
            try {
                zzn zznVar2 = (zzn) message.obj;
                zzo zzoVar2 = (zzo) this.zza.zzb.get(zznVar2);
                if (zzoVar2 != null && zzoVar2.zzb.isEmpty()) {
                    if (zzoVar2.zzd) {
                        zzoVar2.zza.zzd.removeMessages(1, zzoVar2.zzf);
                        zzr zzrVar = zzoVar2.zza;
                        zzrVar.zzf.unbindService(zzrVar.zzc, zzoVar2);
                        zzoVar2.zzd = false;
                        zzoVar2.zzc = 2;
                    }
                    this.zza.zzb.remove(zznVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }
}
